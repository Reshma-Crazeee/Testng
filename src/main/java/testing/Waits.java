package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Waits {
     WebDriver driver;

    public void MainWaits(){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\RKANDREG\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.hyrtutorials.com/");
    }
    public void WaitsPractice() throws InterruptedException {
        driver.findElement(By.xpath("//ul[@id='nav1']/li[4]/a")).click();
        driver.findElement(By.xpath("//ul[@id='nav1']/li[4]/ul/li[5]")).click();
        driver.findElement(By.xpath("//button[@id='btn1']")).click();
        driver.findElement(By.xpath("//button[@id='btn2']")).click();
        //Implicit Wait

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement textbox1val = driver.findElement(By.xpath("(//input[@id='txt1'])[1]"));
        textbox1val.sendKeys("Calcium bicarbonate");
        System.out.println("textbox1 clicked");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

      //Explicit Wait
       WebElement textbox2val = driver.findElement(By.xpath("(//input[@id='txt2' and @type='text'])[1]"));
//
        WebDriverWait txt2 =  new WebDriverWait(driver, Duration.ofSeconds(12));
        txt2.until(ExpectedConditions.visibilityOf(textbox2val));
        textbox2val.sendKeys("hydroChloricacid");
        System.out.println("textbox2 clicked");

        driver.quit();
    }
}


