package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css="._2KpZ6l._2doB4z")
    public WebElement close;

    @FindBy(xpath="//*[@name=\"q\"]")
    public WebElement searchBox;

    @FindBy(xpath="//*[text()='Brand']")
    public WebElement brandButton;

    @FindBy(css="._34uFYj")
    public WebElement brandSearch;

    @FindBy(xpath="//div[text()='LG']")
    public WebElement LgOption;

    @FindBy(css=".s1Q9rs")
    public List<WebElement> productNames;

    @FindBy(xpath="//div[@class='_25b18c']/div[1]")
    public List<WebElement> productPrices;

}
