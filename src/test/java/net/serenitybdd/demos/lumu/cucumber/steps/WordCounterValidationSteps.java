package net.serenitybdd.demos.lumu.cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.demos.lemu.screenplay.questions.TheWords;
import net.serenitybdd.demos.lemu.screenplay.tasks.AnalyzeText;
import net.serenitybdd.demos.lemu.screenplay.tasks.Open;
import net.serenitybdd.demos.lemu.screenplay.tasks.ValidateKeywordDensitySection;
import net.serenitybdd.demos.lemu.screenplay.user_interface.WordCounterModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class WordCounterValidationSteps {

    @Before
    public void set_the_stage() {
        setTheStage(new OnlineCast());
    }

    @ParameterType(".*")
    public Actor actor(String actor) {
        return OnStage.theActorCalled(actor);
    }

    @Given("that {actor} opens the WordCounter.net application")
    public void thatDavidOpensTheWordCounterNetApplication(Actor actor) {

        actor.wasAbleTo(Open.wordCounterApp());
    }

    @When("{actor} analyzes the text {string}")
    public void davidAnalyzesTheText(Actor actor, String text) {
        actor.attemptsTo(
                AnalyzeText.withText(text),
                WaitUntil.the(WordCounterModel.DENSITY, isPresent()));
    }

    @Then("the application should correctly display the number of words {int}")
    public void theApplicationShouldCorrectlyDisplayTheNumberOfWords(Integer words) {
        theActorInTheSpotlight().should(seeThat(TheWords.countWords(), equalTo(words)));
    }

    @Then("the application should correctly display the number of characters {int}")
    public void theApplicationShouldCorrectlyDisplayTheNumberOfCharacters(Integer characters) {
        theActorInTheSpotlight().should(seeThat(TheWords.countCharacters(), equalTo(characters)));
    }

    @Then("the application should correctly display the most repeated words with their repetitions in the Keyword Density section {string}, {string}, {string}")
    public void theApplicationShouldCorrectlyDisplayTheMostRepeatedWordsWithTheirRepetitionsInTheKeywordDensitySectionSampleTextTesting(String sample, String text, String testing) {
        theActorInTheSpotlight().should(seeThat(TheWords.keywordDensity(), containsString(sample)));
    }

    @Then("Then the application should correctly display the most repeated words with their repetitions in the Keyword Density section")
    public void thenTheApplicationShouldCorrectlyDisplayTheMostRepeatedWordsWithTheirRepetitionsInTheKeywordDensitySection(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                ValidateKeywordDensitySection.validateKeywordDensitySection(dataTable)
        );
    }
}

