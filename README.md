# DataEngFinalAsg

Determine the confidence and support of each word pair (bigram)
Ask user for word (as if they were typing it)
Build a List of possible "next words" at least 3 words in length
If the support of a word pair is >65% suggest that as one of the possible next word to be typed
Similar to how your phone gives you a list of possible next words when typing
If no words with support >65% suggest the three most common English connector words:
the, this, of
If less than 3 words found - pad the list with words from the most common Connectors (the this of)
Print out the list with each word on its own line similar to:
"Your next word might be <word here>.\n"
