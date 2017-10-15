package com.elements.parser;

public enum Commands {
    VIEW (new String[]{"view"}),
    OPEN (new String[]{"open","switch","turn"}),
    CLOSE (new String[]{"close"}),
    TAKE (new String[]{"take","pick"}),
    USE (new String[]{"use"}),
    MOVE (new String[]{"move","go"});

    protected String[] synonyms;

    Commands(String[] synonyms){
        this.synonyms =  synonyms;
    }

    private String[] synonyms(){return this.synonyms;}

    /**
     * searches if the input command is a valid one, regardless of its case.
     * @param token the token to be looked for
     * @return returns the command that matched, otherwise returns null
     */
    public static Commands lookup(String token) {
        for (Commands c : Commands.values()) {
            for(String synonym : c.synonyms()) {
                if (synonym.equalsIgnoreCase(token)) {
                    return c;
                }
            }
        }
        return null;
    }
}
