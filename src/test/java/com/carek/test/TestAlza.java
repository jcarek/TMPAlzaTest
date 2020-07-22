package com.carek.test;

import com.carek.pageFragments.MainMenu;
import com.carek.webPages.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.testng.Arquillian;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Test the Alza eshop
 */
@RunAsClient
public class TestAlza extends Arquillian {

    @Drone
    WebDriver driver;

    @Page
    HomePage homePage;

    /**
     * Set browser before all tests
     */
    @Before
    public void setup(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Search for the two most expensive electric cars
     * and add them to cart
     */
    @Test
    public void SearchTwoMostExpensive () {
        homePage = new HomePage(driver);
        MainMenu menu = homePage.getMainMenu();
        menu.goToAuto()
                .goToElectricCars()
                .sortByPriceDesc()
                .addMostExpensive(1)
                .getMainMenu()
                .goToAuto()
                .goToElectricCars()
                .addMostExpensive(2);
    }

    /**
     * close the browser after each test
     */
    @After
    public void close(){
        driver.close();
    }

}
