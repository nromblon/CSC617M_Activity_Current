package com.elements.parser;

import com.elements.Stage;
import com.objects.InteractableObject;
import java.util.ArrayList;
import java.util.List;

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
        //splits input into tokens
        String[] tokens = input.split(" ");
        //Removes empty character and null from String array
        List<String> tokenTemp = new ArrayList<>();
        for(String s : tokens) {
            if(s != null && s.length() > 0) {
               tokenTemp.add(s);
            }
        }
        tokens = tokenTemp.toArray(new String[tokenTemp.size()]);

        ArrayList<Action> actions = new ArrayList<>();
        Commands cmd = null;
        InteractableObject obj = null;
        //Parsing process
        for(index=0; index<tokens.length;index++){
            System.out.println("token[#]: "+index+" -- "+tokens[index]);
            if(cmd == null) {
                cmd = Commands.slookup(index, tokens);

                System.out.println("CMD: "+cmd);
                if(cmd != null) {
                    if (cmd.equals(Commands.EXIT)) {
                        actions.add(new Action(cmd, null));
                        obj = null;
                    }
                }
            }
            else if(Linker.exists(tokens[index])) {
                if(cmd != null && obj != null)
                    actions.add(new Action(cmd, obj));
                else
                    actions.add(new Action(Commands.ERROR,null));
                cmd = null;
                obj = null;
            }
            else{
                if(!cmd.equals(Commands.EXIT) && obj == null) {
                    System.out.println("pre search: "+ index);
                    obj = stage.slookupObject(index, tokens);
                    System.out.println("ppost search: "+ index);
                }

            }

        }

        if(cmd != null && obj != null)
            actions.add(new Action(cmd,obj));
        else {
            if (cmd == null)
                actions.add(new Action(Commands.ERROR, null));
            else if (!cmd.equals(Commands.EXIT))
                actions.add(new Action(Commands.ERROR, null));
        }

        Action[] a = new Action[actions.size()] ;
        a = actions.toArray(a);

        return a;
    }
}
