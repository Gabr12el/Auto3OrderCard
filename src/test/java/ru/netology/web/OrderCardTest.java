package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderCardTest {
    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        //просто путь к драйверу выполн перед каждым тестом
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        //инициал поле драйвер. Будет выполн перед кажд тест методом
        driver = new ChromeDriver();
    }

    @Test
    void test() {//открыть драйвер
        driver.get("http://localhost:9999");//бряку ставить чтоб увидеть браузер
    }

    @AfterEach
    void tearsDown() {//закрыть драйвер и занулить
        driver.quit();
        driver = null;
    }
}