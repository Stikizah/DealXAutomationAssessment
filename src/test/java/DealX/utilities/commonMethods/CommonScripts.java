package DealX.utilities.commonMethods;

import DealX.utilities.pageModels.poLogin;
import DealX.web.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Element;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.w3c.dom.Document;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class CommonScripts extends TestBase {
    poLogin  PageOBJ;

    //static WebDriver driver;

    public CommonScripts(WebDriver driver){
        PageOBJ= PageFactory.initElements(driver,poLogin.class);

    }

    public String UK_Campaign_Codes_CSL(String campaign_code)
    {
        String currentDate = GetDateinJava();

        String Credit_Staq_lite = "api?i5=i5&home_value=0&pension_income=0&rental_income=0&benefits=0&has_other_household_income=0" +
                "&work_phone=0845111112&remaining_mortgage=0&prev_months_at_address=42&other_income=250&prev_county=Aberdeenshire&prev_city=Aberdeen&prev_address2=Address2" +
                "&prev_address1=Address1&prev_postcode=WA4+1AD&prev_residence_type=1&additional_job_income=0&bills=750&v3=v3&i4=i4&i3=i3&i2=i2&i1=i1&v5=v5&v4=v4&v2=v2&v1=v1" +
                "&transport=75&food=125&marketing_opt_in=1&residence_type=1&marital_status=1&loan_purpose=3&income_source=1&employment_industry=1&income_pay_frequency=1" +
                "&income_payment_type=1&site_ip=104.20.70.73&dependent_number=0&next_pay_date="+currentDate+"&loan_term=24&bank_account_type=1&months_at_employer=2" +
                "&bank_sort_code=123456&bank_account_number=12345678&home_phone=01914544322&mobile_phone=07897641544&client_ip=157.61.158.76&dob=1977-09-09&employer_name=O2" +
                "&county=Aberdeenshire&address2=2 Santander road&first_name=Rami&mode=LIVE&gender=M&city=Bigapple" +
                "&client_agent=Mozilla%2F5.0+%28Macintosh%3B+Intel+Mac+OS+X+10_11_6%29+AppleWebKit%2F537.36+%28KHTML%2C+like+Gecko%29+Chrome%2F57.0.2987.133+Safari%2F537.36" +
                "&address1=222&last_name=TESTAA&has_pension=1&campaign_code="+campaign_code+"&site_url=creditperfect.co.uk&postcode=m20 1dd&email=Test1112@mailinator.com" +
                "&months_at_address=42&existing_loan_payments=250&rental_mortgage_payments=250&other_expenses=250&loan_amount=2500&monthly_income=2500" +
                "&gross_annual_income=30000&time_at_bank=5&title=1";

        System.out.println(Credit_Staq_lite);

        return Credit_Staq_lite;
    }

    public String US_Campaign_Codes_CSL(String campaign_code,String emailRequired)
    {

        String Credit_Staq_lite_QA = "api?gclid=&bank_account_number=&job_title=&prev_work_phone=&prev_months_at_employer=&prev_employer_name=&prev_income_source=" +
                "&next_pay_date=&work_phone=&bank_routing_number=&bank_account_type=&employer_address=&bank_name=&income_payment_type=&best_call_time=&driver_license_state=" +
                "&driver_license_number=&state_identification_number=&gender=&middle_name=&employer_zipcode=&employer_city=" +
                "&prev_address=&v2=&i5=&i4=&i3=&i2=&i1=&v5=&v4=&v3=&v1=&employer_state=&device=&network=&match_type=&keyword=&ref=&affiliate_app_id=&months_at_bank=" +
                "&next_pay_date2=&prev_city=&prev_state=&prev_zipcode=&prev_months_at_address=&reference=&prev_residency_type=&prev_monthly_rent=" +
                "&min_commission=0.00&co_app=1&loan_purpose=1&residence_type=1&income_source=1&pay_frequency=1&terms_consent=1&marketing_opt_in=1&site_ip=10.0.1.22" +
                "&co_app_address1=13+South+Second+Avenue&client_ip=172.68.186.91&co_app_dob=1970-12-13&dob=1977-05-21&education_level=5&address1=52+Cowley+Street" +
                "&max_commission=999.00&co_app_zipcode=18635&zipcode=57108&social_security_number=000123000&home_phone=3103232583&mobile_phone=3103232583" +
                "&co_app_last_name=Clements&co_app_address2=Culpa+soluta+delectus+accusantium+illum+aliquid&last_name=Ellison&city=Enim+consequatur+Ipsum+eu+reiciendis+vel+est+vo" +
                "&co_app_first_name=Eve&address2=Incidunt+tempore+vel+amet+placeat+repellendus+&first_name=Automation&mode=LIVE&co_app_state=MN" +
                "&client_agent=Mozilla%2F5.0+%28Windows+NT+10.0%3B+Win64%3B+x64%29+AppleWebKit%2F537.36+%28KHTML%2C+like+Gecko%29+Chrome%2F80.0.3987.122+Safari%2F537.36" +
                "&military=N&state=NE&co_app_city=Qui+ipsam+nobis+voluptate+provident+fugit+volupt&employer_name=TestFirstRun&own_car=Y" +
                "&campaign_code="+campaign_code+"&site_url=https%3A%2F%2Fqa.monevo.us%2Fapply&email="+emailRequired+"&credit_rating=4&monthly_rent=11&months_at_address=68" +
                "&months_at_employer=104&loan_amount=1000&monthly_income=79166&co_app_annual_income=750000";

        System.out.println(Credit_Staq_lite_QA);

        return Credit_Staq_lite_QA;
    }

    public String GetDateinJava()
    {

        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-30");

        //get current date time with Date()
        Date date = new Date();

        // Now format the date
        String date1= dateFormat.format(date);

        // Print the Date
        System.out.println(date1);

        return date1;
    }

    public static String readXmlDocument(String strXmlFile, String strUrl)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try
        {
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            File file = new File(strXmlFile);
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("response");

            for (int temp = 0; temp < nodeList.getLength(); temp++)
            {
                org.w3c.dom.Node node = nodeList.item(temp);
                System.out.println("\nCurrent element: " + node.getNodeName());
                if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;

                    if(element.getElementsByTagName("result").item(0).getTextContent().contains("20"))
                    {
                        //WebDriver driver = null;

                        strUrl = element.getElementsByTagName("redirect_url").item(0).getTextContent();
                        //driver.get(element.getElementsByTagName("redirect_url").item(0).getTextContent());
                        //driver.navigate().to(element.getElementsByTagName("redirect_url").item(0).getTextContent());
                        System.out.println("Message: " + element.getElementsByTagName("message").item(0).getTextContent());
                    }
                    else if (element.getElementsByTagName("result").item(0).getTextContent().contains("21"))
                    {
                        //driver.navigate().to(element.getElementsByTagName("redirect_url").item(0).getTextContent());
                        System.out.println("Message: " + element.getElementsByTagName("message").item(0).getTextContent());
                    }
                    else if (element.getElementsByTagName("result").item(0).getTextContent().contains("22"))
                    {
                        //driver.navigate().to(element.getElementsByTagName("redirect_url").item(0).getTextContent());
                        System.out.println("Message: " + element.getElementsByTagName("message").item(0).getTextContent());
                    }

                }
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return strUrl;
    }

    public static void writeXmlDocumentToXmlFile(Document xmlDocument, String fileName)
    {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();

            //Uncomment if you do not require XML declaration
            //transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            //Print XML or Logs or Console
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(xmlDocument), new StreamResult(writer));
            String xmlString = writer.getBuffer().toString();
            System.out.println(xmlString);

            //Write XML to file
            FileOutputStream outStream = new FileOutputStream(new File(fileName));
            transformer.transform(new DOMSource(xmlDocument), new StreamResult(outStream));
        }
        catch (TransformerException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String convertDocumentToString(Document doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;

        try {
            transformer = tf.newTransformer();
            // below code to remove XML declaration
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();

            return output;

        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try
        {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse( new InputSource( new StringReader(prettyFormat(xmlStr))) );
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String prettyFormat(String input, int indent) {
        try {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (Exception e) {
            throw new RuntimeException(e); // simple exception handling, please review it
        }
    }

    public static String prettyFormat(String input) {
        return prettyFormat(input, 2);
    }

    public void loginEmailWebVerifiedUser() {
        try {
            PageOBJ.setUserName("gftlucky@gmail.com");
            PageOBJ.clickGoogleButton();
            PageOBJ.setPassword("Nkomo1996@");
            PageOBJ.clickGoogleButton();
        } catch (Exception e) {
            System.out.println("Error - loginEmailWebVerifiedUser:\n" + e.getMessage());

        }
    }

    public void loginEmailWebGoogleUser() {
        /*Account details
         * No card
         * Mobile not verified
         * Email not verified
         * */
        try {
            PageOBJ.setUserName("nmthalane@quint.co.uk");
            PageOBJ.clickGoogleButton();
            PageOBJ.setPassword("Lolo4sticks@");
            PageOBJ.clickGoogleButton();
        } catch (Exception e) {
            System.out.println("Error - loginEmailWebGoogleUser:\n" + e.getMessage());

        }

    }

    public void loginMobileWebUnverifiedUser() {
        /*Account details
         * No card
         * Mobile not verified
         * Email not verified
         * */
        try {
            PageOBJ.setMobileNumber("0777555550");
            PageOBJ.clickGoogleButton();
            PageOBJ.setPassword("P@ssword01");
            PageOBJ.clickGoogleButton();
        } catch (Exception e) {
            System.out.println("Error - loginMobileWebUnverifiedUser:\n" + e.getMessage());
        }
    }
    public void loginMobileUnverifiedUser() {
        try {
            PageOBJ.setMobileNumber("834143180");
            PageOBJ.clickGoogleButton();
            PageOBJ.setPassword("P@ssword01");
            PageOBJ.clickGoogleButton();
        } catch (Exception e) {
            System.out.println("Error - loginMobileUnverifiedUser:\n" + e.getMessage());

        }
    }
    public void loginMobileVerifiedUser() {
        try {
            PageOBJ.setMobileNumber("829090909");
            PageOBJ.clickGoogleButton();
            PageOBJ.setPassword("P@ssword01");
            PageOBJ.clickGoogleButton();
        } catch (Exception e) {
        }
    }
    public void loginMobileEditableUser() {
        try {
            PageOBJ.setMobileNumber("827800003");
            PageOBJ.clickGoogleButton();
            PageOBJ.setPassword("P@ssword01");
            PageOBJ.clickGoogleButton();
        } catch (Exception e) {
            System.out.println("Error - loginMobileEditableUser:\n" + e.getMessage());

        }
    }
    public void loginEmailEditableUser() {
        try {
            PageOBJ.setUserName("uu_auto_shr@outlook.com");
            PageOBJ.clickGoogleButton();
            PageOBJ.setPassword("P@ssword01");
            PageOBJ.clickGoogleButton();
        } catch (Exception e) {
            System.out.println("Error - loginEmailEditableUser:\n" + e.getMessage());


        }
    }
    public void LogoutUser() {
        try {
            PageOBJ.profileElement();
            PageOBJ.logout();
        } catch (Exception e) {
            System.out.println("Error - LogoutUser:\n" + e.getMessage());

        }


    }

    public static String uploadFile(String fileLocation, String DataToUse) {
        String OSName = System.getProperty("os.name") ;
        if (OSName.contains("Mac OS X")) {
            fileLocation = System.getProperty("user.dir") + "/src/test/resources/Images/"+DataToUse;
        } else {
            fileLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\Images\\"+DataToUse;
        }
        return fileLocation;
    }

    public void uploadImage(String DataToUse) {
        try {
            String OSName = System.getProperty("os.name") ;
            Thread.sleep(5000);


            if (OSName.contains("Mac OS X")) {

                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.delay(2000);
                robot.keyPress(KeyEvent.VK_META);
                robot.delay(2000);
                robot.keyPress(KeyEvent.VK_G);
                robot.delay(2000);
                robot.keyRelease(KeyEvent.VK_G);
                robot.delay(2000);
                robot.keyRelease(KeyEvent.VK_META);
                robot.delay(2000);
                robot.keyRelease(KeyEvent.VK_SHIFT);

                robot.delay(2000);
            }
            String fileLocation = null;
            if (OSName.contains("Mac OS X")) {
                fileLocation = System.getProperty("user.dir") + "/src/test/resources/Images/"+DataToUse;
            } else {
                fileLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\Images\\"+DataToUse;
            }

            uploadFile(fileLocation,OSName,robot);
        } catch (Exception e) {
            System.out.println("Error - LogoutUser:\n" + e.getMessage());

        }

    }

    private static void setClipboardData(String string) {
        //StringSelection is a class that can be used for copy and paste operations.
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public static void uploadFile(String fileLocation, String OSName, Robot r) {
        try {
            //Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Thread.sleep(3000);
            //KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
            if (OSName.contains("Mac OS X")) {
                r.keyPress(KeyEvent.VK_META);
                r.delay(2000);
                r.keyPress(KeyEvent.VK_V);
                r.delay(2000);
                r.keyRelease(KeyEvent.VK_V);
                r.delay(2000);
                r.keyRelease(KeyEvent.VK_META);
                r.delay(2000);
                PressEnter( 2);
            } else {
                try {
                    Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\fileUpload.exe");
                } catch (Exception e) {
                    System.out.println("Error - Upload Image:\n" + e.getMessage());
                }
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    //Press Shift and Tab
    private static void PressEnter(int iteration) throws InterruptedException, AWTException
    {
        int i=1;
        while(i<=iteration)
        {
            Thread.sleep(1000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(2000);
            robot.keyRelease(KeyEvent.VK_ENTER);
            i++;
        }
    }

    public void uploadImage(WebDriver driver) {
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\fileUpload.exe");
        } catch (Exception e) {
            System.out.println("Error - Upload Image:\n" + e.getMessage());
        }
    }

    public void DragAndDrop(WebDriver driver){

        String sourcePath = "(.//*[text()[contains(.,'Catalog version')]])[2]/following::span[1]";
        String targetPath = "(.//*[text()[contains(.,'Drop Items here to create a Workflow')]])";

        WebElement source = driver.findElement(By.xpath(sourcePath));
        WebElement target = driver.findElement(By.xpath(targetPath));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();

    }

}
