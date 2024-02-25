package net.serenitybdd.demos.lemu.screenplay.questions;

import net.serenitybdd.demos.lemu.screenplay.user_interface.WordCounterModel;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * A factory class used to provide different questions about the items displayed in the todo list
 */
public class TheWords {
    public static Question<Integer> countWords() {
        return Text.of(WordCounterModel.NUMBER_OF_WORDS)
                   .describedAs("the number of words")
                   .asInteger();
    }
    public static Question<Integer> countCharacters() {
        return Text.of(WordCounterModel.NUMBER_OF_CHARACTERS)
                .describedAs("the number of characters")
                .asInteger();
    }
}
