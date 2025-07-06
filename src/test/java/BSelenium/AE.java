package BSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


public class AE {
    public static void main (String srgs[]) throws IOException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        String br = "chrome";
//        switch(br.toLowerCase()){
//            case "chrome" :
//                WebDriverManager.chromedriver().setup();
//                WebDriver driver = new ChromeDriver();
//                driver.manage().window().maximize();
//                driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//                break;
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                WebDriver driver2 = new FirefoxDriver();
//                driver2.manage().window().maximize();
//                driver2.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//                break;
//            default:
//                System.out.println("Unsupported browser: " + br);
//        }

        String execution_Env = "remote";
        WebDriver Rdriver = null;
        if(execution_Env.equalsIgnoreCase("remote")){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //capabilities.setPlatform(Platform.WIN10);
            capabilities.setPlatform(Platform.LINUX);
            capabilities.setBrowserName("chrome");
            Rdriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        }
        Rdriver.manage().window().maximize();
        Rdriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

}

/*
standalone : dowload grid i.e selenium-server jar
             open in same loction cmd java -jar selenium-server-4.33.0.jar standalone -> link will be genetared copy it and paste in chromeGrid can see Overview and sessions -> Run remote code [can run with tetng.xml also]
Hub & Node(Numtile VM) :
Docker : Make hub & node in one network
         install docker form online -> open win cmd -> pull the image -> craete container -> so that in selenium gid we can wee all the nodes -> based on our image upadate in capabilites then run the code[it is head less tetsing]
  Instead of executing all the commands in cmd everytime
  we create congigaration file docker-compose.yaml file

 */