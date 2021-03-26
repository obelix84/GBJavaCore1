package lesson8;

public class Calculator {

    private ExpressionHelper eh;

    public Calculator(ExpressionHelper EH) {
        this.eh = EH;
    }

    public double calculate(String expression) {
        int start = 0;
        String [] parts = expression.split("[\\+\\-\\/\\*]");
        double d = 0;
        if (eh.isNumber(parts[0])){
            d = Double.parseDouble(parts[0]);
        } else if (eh.isFunction(parts[0])) {
            d = Math.sqrt(Double.parseDouble(parts[0].substring(4)));
        }
        double result = d;
        start = parts[0].length();
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (eh.isNumber(part)) {
                d = Double.parseDouble(part);
            } else if (eh.isFunction(part)) {
                d = Math.sqrt(Double.parseDouble(part.substring(4)));
            }
            switch (expression.charAt(start)) {
                case '-':
                    result -= d;
                    break;
                case '+':
                    result += d;
                    break;
                case '*':
                    result *= d;
                    break;
                case '/':
                    result /= d;
                    break;
            }
            start += part.length() + 1;
        }
        return result;
    }

}
