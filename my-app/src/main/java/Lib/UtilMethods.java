package Lib;

import Config.ConfigData;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class UtilMethods {
    /**
     ==========================================================================================
     InitializeWebDriver - launch specified web browser
     Argument - browser Type
     Return Value - specified web driver
     ==========================================================================================
     **/
    public WebDriver InitializeWebDriver(String strBrowserType){
        //switch statement doesn't work for below demands...
        if (strBrowserType.toLowerCase().equals("firefox")) {
            File pathToBinary = new File(ConfigData.strFirefoxDriver);
            FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
            return driver;

        }else if (strBrowserType.toLowerCase().equals("ie")) {
            File file = new File(ConfigData.strIEDriver);
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            WebDriver driver = new InternetExplorerDriver();
            return driver;

        }else{
            System.setProperty("webdriver.chrome.driver", ConfigData.strChromeDriver);
            WebDriver driver = new ChromeDriver();
            return driver;
        }

    }

    /**================================================================================
    WebElementCheck - Checks whether web element exists
    Argument   Web Elements
    Returns    True or False
    ================================================================================  **/

    public boolean WebElementCheck (WebElement element) {
        try {
            element.getSize();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     ================================================================================
     CheckElements - Check whether all web elements in Hash table exists
     Argument    Hash table that contains list of web elements
     Returns     List - list of un-found elements
     ================================================================================
     **/

    public List CheckElements(Hashtable elemList){

        List<String> failedElem = new ArrayList<String>();
        WebElement webElem;

        Enumeration e = elemList.keys();
        Boolean boolElem = Boolean.FALSE;

        while (e.hasMoreElements()){
            String strKey = (String) e.nextElement();
            webElem = (WebElement) elemList.get(strKey);
            boolElem = WebElementCheck(webElem);

            if (!boolElem){
                failedElem.add(strKey);
            }

        }
        return failedElem;
    }
    /**=================================================================================
     CheckWebElements - check wheter element exists, if not added to failed list.
     Argument: hashtable: list of elements
     Returns:  list of missing elements

     ================================================================================= */
    public List CheckWebElements(Hashtable elemList){
       // WebUtil webUtilObj = new WebUtil();
        List failedElem = CheckElements(elemList);

        //if all web objects exists, proceed other wise exit test
        if (failedElem.isEmpty()) {
            return failedElem;
        } else {
            return failedElem;
        }
    }
}
