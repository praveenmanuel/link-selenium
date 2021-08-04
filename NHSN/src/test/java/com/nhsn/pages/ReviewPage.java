package com.nhsn.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReviewPage {
    private static WebDriver driver;

    public ReviewPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public void verifyReviewTableExists()
    {
        Assert.assertTrue("Review Table exists", driver.findElement(By.xpath("//nandina-review/table")).isDisplayed());
        System.out.println("Review Table exists on Review Page");
    }

    public void validateColumnNamesOnReviewTable()
    {
        List<WebElement> noOfColumnsOnReviewTable = driver.findElements(By.xpath("//nandina-review/table//tr[1]/th"));
        Assert.assertEquals("No of Columns in the Review Table is not matching", 7, noOfColumnsOnReviewTable.size());

        List expectedColumnNames = new ArrayList();
        expectedColumnNames.add("Measure");
        expectedColumnNames.add("Reporting Period");
        expectedColumnNames.add("Status");
        expectedColumnNames.add("Submitted Date");
        expectedColumnNames.add("Submitter");
        expectedColumnNames.add("Notes");
        expectedColumnNames.add(" ");

        List ActualColumnNames = new ArrayList();
        for(int i=0;i<noOfColumnsOnReviewTable.size(); i++)
        {
            ActualColumnNames.add(noOfColumnsOnReviewTable.get(i).getText());
        }

        Assert.assertTrue("Column Names are not matching on Review Table", ActualColumnNames.equals(expectedColumnNames));
        System.out.println("Column Names are matching as expected on Review Table");

    }



}
