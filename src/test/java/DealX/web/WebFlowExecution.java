package DealX.web;

import DealX.models.TestStepsModel;
import DealX.models.XtraSavingsCardModel;
import DealX.utilities.*;
import DealX.utilities.commonMethods.CommonScripts;
import DealX.utilities.datahelpers.XtraSavingsCardHandlers;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;


public class WebFlowExecution {

    private WebSiteStepScenario webSiteStepScenario;
    private SeleniumHelpers seleniumHelpers;
    private DataGenerators dataGenerators;
    private XtraSavingsCardModel newCard;
    private XtraSavingsCardHandlers cardHandler;
    private Workbook cardWorkbook;
    private StringBuffer verificationErrors = new StringBuffer();
    String lastGeneratedData = "";
    private CommonScripts commonStripts;
    public String DataHandle;


    public WebFlowExecution() {
        seleniumHelpers = new SeleniumHelpers();
        seleniumHelpers.SetupScreenshotsFolder();
        dataGenerators = new DataGenerators();
        webSiteStepScenario = new WebSiteStepScenario();
    }

    public void WebStepExecutor(WebDriver driver, ExtentTest extentTestCase, TestStepsModel testData, SoftAssert assertion, String platformName, String testFlow) throws IOException {
        String description = testData.Description;
        String action = testData.Action;
        String webElementType = testData.WebElementType;
        String webElementIdentifier = testData.WebElementIdentifier;
        String dataToUse = testData.DataToUse;
        String campaign_code = testData.Campaign_code;
        String first_name = testData.First_name;
        String scenario = testData.Scenario;
        JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
        By webelementToUse;
        CommonScripts commonStripts = new CommonScripts(driver);
        ExtentTest stepNode = extentTestCase.createNode(description); // level = 2
        Duration interval = Duration.ofSeconds(1);
        Duration timeout = Duration.ofSeconds(10);
        Wait<WebDriver> verificationWait = new FluentWait<>(driver).withTimeout(timeout)
                .ignoring(NoSuchElementException.class).pollingEvery(interval);
        webSiteStepScenario.checkPageIsReady(javaExecutor);

        String screenshotPath = seleniumHelpers.logWebScreenShotToFile(driver);
        assert screenshotPath != null;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            switch (action.toUpperCase()) {
                case "NAVIGATE TO PAGE":
                    Boolean validUrl = seleniumHelpers.ParseUrl(dataToUse);
                    if (validUrl) {
                        driver.navigate().to(dataToUse);
                    } else {
                        String combinedUrl;
                        if (dataToUse != null) {
                            combinedUrl = TestBase.baseUrl + dataToUse.trim().toLowerCase();
                        } else {
                            combinedUrl = TestBase.baseUrl;
                        }
                        validUrl = seleniumHelpers.ParseUrl(combinedUrl);
                        if (validUrl) {
                            driver.navigate().to(combinedUrl);
                        } else {
                            assertion.fail("Invalid url used: " + combinedUrl);
                        }
                        Thread.sleep(2000);

                    }
                    break;

                case "CLICK ELEMENT":
                    webelementToUse = seleniumHelpers.DetermineWebElementType(webElementType, webElementIdentifier);

                    try {

                        driver.findElement(webelementToUse).click();
//                        verificationWait.until(ExpectedConditions.presenceOfElementLocated(webelementToUse));
                    } catch (ElementClickInterceptedException e) {
                        javaExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(webelementToUse));
                        driver.findElement(webelementToUse).click();
                    }
                    Thread.sleep(500);
                    break;

                case "CLICK ELEMENT USING JSCRIPT":
                    webelementToUse = seleniumHelpers.DetermineWebElementType(webElementType, webElementIdentifier);

                    try {
                        WebElement element = driver.findElement(webelementToUse);
                        JavascriptExecutor executor = (JavascriptExecutor) driver;
                        executor.executeScript("arguments[0].click();", element);
                    } catch (ElementClickInterceptedException e) {
                        javaExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(webelementToUse));
                        driver.findElement(webelementToUse).click();
                    }
                    break;

                case "INPUT TEXT":
                    webelementToUse = seleniumHelpers.DetermineWebElementType(webElementType, webElementIdentifier);
                    try {
                        driver.findElement(webelementToUse);
                    } catch (NoSuchElementException e) {
                        javaExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(webelementToUse));
                    }
                    driver.findElement(webelementToUse).clear();
                    driver.findElement(webelementToUse).clear();
                    if (dataToUse.toUpperCase().contains("GENERATED")) {
                        String dataRequired = dataGenerators.GenerateRequiredData(dataToUse);
                        driver.findElement(webelementToUse).sendKeys(dataRequired);
                        lastGeneratedData = dataRequired;
                        Thread.sleep(2000);

                    } else if (dataToUse.toUpperCase().contains("NUMBER")) {
                        String dataRequired = dataGenerators.generateRandomValue(10);
                        driver.findElement(webelementToUse).sendKeys(dataRequired);
                        DataHandle = dataRequired;
                    } else if (dataToUse.toUpperCase().contains("VALUE")) {
                        String dataRequired = dataGenerators.generateRandomString(10);
                        driver.findElement(webelementToUse).sendKeys(dataRequired);
                        DataHandle = dataRequired;
                    } else if (dataToUse.toUpperCase().contains("SEARCHBONUSBUY")) {
                        driver.findElement(webelementToUse).sendKeys(DataHandle);
                    } else if (dataToUse.toUpperCase().contains("BONUSBUY")) {
                        String dataRequired = dataGenerators.generateRandomValue(10);
                        DataHandle = "testBonusBuy" + dataRequired;
                        driver.findElement(webelementToUse).sendKeys(DataHandle);
                    }else if(dataToUse.toUpperCase().contains("PRIORSTORED"))  {
                        driver.findElement(webelementToUse).sendKeys(TestBase.sStoredValue);
                    }
                    else {
                        if (dataToUse.toUpperCase().contains("LAST GEN DATA")) {
                            driver.findElement(webelementToUse).sendKeys(lastGeneratedData);
                        } else if(dataToUse.toUpperCase().contains("LASTDATA")) {
                            driver.findElement(webelementToUse).sendKeys(DataHandle);

                        }else{
                            driver.findElement(webelementToUse).sendKeys(dataToUse);
                            //Thread.sleep(2000);

                        }
                    }
                    break;

                case "MANIPULATE INPUT TEXT":
                    webelementToUse = seleniumHelpers.DetermineWebElementType(webElementType, webElementIdentifier);
                    //inline initialization
                    String[] searchCriteria = {"Blouse","Faded Short Sleeve T-shirts","Printed Dress"};

                    //iterating all elements in the array
                    for (int i = 0; i <= searchCriteria.length; i++) {
                        System.out.println(searchCriteria[i]);
                        driver.findElement(webelementToUse).clear();
                        driver.findElement(webelementToUse).sendKeys(searchCriteria[i]);
                        driver.findElement(webelementToUse).sendKeys(Keys.RETURN);

                        try {
                            assertEquals(driver.findElement(By.xpath("//*[@class='lighter']")).getText(), searchCriteria[i]);
                        }catch (Error e) {
                            verificationErrors.append(e.toString());
                        }

                    }
                    break;

                case "HOVER TO ELEMENT":
                    WebElement ele = driver.findElement(By.xpath("//*[@itemprop='image']"));

                    //Creating object of an Actions class
                    Actions actionHover = new Actions(driver);

                    //Performing the mouse hover action on the target element.
                    actionHover.moveToElement(ele).perform();

                    break;


                case "TOTAL PRICE":
                    String Quantity = driver.findElement(By.xpath("//*[@id='layer_cart_product_quantity']")).getText();
                    String Total = driver.findElement(By.xpath("//*[@id='layer_cart_product_price']")).getText();;

                    System.out.println("Quality = " + Integer.parseInt(Quantity));
                    System.out.println("Total = " + Total);

                    String output = Total.replace("$", "").replace(",", "");

                    System.out.println("Total Cost = " + output);

                    double Quantity_Number = Double.parseDouble(Quantity);

                    double Total_Number = Double.parseDouble(output);

                    double Total_Cost = (27 * Quantity_Number);
                    System.out.println("Total Cost = " + Total_Cost);

                    assertEquals(Total_Number, Total_Cost);

                    break;

                case "VERIFY ELEMENT PRESENT":
                    webelementToUse = seleniumHelpers.DetermineWebElementType(webElementType, webElementIdentifier);
                    verificationWait.until(ExpectedConditions.visibilityOfElementLocated(webelementToUse)).isDisplayed();
                    break;

                case "VERIFY ELEMENT TEXT":
                    webelementToUse = seleniumHelpers.DetermineWebElementType(webElementType, webElementIdentifier);
                    String currentTextValue = null;
//                    verificationWait.until(ExpectedConditions.textToBePresentInElementLocated(webelementToUse, dataToUse));
                    try {
                        assertEquals(driver.findElement(webelementToUse).getText(), dataToUse);
                        currentTextValue = driver.findElement(webelementToUse).getText();
                    } catch (Error e) {
                        verificationErrors.append(e.toString());
                    }

                    break;

                case "WAIT":
                    int seconds = Integer.parseInt(dataToUse);
                    Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));

                    break;

                case "REFRESH PAGE":
                    driver.navigate().refresh();
                    break;

                case "DOUBLE-CLICK ELEMENT":
                    webelementToUse = seleniumHelpers.DetermineWebElementType(webElementType, webElementIdentifier);
                    try {
                        Actions actions = new Actions(driver);
                        WebElement elementLocator = driver.findElement(webelementToUse);
                        actions.doubleClick(elementLocator).perform();
                    } catch (ElementClickInterceptedException e) {
                        javaExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(webelementToUse));
                        verificationWait.until(ExpectedConditions.elementToBeClickable(webelementToUse)).click();
                    }
                    break;

            }
            Thread.sleep(100);
            //TODO - replace with wait for angular ready
            assert screenshotPath != null;
            stepNode.pass("[Info] Execution: | "  + scenario + "  |  " + action + "  |  "+ "  |  " + scenario + "  |  "+ description +"  |  "+ webElementType + "  |  "+ webElementIdentifier + "  |  "+dataToUse +  campaign_code ,
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            seleniumHelpers.LogScreenshotToRP(description, "INFO", screenshotPath);

        } catch (Exception e) {
            assertion.fail(e.getMessage());
            screenshotPath = seleniumHelpers.logWebScreenShotToFile(driver);
            assert screenshotPath != null;
            stepNode.fail(description + " - " + e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            if (TestBase.prop.getProperty("alm_update").toUpperCase().contains("TRUE"))
            {
                if(!TestBase.isALMExecuted) {

                    try {
                        TestBase.myrun = ALM_Wrapper.updateTestResult(TestDataCreator.TestSetPath, TestDataCreator.TestSetName, Integer.parseInt(TestDataCreator.TestSetID), testFlow, "FAILED");
                    } catch (Exception s) {
                        System.out.println("Update Test Result Error : " + s.getMessage());
                    }
                    TestBase.isALMExecuted = true;
                }
                ALM_Wrapper.addTestStep(TestBase.myrun, description, description, description, e.toString(), "FAILED");

            }

            seleniumHelpers.LogScreenshotToRP(description + " - " + e, "ERROR", screenshotPath);
        }
    }

}
