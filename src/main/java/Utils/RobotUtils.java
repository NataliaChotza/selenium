package Utils;

import aquality.selenium.browser.AqualityServices;
import lombok.experimental.UtilityClass;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

@UtilityClass
public class RobotUtils {

    public static void uploadFile(String path) {
        StringSelection strSelection = new StringSelection(System.getProperty("user.dir") + path);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(strSelection, null);
        try {
            Robot robot = new Robot();
            robot.delay(300);
            robot.keyPress(KeyEvent.VK_CONTROL);
            AqualityServices.getLogger().info("Pressed control button");
            robot.keyPress(KeyEvent.VK_V);
            AqualityServices.getLogger().info("Pressed v button");
            robot.delay(300);
            robot.keyPress(KeyEvent.VK_ENTER);
            AqualityServices.getLogger().info("Pressed eneter button");
        } catch (AWTException ex) {
            System.err.println(ex.getMessage());
        }


    }

}
