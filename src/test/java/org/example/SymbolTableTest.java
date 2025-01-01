package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTableTest {

    @Test
    public void predefinedTest(){
        SymbolTable symbolTable = new SymbolTable();

        Integer screen = symbolTable.get("SCREEN");
        assertEquals(16384, screen);
    }

    @Test
    public void testAddSymbol(){
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.put("LOOP", 25);

        Integer loop = symbolTable.get("LOOP");
        assertEquals(25, loop);
    }

    @Test
    public void testVariable(){
        SymbolTable symbolTable = new SymbolTable();

        Integer firstVariable =  symbolTable.getOfVariable("firstTmp");
        Integer firstVariable2 =  symbolTable.getOfVariable("firstTmp");
        Integer secondVariable =  symbolTable.getOfVariable("secondTmp");

        //variable's register starts from 16
        assertEquals(16, firstVariable);
        assertEquals(16, firstVariable2);
        assertEquals(17, secondVariable);
    }

}