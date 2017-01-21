package Lib;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

        //Capture location of drivers
        String driverPath = System.getProperty("user.dir");
        Integer pos = driverPath.lastIndexOf("\\");
        driverPath = driverPath.substring(0,pos);

        if (strBrowserType.toLowerCase().equals("ie")) {
            driverPath = driverPath + "\\IEDriverServer.exe";
            File file = new File(driverPath);
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            WebDriver driver = new InternetExplorerDriver();
            return driver;

        }else{
            driverPath = driverPath + "\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
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
