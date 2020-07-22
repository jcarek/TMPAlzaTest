package com.carek.webPages;

import com.carek.pageFragments.MainMenu;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Alza home page
 */
public class HomePage {

    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="http://www.alza.cz";

    //Locators
    @FindBy(how = How.XPATH, using="//div[@id='logo']")
    private WebElement logo;

    //PageFragments
    private MainMenu mainMenu;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
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
        Assert.assertTrue("Title not matched.", driver.getTitle().contains("Alza"));
        Assert.assertTrue("Logo is not present",logo.findElement(By.xpath("./a")).getAttribute("title").contains("Alza.cz"));
    }

    // PageFragments functions
    /**
     * @return Main Alza menu
     */
    public MainMenu getMainMenu() {
        return mainMenu;
    }

}