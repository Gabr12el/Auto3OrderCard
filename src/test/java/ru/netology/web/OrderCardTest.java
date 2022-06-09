package ru.netology.web;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCardTest {
    private WebDriver driver;

    @BeforeAll
    static void setupAll() {//psv тоже можно
        //просто путь к драйверу выполн перед каждым тестом
        System.setProperty("webdriver.chrome.driver", "driver/win/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        //инициал поле драйвер. Будет выполн перед кажд тест методом
        driver = new ChromeDriver();
        //Включение headless режима при использовании selenium необходимо реализовать в коде во время создания экземпляра webdriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
//после каждого
    void tearsDown() {//закрыть драйвер и занулить
        driver.quit();
        driver = null;
    }

    @Test
    void ShouldValid() {//открыть драйвер
        driver.get("http://localhost:9999");//бряку ставить чтоб увидеть браузер
//        System.out.println("");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Протопоп Акакий");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+78881113355");//Телефон
        //А можно делать так:
//        List<WebElement> textFields = driver.findElements(By.className("input__control"));
//        textFields.get(0).sendKeys("Протопоп Акакий");
//        textFields.get(1).sendKeys("+78881113355");
        driver.findElement(By.cssSelector(".checkbox__box")).click();//Галочка
        driver.findElement(By.cssSelector("button")).click();//Кнопка продоложить
        //А можно делать так:
//        driver.findElement(By.className("checkbox__box")).click();//Галочка
//        driver.findElement(By.tagName("button")).click();//Кнопка продоложить
// По лекции Ксюши:
        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();//трим пробелы убирает

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidName1() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Protopop Акакий");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+78881113355");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidName2() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Ёкарный Бабай");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+78881113355");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidName3() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Екарный-Бабай");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+78881113355");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidName4() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Абдурахман ибн Хаттаб");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+78881113355");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }
    @Test
    void ShouldInvalidName5() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Абдурахман");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+78881113355");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }
    @Test
    void ShouldInvalidTel10() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Протопоп Акакий");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+7888111335");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidTel12() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Протопоп Акакий");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+788811133567");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidTelSym() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Протопоп Акакий");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+78р81113355");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidTelSym2() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Протопоп Акакий");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("-78581113355");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidTelSym3() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Протопоп Акакий");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("7+8581113355");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidTelSym4() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Протопоп Акакий");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("88581113355");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidField1() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("88581113355");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidField2() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Протопоп Акакий");//Ф.И.

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

    @Test
    void ShouldInvalidAgree() {
        driver.get("http://localhost:9999");
        //Можно делать по type:
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Protopop Акакий");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+78881113355");//Телефон

        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }
}