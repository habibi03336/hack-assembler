package org.example;

public class AInstructionCode extends Code {

    String code;

    public AInstructionCode(int line){
        String binary = Integer.toString(line, 2);
        code = "0".repeat(16 - binary.length()) + binary;
    }

    @Override
    public String getCode() {
        return code;
    }
}
