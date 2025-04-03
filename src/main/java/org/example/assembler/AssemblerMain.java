package org.example.assembler;

import java.io.*;

public class AssemblerMain {

    private static SymbolTable symbolTable = new SymbolTable();
    public static void run(String filePath) throws IOException {
        doFirstPass(filePath);
        doSecondPass(filePath);
    }

    public static void doFirstPass(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                if(isEmpty(line)) continue;
                index = firstPass(line, index);
            }
        }
    }

    private static int firstPass(String line, int index) {
        String cleanedLine = cleanLine(line);
        if (isSymbol(cleanedLine)){
            String symbol = cleanedLine.substring(1, cleanedLine.length()-1);
            symbolTable.put(symbol, index);
            return index;
        } else {
            return index + 1;
        }
    }

    private static void doSecondPass(String filePath) throws IOException {
        File file = new File(filePath);
        String fileName = file.getName();
        File hackFile = new File(file.getParent(), changeExtToHack(fileName));
        try (
                BufferedReader br = new BufferedReader(new FileReader(file));
                FileWriter writer = new FileWriter(hackFile)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                if(isEmpty(line) || isSymbol(line)) continue;
                String instruction = secondPass(line);
                writer.write(instruction + System.lineSeparator());
            }
        }
    }

    private static String secondPass(String line){
        String cleanedLine = cleanLine(line);
        Code code;
        if(cleanedLine.startsWith("@")){
            // A instruction
            String trimmed = cleanedLine.substring(1);
            int firstChar = trimmed.charAt(0);
            Integer val;
            if('0' <= firstChar && firstChar <= '9'){
                val = Integer.parseInt(trimmed);
            } else {
                val = symbolTable.get(trimmed);
                if(val == null){
                    // first seen variable
                    val = symbolTable.getOfVariable(trimmed);
                }
            }
            code = new AInstructionCode(val);
        } else {
            // C instruction
            Parser parser = new Parser(line);
            code = new CInstructionCode(parser.getDest(), parser.getComp(), parser.getJmp());
        }
        return code.getCode();
    }

    private static String changeExtToHack(String fileName){
        for(int i = fileName.length() - 1; i >= 0; i -= 1){
            char c = fileName.charAt(i);
            if(c == '.'){
                return fileName.substring(0, i) + ".hack";
            }
        }
        return fileName + ".hack";
    }

    private static boolean isEmpty(String line){
        String cleanedLine = cleanLine(line);
        return cleanedLine.length() == 0;
    }
    private static boolean isSymbol(String line){
        String cleanedLine = cleanLine(line);
        return cleanedLine.startsWith("(") && cleanedLine.endsWith(")");
    }
    public static String cleanLine(String line){
        return line.replace(" ", "").split("//")[0];
    }
}