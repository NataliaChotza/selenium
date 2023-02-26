package Helper;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;

import java.util.List;
import java.util.Random;

public class FormFiller {

    public static void setPassword(String password, ITextBox txbPassword){
        AqualityServices.getLogger().info("Set password in in FormFiller class");
        txbPassword.clearAndType(password);
    }
    public static void setEmail(String email,ITextBox txbEmail){
        AqualityServices.getLogger().info("Set email in FormFiller class");
        txbEmail.clearAndType(email);
    }
    public static void setDomain(String domain,ITextBox txbDomain){
        AqualityServices.getLogger().info("Set domain in FormFiller class");
        txbDomain.clearAndType(domain);
    }
    public static void setDropDownValue(List<IButton> dropDownList){
        AqualityServices.getLogger().info("Set dropdown value in FormFiller class");
        int index = new Random().nextInt(1, dropDownList.size());
        dropDownList.get(index).click();
    }
}
