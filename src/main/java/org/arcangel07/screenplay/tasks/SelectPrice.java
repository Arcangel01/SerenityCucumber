package org.arcangel07.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.JavaScript;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.arcangel07.screenplay.userinterface.SelectPricePage;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.arcangel07.screenplay.userinterface.SelectPricePage.*;

public class SelectPrice implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        getPrice(actor);
        cancelAlert(actor);
        actor.attemptsTo(
                Scroll.to(SelectPricePage.CARD).andAlignToTop(),
                Click.on(SelectPricePage.CARD),
                Scroll.to(SelectPricePage.BUTTON_CONTINUE).andAlignToTop(),
                JavaScriptClick.on(SelectPricePage.BUTTON_CONTINUE)
        );
        this.selectChair(actor);
    }

    private void selectChair(Actor actor) {
        actor.attemptsTo(
                Click.on(By.xpath("//*[@id=\"seats-modal-body\"]/div/div[5]/div[2]/div[3]/div[1]/button")),
                Click.on(By.xpath("//*[@class=\"vue-dialog-buttons\"]/button[1]")),
                Click.on(By.xpath("//*[@class=\"bag-service-buttons\"]/div/button[1]"))
        );
    }

    private void getPrice(Actor actor) {
        List<String> prices = Text.of(SelectPricePage.PRICES) .viewedBy(actor).asList();
        List<Double> pricesListDouble = new ArrayList<>(0);
        if (prices.size() > 0) {
            prices.forEach(i -> {
                pricesListDouble.add(Double.parseDouble(i.replaceAll("[COP, ,]", "")));
            });
            Double minValue = pricesListDouble.stream().min(Comparator.naturalOrder()).get();
            Boolean bandera = false;
            for (String price : prices) {
                if (minValue == Double.parseDouble(price.replaceAll("[COP, ,]", ""))
                        && !bandera) {
                    actor.attemptsTo(
                            Click.on(By.xpath("//div[@class=\"from-price\" and contains(text()," + "\"" + price + "\"" + ")]")),
                            RememberThat.theValueOf("starting_price").is(minValue)
                    );
                    bandera = true;
                }
            }
        }
    }

    private void cancelAlert(Actor actor) {
        if (isPresent().matches(POP_UP1) && isPresent().matches(POP_UP2)) {
            actor.attemptsTo(
                    WaitUntil.the(POP_UP1, isClickable()),
                    Click.on(POP_UP1),
                    WaitUntil.the((POP_UP2), isClickable()),
                    Click.on(POP_UP2)
            );
        }
    }

}
