package tests;

import org.junit.jupiter.api.*;
import pages.*;

import java.awt.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WebTest {

    GoogleSearch googleSearch = new GoogleSearch();
    MMTSearch mmtSearch = new MMTSearch();
    SerenityPageTrial serenityPageTrial;
    AmazonSizeSelect amazonSizeSelect = new AmazonSizeSelect();

    @BeforeAll
    public static void beforeScope(){
        Hooks.beforeScope();
    }

    @AfterAll
    public static void afterScope(){
        Hooks.afterScope();
    }

    //@Test
    public void searchForMMT() throws InterruptedException {
        googleSearch.searchUrl("make my trip");
        String pageTitle = googleSearch.clickUrl("makemytrip.com");
        Assertions.assertTrue(
                pageTitle.equalsIgnoreCase("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday"),
                "Title of the page is not as expected");
    }

    //@Test
    public void searchForAllBookNowTitles() throws InterruptedException {
        searchForMMT();
        googleSearch.getTitlesPreceedingBookNow();
    }

    //Setting below scenario to run first as the language pop up throws error when run later
    @Order(1)
    //@Test
    public void changeDestination() throws InterruptedException {
        searchForMMT();
        mmtSearch.searchFlightsAfterSelectingDestination(null,"Hyderabad");
        serenityPageTrial.isDriverInit();
    }

    //@Test
    public void getCountOfStatus() throws InterruptedException {
        //Get the count of status in the table
        new TableCount().statusCount();
    }


    @Test
    public void searchByImage() throws InterruptedException, AWTException {
        googleSearch.searchByImage();
    }

    @Test
    public void searchInAmazon() throws InterruptedException {
        amazonSizeSelect.searchUrl();
    }

}


