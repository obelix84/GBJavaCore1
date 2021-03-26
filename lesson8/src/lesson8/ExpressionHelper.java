package lesson8;

import java.util.regex.Pattern;

public class ExpressionHelper {

    private final String fullExpression = "^((\\d+\\.?\\d*)|(sqrt(\\d+\\.?\\d*)))([\\-\\+\\*\\/]((\\d+\\.?\\d*)|sqrt(\\d+\\.?\\d*)))*$";
    private final String intermediateExpression = "^((\\d+\\.?\\d*)|(sqrt(?=$)|sqrt(\\d+\\.?\\d*)))([\\-\\+\\*\\/]" +
            "((\\d+\\.?\\d*)|(sqrt(?=$)|sqrt(\\d+\\.?\\d*))))*([\\-\\+\\*\\/]?)$";
    private final String operatorAtEnd = "([\\-\\+\\*\\/])([\\-\\+\\*\\/])$";

    private final String numbers = "\\d+\\.?\\d*";
    private final String functions = "sqrt(\\d+\\.?\\d*)";
    private final String operators = "[\\-\\+\\*\\/]";

    private final Pattern patternFull;
    private final Pattern patternInter;
    private final Pattern patternOperatorAtEnd;
    private final Pattern patternOperators;
    private final Pattern patternNumber;
    private final Pattern patternFunctions;

    public ExpressionHelper() {
        patternFull = Pattern.compile(fullExpression);
        patternInter = Pattern.compile(intermediateExpression);
        patternOperators = Pattern.compile(operators);
        patternOperatorAtEnd = Pattern.compile(operatorAtEnd);
        patternNumber = Pattern.compile(numbers);
        patternFunctions = Pattern.compile(functions);
    }

    public boolean isValid(String expression) {
        return patternInter.matcher(expression).matches();
    }

    public boolean isNumber(String expression) {
        return patternNumber.matcher(expression).matches();
    }

    public boolean isFunction(String expression) {
        return patternFunctions.matcher(expression).matches();
    }

    public boolean isComputable(String expression) {
        return patternFull.matcher(expression).matches();
    }

    public boolean isOperation(String expression) {
        return patternOperators.matcher(expression).matches();
    }

    public boolean isOperatorAtEnd(String expression) {
        return patternOperatorAtEnd.matcher(expression).find();
    }
}
