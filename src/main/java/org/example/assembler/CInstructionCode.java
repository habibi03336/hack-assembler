package org.example.assembler;

public class CInstructionCode extends Code {

    private String code;

    public CInstructionCode(String dest, String comp, String jmp){
        String destCode = Dest.valueOf(dest).code;
        String compCode = Comp.getCompOf(comp).code;
        String jmpCode = Jump.valueOf(jmp).code;
        code = "111" + compCode + destCode + jmpCode;
    }

    @Override
    public String getCode() {
        return code;
    }

    private enum Comp {
        ZERO("0", "0101010"),
        ONE("1", "0111111"),
        MINUS_ONE("-1", "0111010"),
        D("D", "0001100"),
        A("A", "0110000"),
        NOT_D("!D", "0001101"),
        NOT_A("!A", "0110001"),
        MINUS_D("-D", "0001111"),
        MINUS_A("-A", "0110011"),
        D_PLUS_ONE("D+1", "0011111"),
        A_PLUS_ONE("A+1", "0110111"),
        D_MINUS_ONE("D-1", "0001110"),
        A_MINUS_ONE("A-1", "0110010"),
        D_PLUS_A("D+A", "0000010"),
        D_MINUS_A("D-A", "0010011"),
        A_MINUS_D("A-D", "0000111"),
        D_BITAND_A("D&A", "0000000"),
        D_BITOR_A("D|A", "0010101"),
        M("M", "1110000"),
        NOT_M("!M", "1110001"),
        MINUS_M("-M", "1110011"),
        M_PLUS_ONE("M+1", "1110111"),
        M_MINUS_ONE("M-1", "1110010"),
        D_PLUS_M("D+M", "1000010"),
        D_MINUS_M("D-M", "1010011"),
        M_MINUS_D("M-D", "1000111"),
        D_BITAND_M("D&M", "1000000"),
        D_BITOR_M("D|M", "1010101");

        private final String sign;
        private final String code;
        Comp(String sign, String code){
            this.sign = sign;
            this.code = code;
        }

        private static Comp getCompOf(String sign){
            for(Comp comp : Comp.values()){
                if(comp.sign.equals(sign)){
                    return comp;
                }
            }
            throw new IllegalArgumentException("해당 computation이 존재하지 않습니다.");
        }
    }

    private enum Dest {
        NULL("000"),
        M("001"),
        D("010"),
        MD("011"),
        A("100"),
        AM("101"),
        AD("110"),
        AMD("111");

        private final String code;

        Dest(String code){
            this.code = code;
        }

    }

    private enum Jump {
        NULL("000"),
        JGT("001"),
        JEQ("010"),
        JGE("011"),
        JLT("100"),
        JNE("101"),
        JLE("110"),
        JMP("111");

        private final String code;

        Jump(String code){
            this.code = code;
        }
    }

}
