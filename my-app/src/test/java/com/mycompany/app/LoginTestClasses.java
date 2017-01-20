package com.mycompany.app;

import Config.ConfigData;
import Lib.UtilMethods;
import PageObjects.LoginPageObjects;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Hashtable;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LoginTestClasses
{

    //web driver -- you can select ie, chrome
    public  static WebDriver driver =  new Lib.UtilMethods().InitializeWebDriver("chrome");

    //Page objects
    LoginPageObjects login = PageFactory.initElements(driver, LoginPageObjects.class);

    //Util Objects
    UtilMethods utilObj = new Lib.UtilMethods();

    //Wait objects
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Test
    public void VerifyPageAllElements()
    {
        //lauch URL
        driver.get(ConfigData.strURL);
        driver.manage().window().maximize();

        //Check if all web objects exists
        Hashtable elemList = login.CreateLoginElemTable();
        List testResult = utilObj.CheckWebElements(elemList);
        if(!testResult.isEmpty()){
            System.out.println("=====Following Web Element Missing: " + testResult);
        }
        assertTrue(testResult.isEmpty());
        //driver.close();
   }

    @Test
    public void VerifyMissingMandatoryErrMsg()
    {
        //launch URL
        driver.get(ConfigData.strURL);
        driver.manage().window().maximize();

        //Click Continue without entering any data
        login.btnContinue.click();
        assertEquals("6 Questions have not been completed or have been filled incorrectly", login.txtErrMsg.getText());
        assertEquals("Please select an option", login.txtTitleErr.getText());
        assertEquals("Please enter your first name in letters only between 2 and 15 characters in length", login.txtFirstnameErr.getText());
        assertEquals("Please enter your surname in letters only between 2 and 20 characters in length", login.txtSurnameErr.getText());
        assertEquals("Please enter a valid date of birth", login.txtDOBErr.getText());
        assertEquals("Please enter your house number or name. House names should be between 2 and 40 characters in length", login.txtHouseNoErr.getText());
        assertEquals("Postcode is required", login.txtPostcodeErr.getText());

        //Add Title and click Continue
        login.ddlMR.click();
        login.btnContinue.click();
        assertEquals("5 Questions have not been completed or have been filled incorrectly", login.txtErrMsg.getText());
        assertEquals("Please enter your first name in letters only between 2 and 15 characters in length", login.txtFirstnameErr.getText());
        assertEquals("Please enter your surname in letters only between 2 and 20 characters in length", login.txtSurnameErr.getText());
        assertEquals("Please enter a valid date of birth", login.txtDOBErr.getText());
        assertEquals("Please enter your house number or name. House names should be between 2 and 40 characters in length", login.txtHouseNoErr.getText());
        assertEquals("Postcode is required", login.txtPostcodeErr.getText());

        //Add Firstname and click Continue
        login.boxFirstname.sendKeys("Peter");
        login.btnContinue.click();
        login.btnContinue.click();//First click doesn't work, so click twice
        assertEquals("4 Questions have not been completed or have been filled incorrectly", login.txtErrMsg.getText());
        assertEquals("Please enter your surname in letters only between 2 and 20 characters in length", login.txtSurnameErr.getText());
        assertEquals("Please enter a valid date of birth", login.txtDOBErr.getText());
        assertEquals("Please enter your house number or name. House names should be between 2 and 40 characters in length", login.txtHouseNoErr.getText());
        assertEquals("Postcode is required", login.txtPostcodeErr.getText());

        //Add Surname and click Continue
        login.boxSurname.sendKeys("Rabbit");
        login.btnContinue.click();
        login.btnContinue.click();//First click doesn't work, so click twice
        assertEquals("3 Questions have not been completed or have been filled incorrectly", login.txtErrMsg.getText());
        assertEquals("Please enter a valid date of birth", login.txtDOBErr.getText());
        assertEquals("Please enter your house number or name. House names should be between 2 and 40 characters in length", login.txtHouseNoErr.getText());
        assertEquals("Postcode is required", login.txtPostcodeErr.getText());

        //Add DOB and click Continue
        login.dateDOB1.click();
        login.monthDOBJan.click();
        login.yearDOB1990.click();
        login.btnContinue.click();
        login.btnContinue.click();//First click doesn't work, so click twice
        assertEquals("2 Questions have not been completed or have been filled incorrectly", login.txtErrMsg.getText());
        assertEquals("Please enter your house number or name. House names should be between 2 and 40 characters in length", login.txtHouseNoErr.getText());
        assertEquals("Postcode is required", login.txtPostcodeErr.getText());

        //Add House No and click Continue
        login.boxHouseNumber.sendKeys("100");
        login.btnContinue.click();
        login.btnContinue.click();//First click doesn't work, so click twice
        assertEquals("1 Question has not been completed or has been filled incorrectly", login.txtSingleErrMsg.getText());
        assertEquals("Postcode is required", login.txtPostcodeErr.getText());

        //Add Address and click Continue
        login.boxPostcode.sendKeys("PE2 6YS");
        login.btnFindAddress.click();
        wait.until(ExpectedConditions.elementToBeClickable(login.ddlFirstAddress));
        login.ddlFirstAddress.click();
        login.btnEnterAddress.click();
        wait.until(ExpectedConditions.elementToBeClickable(login.btnContinue));
        login.btnContinue.click();
        login.btnContinue.click();//First click doesn't work, so click twice
        //check if page moved to the next page
        assertEquals("https://www.budgetinsurance.com/Car/ProductGeneric/QuestionSet/QuickQuestions", driver.getCurrentUrl());

        driver.close();


    }
}
