import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginTest {


    public static WebDriver driver;


    @BeforeTest
    public void startChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Анастасия\\Desktop\\JustTestIt\\JustTestIt\\enviroment\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://en.myshows.me/");
    }

    @Test
    public void loginToMyshows() {
        driver.findElement(By.xpath(("//*[@class='modal_login']"))).click();
        driver.findElement(By.id("ajax_login_login")).sendKeys("Sunwel");
        driver.findElement(By.id("ajax_login_password")).sendKeys("A771d6552");
        driver.findElement(By.id("ajax_login")).click();

        Assert.assertTrue(driver.getTitle().contains("MyShows"), "Login is successful!");

    }
    @Test (priority = 1)
    public void selectShowsFromList() throws InterruptedException {
        String MyShow = "Lost";
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[contains(@href,'/search/all/')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'myshows.me/view/8/')]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/a")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[contains(@href,'/profile/favorites/')]")).click();

        Assert.assertEquals((MyShow),"Lost");

        //remove from favorites
        driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[2]/div/div/a[2]")).click();

    }
}