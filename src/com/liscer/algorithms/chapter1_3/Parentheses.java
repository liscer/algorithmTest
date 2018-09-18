package com.liscer.algorithms.chapter1_3;

import java.util.Stack;
/**
 * 判断括号大括号中括号是否成对出现
 * @author libaojia
 *
 */
public class Parentheses {
	private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';
	

	public static void main(String[] args) {
		String s = "[()]{}{[()()]()}";
		System.out.println(isBalanced1(s));
	}
	/**
	 * 第一种写法
	 * 判断括号大括号中括号是否成对出现
	 * @param s 字符串
	 * @return
	 */
	public static boolean isBalanced(String s){
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)==LEFT_PAREN) {
				stack.push(LEFT_PAREN);
			}
			if (s.charAt(i)==LEFT_BRACE) {
				stack.push(LEFT_BRACE);
			}
			if (s.charAt(i)==LEFT_BRACKET) {
				stack.push(LEFT_BRACKET);
			}
			if (s.charAt(i)==RIGHT_PAREN) {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop()!=LEFT_PAREN) {
					return false;
				}
			}
			else if (s.charAt(i)==RIGHT_BRACE) {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop()!=LEFT_BRACE) {
					return false;
				}
			}
			else if (s.charAt(i)==RIGHT_BRACKET) {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop()!=LEFT_BRACKET) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static boolean isBalanced1(String s){
		Stack<String> stack = new Stack<>();
		String[] inputs = s.split("");
		for (String input : inputs) {
			if (input.equals("[") || input.equals("(") || input.equals("{")) {
				stack.push(input);
			} else if(!stack.isEmpty()){
				if (input.equals("}")) {
					if (!stack.pop().equals("{")) {
						return false;
					}
				}else if (input.equals("]")) {
					if (!stack.pop().equals("[")) {
						return false;
					}
				}else if (input.equals(")")) {
					if (!stack.pop().equals("(")) {
						return false;
					}
				}
			}
		}
		return stack.empty();
	}

}
