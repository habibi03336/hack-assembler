package org.example.vmTranslator;

import java.util.List;

/*
* parse each VM command into its lexical element
* */
public class Parser {

    private CommandType commandType;
    private String arg1;
    private int arg2;

    public Parser(String filePath){}

    public boolean hasMoreCommands(){ return true; }

    public void advance(){}

    public CommandType commandType() { return commandType; }

    public String arg1(){ return arg1; }

    public int arg2(){ return arg2; }

    private List<String> arithmeticExpressions = List.of("add", "sub", "neg", "eq", "gt", "lt", "and", "or", "not");
    void doAdvance(String command){
        String[] commands = command.split(" ");
        if(arithmeticExpressions.contains(commands[0])){
            commandType = CommandType.C_ARITHMETIC;
            arg1 = commands[0];
        } else {
            commandType = CommandType.fromToken(commands[0]);
            arg1 = commands[1];
            arg2 = Integer.valueOf(commands[2]);
        }
    }
}
