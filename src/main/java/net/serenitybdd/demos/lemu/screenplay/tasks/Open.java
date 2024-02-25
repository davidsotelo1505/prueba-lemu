package net.serenitybdd.demos.lemu.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Open {
    public static Performable wordCounterApp() {
        return Task.where("{0} starts word counter aplication",
                net.serenitybdd.screenplay.actions.Open.browserOn().thePageNamed("home.page")
        );
    }
}
