package org.arcangel07.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import org.arcangel07.screenplay.userinterface.ExtrasPage;

import java.lang.annotation.Target;

public class Extras implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ExtrasPage.CHECK_IN).andAlignToBottom(),
                Click.on(ExtrasPage.CHECK_IN),
                Scroll.to(ExtrasPage.FILA_EXPRESS).andAlignToBottom(),
                Click.on(ExtrasPage.FILA_EXPRESS),
                Scroll.to(ExtrasPage.CANCEL_PROTECTION).andAlignToBottom(),
                Click.on(ExtrasPage.CANCEL_PROTECTION),
                Scroll.to(ExtrasPage.INSURANCE).andAlignToBottom(),
                Click.on(ExtrasPage.INSURANCE)
        );
        getTotalValue(actor);
    }

    private void getTotalValue(Actor actor) {
        String total = Text.of(ExtrasPage.TOTAL).viewedBy(actor).value();
        System.out.println("total - " + total);
        if (!total.isEmpty()) {
            String value = total.replaceAll("[COP, Total:, ,]", "");
            Double valueTotal = Double.parseDouble(value);
            actor.attemptsTo(RememberThat.theValueOf("total_value").is(valueTotal));
        }
    }
}
