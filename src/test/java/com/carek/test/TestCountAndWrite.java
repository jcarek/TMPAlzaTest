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

public class TestCountAndWrite {

    @Before
    public void setup(){
    }

    @Test
    public void CountAndWrite () {
        for (int number = 100; number >= 1; number--) {

            if (number % 3 == 0 && number % 5 == 0) {System.out.println("Testing");}
            else if (number % 3 == 0) {System.out.println("Software");}
            else if (number % 5 == 0) {System.out.println("Agile");}
            else {System.out.println(number);}

        }
    }

    @After
    public void close(){

    }

}
