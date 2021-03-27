package org.arcangel07.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Reservation implements Question<Double> {
    @Override
    public Double answeredBy(Actor actor) {
        return actor.recall("total_value");
    }

    public static Question<Double> totalPrice(){
        return new Reservation();
    }
}
