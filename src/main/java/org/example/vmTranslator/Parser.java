package org.example.vmTranslator;

/*
* parse each VM command into its lexical element
* */
public class Parser {

    private CommandType command;
    private String arg1;
    private int arg2;

    public Parser(String filePath){}

    public boolean hasMoreCommands(){ return true; }

    public void advance(){}

    public CommandType commandType() { return command; }

    public String arg1(){ return arg1; }

    public int arg2(){ return arg2; }

    void doAdvance(String command){

    }
}
