package POModel.abvBG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LoginPage {
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
    LoginPage one=new LoginPage();
    one.setUp();
    one.driver.get("https://www.youtube.com");
    one.close();
}
}