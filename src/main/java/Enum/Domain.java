package Enum;

import aquality.selenium.browser.AqualityServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Domain {
    GMAIL,YAHOO,OUTLOOK;

    public static String getRandomDomain() {
        AqualityServices.getLogger().info("Returned random domain");
        List<Domain> domains = new ArrayList<>();
        domains.add(Domain.GMAIL);
        domains.add(Domain.YAHOO);
        domains.add(Domain.OUTLOOK);

        int index = new Random().nextInt(domains.size());
        return domains.get(index).toString().toLowerCase();
    }
}

