package org.example;

public class Parser {

    private String dest = "NULL";
    private String comp = "NULL";
    private String jmp = "NULL";

    public Parser(String instruction){
        String[] splitJmp = instruction
                .replace(" ", "")
                .split(";");
        if(splitJmp.length == 2){
            jmp = splitJmp[1];
        }
        String[] splitDest = splitJmp[0].split("=");
        if(splitDest.length == 2){
            dest = splitDest[0];
            comp = splitDest[1];
        } else if (splitDest.length == 1) {
            comp = splitDest[0];
        }
    }

    public String getDest(){
        return dest;
    }

    public String getComp(){
        return comp;
    }

    public String getJmp(){
        return jmp;
    }

}
