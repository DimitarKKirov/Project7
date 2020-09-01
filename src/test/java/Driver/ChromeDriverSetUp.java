package Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class ChromeDriverSetUp {
    WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Poject7\\src\\Drivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("--start-maximized", "--disable-extensions");
        driver = new ChromeDriver(options);


    }
public void close(){
        driver.close();
}


public static void main(String[] args) {
    ChromeDriverSetUp one=new ChromeDriverSetUp();
    one.setUp();
    one.driver.get("https://www.youtube.com");
    one.close();
}
}