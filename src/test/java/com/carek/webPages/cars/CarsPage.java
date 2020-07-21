package com.carek.webPages.cars;

import com.carek.pageFragments.MainMenu;
import com.carek.webPages.cars.electricCars.ElectricCarsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarsPage {

    private WebDriver driver;

    //Locators
    @FindBy(id = "litp18867409")
    private WebElement electricCars;

    //PageFragments
    private MainMenu mainMenu;
    private ElectricCarsPage electricCarsPage;

    //Constructor
    public CarsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

        // Check all key elements are present
        checkPage();

        // Initialize PageFragments
        mainMenu = new MainMenu(driver);
    }

    // Functions
    private void checkPage() {
        Assert.assertTrue("Electric cars button not displayed.",electricCars.isDisplayed());
    }

    public ElectricCarsPage goToElectricCars() {
        electricCars.click();
        electricCarsPage = new ElectricCarsPage(driver);
        return electricCarsPage;
    }

    // PageFragments functions
    public MainMenu getMainMenu() {
        return mainMenu;
    }

}