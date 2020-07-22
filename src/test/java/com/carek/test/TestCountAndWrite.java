package com.carek.test;

import com.carek.pageFragments.MainMenu;
import com.carek.webPages.HomePage;
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
 * Basic tests of counting
 */
public class TestCountAndWrite {

    /**
     * setup before each test
     */
    @Before
    public void setup(){
    }

    /**
     * counts backwards from 100 to 1 and prints:
     *      “Agile” if the number is divisible by 5,
     *      “Software” if the number is divisible by 3,
     *      “Testing” if the number is divisible by both,
     *      or prints just the number if none of those cases are true
     */
    @Test
    public void CountAndWrite () {
        for (int number = 100; number >= 1; number--) {

            if (number % 3 == 0 && number % 5 == 0) {System.out.println("Testing");}
            else if (number % 3 == 0) {System.out.println("Software");}
            else if (number % 5 == 0) {System.out.println("Agile");}
            else {System.out.println(number);}

        }
    }

    /**
     * setup after each test
     */
    @After
    public void close(){

    }

}
