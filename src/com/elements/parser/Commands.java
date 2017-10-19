package com.elements.parser;

public enum Commands {
    VIEW (new String[]{"view","check","inspect","observe"}),
    OPEN (new String[]{"open","switch","turn","enter"}),
    CLOSE (new String[]{"close"}),
    TAKE (new String[]{"take","pick","remove","lift"}),
    USE (new String[]{"use"}),
    EXIT (new String[]{"exit","go back", "leave"}),
    MOVE (new String[]{"move","go","goto", "go to"}),
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

    public static Commands slookup(int index, String[] tokens){
        for (Commands c : Commands.values()) {
            for(String s : c.synonyms()) {
                String[] ntokens = s.split(" ");
                boolean isMismatch = false;
                int i = index, j = 0;
                while(j < ntokens.length && i < tokens.length){
                    if(ntokens[j++].equalsIgnoreCase(tokens[i])) {
                        i++;
                    }
                    else{
                        isMismatch=true;
                        break;
                    }
                }

                if(j != ntokens.length)
                    isMismatch = true;

                if(!isMismatch) {
                    ActionParser.index = index + (i - index) - 1;
                    return c;
                }
            }
        }

        return null;
    }
}
