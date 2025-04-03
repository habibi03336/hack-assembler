package org.example;

import org.example.assembler.AssemblerMain;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String type = args[0];
        String filePath = args[1];

        if("assembler".equalsIgnoreCase(type)){
            AssemblerMain.run(filePath);
        } else if("vm-translator".equalsIgnoreCase(type)){

        }
    }

}
