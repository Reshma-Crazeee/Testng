package SeleTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Application {
    ChromeDriver driver;
    String url = "https://demo.guru99.com/v4/";
//  @BeforeMethod
  @Test(priority = -100)
    public void invokeBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\RKANDREG\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
  @Test(priority = 10)
    public void verifyTitle(){
        String expectedTitle = "Guru99 Bank Home Page";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle,expectedTitle);
    }

//    User ID :	mngr451862
//    Password :	hUpebEn
//    @Test(priority = 100,enabled = false)
    @Test(priority = 100)
    public void loginApp(){
        WebElement userId = driver.findElement(By.name("uid"));
        WebElement pswd = driver.findElement(By.name("password"));
        WebElement lgnBtn = driver.findElement(By.name("btnLogin"));

        userId.sendKeys("mngr451862");
        pswd.sendKeys("hUpebEn");
        lgnBtn.click();
    }
    @Test(priority = 200)
    public void newCustomer(){
      WebElement newCust = driver.findElement(By.linkText("New Customer"));
      newCust.click();
        driver.findElement(By.name("name")).sendKeys("peterpan");
        driver.findElement(By.xpath("//input[@value='f']")).click();
        driver.findElement(By.name("dob")).sendKeys("24-08-2002");
        driver.findElement(By.name("addr")).sendKeys("235 Calef Hwy");
        driver.findElement(By.name("city")).sendKeys("Epping");
        driver.findElement(By.name("state")).sendKeys("New Jersy");
        driver.findElement(By.name("pinno")).sendKeys("030426");
        driver.findElement(By.name("telephoneno")).sendKeys("6036798225");
        driver.findElement(By.name("emailid")).sendKeys("pubgame@gmail.com");
        driver.findElement(By.name("password")).sendKeys("pubgame123");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wd.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("sub"))));
        driver.findElement(By.name("sub")).click();

    }
    @Test(priority = 210)
    public void getCustId(){
      String custId = driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();
      System.out.println("Customer Id- "+custId);
      driver.findElement(By.linkText("Continue")).click();
//      driver.findElement(By.linkText("Delete Customer")).click();
//      driver.findElement(By.name("cusid")).sendKeys(custId);
//      driver.findElement(By.name("AccSubmit")).click();
//      driver.findElement(By.name("telephoneno")).sendKeys("9936798225");
//      driver.findElement(By.name("sub")).click();

//      Alert nrmlAlt = driver.switchTo().alert();
//      nrmlAlt.accept();
    }

//     @Test(priority = 250)
//    public void editCust(){
//    }
}
