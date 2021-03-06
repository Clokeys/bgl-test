package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Hashtable;

/**===============================================================
 * Created by aska.cloke on 19/01/2017.
 * All Login Page objects are listed here
 ===============================================================*/
public class LoginPageObjects {
    //initialise my objects in the page
    public LoginPageObjects(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".brandingLarge")
    public WebElement txtUsername;

    @FindBy(css = ".headerMessage.autoHeaderMessage")  //Welcome to your Car Insurance Quote
    public WebElement txtWelcome;

    @FindBy(css = ".formRow0")
    public WebElement txtEnterDetails ; //Please enter your details below for a great quote in minutes

    @FindBy(css = ".formRow1")
    public WebElement txt30schemes ;//We'll search over 30 different schemes from leading car insurers to find the best policy for you

    @FindBy(xpath = "//*[@id='QuestionSetViewModel']/section[2]/div/strong")
    public WebElement txtSavedQuote ; //Already saved a quote? Click here to retrieve a saved quote

    @FindBy(css = ".autoQuestionSetTopHeaderText_block_1")
    public WebElement textGetNewQuote ; //Get a new quote

    @FindBy(css = ".autoLabelTitle_For_MOTOR__filtered_Answer_list")
    public WebElement txtTitle;

    @FindBy(css = "#input_1-1")
    public WebElement ddlTitle ;

    @FindBy(css = "#input_1-1 option[value='MR']")
    public WebElement ddlMR ;

    @FindBy(css = ".autoLabelFirstNames")
    public WebElement txtFirstname;

    @FindBy(css = "#input_1-2")
    public WebElement boxFirstname;

    @FindBy(css = ".autoLabelSurname")
    public WebElement txtSurname;

    @FindBy(css = "#input_1-3")
    public WebElement boxSurname;

    @FindBy(css = ".autoLabelDateOfBirth")
    public WebElement txtDOB;

    @FindBy(css = "#input_1-4_d")
    public WebElement dateDOB;

    @FindBy(css = "#input_1-4_m")
    public WebElement monthDOB;

    @FindBy(css = "#input_1-4_y")
    public WebElement yearDOB;

    @FindBy(css = "#input_1-4_d option[value='01']")
    public WebElement dateDOB1;

    @FindBy(css = "#input_1-4_m option[value='01']")
    public WebElement monthDOBJan;

    @FindBy(css = "#input_1-4_y option[value='1990']")
    public WebElement yearDOB1990;

    @FindBy(xpath = "//*[@id='frPostcodeLookup_1-5']/div/ul/li[1]/a")
    public WebElement ddlFirstAddress;

    @FindBy(css = ".manualAddressLink.primaryButtonSmall.autoButtonManualAddress")
    public WebElement btnEnterAddress;

    @FindBy(css = ".autoLabelRiskAddress_house")
    public WebElement txtHouseNumber;

    @FindBy(css = "#input_1-5_house")
    public WebElement boxHouseNumber;

    @FindBy(css = ".autoLabelRiskAddress_pcode")
    public WebElement txtPostcode;

    @FindBy(css = "#input_1-5_pcode")
    public WebElement boxPostcode;

    @FindBy(css = "#findAddressButton_1-5")
    public WebElement btnFindAddress;

    @FindBy(css = ".autoLabelVehicle_Description_for_Welcome_Screen")
    public WebElement txtCarReg;

    @FindBy(css = "#input_1-6")
    public WebElement boxCarReg;

    @FindBy(css = ".hintText.autoHintText1-6")
    public WebElement txtLeaveBlank;

    @FindBy(css = "#additionalText")
    public WebElement txtAgreeTC;

    @FindBy(xpath = "//*[@id='welcomePagequoteEligibility']/a")
    public WebElement lnkTC;

    @FindBy(css = ".defaqto5StarImage")
    public WebElement imgDefqto;

    @FindBy(xpath = "//*[@id='Welcome']/div[2]/div[2]/p[2]")
    public WebElement txtRights;

    @FindBy(xpath = "//*[@id='Welcome']/div[2]/div[2]/p[3]")
    public WebElement txtHeadOffice;

    @FindBy(xpath = "//*[@id='Welcome']/div[2]/div[2]/p[4]/a")
    public WebElement lnkFCA;

    @FindBy(xpath = "//*[@id='Welcome']/div[2]/div[2]/p[4]")
    public WebElement txtFCA;

    @FindBy(xpath = "//*[@id='Welcome']/div[2]/div[2]/p[5]/strong/u")
    public WebElement lnkDataProtection;

    @FindBy(xpath = "//*[@id='Welcome']/div[2]/div[2]/p[6]")
    public WebElement txtDetailsDataProtection;

    @FindBy(xpath = "//*[@id='Welcome']/div[2]/div[2]/p[7]/strong/u")
    public WebElement lnkDataUsageConsent;

    @FindBy(xpath = "//*[@id='Welcome']/div[2]/div[2]/p[8]")
    public WebElement txtDetailsDataUsage;

    @FindBy(xpath = "//*[@id='Welcome']/div[2]/div[2]/p[9]")
    public WebElement txtCallRecorded;

    @FindBy(xpath = "//*[@id='Welcome']/div[2]/div[2]/p[10]/a")
    public WebElement lnkPrivatePolicy;

    @FindBy(xpath = "//*[@id='Welcome']/div[2]/div[2]/p[11]/a")
    public WebElement lnkBackToTop;

    @FindBy(css = ".continueButton.primaryButton.autoContinueButton")
    public WebElement btnContinue;

    //Error Message Objects
    @FindBy(css = ".largeErrorMessage.autoMultipleErrorLargeMessage")
    public WebElement txtErrMsg;

    @FindBy(xpath = "//*[@id='singleErrorValidationBlock']/p[1]")
    public WebElement txtSingleErrMsg;

    @FindBy(css = ".validationText.autoValidationTitle_For_MOTOR__filtered_Answer_list")
    public WebElement txtTitleErr;  //Please select an option

    @FindBy(css = ".validationText.autoValidationFirstNames")
    public WebElement txtFirstnameErr; //Please enter your first name in letters only between 2 and 15 characters in length

    @FindBy(css = ".validationText.autoValidationSurname")
    public WebElement txtSurnameErr;  //Please enter your surname in letters only between 2 and 20 characters in length

    @FindBy(css = ".validationText.autoValidationDateOfBirth")
    public WebElement txtDOBErr;  //Please enter a valid date of birth

    @FindBy(css = ".validationText.autoValidationRiskAddress_house")
    public WebElement txtHouseNoErr; //Please enter your house number or name. House names should be between 2 and 40 characters in length

    @FindBy(css = ".validationText.autoValidationRiskAddress_pcode")
    public WebElement txtPostcodeErr;  //Postcode is required

    @FindBy(css = ".fontSizeSmall.active>a")
    public WebElement fontsizeS;

    @FindBy(css = ".fontSizeMedium>a")
    public WebElement fontsizeM;

    @FindBy(css = ".fontSizeLarge>a")
    public WebElement fontsizeL;

    @FindBy(css = ".asideBody>p")
    public WebElement txtBeforeBegin;

    @FindBy(css = ".ask")
    public WebElement txtAsk;

    @FindBy(css = ".nw_UserInputField")
    public WebElement boxAsk;

    @FindBy(css = ".nw_UserSubmit.nw_Disabled")
    public WebElement btnAsk;

    @FindBy(xpath = "//*[@id='jqShoppingBasketContainer']/div[2]/div[1]/div/p")
    public WebElement txtFurtherInfo;

    @FindBy(xpath = "//*[@id='jqShoppingBasketContainer']/div[2]/div[2]/div/p")
    public WebElement txtInfoRequired;

    @FindBy(css = ".securePopUp.popupLink.autoSecureSite>p")
    public WebElement txtSecureSite;

    @FindBy(css = ".securityImage")
    public WebElement imgSecureSite;



    //Put all Page Objects into table so they can be verified in loop
    public Hashtable CreateLoginElemTable(){
        Hashtable<String, WebElement> elemList = new Hashtable<String, WebElement>();
        elemList.put("Username", txtUsername);
        elemList.put("Welcome", txtWelcome);
        elemList.put("EnterDetails", txtEnterDetails);
        elemList.put("30schemea", txt30schemes);
        elemList.put("SavedQuote", txtSavedQuote );
        elemList.put("textGetNewQuote", textGetNewQuote );
        elemList.put("Title-text", txtTitle);
        elemList.put("TitleDropDown", ddlTitle );
        elemList.put("FirstnameText", txtFirstname);
        elemList.put("boxFirstname", boxFirstname);
        elemList.put("txtSurname", txtSurname);
        elemList.put("boxSurname", boxSurname);
        elemList.put("txtDOB", txtDOB);
        elemList.put("dateDOB", dateDOB);
        elemList.put("monthDOB", monthDOB);
        elemList.put("yearDOB", yearDOB);
        elemList.put("txtHouseNumber", txtHouseNumber);
        elemList.put("boxHouseNumber", boxHouseNumber);
        elemList.put("txtPostcode", txtPostcode);
        elemList.put("boxPostcode", boxPostcode);
        elemList.put("btnFindAddress", btnFindAddress);
        elemList.put("txtCarReg", txtCarReg);
        elemList.put("boxCarReg", boxCarReg);
        elemList.put("txtLeaveBlank", txtLeaveBlank);
        elemList.put("txtAgreeTC", txtAgreeTC);
        elemList.put("lnkTC", lnkTC);
        elemList.put("imgDefqto", imgDefqto);
        elemList.put("txtRights", txtRights);
        elemList.put("txtHeadOffice", txtHeadOffice);
        elemList.put("lnkFCA", lnkFCA);
        elemList.put("lnkDataProtection", lnkDataProtection);
        elemList.put("txtDetailsDataProtection", txtDetailsDataProtection);
        elemList.put("lnkDataUsageConsent", lnkDataUsageConsent);
        elemList.put("txtDetailsDataUsage", txtDetailsDataUsage);
        elemList.put("txtCallRecorded", txtCallRecorded);
        elemList.put("lnkPrivatePolicy", lnkPrivatePolicy);
        elemList.put("lnkBackToTop", lnkBackToTop);
        elemList.put("ContinueButton", btnContinue);
        elemList.put("fontSmall", fontsizeS);
        elemList.put("fontsizeM",fontsizeM );
        elemList.put("fontsizeL", fontsizeL);
        elemList.put("txtBeforeBegin", txtBeforeBegin);
        elemList.put("txtAsk", txtAsk);
        elemList.put("boxAsk", boxAsk);
        elemList.put("btnAsk", btnAsk);
        elemList.put("txtFurtherInfo", txtFurtherInfo);
        elemList.put("txtInfoRequired", txtInfoRequired);
        elemList.put("txtSecureSite", txtSecureSite);
        elemList.put("imgSecureSite", imgSecureSite);
        return elemList;
    }

    // Login Page Texts
    public String ErrMissingTitle = "Please select an option";
    public String ErrMissingFirstname = "Please enter your first name in letters only between 2 and 15 characters in length";
    public String ErrMissingSurname = "Please enter your surname in letters only between 2 and 20 characters in length";
    public String ErrMissingDOB = "Please enter a valid date of birth";
    public String ErrMissingHouseNo = "Please enter your house number or name. House names should be between 2 and 40 characters in length";
    public String ErrMissingPostcode = "Postcode is required";

    public String txtCheckWelcome = "Welcome to your Car Insurance Quote";
    public String txtCheckSearchThirty = "We'll search over 30 different schemes from leading car insurers to find the best policy for you";
    public String txtCheckTandC = "By clicking 'Continue', you are confirming that you have read and agree to our Terms & Conditions";
    public String txtCheckBGL = "Budget is a trading name of BISL Limited. Registered Head Office: Pegasus House. Bakewell Road, Orton Southgate, Peterborough, PE2 6YS.";
    public String txtCheckDataProtection = "By supplying data to us you will provide information about yourself and others which the Data Protection " +
            "Act defines as personal data or sensitive personal data. The data controller will be BISL Limited. Data, including your telephone" +
            " number, will be used by BISL Limited and other carefully selected companies for administration, renewals, claims checking, " +
            "a credit search, marketing and research purposes and will be added to certain databases which may be checked by various " +
            "organisations including the police.";
    public String txtCheckBeforeBegin = "It is important that the information you provide throughout the quote and duration of the policy is accurate. " +
            "Failure to disclose correct and complete information to the best of your knowledge and belief may result in increased premiums, " +
            "refusal of a claim or not being fully paid, your policy being cancelled or being made null & void and treated as if it never existed.";
    public String txtCheckFCA = "We are an independent intermediary dealing with selected insurers and authorised and regulated by the Financial Conduct Authority.";




}
