package net.serenitybdd.demos.lemu.screenplay.tasks;

import com.google.common.base.Joiner;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.Arrays;
import java.util.List;

public class Open {

    public static Performable wordCounterApp() {
        return Task.where("{0} starts word counter aplication",
                net.serenitybdd.screenplay.actions.Open.browserOn().thePageNamed("home.page")
        );
    }
}
