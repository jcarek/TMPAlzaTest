package com.carek.pageFragments;

import com.carek.webPages.cars.CarsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Alza main menu containing links to basic categories and searching
 */
public class MainMenu {

    private WebDriver driver;

    //Locators
    @FindBy(how = How.XPATH, using="//a[@data-type='auto']")
    private WebElement auto;

    //PageFragments
    private CarsPage carsPage;


    public MainMenu(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

        // Check all key elements are present
        checkPage();

        // Initialize PageFragments

    }

    // Functions

    /**
     * Check the page for all required elements to be present.
     */
    private void checkPage() {
        Assert.assertTrue("Auto link is not present",auto.isDisplayed());
    }

    /**
     * @return Cars category page
     */
    public CarsPage goToAuto() {
        System.out.println("Clicking on Auto");
        auto.click();
        carsPage = new CarsPage(driver);
        return carsPage;
    }


}
