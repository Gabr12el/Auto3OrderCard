package ru.netology.web;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCardTest {
    private WebDriver driver;

    @BeforeAll
    static void setupAll() {//psv тоже можно
        //просто путь к драйверу выполн перед каждым тестом
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        //инициал поле драйвер. Будет выполн перед кажд тест методом
        driver = new ChromeDriver();
    }

    @AfterEach//после каждого
    void tearsDown() {//закрыть драйвер и занулить
        driver.quit();
        driver = null;
    }

    @Test
    void test() {//открыть драйвер
        driver.get("http://localhost:9999");//бряку ставить чтоб увидеть браузер
//        System.out.println("");
//        driver.findElement().sendKeys("Протопоп Акакий");//Ф.И.
//        driver.findElement().sendKeys("+78881113355");//Телефон
        List<WebElement> textFields = driver.findElements(By.className("input__control"));
        textFields.get(0).sendKeys("Протопоп Акакий");
        textFields.get(1).sendKeys("+78881113355");

        driver.findElement(By.className("checkbox__box")).click();//Галочка
        driver.findElement(By.tagName("button")).click();//Кнопка продоложить
        String actualText = driver.findElement(By.className("order-success")).getText().trim();//трим пробелы убирает
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }
}