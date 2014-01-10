import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Date;

public class Start {
  public static void main(String[] args) {
    WebDriver driver = new FirefoxDriver();
//..
    String idProd = "447195";
    String goods = "http://m.miniinthebox.com/ru/gold-plated-salix-leaf-white-diamond-necklace-earring-ring-and-bracelet-jewelry-set_p447195.html";

    driver.get("https://m.miniinthebox.com/ru/index.php?main_page=login");
    WebElement login = driver.findElement(By.id("loginEmail"));
    WebElement pass = driver.findElement(By.id("password"));
    login.sendKeys("zoirs@ya.ru");
    pass.sendKeys("q123456");
    WebElement in = driver.findElement(By.className("litb-btn-new"));
    in.submit();

    driver.get(goods);
    do {

    } while (!(new Date().getMinutes() == 0 && new Date().getSeconds() == 0));

    driver.get(goods);
    System.out.println(new Date());

    WebElement buy = driver.findElement(By.id("submit_" + idProd));
    buy.click();

  }
}
