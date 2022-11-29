package tests;

import org.junit.jupiter.api.*;
import pages.*;
import runners.WebDriverTest;

import java.awt.*;

public class WebTest {

    AmazonSizeSelect amazonSizeSelect = new AmazonSizeSelect();

    @BeforeAll
    public static void beforeScope(){
        Hooks.beforeScope();
    }

    @AfterAll
    public static void afterScope(){
        Hooks.afterScope();
    }


    @WebDriverTest
    public void searchInAmazon() throws InterruptedException {
        amazonSizeSelect.searchUrl();
    }

}


