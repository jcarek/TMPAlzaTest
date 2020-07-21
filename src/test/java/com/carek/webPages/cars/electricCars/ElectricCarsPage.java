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

public class ElectricCarsPage {

    private WebDriver driver;

    //Locators
    @FindBy(id = "ui-id-3")
    private WebElement sortByPriceDesc;

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
    private void checkPage() {
        Assert.assertTrue("Sorting Desc button not displayed.",sortByPriceDesc.isDisplayed());
    }

    public ElectricCarsPage sortByPriceDesc() {
        sortByPriceDesc.click();
        return this;
    }

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

    public AddedItemPage addMostExpensive(int order) {
        List<WebElement> boxes = containerOfBoxes.findElements(By.xpath("./div[contains(@class,'box') and descendant::span[contains(@class,'c2')]]"));

        Integer price1 = 0;
        Integer price2 = 0;
        WebElement element1 = null;
        WebElement element2 = null;
        // Sorry, short of time.

        for (int i = 0; i < boxes.size(); i++) {
            String name = boxes.get(i).findElement(By.xpath(".//a[contains(@class,'name')]")).getText();
            String priceString = boxes.get(i).findElement(By.xpath(".//span[contains(@class,'c2')]")).getText().replaceAll("[^0-9]","");
            Integer price = Integer.valueOf(priceString);
            System.out.println("Name: " + name + " ; Price: " + price);

            if(price > price1) {
                if (price1 > price2) {
                    price2 = price1;
                    element2 = element1;
                }
                price1 = price;
                element1 = boxes.get(i);
            }
            else if (price > price2) {
                price2 = price;
                element2 = boxes.get(i);
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

    // PageFragments functions
    public MainMenu getMainMenu() {
        return mainMenu;
    }

}