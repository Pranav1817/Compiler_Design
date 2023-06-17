import java.util.Stack;

public class ThreeAddressCodeGenerator {
    
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    public static String generateThreeAddressCode(String postfixExpr) {
        Stack<String> stack = new Stack<>();
        int tempVarCount = 1;
        
        for (char token : postfixExpr.toCharArray()) {
            if (Character.isLetter(token)) {
                stack.push(Character.toString(token));
            } else if (isOperator(token)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String tempVar = "T" + tempVarCount++;
                
                String code = tempVar + " = " + operand1 + " " + token + " " + operand2;
                stack.push(tempVar);
                
                System.out.println(code);
            }
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String postfixExpression = "AB+CD-*";
        System.out.println("Three-address code:");
        generateThreeAddressCode(postfixExpression);
    }
}
