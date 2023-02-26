package Utils;

import aquality.selenium.browser.AqualityServices;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang.RandomStringUtils;

import java.util.logging.Logger;

@UtilityClass
public class StringUtils {
    private static final int COMMON_CHAR_INDEX = 1;
    private static final int NUMBERS = 1;
    private static final int PASSWORD_LENGTH = 9;
    private static final int EMAIL_LENGTH = 7;

    private static String email;
    private static String password;

    public static void generateRandomPassword(String email) {
        AqualityServices.getLogger().info("Generated password in StringUtils");
        String randomText = RandomStringUtils.randomNumeric(NUMBERS);
        randomText += RandomStringUtils.randomAlphanumeric(PASSWORD_LENGTH);
        char commonLetter = email.charAt(COMMON_CHAR_INDEX);
        randomText += String.valueOf(commonLetter).toUpperCase();
        setPassword(randomText);
    }

    static public void generateRandomEmail() {
        AqualityServices.getLogger().info("Generated email in StringUtils");
        String email = RandomStringUtils.random(EMAIL_LENGTH, true, false);
        setEmail(email.toLowerCase());
    }

    static public String getEmail() {
        AqualityServices.getLogger().info("Returned email in StringUtils");
        return email;
    }

    static public void setPassword(String generatedPassword) {
        password = generatedPassword;
    }

    static public String getPassword() {
        AqualityServices.getLogger().info("Returned password in StringUtils");
        return password;
    }

    public static void setEmail(String generatedEmail) {
        email = generatedEmail;
    }
}
