package com.mycompany.app;

import Config.ConfigData;
import Lib.UtilMethods;
import PageObjects.LoginPageObjects;
import org.junit.AfterClass;
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

   }

    @Test
    public void VerifyLoginPageTexts(){
        //launch URL
        driver.get(ConfigData.strURL);
        driver.manage().window().maximize();

        assertEquals(login.txtCheckWelcome, login.txtWelcome.getText());
        assertEquals(login.txtCheckSearchThirty, login.txt30schemes.getText());
        assertEquals(login.txtCheckTandC, login.txtAgreeTC.getText());
        assertEquals(login.txtCheckBGL, login.txtHeadOffice.getText());
        assertEquals(login.txtCheckDataProtection, login.txtDetailsDataProtection.getText());
        assertEquals(login.txtCheckBeforeBegin, login.txtBeforeBegin.getText());
        assertEquals(login.txtCheckFCA, login.txtFCA.getText());

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
        assertEquals(login.ErrMissingTitle, login.txtTitleErr.getText());
        assertEquals(login.ErrMissingFirstname, login.txtFirstnameErr.getText());
        assertEquals(login.ErrMissingSurname, login.txtSurnameErr.getText());
        assertEquals(login.ErrMissingDOB, login.txtDOBErr.getText());
        assertEquals(login.ErrMissingHouseNo, login.txtHouseNoErr.getText());
        assertEquals(login.ErrMissingPostcode, login.txtPostcodeErr.getText());

        //Add Title and click Continue
        login.ddlMR.click();
        login.btnContinue.click();
        assertEquals("5 Questions have not been completed or have been filled incorrectly", login.txtErrMsg.getText());
        assertEquals(login.ErrMissingFirstname, login.txtFirstnameErr.getText());
        assertEquals(login.ErrMissingSurname, login.txtSurnameErr.getText());
        assertEquals(login.ErrMissingDOB, login.txtDOBErr.getText());
        assertEquals(login.ErrMissingHouseNo, login.txtHouseNoErr.getText());
        assertEquals(login.ErrMissingPostcode, login.txtPostcodeErr.getText());

        //Add Firstname and click Continue
        login.boxFirstname.sendKeys("Peter");
        login.btnContinue.click();
        login.btnContinue.click();//First click doesn't work, so click twice
        assertEquals("4 Questions have not been completed or have been filled incorrectly", login.txtErrMsg.getText());
        assertEquals(login.ErrMissingSurname, login.txtSurnameErr.getText());
        assertEquals(login.ErrMissingDOB, login.txtDOBErr.getText());
        assertEquals(login.ErrMissingHouseNo, login.txtHouseNoErr.getText());
        assertEquals(login.ErrMissingPostcode, login.txtPostcodeErr.getText());

        //Add Surname and click Continue
        login.boxSurname.sendKeys("Rabbit");
        login.btnContinue.click();
        login.btnContinue.click();//First click doesn't work, so click twice
        assertEquals("3 Questions have not been completed or have been filled incorrectly", login.txtErrMsg.getText());
        assertEquals(login.ErrMissingDOB, login.txtDOBErr.getText());
        assertEquals(login.ErrMissingHouseNo, login.txtHouseNoErr.getText());
        assertEquals(login.ErrMissingPostcode, login.txtPostcodeErr.getText());

        //Add DOB and click Continue
        login.dateDOB1.click();
        login.monthDOBJan.click();
        login.yearDOB1990.click();
        login.btnContinue.click();
        login.btnContinue.click();//First click doesn't work, so click twice
        assertEquals("2 Questions have not been completed or have been filled incorrectly", login.txtErrMsg.getText());
        assertEquals(login.ErrMissingHouseNo, login.txtHouseNoErr.getText());
        assertEquals(login.ErrMissingPostcode, login.txtPostcodeErr.getText());

        //Add House No and click Continue
        login.boxHouseNumber.sendKeys("100");
        login.btnContinue.click();
        login.btnContinue.click();//First click doesn't work, so click twice
        assertEquals("1 Question has not been completed or has been filled incorrectly", login.txtSingleErrMsg.getText());
        assertEquals(login.ErrMissingPostcode, login.txtPostcodeErr.getText());

        //Add Address and click Continue
        login.boxPostcode.sendKeys("PE2 6YS");
        login.btnFindAddress.click();
        wait.until(ExpectedConditions.elementToBeClickable(login.ddlFirstAddress));
        login.ddlFirstAddress.click();
        wait.until(ExpectedConditions.elementToBeClickable(login.btnContinue));
        login.btnContinue.click();
        login.btnContinue.click();//First click doesn't work, so click twice
        //check if page moved to the next page
        assertEquals(ConfigData.strURL_AboutYou, driver.getCurrentUrl());

    }

    @Test
    public void CheckDataBoundary() {
        //launch URL
        driver.get(ConfigData.strURL);
        driver.manage().window().maximize();

        //Enter Mandatory data
        login.ddlMR.click();
        login.boxSurname.sendKeys("Rabbit");
        login.dateDOB1.click();
        login.monthDOBJan.click();
        login.yearDOB1990.click();
        login.boxHouseNumber.sendKeys("100");
        login.boxPostcode.sendKeys("PE2 6YS");
        login.btnFindAddress.click();
        wait.until(ExpectedConditions.elementToBeClickable(login.ddlFirstAddress));
        login.ddlFirstAddress.click();


        //Firstname  < min
        login.boxFirstname.sendKeys("a");
        login.btnContinue.click();
        assertEquals(login.ErrMissingFirstname, login.txtFirstnameErr.getText());

        //Lastname < min
        login.boxFirstname.clear();
        login.boxFirstname.sendKeys("Peter");
        login.boxSurname.clear();
        login.boxSurname.sendKeys("a");
        login.btnContinue.click();
        login.btnContinue.click();
        assertEquals(login.ErrMissingSurname, login.txtSurnameErr.getText());

        //Verify system won't let you enter more than max char amount
        login.boxFirstname.clear();
        login.boxFirstname.sendKeys("PeterPeterPeterPeterPeterPeter");
        login.boxSurname.clear();
        login.boxSurname.sendKeys("RabbitRabbitRabbitRabbitRabbitRabbitRabbit");
        login.btnContinue.click();
        login.btnContinue.click();//First click doesn't work, so click twice
        //check if page moved to the next page
        assertEquals(ConfigData.strURL_AboutYou, driver.getCurrentUrl());
    }

    @Test
    public void CheckSpecialCharacters() {
        //launch URL
        driver.get(ConfigData.strURL);
        driver.manage().window().maximize();
        //Enter Mandatory data
        login.ddlMR.click();
        login.boxFirstname.sendKeys("Molly Anne");
        //login.boxFirstname.sendKeys("Mölly Anne");  European language not supported?
        login.boxSurname.sendKeys("O'Reilly-Johnson");
        login.dateDOB1.click();
        login.monthDOBJan.click();
        login.yearDOB1990.click();
        login.boxHouseNumber.sendKeys("100");
        login.boxPostcode.sendKeys("PE2 6YS");
        login.btnFindAddress.click();
        wait.until(ExpectedConditions.elementToBeClickable(login.ddlFirstAddress));
        login.ddlFirstAddress.click();
        login.btnContinue.click();
    }

    @Test
    public void VerifyHappyPath() {
        //launch URL
        driver.get(ConfigData.strURL);
        driver.manage().window().maximize();
        //Enter Mandatory data
        login.ddlMR.click();
        login.boxFirstname.sendKeys("Molly Anne");
        login.boxSurname.sendKeys("O'Reilly-Johnson");
        login.dateDOB1.click();
        login.monthDOBJan.click();
        login.yearDOB1990.click();
        login.boxHouseNumber.sendKeys("100");
        login.boxPostcode.sendKeys("PE2 6YS");
        login.btnFindAddress.click();
        wait.until(ExpectedConditions.elementToBeClickable(login.ddlFirstAddress));
        login.ddlFirstAddress.click();
        login.btnContinue.click();
        assertEquals(ConfigData.strURL_AboutYou, driver.getCurrentUrl());
    }
/*
    // This test needs to set the Webdriver Wait time in expected seconds before executing
    @Test
    public void VerifySessionEnd() {
        //launch URL
        driver.get(ConfigData.strURL);
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.urlMatches(ConfigData.strURL_SessionEnd));

    }

*/
    @AfterClass
    public static void Teardown() {
        driver.quit();
    }

}
