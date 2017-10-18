package com.elements.parser;

import com.objects.InteractableObject;

public class Action {

    private Commands command;
    private InteractableObject object;

    public Action(Commands command, InteractableObject target){
        this.command = command;
        this.object = target;
    }

    public Commands getCommand() {
        return command;
    }

    public void setCommand(Commands command) {
        this.command = command;
    }

    public InteractableObject getObject() {
        return object;
    }

    public void setObject(InteractableObject object){
        this.object = object;
    }
}
