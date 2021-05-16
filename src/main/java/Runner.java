import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * JDK 8, Genymotion emulator, Google Pixel 2 (Android 9.0).
 */
public class Runner {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "192.168.243.102:5555");
        caps.setCapability("platformName", "Android");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        /*
        Testing main features
        */
        MobileElement leftfield = (MobileElement) driver
            .findElementById("com.vbanthia.androidsampleapp:id/inputFieldLeft");
        leftfield.click();
        leftfield.sendKeys("5");

        MobileElement rightfield = (MobileElement) driver
            .findElementById("com.vbanthia.androidsampleapp:id/inputFieldRight");
        rightfield.click();
        rightfield.sendKeys("5");

        MobileElement result = (MobileElement) driver.findElementByXPath(
            "//android.widget.TextView[@resource-id='com.vbanthia.androidsampleapp:id/resultTextView']");

        //Add
        MobileElement add = (MobileElement) driver
            .findElementById("com.vbanthia.androidsampleapp:id/additionButton");
        add.click();
        String res1 = result.getText();
        if (!result.getText().equals("5.00 + 5.00 = 10.00")) {
            System.out.println("FAIL = " + res1);
        } else {
            System.out.println("Addition result OK = " + res1);
        }

        //Subtract
        MobileElement subtract = (MobileElement) driver
            .findElementById("com.vbanthia.androidsampleapp:id/subtractButton");
        subtract.click();
        String res2 = result.getText();
        if (!result.getText().equals("5.00 - 5.00 = 0.00")) {
            System.out.println("FAIL = " + res2);
        } else {
            System.out.println("Subtraction result OK = " + res2);
        }

        //Multiply
        MobileElement multiply = (MobileElement) driver
            .findElementById("com.vbanthia.androidsampleapp:id/multiplicationButton");
        multiply.click();
        String res3 = result.getText();
        if (!result.getText().equals("5.00 * 5.00 = 25.00")) {
            System.out.println("FAIL = " + res3);
        } else {
            System.out.println("Multiplication result OK = " + res3);
        }

        //Divide
        MobileElement divide = (MobileElement) driver
            .findElementById("com.vbanthia.androidsampleapp:id/divisionButton");
        divide.click();
        String res4 = result.getText();
        if (!result.getText().equals("5.00 / 5.00 = 1.00")) {
            System.out.println("FAIL = " + res4);
        } else {
            System.out.println("Division result OK = " + res4);
        }

        //Reset
        MobileElement reset = (MobileElement) driver
            .findElementById("com.vbanthia.androidsampleapp:id/resetButton");
        reset.click();
        //Divide by zero
        leftfield.click();
        leftfield.sendKeys("5");
        rightfield.click();
        rightfield.sendKeys("0");
        divide.click();
        String res5 = result.getText();
        if (!result.getText().equals("5.00 / 0.00 = Infinity")) {
            System.out.println("FAIL = " + res5);
        } else {
            System.out.println("Division by zero result OK = " + res5);
        }
        //Correct input test
        leftfield.click();
        leftfield.sendKeys("?");
        rightfield.click();
        rightfield.sendKeys("?");
        add.click();
        String res6 = result.getText();
        if (!result.getText().equals("Please, fill the input fields correctly")) {
            System.out.println("FAIL = " + res6);
        } else {
            System.out.println("Correct input test OK = " + res6);
        }
        driver.quit();


    }
}