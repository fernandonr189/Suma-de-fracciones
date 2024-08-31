import java.util.Arrays;
import java.util.Objects;

public class Operation {

    private String leftStatement;
    private String rightStatement;
    private Operand leftOperand;
    private Operand rightOperand;
    private Operator operator;
    private String statement;

    public double getResult() {
        return result;
    }

    private double result;

    public Operation(String _statement) {
        this.statement = _statement;
    }

    public enum Operator {
        MAS,
        MENOS,
        POR,
        ENTRE
    }

    private static final String[] operators = new String[] {
            " mas ",
            " menos ",
            " por ",
            " entre "
    };


    public void parseInput() throws Exception {
        String op = "";

        // Obtener operador
        for(String operator: operators) {
            if(statement.contains(operator)) {
                op = operator;
            }
        }

        // Seleccionar operador en enum
        switch (op) {
            case " mas ":
                operator = Operator.MAS;
                break;
            case " menos ":
                operator = Operator.MENOS;
                break;
            case " por ":
                operator = Operator.POR;
                break;
            case " entre ":
                operator = Operator.ENTRE;
                break;
            default:
                throw new Exception("No valid operator in input string");
        };

        // Dividir string en operandos
        String[] operators = statement.split(op);

        if(operators.length < 2 || Objects.equals(operators[0], "")) {
            throw new Exception("No enough operands!");
        }

        leftStatement = operators[0];
        rightStatement = operators[1];

        // Generar Operandos

        leftOperand = new Operand(leftStatement);
        rightOperand = new Operand(rightStatement);

        generateResult();
    }

    private void generateResult() throws Exception {
        double leftOperandValue = (double) leftOperand.getNumeratorValue() / (double) leftOperand.getDenominatorValue();
        double rightOperandValue = (double) rightOperand.getNumeratorValue() / (double) rightOperand.getDenominatorValue();


        switch (operator) {
            case MAS -> result = leftOperandValue + rightOperandValue;
            case POR -> result = leftOperandValue * rightOperandValue;
            case ENTRE -> result = leftOperandValue / rightOperandValue;
            case MENOS -> result = leftOperandValue - rightOperandValue;
            default -> throw new Exception("Ha ocurrido un error: operador invalido");
        }
    }
}
