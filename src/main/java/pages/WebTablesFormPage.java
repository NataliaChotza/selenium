package pages;


import elements.Button;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import utilities.LoggerUtils;

import java.util.ArrayList;
import java.util.List;

public class WebTablesFormPage {
    private static final Logger logger = LoggerUtils.setLoggerClass(WebTablesFormPage.class);

    private static final Button webTableForm = new Button(By.xpath("//div[contains(@class,'web-tables-wrapper')]"));
    private static final Button addButton = new Button(By.xpath("//button[contains(@id,'addNewRecordButton')]"));

    public static boolean isWebTableFormVisible(){
        logger.info("Web table form is visible on the page");
        return webTableForm.isDisplayed();
    }
    public static void clickAddButton(){
        logger.info("Clicked add button");
        addButton.click();
    }


    static Button deleteButton ;
    public static List<String> getTable() {
        logger.info("The data from table are returned");

        Button tableBody = new Button(By.xpath("//div[contains(@class,'rt-tbody')]"));
        List<WebElement>list = tableBody.getElementList(By.xpath("//div[contains(@class,'rt-tr-group')][4]//div[contains(@class,'rt-td')]"));
        List<String> rowList = new ArrayList<>();
        for(int i=0;i< list.size()-1;i++){
            rowList.add(list.get(i).getText());
            System.out.println(list.get(i).getText());
        }

        return rowList.stream().sorted().toList();

    }
    public static void clickDeleteButton(){
        logger.info("Clicked delete button");
        deleteButton.click();
    }



}
