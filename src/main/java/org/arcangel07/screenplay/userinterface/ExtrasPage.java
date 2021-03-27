package org.arcangel07.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ExtrasPage {
    public static final Target CHECK_IN = Target.the("check in").located(By.xpath("//*[@id=\"pass\"]/div[2]/div/div[1]/div[2]/div[2]/div"));
    public static final Target FILA_EXPRESS = Target.the("check in").located(By.xpath("//*[@id=\"expressLine\"]/div[2]/div/div[1]/div[2]/div[2]/div"));
    public static final Target CANCEL_PROTECTION = Target.the("check in").located(By.xpath("//*[@id=\"cancelProtection\"]/div[2]/div/div[1]/div[2]/div[2]/div"));
    public static final Target INSURANCE = Target.the("check in").located(By.xpath("//*[@id=\"insurance-ssr\"]/div/div/div/label/span[1]"));
    public static final Target TOTAL = Target.the("total").located(By.xpath("//*[@id=\"basket-icon\"]/div[1]/div[2]/span"));
}
