package org.example.assembler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AInstructionCodeTest {

    @Test
    public void test(){
        int line = 16;
        Code code = new AInstructionCode(line);

        assertEquals("0000000000010000", code.getCode());
    }

    @Test
    public void test2(){
        int line = 12345;
        Code code = new AInstructionCode(line);

        assertEquals("0011000000111001", code.getCode());
    }

}