package com.elements.parser;

public enum Commands {
    VIEW (new String[]{"view","check","inspect","observe"}),
    OPEN (new String[]{"open","switch","turn","enter"}),
    CLOSE (new String[]{"close"}),
    TAKE (new String[]{"take","pick","remove","lift"}),
    USE (new String[]{"use"}),
    MOVE (new String[]{"move","go","goto"}),
    ERROR (new String[]{"error"});
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
