package org.arcangel07.screenplay.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.arcangel07.screenplay.model.Search;
import org.arcangel07.screenplay.questions.Reservation;
import org.arcangel07.screenplay.tasks.Extras;
import org.arcangel07.screenplay.tasks.SearchFlight;
import org.arcangel07.screenplay.tasks.SelectPrice;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class ReservationStepDefinitions {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("(.*) wants to select the cheapest flight")
    public void goFindFlight(String actorName) {
        theActorCalled(actorName).wasAbleTo(Open.url("https://www.vivaair.com"));
    }

    @When("Arcangel wants to compare the initial value with the final value")
    public void selectFlight() {
        theActorInTheSpotlight().attemptsTo(SearchFlight.with(new Search("Medellin", "Bogota")));
        theActorInTheSpotlight().attemptsTo(new SelectPrice(), new Extras());
    }

    @Then("Arcangel makes the reservation")
    public void takeReservation() {
        Double starting_price = theActorInTheSpotlight().recall("starting_price");
        theActorInTheSpotlight().should(seeThat(Reservation.totalPrice(), is(starting_price)));
    }
}
