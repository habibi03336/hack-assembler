package org.example;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private Map<String, Integer> map = new HashMap<>();
    private int pointer = 16;

    public SymbolTable(){
        // set up predefined symbols
        for(int i = 0; i < 16; i += 1){
            map.put("R" + i, i);
        }
        map.put("SCREEN", 16384);
        map.put("KBD", 24576);
        map.put("SP", 0);
        map.put("LCL", 1);
        map.put("ARG", 2);
        map.put("THIS", 3);
        map.put("THAT", 4);
    }
    public Integer getOfVariable(String variable){
        if(!map.containsKey(variable)){
            map.put(variable, pointer);
            pointer += 1;
        }
        return map.get(variable);
    }

    public void put(String symbol, Integer val){
        map.put(symbol, val);
    }

    public Integer get(String symbol){
        return map.get(symbol);
    }

}
