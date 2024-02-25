package net.serenitybdd.demos.lemu.screenplay.tasks;

import net.serenitybdd.demos.lemu.screenplay.user_interface.WordCounterModel;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;


public class AnalyzeText {

    public static Task withText(String text) {
        return Task.where("{0} enter text to analyze: " + text,
                Enter.theValue(text)
                        .into(WordCounterModel.TEXT_TO_ANALYZE)
                );
    }
}
