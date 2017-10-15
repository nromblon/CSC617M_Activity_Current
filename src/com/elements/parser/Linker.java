package com.elements.parser;

public enum Linker {
    THEN,
    AND;


    public static boolean exists(String token) {
        for (Linker a : Linker.values()) {
            if (a.name().equalsIgnoreCase(token)) {
                return true;
            }
        }
        return false;
    }
}
