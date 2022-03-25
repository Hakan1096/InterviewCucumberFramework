package com.stepDefinitions;

import com.pages.BasePage;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import java.util.SortedMap;
import java.util.TreeMap;

public class FlipKartTask extends BasePage {
    SortedMap<Integer, String> productPrice = new TreeMap<>();

    @Given("go to FlipKart page")
    public void go_to_FlipKart_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        close.click();
    }

    @When("search the {string}")
    public void searchThe(String product) {
        searchBox.sendKeys(product + Keys.ENTER);
    }

    @And("click to Brand and search {string}")
    public void clickToBrandAndSearch(String model) {
        BrowserUtils.clickWithJS(brandButton);
        brandSearch.sendKeys(model+ Keys.ENTER);
        LgOption.click();
    }

    @Then("take all the product's names with prices on the page")
    public void take_all_the_products_name_with_price_on_page() {

        for (int i = 0; i < productNames.size(); i++) {

            try {
                Thread.sleep(1000);
                productPrice.put(Integer.parseInt(productPrices.get(i).getText().replace("₹", "")
                        .replace(",", "")), productNames.get(i).getText());
            } catch (Exception e) {

                break;
            }
        }
    }

    @Then("sort of the all products via price")
    public void sort_of_the_all_products_via_price() {

        for (Integer price : productPrice.keySet()) {
            System.out.println(productPrice.get(price) + " : " + price);
        }

    }



}
