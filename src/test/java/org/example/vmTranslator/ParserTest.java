package org.example.vmTranslator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    public void parsePushCommand(){
        //given
        Parser parser = new Parser("");

        //execute
        parser.doAdvance("push local 1");

        //then
        assertEquals(CommandType.C_PUSH, parser.commandType());
        assertEquals("local", parser.arg1());
        assertEquals(1, parser.arg2());
    }

    @Test
    public void parsePopCommand(){
        //given
        Parser parser = new Parser("");
        String commandString = "pop local 1";

        //execute
        parser.doAdvance(commandString);

        //then
        assertEquals(CommandType.C_POP, parser.commandType());
        assertEquals("local", parser.arg1());
        assertEquals(1, parser.arg2());
    }


}