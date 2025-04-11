import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 *
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 *
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：s = "(]"
 *
 * 输出：false
 *
 * 示例 4：
 *
 * 输入：s = "([])"
 *
 * 输出：true
 */
public class ValidBracket {
    // 注意审题，是按顺序关闭
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            if (stack.isEmpty())
                return false;
            if (c == '}' && stack.peek() != '{'){
                return false;
            }

            if (c == ']' && stack.peek() != '['){
                return false;
            }
            if (c == ')' && stack.peek() != '('){
                return false;
            }

            if (c == '}' || c == ']' || c == ')'){
                stack.pop();
            }

        }

        if (stack.isEmpty())
            return true;

        return  false;
    }

    public static void main(String[] args) {
        String str = "()";
        ValidBracket validBracket = new ValidBracket();
        System.out.println(validBracket.isValid(str));
    }
}
