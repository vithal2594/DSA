package stacks.Easy;

import java.util.Stack;

public class removekdigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigitsMax(num, k));  // Output: "4329"
        System.out.println(removeKdigitsmin(num, k));   //1219
        System.out.println(removeKdigitsMax1(num, k));  // Output: "4329"
        System.out.println(removeKdigitsmin1(num, k));
    }
    // Minimum Number Version
    public static String removeKdigitsmin1(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        // Remove remaining digits from end
        while (k-- > 0 && !stack.isEmpty()) {
            stack.pop();
        }
        // Build result
        StringBuilder sb = new StringBuilder();
        for (char digit : stack) {
            sb.append(digit);
        }
        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

    // Maximum Number Version
    public static String removeKdigitsMax1(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        // Remove remaining digits from end
        while (k-- > 0 && !stack.isEmpty()) {
            stack.pop();
        }
        // Build result
        StringBuilder sb = new StringBuilder();
        for (char digit : stack) {
            sb.append(digit);
        }
        return sb.toString();
    }
    public static String removeKdigitsMax(String num, int k) {
        StringBuilder sb = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }

        // Remove remaining from end if k > 0
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        return sb.toString();
    }
    public static String removeKdigitsmin(String num, int k) {
        StringBuilder sb = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }

        // remove remaining from end
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        // remove leading zeros
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String result = sb.substring(i);
        return result.isEmpty() ? "0" : result;
    }
}

