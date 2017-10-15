package com.elements.parser;

import com.elements.Stage;
import com.objects.InteractableObject;
import world.GameWorld;

import java.util.ArrayList;

public class ActionParser {

//    private ActionParser(){
//        instance = new ActionParser();
//    }
//
//    public static ActionParser getInstance() {
//        if(instance == null){
//            instance = new ActionParser();
//        }
//        return instance;
//    }
    public static int index = 0;


    public static Action[] parse(String input, Stage stage){
        String[] tokens = input.split(" ");

        ArrayList<Action> actions = new ArrayList<>();
        Commands cmd = null;
        InteractableObject obj = null;

        for(index=0; index<tokens.length;index++){
            System.out.println("token[#]: "+index+" -- "+tokens[index]);
            if(cmd == null)
                cmd = Commands.lookup(tokens[index]);
            else{
                if(obj == null) {
                    System.out.println("pre search: "+ index);
                    obj = stage.slookupObject(index, tokens);
                    System.out.println("ppost search: "+ index);
                }
                else
                    if(Linker.exists(tokens[index])) {
                        actions.add(new Action(cmd, obj));
                        cmd = null;
                        obj = null;
                    }

            }
        }

        if(cmd != null && obj != null)
            actions.add(new Action(cmd,obj));

        Action[] a = new Action[actions.size()] ;
        a = actions.toArray(a);

        return a;
    }
}
