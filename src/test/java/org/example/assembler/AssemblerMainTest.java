package org.example.assembler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;


public class AssemblerMainTest {

    @Test
    public void pongCompareTest() throws IOException {
        URL pongAsm = AssemblerMainTest.class.getClassLoader().getResource("MainTestPongL.asm");
        AssemblerMain.run(pongAsm.getPath());

        URL pongHackAssembled = AssemblerMainTest.class.getClassLoader().getResource("MainTestPongL.hack");
        URL pongHackExpected = AssemblerMainTest.class.getClassLoader().getResource("MainTestPongLExpected.hack");

        try (
                BufferedReader assembled = new BufferedReader(new FileReader(pongHackAssembled.getPath()));
                BufferedReader expected = new BufferedReader(new FileReader(pongHackExpected.getPath()))
        ){
            String assembledLine = assembled.readLine();
            String expectedLine = expected.readLine();
            while(assembledLine!= null && expectedLine != null) {
                // assert every line is equal
                assertEquals(expectedLine, assembledLine);
                assembledLine = assembled.readLine();
                expectedLine = expected.readLine();
            }
            // assert length of the files is same
            assertTrue(assembledLine == null && expectedLine == null);
        }
    }
}
