package org.arcangel07.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.arcangel07.screenplay.model.Search;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.arcangel07.screenplay.userinterface.HomePage.*;

public class SearchFlight implements Task {

    private Search search;

    public SearchFlight(Search search) {
        this.search = search;
    }

    @Override
    @Step("{0} try login")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CANCEL_ALERT),
                Click.on(CHECK_GOING),
                Clear.field(SOURCE),
                Enter.theValue(search.getSource()).into(SOURCE),
                Click.on(By.id("criteria-airport-select-departure-station-MDE")),
                Enter.theValue(search.getDestination()).into(DESTINATION),
                Click.on(By.id("criteria-airport-select-destination-station-BOG")),
                Click.on(FIELD_DATE),
                Scroll.to(DATE).andAlignToTop(),
                Click.on(DATE),
                Click.on(SEARCH_FLIGHT)
        );
    }

    public static SearchFlight with(Search search) {
        return instrumented(SearchFlight.class, search);
    }
}
