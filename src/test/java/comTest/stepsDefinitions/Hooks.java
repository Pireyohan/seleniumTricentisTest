package comTest.stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    public static AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        WebDriverManager.chromedriver().setup();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "12.0");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        // capabilities.setCapability(MobileCapabilityType.APP, "/path/to/your/app.apk");
        capabilities.setCapability("appium:browserName", "chrome");
        //capabilities.setCapability("unicodeKeyboard", true);
        //capabilities.setCapability("resetKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(remoteUrl, capabilities);


    }
    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
//
    //    @Before
//    public void beforeScenario() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
////        ChromeOptions options= new ChromeOptions();
////        options.addArguments("--remote-allow-origins=*");
////        driver=new ChromeDriver(options);
//        driver.manage().window().maximize();
//    }
//
//    @After
//    public void afterScenario() {
//        if (driver != null)
//            driver.quit();
//    }

//    @Test
//    public void testExample() {
//        // Perform your test steps using the Appium driver
//        // For example:
//        MobileElement element = driver.findElementById("com.example.app:id/username");
//        element.sendKeys("myusername");
//    }


}


