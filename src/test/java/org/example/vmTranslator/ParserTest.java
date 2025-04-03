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


}