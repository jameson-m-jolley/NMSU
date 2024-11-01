public class postfix {
    public static void main(String[] args) {
        String postfix = "54*67-+8*";
        char operator;
        int op1;
        int op2;
        
        linkstack<String> stack = new linkstack<String>();
        char[] post = postfix.toCharArray();
        for (int i = 0;i<postfix.length();i++){
            
                stack.push(""+(post[i]));
            if(Character.isDigit(stack.top().charAt(0))){
                
                continue;
            }else{
                operator = stack.pop().charAt(0);
                op1 = Integer.parseInt(stack.pop());
                op2 = Integer.parseInt(stack.pop());
                switch (operator) {
                    case '+':
                        stack.push(Integer.toString(op1+op2));
                        break;
                    case '-':
                        stack.push(Integer.toString(op1-op2));
                        break;
                    case '*':
                        stack.push(Integer.toString(op1*op2));
                        break;
                    case '/':
                        if (op2 != 0) {
                            stack.push(Integer.toString(op1/op2));
                        } else {
                            throw new ArithmeticException("Division by zero");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator: " + operator);
                }
            }
            }
            System.out.println(stack.pop());
    
    }
}
