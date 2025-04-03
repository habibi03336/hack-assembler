package org.example.vmTranslator;

import java.util.Map;

/*
* writes the assembly code that implements that parsed command
* */
public class CodeWriter {

    public CodeWriter(){}

    public void writeArithmetic(String arithmetic){}

    public void writePushPop(String command, String segment, int index){}

    private Map<String, String> segmentMapping = Map.of(
            "local", "LCL"
    );
    String[] translatePop(String segment, int index){
        return new String[]{
                "@SP",
                "M=M-1",
                "A=M",
                "D=M",
                "@" + segmentMapping.get(segment),
                "D=D+M",
                String.format("@%d", index),
                "D=D+A",
                "@SP",
                "A=M",
                "A=M",
                "A=D-A",
                "M=D-A"
        };
    }

    public void close(){}

}

