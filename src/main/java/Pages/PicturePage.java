package Pages;

import Utils.ConfigUtils;
import Utils.RobotUtils;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PicturePage extends Form implements BasePageInterface {
    private static final String locator = "//div[@class,'avatar-and-interests__form']";
    private static final int PICTURE_PAGE_INDICATOR = 2;

    private final IButton nextButton = getElementFactory().getButton(By.xpath("//div[contains(@class,'avatar-and-interests-page__buttons')]//button[contains(@class,'button--stroked')]"), "next button", ElementState.DISPLAYED);

    private final static String CHECKBOX_LOC = "//div[contains(@class,'avatar-and-interests__interests-list')]//div[contains(@class,'avatar-and-interests__interests-list__item')]//label";

    private final ICheckBox unSelectAll = getElementFactory().getCheckBox(By.xpath(CHECKBOX_LOC + "//input[contains(@id,'interest_unselectall')]/ancestor::span"), "unselect", ElementState.DISPLAYED);
    private final IButton imageButton = getElementFactory().getButton(By.xpath("//a[contains(@class,'avatar-and-interests__upload-button')]"), "avatar", ElementState.DISPLAYED);
    private final IButton picture = getElementFactory().getButton(By.xpath("//div[contains(@class,'avatar-and-interests__avatar-image')]"), "picture", ElementState.EXISTS_IN_ANY_STATE);

    private final static String SELECT_ALL = "interest_selectall";
    private final static String UN_SELECT_ALL = "interest_unselectall";

    public PicturePage(String name) {
        super( By.xpath(locator), name);
    }


    public void clickNextButton() {
        getLogger().info("Clicked next button in PicturePage class");
        nextButton.click();
    }

    public void chooseRandomCheckbox() {
        getLogger().info("Random checkboxes chosen in PicturePage class");
        List<ICheckBox> allCheckBoxes = getElementFactory().findElements(By.xpath(CHECKBOX_LOC), ElementType.CHECKBOX);
        List<Integer> indexes = new ArrayList<>();

        unSelectAll.click();
        for (int i = 0; i < 3; i++) {
            int index = new Random().nextInt(allCheckBoxes.size());
            if (indexes.contains(index) || (allCheckBoxes.get(index).getAttribute("for").matches(UN_SELECT_ALL)
                    || allCheckBoxes.get(index).getAttribute("for").matches(SELECT_ALL))) {
                i--;
            } else {
                allCheckBoxes.get(index).check();
                indexes.add(index);
            }
        }
    }

    public void uploadImage() {
        getLogger().info("Uploaded picture in PicturePage class");
        imageButton.clickAndWait();
        RobotUtils.uploadFile(ConfigUtils.getImage());
        picture.state().waitForDisplayed();

    }
    public int getPicturePageIndicator(){
        getLogger().info("Returned page indicator");
        return PICTURE_PAGE_INDICATOR;
    }


    @Override
    public int getPageIndicator(By locator, String name) {
        getLogger().info("Returned page indicator in PicturePage class");
        IButton pageIndicator = getElementFactory().getButton(locator, name, ElementState.DISPLAYED);
        return Integer.parseInt(pageIndicator.getText().split("/")[0].trim());

    }
}
