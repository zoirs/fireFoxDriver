import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Date;

public class Start {
  public static void main(String[] args) {
    WebDriver driver = new FirefoxDriver();

    String idProd = "240560";
    String price = "24,79";
    String goods = "http://m.miniinthebox.com/ru/universal-car-windshield-swivel-mount-for-cell-phones_p240560.html";
    int countTry = 2;

    driver.get("https://m.miniinthebox.com/ru/index.php?main_page=login");
    WebElement login = driver.findElement(By.id("loginEmail"));
    WebElement pass = driver.findElement(By.id("password"));
    login.sendKeys("zoirs@ya.ru");
    pass.sendKeys("q123456");
    WebElement in = driver.findElement(By.className("litb-btn-new"));
    in.submit();

    driver.get(goods);
    WebElement isSale = null;
    int i = 0;
    do {
      driver.get(goods);
      i++;
      try {
        isSale = driver.findElement(By.id("salePrice_" + idProd));
      } catch (NoSuchElementException ignored) {
      } finally {
        System.out.println("Попытка " + i + ", время: " + new Date() + " " + (isSale != null ? isSale.getText() : "не найден елемент цена распродажи"));
      }
    }
    while (!(isSale != null && isSale.getText().contains(price)) && i < countTry);

    if (i < countTry) {
      if (isSale.getText().contains(price)) {
        System.out.println("Найдена скидка!");
      }
    } else {
      System.out.println("Превысило " + i + " попыток");
    }

    WebElement buy = null;
    try {
      buy = driver.findElement(By.id("submit_" + idProd));
    } catch (NoSuchElementException e) {
      System.out.println("Не найдена кнопка купить");
    }

    if (buy != null) {
      buy.click();
    }

  }
}
