package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CInstructionCodeTest {

    @Test
    public void test(){
        Code code = new CInstructionCode("AM", "D+1", "NULL");
        assertEquals("1110011111101000",  code.getCode());
    }

    @Test
    public void test2(){
        Code code = new CInstructionCode("NULL", "D+A", "JNE");
        assertEquals("1110000010000101",  code.getCode());
    }

    @Test
    public void test3(){
        Code code = new CInstructionCode("D", "0", "JMP");
        assertEquals("1110101010010111",  code.getCode());
    }

}