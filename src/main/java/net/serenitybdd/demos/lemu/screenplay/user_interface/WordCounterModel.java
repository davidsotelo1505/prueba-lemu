package net.serenitybdd.demos.lemu.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class WordCounterModel {
    public static final Target TEXT_TO_ANALYZE = Target.the("Start typing").locatedBy("#box");
    public static final Target NUMBER_OF_WORDS = Target.the("Number of counts word").locatedBy("#word_count");
    public static final Target DENSITY = Target.the("KeyWord Density").locatedBy("#kwd-accordion-data > a");
    public static final Target NUMBER_OF_CHARACTERS = Target.the("Number of counts characters").locatedBy("#character_count");
}