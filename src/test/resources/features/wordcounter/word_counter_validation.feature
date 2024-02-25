Feature: WordCounter Validation

  Scenario Outline: Validate WordCounter.net functionality number of word with different texts
    Given that David opens the WordCounter.net application
    When David analyzes the text "<textToAnalyze>"
    Then the application should correctly display the number of words <words>

    Examples:
      | textToAnalyze                                 | words |
      | This is a sample text for WordCounter testing | 8     |
      | Another example for testing WordCounter       | 5     |
      | Test with numbers: 123 456 789                | 5     |

  Scenario Outline: Validate WordCounter.net functionality number of characters with different texts
    Given that David opens the WordCounter.net application
    When David analyzes the text "<textToAnalyze>"
    Then the application should correctly display the number of characters <characters>

    Examples:
      | textToAnalyze                                 | characters |
      | This is a sample text for WordCounter testing | 45         |
      | Another example for testing WordCounter       | 39         |
      | Test with numbers: 123 456 789                | 15         |
  @test
  Scenario Outline: Validate Keyword Density Section
    Given that David opens the WordCounter.net application
    When David analyzes the text "<textToAnalyze>"
    Then Then the application should correctly display the most repeated words with their repetitions in the Keyword Density section
      | word    | repetitions |
      | sample  | 4           |
      | text | 4           |
      | testing | 3           |
    Examples:
      | textToAnalyze                                                            |
      | This is a sample text for WordCounter testing testing sample sample text text text sample testing |