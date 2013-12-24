import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Date;

public class Start {
  public static void main(String[] args) {
    WebDriver driver = new FirefoxDriver();

    String idProd = "370647";
    String price = "";
    String goods = "http://m.miniinthebox.com/ru/premium-charge-and-sync-cable-for-ipad-2-ipad-iphone-ipods-1m-white-_p197167.html";

    driver.get("https://m.miniinthebox.com/ru/index.php?main_page=login");
    WebElement login = driver.findElement(By.id("loginEmail"));
    WebElement pass = driver.findElement(By.id("password"));
    login.sendKeys("zoirs@ya.ru");
    pass.sendKeys("q123456");
    WebElement in = driver.findElement(By.className("litb-btn-new"));
    in.submit();

    driver.get(goods);
    WebElement isSale = null;
    int i=0;
    do {
//      нужно ли тут перезагружать страницу?
      i++;
      try {
        isSale = driver.findElement(By.id("salePrice_" + idProd));
      } catch (NoSuchElementException e) {
        System.out.println("Написать чтобы повторилось");
      }
    }
    while (!(isSale != null && isSale.getText().contains(price)) || i>1000);

    WebElement buy = null;
    try {
      buy = driver.findElement(By.id("submit_" + idProd));
    } catch (NoSuchElementException e) {
      System.out.println("Почему нет ?");
    }

    if (buy != null) {
      buy.click();
    }

  }
}
