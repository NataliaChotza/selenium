package pages;

import base.BaseForm;
import elements.Button;
import elements.Input;
import org.openqa.selenium.By;

import org.slf4j.Logger;
import utilities.LoggerUtils;
import utilities.TestDataUtils;

public class RegistrationFormPage extends BaseForm {
    private static final Logger logger = LoggerUtils.setLoggerClass(RegistrationFormPage.class);

    private static final Input firstNameInput = new Input(By.xpath("//input[contains(@id,'firstName')]"));
    private static final Input lastNameInput = new Input(By.xpath("//input[contains(@id,'lastName')]"));
    private static final Input emailInput = new Input(By.xpath("//input[contains(@id,'userEmail')]"));
    private static final Input ageInput = new Input(By.xpath("//input[contains(@id,'age')]"));
    private static final Input salaryInput = new Input(By.xpath("//input[contains(@id,'salary')]"));
    private static final Input departmentInput = new Input(By.xpath("//input[contains(@id,'department')]"));
    public static final String USER ="user2";
    public static String registrationForm = "//div[contains(@class,'modal-content')]";
    private static final String INPUTFIRSTNAME = "firstname";
    private static final String INPUTLASTNAME = "lastname";
    private static final String INPUTEMAIL = "email";
    private static final String INPUTAGE = "age";

    private static final String INPUTSALARY ="salary";

    private static final String INPUTDEPARTMENT ="department";

    private static final Button submitButton = new Button(By.xpath("//button[contains(@id,'submit')]"));
    public static void sendKeyFirstNameInput(){
        logger.info("Sent key"+INPUTFIRSTNAME);
        firstNameInput.sendText(TestDataUtils.getUserData(USER).get(INPUTFIRSTNAME));
    }
    public static void sendKeyLastNameInput(){
        logger.info("Sent key"+INPUTLASTNAME);
        lastNameInput.sendText(TestDataUtils.getUserData(USER).get(INPUTLASTNAME));
    }
    public static void sendKeyEmailInput(){
        logger.info("Sent key"+INPUTEMAIL);
        emailInput.sendText(TestDataUtils.getUserData(USER).get(INPUTEMAIL));
    }
    public static void sendKeyAgeInput()
    { logger.info("Sent key"+INPUTAGE);
        ageInput.sendText(TestDataUtils.getUserData(USER).get(INPUTAGE));
    }
    public static void sendKeySalaryInput(){
        logger.info("Sent key"+INPUTSALARY);
        salaryInput.sendText(TestDataUtils.getUserData(USER).get(INPUTSALARY));
    }
    public static void sendKeyDepartmentInput(){
        logger.info("Sent key"+INPUTDEPARTMENT);
        departmentInput.sendText(TestDataUtils.getUserData(USER).get(INPUTDEPARTMENT));
    }
    public static void clickSubmitButton(){
        logger.info("Clicked submit button");
        submitButton.click();
    }






}
