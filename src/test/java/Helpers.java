import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Helpers {
    public void clickElement(AppiumDriver driver, String locator) throws InterruptedException {
        Thread.sleep(5000); //To be removed later
        System.out.println("clicked " + locator);
        driver.findElement(AppiumBy.xpath(locator)).click();
    }

    public void sendKeys(AppiumDriver driver, String locator, String text) throws InterruptedException {
        Thread.sleep(5000); //To be removed later
        driver.findElement(AppiumBy.xpath(locator)).sendKeys(text);
        Thread.sleep(5000); // To be removed later
    }
}
