FUN-PROMPT-NAME - At launch, the system shall ask the user the name of the user's cat and wait for input.

FUN-PROMPT-WEIGHT - After user enters the name of the cat, the system shall ask the user the weight of the cat and wait for input.

FUN-DISPLAY-VERDICT - After user enters the weight of the cat, the system shall print the string "[NAME] is [VERDICT].", where [NAME] is the cat's name provided by the user and [VERDICT] is the string "underweight" when the provided weight is 4 or less, "normal weight" when the weight is between 5 and 25 inclusive, or "overweight" when the weight is 26 or above.  Then the sytem shall shut down.

FUN-INVALID-NAME - If provided name does not consist of lower-case or upper-case alphabets of length less or equal to 10, the system shall ask the user to try again with a shorter name and shut down.

FUN-INVALID-WEIGHT - If provided weight is not an integer, the system shall ask the user to try again with a valid weight and shut down.
