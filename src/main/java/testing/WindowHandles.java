package testing;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    WebDriver driver;
    String parentWin;
    String pswd ="Okay";
    String email ="hybrid@tutorial.com";
    public void OpenWebsite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RKANDREG\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/");
        driver.findElement(By.xpath("//ul[@id='nav1']/li[4]/a")).click();
        driver.findElement(By.xpath("//ul[@id='nav1']/li[4]/ul/li[6]")).click();
        driver.findElement(By.xpath("(//input[@id='name' and @type='text'])")).click();
    }

    public void NewWindow() throws InterruptedException, AWTException {
        driver.findElement(By.id("name")).sendKeys("testing windows handling");
        driver.findElement(By.id("newWindowBtn")).click();

        parentWin = driver.getWindowHandle();
        Set<String> allWins = driver.getWindowHandles();
        for (String cldWin : allWins) {
            if (!parentWin.equals(cldWin)) {
                driver.switchTo().window(cldWin);
                driver.manage().window().maximize();

                driver.findElement(By.id("frenchchbx")).click();
                driver.findElement(By.id("latinchbx")).click();
                driver.findElement(By.id("chinesechbx")).click();
                driver.findElement(By.id("registerbtn")).click();
                System.out.println(driver.findElement(By.id("msg")).getText());
                Thread.sleep(3000);
                driver.close();
            }
        }
        driver.switchTo().window(parentWin);
        Thread.sleep(5000);

        //Robot Class
//        Robot rob=new Robot();
//        for(int a=0;a<3;a++){
//            rob.keyPress(KeyEvent.VK_DOWN);
//            rob.keyRelease(KeyEvent.VK_DOWN);
//        }

    }

    public void NewTab() throws InterruptedException {
        driver.findElement(By.id("newTabBtn")).click();
        Thread.sleep(3000);
        parentWin = driver.getWindowHandle();
        Set<String> allWins = driver.getWindowHandles();
        for (String cldWins : allWins) {
            if (!parentWin.equals(cldWins)) {
                driver.switchTo().window(cldWins);

                //nrml alert
                driver.findElement(By.id("alertBox")).click();
                Alert basicAlt = driver.switchTo().alert();
                System.out.println("Alert box" );
                basicAlt.accept();
                System.out.println(driver.findElement(By.id("output")).getText());
                Thread.sleep(5000);

                //confirm alert
                driver.findElement(By.id("confirmBox")).click();
                Alert cnfrmAlt = driver.switchTo().alert();
                System.out.println("confirm box");
                cnfrmAlt.dismiss();
                System.out.println(driver.findElement(By.id("output")).getText());
                Thread.sleep(5000);

                //prompt box
                driver.findElement(By.id("promptBox")).click();
                Alert prmptAlt = driver.switchTo().alert();
                System.out.println("prompt box" );
                prmptAlt.sendKeys("magnesium Suphate");
                prmptAlt.accept();
                System.out.println(driver.findElement(By.id("output")).getText());

                Thread.sleep(5000);
                driver.close();
            }
            driver.switchTo().window(parentWin);
//            driver.close();
        }
    }

    public void MultipleWin() throws InterruptedException {
        driver.findElement(By.id("newWindowsBtn")).click();
        Thread.sleep(3000);

        //Multiple windows
        parentWin = driver.getWindowHandle();
        Set<String> allwin = driver.getWindowHandles();
        Iterator<String> iterator1 = allwin.iterator();
        while (iterator1.hasNext()) {
            String cldWin = iterator1.next();
            if (!parentWin.equalsIgnoreCase(cldWin)) {
                driver.switchTo().window(cldWin);
                driver.manage().window().maximize();

                //2 windows
                if ((driver.getTitle()).contains("XPath Practice")) {
                    driver.findElement(By.xpath("//div[@class='container']/input[3]")).sendKeys(email);
                    driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(pswd);
                    driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(pswd);
                    driver.findElement(By.xpath("(//button[@type='submit'])")).click();
//                    Thread.sleep(3000);
                    driver.close();

                } else if ((driver.getTitle()).contains("Basic Controls")) {
                    driver.findElement(By.id("femalerb")).click();
                    driver.findElement(By.id("registerbtn")).click();
                    System.out.println(driver.findElement(By.id("msg")).getText());
                    Thread.sleep(3000);
                    driver.close();
                }
            }

        }
        driver.switchTo().window(parentWin);
//        driver.close();
    }

    public void MultiWinTab() throws InterruptedException {
        driver.findElement(By.id("newTabsWindowsBtn")).click();
        Thread.sleep(3000);

        //multi Tab
        parentWin = driver.getWindowHandle();
        Set<String> allwin = driver.getWindowHandles();
        Iterator<String> tabItr = allwin.iterator();

        while (tabItr.hasNext()) {
            String cldwin = tabItr.next();
            if (!parentWin.equalsIgnoreCase(cldwin)) {
                driver.switchTo().window(cldwin);

                if ((driver.getTitle()).contains("AlertsDemo")) {
                    driver.findElement(By.id("promptBox")).click();
                    Alert cnfrmAlt = driver.switchTo().alert();
                    System.out.println("Prompt Box");
                    cnfrmAlt.sendKeys("Hypo Sulphate");
                    cnfrmAlt.accept();
                    System.out.println(driver.findElement(By.id("output")).getText());
                    Thread.sleep(3000);
                    driver.close();
                } else if ((driver.getTitle()).contains("Basic Controls")) {
                    driver.findElement(By.id("registerbtn")).click();
                    System.out.println(driver.findElement(By.id("msg")).getText());
                    Thread.sleep(3000);
                    driver.close();
                }
                else if((driver.getTitle()).contains("Contact Me")){
                    driver.manage().window().maximize();
                    driver.findElement(By.xpath("(//input[@class='contact-form-email'])[1]")).sendKeys(email);
                    driver.findElement(By.xpath("(//textarea[@class='contact-form-email-message'])[1]")).sendKeys("am nitogren peroxide");
                    driver.findElement(By.xpath("(//input[@id='ContactForm1_contact-form-submit'])[1]")).click();
                    Thread.sleep(3000);
                    driver.close();
                }else if ((driver.getTitle()).contains("XPath Practice")){
                    driver.manage().window().maximize();
                    driver.findElement(By.xpath("//div[@class='container']/input[3]")).sendKeys(email);
                    driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(pswd);
                    driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(pswd);
                    driver.findElement(By.xpath("(//button[@type='submit'])")).click();
                    Thread.sleep(3000);
                    driver.close();
                }
            }
        }
            driver.switchTo().window(parentWin);
             Thread.sleep(3000);
            driver.quit();
        //multi win

    }
  }


