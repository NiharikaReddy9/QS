package BSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class AElements {
    public static void main (String srgs[]) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait Ewait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement E1 = Ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
        E1.click();
        Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
        WebElement E2 = Fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.id(""));
            }
        });
        E2.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",E1);
        js.executeScript("document.body.style.zoom='50%'");                                        // Zoom
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");                         // scroll Down
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");                        // scroll Up
        js.executeScript("window.scrollBy(0, document.body.scrollHeight * 0.3);");
        js.executeScript("window.scrollBy(0, -document.body.scrollHeight * 0.3);");
        js.executeScript("arguments[0].style.border='3px solid red'",E1);                          // Border
        String bgColour = E1.getCssValue("background-color");                                   // [ Get original background color ]
        for(int i = 0; i < 30; i++) {
            js.executeScript("arguments[0].style.backgroundColor = '#000000';", E1);               // [ Change to black ]
            js.executeScript("arguments[0].style.backgroundColor = arguments[1];", E1 , bgColour); // [ Restore original color ]
        }

        TakesScreenshot Ts = (TakesScreenshot) driver;                                                   // Full page
        File src = Ts.getScreenshotAs(OutputType.FILE);                                                  // File src = e2.getScreenshotAs(OutputType.FILE); [Portion or ele]
        File trg = new File("C:\\Users\\Windows\\Downloads\\Img1.png");
        FileUtils.copyFile(src, trg);

// id, name, classname, tagName, linktext, partiallink, xapath, css , Shadow Element

        driver.findElement(By.linkText("OrangeHRM, Inc")).click();                                       // <a href="http://www.orangehrm.com" target="_blank">OrangeHRM, Inc</a>
        driver.findElement(By.partialLinkText("Inc")).click();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        WebElement E3 =  driver.findElement(By.linkText("OrangeHRM, Inc"));
        String link   =  E3.getAttribute("href");
        URL l         =  new URL(link);
        HttpURLConnection hconnection = (HttpURLConnection) l.openConnection();
        hconnection.connect();
        int responsecode = hconnection.getResponseCode();                                               //[400 broken link, 200 series valid link,few links willne null and empty we cant do aything it wont display]



        Actions act = new Actions(driver);
        act.contextClick(E1).perform();
        act.doubleClick(E1).perform();
        act.dragAndDropBy(E1,100,0);                                                       // handslider
        act.dragAndDrop(E1,E2).perform();
        act.moveToElement(E1).moveToElement(E2).click().perform();
//        act.sendKeys(Keys.ENTER).perform();  // single key pressing
//        act.keyDown(Keys.CONTROL);           // Multiple keys pressing why Keydown is manualy we press control keydon the A [Note: on based on weblement sendkays also it will work e1.sendkeys(Keys.CONTROL + "a", Keys.DELETE);
//        act.sendKeys("a");
//        act.keyUp(Keys.CONTROL);
//        act.perform();
//        String tab = Keys.chord(Keys.CONTROL,Keys.RETURN);    //open url in new tab, chrod accepts multiple keys
//        driver.findElement(By.linkText("Regitser")).sendKeys(tab);
//        driver.get("");                                       //open urls in multiple Tabs & Windows
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("");

        Alert alrt = driver.switchTo().alert();                                                        // Javascriptpopups [OK,Cnacel, sendkeys ] we cant take control inside box using locators so we use methods
        alrt.accept();
        alrt.dismiss();
        alrt.sendKeys("");
        String alrtText = alrt.getText();
        driver.get("https://admin:admin@www.google.com/search?q=google&rlz");                          // Authenticationpopups [ask Username & pwd]
        ChromeOptions options = new ChromeOptions();                                                   //Browser Notificatiosn [ask/propmpt,allow, block]
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 0);
        options.setExperimentalOption("prefs", prefs);
        //WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.example.com");



        driver.findElement(By.id("")).sendKeys("P");                                        // to shift from one frame we need to go back to parent deafult page In inner frames we can shift from one F to other F
        driver.switchTo().frame("frm1");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frm2");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frm3");
        driver.switchTo().frame("frm31a");
        driver.switchTo().defaultContent();

        String  PWindowID       = driver.getWindowHandle();                                           //click any link opens new window
        Set<String> CWindowsID  = driver.getWindowHandles();
        for(String ID : CWindowsID){
            driver.switchTo().window(ID);
            String ttitle = driver.getTitle();
            if(ttitle.equals("meesho")){
                driver.findElement(By.id(""));
                driver.close();
            }
        }
        driver.switchTo().window(PWindowID);

        Cookie ck = new Cookie("mycookie123","12345");                                 // We can add or delete cookies in our own app because we control the domain, but we can't do that for third-party sites since the domain isn't ours."
        driver.manage().addCookie(ck);   // same for get cookie
        driver.manage().deleteCookie(ck);
        driver.manage().deleteCookieNamed("mycookie123");
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie c : cookies){
            String cName    =  c.getName();
            String cValue   =  c.getValue();
        }

        FileReader file = new FileReader("C:\\Users\\Windows\\Downloads\\Framework\\QA-Strengths\\src\\test\\java\\BSelenium\\application.properties");
        Properties p =  new Properties();
        p.load(file);
        String str = p.getProperty("appURL");

        Logger logger  = LogManager.getLogger(AE.class);                                           // [can put (this.class) also but this and super not allowed in ststctic so using classname AE.class we are writing  Logger logger  = LogManager.getLogger(this.getClass());
        logger.info("*** Started Testcas ***");
        logger.error("Test failed");
        logger.debug("debug logs");

        // Em chesedhi ledhu Customlisteners add cheyali & Only Testng tho runc cheyali. because CustomListners class implements ITestListener, which works only when registered with TestNG.not with a main() method
        /* option 2) inside class also  @Listeners(BSelenium.CustomListners.class)
                                          public class AE {
                                            @Test
                                            public void sampleTest() { }

         */


//        public class PageObjects {
//            WebDriver driver;
//            public PageObjects(WebDriver driver){
//                this.driver = driver;
//                PageFactory.initElements(driver, this);
//            }
//            @FindBy(xpath = "//input[@name='username']") WebElement uname;
//            @FindBy(xpath = "//input[@type='password' and @name='password']") WebElement pwd;
//            @FindBy(xpath = "//button[@type='submit' and contains(@class, 'orangehrm-login-button')]") WebElement loginbton;
//
//            public void logintoOHRM(String UNAME,String PWD){
//                uname.sendKeys(UNAME);
//                pwd.sendKeys(PWD);
//                loginbton.click();
//            }
//        }
//        -------> call in other class by creteing obj Selenium. <------
//        public class A {
//            public static void main (String args[]){
//            PageObjects pob = new PageObjects(driver);
//            pob.logintoOHRM("Admin","admin123");
//        }



    }
}







/*
✅ Types of Popups and How to Identify & Handle Them in Selenium
    Type	                                         Behaviour	Common HTML Tags / Clues	                                Commmon html tags
1) Custom Popup (HTML Modal)	                : Inside the same browser tab, blocks screen partially or fully		[You can inspect it] <div class="modal">, <div class="popup">, .loginModal, .overlay, .dialog, .commonModal__close	Use findElement() with XPath/CSS selectors to locate and click close button
2) Advertisement Banner (HTML, Often in iframe)	: Small or large box inside the page, sometimes auto-show	      	[You can inspect it] <iframe>, <div class="ad">, .banner, .sponsored, .adsbygoogle, .widgetBanner	                Switch to iframe if needed → locate ad → close using element click
3) Browser Notification (Chrome/OS Based)     	: Top-left of browser, asks “Allow/Block Notifications”	            [Cant inspect it   ] Disable using ChromeOptions
                                                  options.addArguments("--disable-notifications");   it support inonsistently so not recomended. better to use "prefs" approch this setting is induit into chrome and always works
                                                  prompt/ask(default)  0, Always Alllow 1, Always Block 2 as per our wish we can shift
4) JavaScript Alert/Confirm (Native Dialogs)	: OS-style popup with “OK / Cancel”	                                [Cant inspect it   ] use alert class and handle
💻 Sysetem properties : Java itself sets some **default system properties** when the JVM starts up.
   it already contains few predefined ssystem properyes we are using it if we want we can set properties allso
   System.setProperty("browser", "chrome");
   String browser = System.getProperty("browser");  // "chrome"

   Property Key	What It Represents	Example Value
user.dir	     ✅ Current working directory (project root)	        C:\Users\Windows\Downloads\Framework\QA-Strengths
user.name	     ✅ Logged-in OS user name	                            Niharika
os.name  	     ✅ Operating system name	                            Windows 10
os.version	     OS version	                                             10.0
os.arch	         OS architecture	                                    amd64
java.version     Java runtime version	                                17.0.8
java.vendor	     Java vendor	                                        Oracle Corporation
java.home	     Path to the JRE	                                    C:\Program Files\Java\jdk-17\jre
java.class.path	 Classpath used for execution	                        .; lib/*.jar
file.separator	 File path separator(/ on Linux, \ on Windows)	        \ (Windows), / (Linux)
line.separator	 Line break for the system	                            \r\n or \n
path.separator	 Separator used in environment PATH	                    ; (Windows), : (Linux)
user.home	     Home directory of current user	                        C:\Users\Windows
 */