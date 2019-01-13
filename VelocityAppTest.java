package com.heisideus;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Web Driver automated test for Velocity App.
 */
public class VelocityAppTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass()
    {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest()
    {
        driver = new ChromeDriver();
    }

    @After
    public void teardown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }

    @Test
    public void velocityAppTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        String navigationBarOpenBusinessDropdownBox = "[id='top-menu'] li:nth-child(3) a";
        String velocityHomePageNavigationSmallCommercialDropdownBoxAnchor = "[id='top-menu'] li:nth-child(3) ul li:nth-child(2) a";
        String velocityHomePageUrl = "http://velocityrisk.com/";
        String smallCommercialBusinessPageUrl = "http://velocityrisk.com/for-businesses/small_business/";
        String smallCommercialBusinessPageUnlockImgAltAttribute = "Alt";
        String smallCommercialBusinessPageUnlockImgAltAttributeValue = "Financial Strength";
        String smallCommercialBusinessPageUnlockImgPath = "body > div.velocity_advantage_part > div > div:nth-child(3) > div.velocity_advantage_leftpart > picture > img";
        String smallCommercialBusinessPageTVEFinancialStrengthParagraph = "Experience peace of mind knowing we have the funds to deliver on our promise when it matters the most.";
        String smallCommercialBusinessPageTVEFinancialStrengthParagraphPath = "body > div.velocity_advantage_part > div > div:nth-child(3) > div.velocity_advantage_rightpart > p:nth-child(3)"; 

        //Step1
        driver.get(velocityHomePageUrl);
        wait.until(ExpectedConditions.urlToBe(velocityHomePageUrl));
        //Step2
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(navigationBarOpenBusinessDropdownBox)));
        driver.findElement(By.cssSelector(navigationBarOpenBusinessDropdownBox)).click();
        //Step3
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(velocityHomePageNavigationSmallCommercialDropdownBoxAnchor)));
        driver.findElement(By.cssSelector(velocityHomePageNavigationSmallCommercialDropdownBoxAnchor)).click();
        //Step 4
        wait.until(ExpectedConditions.urlToBe(smallCommercialBusinessPageUrl));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(smallCommercialBusinessPageUnlockImgPath))));
        wait.until(ExpectedConditions.attributeContains(By.cssSelector(smallCommercialBusinessPageUnlockImgPath), smallCommercialBusinessPageUnlockImgAltAttribute, smallCommercialBusinessPageUnlockImgAltAttributeValue));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(smallCommercialBusinessPageTVEFinancialStrengthParagraphPath), smallCommercialBusinessPageTVEFinancialStrengthParagraph));

    }

}
