package com.example.deliverybackend.api;

import com.example.deliverybackend.entity.MenuDao;
import com.example.deliverybackend.entity.StoreDao;
import com.example.deliverybackend.repository.MenuRepository;
import com.example.deliverybackend.repository.StoreRepository;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

// 네이버 매장 정보 크롤링 하는 코드

@SpringBootApplication
@Service
public class NaverStoreCrawler {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private MenuRepository menuRepository;

    private WebDriver driver;

    public static final String category = "중식";
    private static final String url = "https://map.naver.com/p/search/" + category;

    public void process() {
        // 크롬 드라이버 세팅 (드라이버 설치 경로 입력)
        System.setProperty("webdriver.chrome.driver", "D:/Spring_WS/DeliveryBackend/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // 브라우저 선택
        driver = new ChromeDriver(options);

        try {
            getDataList();
        } catch (Exception e) {
            // 예외 처리 로직
            e.printStackTrace();
        } finally {
            // 리소스 해제
            if (driver != null) {
                try {
                    // 탭 닫기
                    driver.close();
                } catch (Exception e) {
                    // 무시: 이미 닫힌 탭에 대한 예외 처리
                }
                try {
                    // 브라우저 닫기
                    driver.quit();
                } catch (Exception e) {
                    // 무시: 이미 닫힌 브라우저에 대한 예외 처리
                }
            }
        }
    }

    // 데이터 가져오기
    private void getDataList() {
        // (1) 브라우저에서 url로 이동한다.
        driver.get(url);

        // 60초까지 기다려줌
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        //10개의 데이터중 받아올 수있는 데이터만 가져온다는 뜻^^
        for (int i = 0; i < 10; i++) {
            try {
                // (2) 검색결과 iframe으로 frame을 바꾼다.
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe#searchIframe")));
                // 검색 결과 장소 목록을 elements에 담는다.
                List<WebElement> storeNameElements = driver.findElements(By.cssSelector(".place_bluelink.TYaxT"));
                // 매장 이미지 목록을 elements에 담는다.
                List<WebElement> storeImageElements = driver.findElements(By.cssSelector("div.yLaWz img"));

                // 매장 이름 출력
                if (!storeNameElements.isEmpty() /*&& !storeImageElements.isEmpty()*/) {
                    WebElement storeNameElement = storeNameElements.get(i);
                    String storeName = storeNameElement.getText();
                    System.out.println("--------------------매장명: " + storeName);
                    WebElement storeImageElement = storeImageElements.get(0);
                    String storeImg = storeImageElement.getAttribute("src");
                    System.out.println("--------------------매장 이미지: " + storeImg);

                    // (3) 첫번째 검색결과를 클릭한다.
                    storeNameElement.click();

                    // 현재 프레임에서 상위 프레임으로 이동한다.
                    driver.switchTo().defaultContent();

                    // 주소 정보를 가져오는 로직을 재시도 포함하여 추가
                    String storeAddress = null;

                    while (storeAddress == null) {
                        try {
                            // (4) 상세정보가 나오는 프레임으로 이동한다.
                            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe#entryIframe")));

                            // (5) 상세정보 프레임에서 주소 정보가 들어있는 곳으로 이동한다.
                            List<WebElement> placeSectionContents = driver.findElements(By.cssSelector(".place_section_content"));
                            WebElement homeElement = placeSectionContents.get(1);

                            // (6) "주소" 버튼 요소를 찾아 클릭한다.
                            WebElement addressButton = homeElement.findElement(By.className("_UCia"));
                            addressButton.click();

                            // (7) "도로명"과 "지번" 정보가 들어있는 div 요소를 찾아서, 해당 정보를 가져온다.
                            WebElement addressDiv = driver.findElement(By.className("Y31Sf"));
                            List<WebElement> addressInfos = addressDiv.findElements(By.className("nQ7Lh"));

                            // 도로명 주소만 가져오기
                            if (!addressInfos.isEmpty()) {
                                WebElement firstAddressInfo = addressInfos.get(0);
                                WebElement addressType = firstAddressInfo.findElement(By.tagName("span"));
                                String fullAddress = firstAddressInfo.getText().trim();

                                // 마지막 두 글자를 제외한 주소 문자열("복사" 글씨 제외)
                                storeAddress = fullAddress.substring(0, fullAddress.length() - 2);

                                System.out.println("--------------------주소: " + storeAddress);
                            }
                        } catch (Exception e) {
                            System.out.println("주소 요소를 못찾음 될때까지 대가리 박아봄.");

                            driver.navigate().refresh();
                        }
                    }


                    // 메뉴 정보 가져오기
                    driver.switchTo().defaultContent(); // 기본 콘텐츠로 돌아가기
                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe#searchIframe"))); // searchIframe으로 다시 이동

                    storeNameElements = driver.findElements(By.cssSelector(".place_bluelink.TYaxT")); // 요소 재로딩
                    storeNameElements.get(i).click(); // 첫번째 검색결과 클릭
                    driver.switchTo().defaultContent(); // 기본 콘텐츠로 돌아가기
                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe#entryIframe"))); // 상세정보가 나오는 프레임으로 이동

                    WebElement menuButton;
                    try {
                        menuButton = driver.findElement(By.xpath("//a[@class='fvwqf' and .//span[text()='메뉴']]"));
                        menuButton.click();
                    } catch (NoSuchElementException e) {
                        System.out.println("메뉴더보기버튼이 없으므로 패스함.");
                        driver.navigate().refresh();
                        continue;
                    }

                    try {
                        List<WebElement> productElements = driver.findElements(By.cssSelector("span.lPzHi"));
                        List<WebElement> priceElements = driver.findElements(By.cssSelector(".GXS1X"));
                        List<WebElement> productImageElement = driver.findElements(By.cssSelector("div.place_thumb img"));

                        for (int j = 0; j < productElements.size(); j++) {
                            // 상품 이미지 받아옴
                            String productImg = productImageElement.get(j).getAttribute("src");
                            // 상품 이름 받아옴
                            String productName = productElements.get(j).getText();
                            // 상품 가격 받아옴 (price가 String 값이므로 int로 변환 시킴.)
                            String priceText = priceElements.get(j).getText().replace(",", "").replace("원", "");
                            int price = Integer.parseInt(priceText);// 정수로 변환
                            System.out.println("--------------------음식명: " + productName);
                            System.out.println("--------------------음식사진: " + productImg);
                            System.out.println("--------------------가격: " + price);

                            // 데이터베이스에 삽입
                            // 매장 정보 저장
                            //중복 저장 방지해줌.
                            StoreDao existingStore = storeRepository.findByStoreName(storeName);
                            if (existingStore == null) {
                                StoreDao storeDao = new StoreDao();
                                storeDao.setStoreName(storeName);
                                storeDao.setStoreAddress(storeAddress);
                                storeDao.setCategory(category);
                                storeDao.setStoreImg(productImageElement.get(0).getAttribute("src"));
                                existingStore = storeRepository.save(storeDao);
                            }

                            // 메뉴 정보 저장
                            MenuDao menuDao = new MenuDao();
                            menuDao.setProductName(productName);
                            menuDao.setPrice(price);
                            menuDao.setProductImg(productImg);
                            menuDao.setStoreId(existingStore); // 매장 정보 설정
                            menuRepository.save(menuDao);




                        }

                        driver.switchTo().defaultContent(); // 기본 콘텐츠로 돌아가기
                    } catch (Exception e) {
                        System.out.println("UI구조가 달라서 패스");
                        driver.switchTo().defaultContent(); // 기본 콘텐츠로 돌아가기
                    }
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException 발생, 재시도 중...");
                i--; // 현재 반복을 재시도하기 위해 i를 감소시킨다.
                driver.navigate().refresh(); // 페이지를 새로 고침하여 요소를 다시 가져온다.
            }
        }
    }
}
