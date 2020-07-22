package com.carek.webPages;

import com.carek.pageFragments.MainMenu;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Page with the item added to cart
 */
public class AddedItemPage {

    private WebDriver driver;

    //Locators

    //PageFragments
    private MainMenu mainMenu;

    //Constructor
    public AddedItemPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

        // Check all key elements are present
        checkPage();

        // Initialize PageFragments
        mainMenu = new MainMenu(driver);
    }

    // Functions

    /**
     * Check the page for all required elements to be present.
     */
    private void checkPage() {

    }

    // PageFragments functions
    /**
     * @return Main Alza menu
     */
    public MainMenu getMainMenu() {
        return mainMenu;
    }

}