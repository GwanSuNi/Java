package 스택활용예제;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String postfix = "";

		while (true) {
			System.out.print("사칙 연산 식을 입력하세요 > ");
			// 2 + 3 * 4 - 1
			String expression = scan.nextLine();
			// 한줄 읽고 q인지 확인해서 q면 break;
			if (expression.equals("q")) {
				System.out.println("종료됨");
				break;
			}

			ArrayStack<String> stack = new ArrayStack<String>();
			postfix = "";
			// 아니면 수식 계산
			StringTokenizer tokens = new StringTokenizer(expression, "+-*/", true);
			// 피연산자 스택 (operand stack)
//			ArrayStack<String> oprStack = new ArrayStack<String>();
//			// 연산자 스택 (operator stack)
//			ArrayStack<String> opStack = new ArrayStack<String>();

			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken().trim();
				if (token.chars().allMatch(Character::isDigit)) {
					// System.out.println("숫자 문자열");
					// oprStack.push(token);

					// 피 연산자이면 무조건 후위표기 문자열로추가
					postfix += token + " ";

				} else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
					// System.out.println("연산자");
//					opStack.push(token);
					// 연산자 우선순위 검사
					// 사칙연산 우선순위 높은 *, / 이면 바로 스택에 추가
					if (token.equals("*") || token.equals("/")) {
						stack.push(token);
					} else { // 사칙연산 우선순위 낮은 +,-이면 스택에서 토큰 꺼서 후위 표기 문자열로 추가
						do {
							if (stack.isEmpty())
								break;
							postfix += stack.pop() + " ";
						} while (!stack.isEmpty()
								&& (!stack.peek().contentEquals("+") && !stack.peek().contentEquals("-")));
						stack.push(token);
					}
				} else {
					System.out.println("수식에 문제가 있습니다");
				}
			}
//			oprStack.print();
//			opStack.print();
			while (!stack.isEmpty()) {
				postfix += stack.pop() + " ";
			}
			System.out.println(postfix);

			ArrayStack<String> calc = new ArrayStack<String>();
			StringTokenizer values = new StringTokenizer(postfix, " ");
			double num1, num2, result;

			while (values.hasMoreTokens()) {
				String token = values.nextToken();

				if (token.chars().allMatch(Character::isDigit)) { // token을 trim 하면 empty string 뜨고 있던 이유
					calc.push(token);
				} else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
					num2 = Double.parseDouble(calc.pop());
					num1 = Double.parseDouble(calc.pop());

					result = calculate(num1, num2, token);
					calc.push(Double.toString(result));
				}
			} // end while
				// result
			System.out.println("result = " + calc.pop());
		}
		scan.close();
	}

	public static double calculate(double a, double b, String op) {
		switch (op) {
		case "*":
			return a * b;
		case "/":
			return a / b;
		case "+":
			return a + b;
		default:
			return a - b;
		}

	}
}
