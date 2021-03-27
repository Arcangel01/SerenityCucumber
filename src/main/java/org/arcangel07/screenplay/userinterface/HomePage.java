package org.arcangel07.screenplay.userinterface;

import net.serenitybdd.screenplay.questions.targets.TargetSelectOptions;
import net.serenitybdd.screenplay.targets.Target;
import org.arcangel07.screenplay.model.Search;
import org.openqa.selenium.By;

import java.util.List;

public class HomePage {
    public static final Target CANCEL_ALERT = Target.the("cancel alert").located(By.id("onesignal-slidedown-cancel-button"));
    public static final Target CHECK_GOING = Target.the("check going").located(By.className("box"));
    public static final Target SOURCE = Target.the("source").located(By.id("criteria-airport-select-departure-input"));
    public static final Target DESTINATION = Target.the("destination").located(By.id("criteria-airport-select-destination-input"));
    public static final Target FIELD_DATE = Target.the("field date").located(By.id("criteria-dates-from"));
    public static final Target DATE = Target.the("date").located(By.xpath("//*[@date=\""+ Search.getFecha() +"\" and @type=\"button\"]"));
    public static final Target SEARCH_FLIGHT = Target.the("search flight").located(By.id("criteria-search-button-desktop"));
}
