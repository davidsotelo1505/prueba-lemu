package net.serenitybdd.demos.lemu.screenplay.tasks;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.Map;

public class ValidateKeywordDensitySection implements Task {
    private final DataTable dataTable;
    public ValidateKeywordDensitySection(DataTable dataTable) {
        this.dataTable = dataTable;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Map<String, String>> expectedKeywordInfo = dataTable.asMaps(String.class, String.class);
        int position = 1;
        for (Map<String, String> expectedInfo : expectedKeywordInfo) {
            Target mostRepeatedWord = Target.the("Most repeated word").locatedBy("#kwd-accordion-data > a:nth-child(" + position + ")");
            String repetitions = expectedInfo.get("repetitions");
            String[] actualText = Text.of(mostRepeatedWord).answeredBy(actor).split("\\s+");
            String actualFirstChar = actualText[0];

            actor.attemptsTo(
                    Ensure.that(actualFirstChar).isEqualTo(repetitions)
            );

            position++;
        }
    }
    public static Performable validateKeywordDensitySection(DataTable dataTable) {
        return Task.where("{0} validates the Keyword Density section",
                new ValidateKeywordDensitySection(dataTable)
        );
    }
}
