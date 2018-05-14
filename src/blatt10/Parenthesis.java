import AlgoTools.IO;

public class Parenthesis {

    public static void main(String[] args) {

        //
        ArrayStack stack = new ArrayStack();
        String input;
        boolean correct = true;
        char currentBracket = ' ';

        do {
            input = IO.readString("Eingeben: ");
        } while (input.length() == 0);

        for (int i = 0; i < input.length() && correct; i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '<') {
                switch (input.charAt(i)) {
                    case '(':
                        currentBracket = ')';
                        break;
                    case '{':
                        currentBracket = '}';
                        break;
                    case '[':
                        currentBracket = ']';
                        break;
                    case '<':
                        currentBracket = '>';
                        break;
                }
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == currentBracket) {
                if (!stack.isEmpty() && ((char) stack.top() == '(' || (char) stack.top() == '{' || (char) stack.top() == '[' || (char) stack.top() == '<')) {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        switch ((char) stack.top()) {
                            case '(':
                                currentBracket = ')';
                                break;
                            case '{':
                                currentBracket = '}';
                                break;
                            case '[':
                                currentBracket = ']';
                                break;
                            case '<':
                                currentBracket = '>';
                                break;
                        }
                    } else {
                        currentBracket = ' ';
                    }
                } else {
                    correct = false;
                }
            }
        }

        if (stack.isEmpty() && correct) {
            IO.println("Jo!");
        } else {
            IO.println("Cool!");
        }

        IO.println();

    }
}
