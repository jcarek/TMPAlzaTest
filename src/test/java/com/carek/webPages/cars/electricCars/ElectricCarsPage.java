package com.carek.webPages.cars.electricCars;

import com.carek.pageFragments.MainMenu;
import com.carek.webPages.AddedItemPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Category of electric cars
 */
public class ElectricCarsPage {

    private WebDriver driver;

    //Locators
    /**
     * Sort button by price desc
     */
    @FindBy(id = "ui-id-3")
    private WebElement sortByPriceDesc;

    /**
     * Div container including all items on page
     */
    @FindBy(id = "boxes")
    private WebElement containerOfBoxes;

    //PageFragments
    private MainMenu mainMenu;
    private AddedItemPage addedItemPage;

    //Constructor
    public ElectricCarsPage(WebDriver driver){
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
        Assert.assertTrue("Sorting Desc button not displayed.",sortByPriceDesc.isDisplayed());
    }

    /**
     * @return refreshed page after sorted products by price desc
     */
    public ElectricCarsPage sortByPriceDesc() {
        sortByPriceDesc.click();
        return this;
    }

    /**
     * Write to console some first items
     * @param numberOfItems How many first items to write down to console
     */
    public void writeDownFirstItems(int numberOfItems) {
        System.out.println("First "+numberOfItems+" items");
        List<WebElement> boxes = containerOfBoxes.findElements(By.xpath("./div[contains(@class,'box')]"));

        Assert.assertTrue("There is just "+boxes.size()+" items, not "+numberOfItems+".",(boxes.size() > numberOfItems));

        for (int i = 1; i <= numberOfItems; i++) {
            Assert.assertTrue("Item is not visiable.",boxes.get(i).isDisplayed());
            String name = boxes.get(i).findElement(By.xpath(".//a[contains(@class,'name')]")).getText();
            String price = boxes.get(i).findElement(By.xpath(".//span[contains(@class,'c2')]")).getText();
            System.out.println("Name: " + name + " ; Price: " + price);
        }
    }

    /**
     * Add the n-th most expensive item on page to cart
     * @param order Order of item on page to add to cart sorted by price desc
     * @return Webpage of added item
     */
    public AddedItemPage addMostExpensive(int order) {
        List<WebElement> boxes = containerOfBoxes.findElements(By.xpath("./div[contains(@class,'box') and descendant::span[contains(@class,'c2')]]"));

        int price1 = 0;
        int price2 = 0;
        WebElement element1 = null;
        WebElement element2 = null;
        // Sorry, short of time.

        for (WebElement box : boxes) {
            String name = box.findElement(By.xpath(".//a[contains(@class,'name')]")).getText();
            String priceString = box.findElement(By.xpath(".//span[contains(@class,'c2')]")).getText().replaceAll("[^0-9]", "");
            int price = Integer.parseInt(priceString);
            System.out.println("Name: " + name + " ; Price: " + price);

            if (price > price1) {
                if (price1 > price2) {
                    price2 = price1;
                    element2 = element1;
                }
                price1 = price;
                element1 = box;
            } else if (price > price2) {
                price2 = price;
                element2 = box;
            }
        }

        if (order == 1) {
            element1.findElement(By.xpath(".//a[@class='btnk1']")).click();
        }
        else if (order == 2 ){
            element2.findElement(By.xpath(".//a[@class='btnk1']")).click();
        }
        else {Assert.fail("Invalid number.");}
        addedItemPage = new AddedItemPage(driver);
        return addedItemPage;
    }

    /**
     * @return Main Alza menu
     */
    // PageFragments functions
    public MainMenu getMainMenu() {
        return mainMenu;
    }

}