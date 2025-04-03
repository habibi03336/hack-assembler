package org.example.vmTranslator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeWriterTest {

    @Test
    void translatePopCommandLocalTest(){
        // given
        CodeWriter codeWriter = new CodeWriter();

        // execute
        String[] translated = codeWriter.translatePop("local", 7);

        // then
        // https://evoniuk.github.io/posts/nand.html ... beautiful optimization, mine was 17 lines.
        assertEquals("@SP", translated[0]);
        assertEquals("M=M-1", translated[1]);
        assertEquals("A=M", translated[2]);
        assertEquals("D=M", translated[3]);
        assertEquals("@LCL", translated[4]);
        assertEquals("D=D+M", translated[5]);
        assertEquals("@7", translated[6]);
        assertEquals("D=D+A", translated[7]);
        assertEquals("@SP", translated[8]);
        assertEquals("A=M", translated[9]);
        assertEquals("A=M", translated[10]);
        assertEquals("A=D-A", translated[11]);
        assertEquals("M=D-A", translated[12]);
    }

    @Test
    void translatePopCommandTest(){
        // given
        CodeWriter codeWriter = new CodeWriter();

        // execute
        String[] translated = codeWriter.translatePop("argument", 20);

        // then
        // https://evoniuk.github.io/posts/nand.html ... beautiful optimization, mine was 17 lines.
        assertEquals("@SP", translated[0]);
        assertEquals("M=M-1", translated[1]);
        assertEquals("A=M", translated[2]);
        assertEquals("D=M", translated[3]);
        assertEquals("@ARG", translated[4]);
        assertEquals("D=D+M", translated[5]);
        assertEquals("@20", translated[6]);
        assertEquals("D=D+A", translated[7]);
        assertEquals("@SP", translated[8]);
        assertEquals("A=M", translated[9]);
        assertEquals("A=M", translated[10]);
        assertEquals("A=D-A", translated[11]);
        assertEquals("M=D-A", translated[12]);
    }

}