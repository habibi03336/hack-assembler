package org.example.vmTranslator;

public enum CommandType {
    C_ARITHMETIC("arithmetic"),
    C_PUSH("push"),
    C_POP("pop");

//    C_LABEL(""),
//    C_GOTO(""),
//    C_IF(""),
//    C_FUNCTION(""),
//    C_RETURN(""),
//    C_CALL("")

    private String token;

    public static CommandType fromToken(String token) {
        for (CommandType type : CommandType.values()) {
            if (type.token.equals(token)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown command token: " + token);
    }

    CommandType(String token){
        this.token = token;
    }
}
