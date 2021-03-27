package org.arcangel07.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelectPricePage {
    public static final Target PRICES = Target.the("price list").located(By.className("from-price"));
    public static final Target CARD = Target.the("select card").located(By.className("radiobutton"));
    public static final Target POP_UP1 = Target.the("popup1").located(By.id("bx-searches-modal__btn-close-icon"));
    public static final Target POP_UP2 = Target.the("popup2").located(By.id("bx-last-booked-modal__btn-close-icon"));
    public static final Target BUTTON_CONTINUE = Target.the("button continue").located(By.xpath("//*[@id=\"flights-scroll-to\"]/div[2]/button"));
}
