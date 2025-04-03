package org.example.assembler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    public void testComp1(){
        String instruction = "D=M+1";
        Parser parser = new Parser(instruction);

        String dest = parser.getDest();
        String comp = parser.getComp();
        String jmp = parser.getJmp();

        assertEquals("D", dest);
        assertEquals("M+1", comp);
        assertEquals("NULL", jmp);
    }

    @Test
    public void testComp2(){
        String instruction = "D=D+M";
        Parser parser = new Parser(instruction);

        String dest = parser.getDest();
        String comp = parser.getComp();
        String jmp = parser.getJmp();

        assertEquals("D", dest);
        assertEquals("D+M", comp);
        assertEquals("NULL", jmp);
    }

    @Test
    public void testComp3(){
        String instruction = "A=M";
        Parser parser = new Parser(instruction);

        String dest = parser.getDest();
        String comp = parser.getComp();
        String jmp = parser.getJmp();

        assertEquals("A", dest);
        assertEquals("M", comp);
        assertEquals("NULL", jmp);
    }

    @Test
    public void testJump1(){
        String instruction = "0; JMP";
        Parser parser = new Parser(instruction);

        String dest = parser.getDest();
        String comp = parser.getComp();
        String jmp = parser.getJmp();

        assertEquals("NULL", dest);
        assertEquals("0", comp);
        assertEquals("JMP", jmp);
    }

    @Test
    public void testJump2(){
        String instruction = "D; JEQ";
        Parser parser = new Parser(instruction);

        String dest = parser.getDest();
        String comp = parser.getComp();
        String jmp = parser.getJmp();

        assertEquals("NULL", dest);
        assertEquals("D", comp);
        assertEquals("JEQ", jmp);
    }

    @Test
    public void testCompJump(){
        String instruction = "A=A+D; JEQ";
        Parser parser = new Parser(instruction);

        String dest = parser.getDest();
        String comp = parser.getComp();
        String jmp = parser.getJmp();

        assertEquals("A", dest);
        assertEquals("A+D", comp);
        assertEquals("JEQ", jmp);
    }

}