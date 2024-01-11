import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class tvAutomation {

    private AndroidDriver driver;
    private Helpers helpers;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Before
    public void setUp() {
        BaseOptions options = new BaseOptions<>()
                .amend("platformName", "Android")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:deviceName", "deviceID")
                .amend("appium:appPackage", "com.crunchyroll.crunchyroid")
                .amend("appium:appActivity", ".splash.ui.SplashActivity")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(this.getUrl(), options);
    }

    @Test
    public void sampleTest() throws InterruptedException {
        helpers = new Helpers();
        helpers.clickElement(driver, "//android.view.View[@resource-id=\"login\"]");
        helpers.clickElement(driver, "//android.view.View[@resource-id=\"emailLoginNavDrawer\"]");
        helpers.sendKeys(driver, "//android.widget.EditText[@resource-id=\"emailTextField\"]", "email");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}