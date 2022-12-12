package com.java.register;

import java.util.regex.Pattern;

public class 정규표현식테스트 {

	public static void main(String[] args) {
		String regString = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{5,16}$";

		System.out.println(Pattern.matches(regString, "12345"));
		System.out.println(Pattern.matches(regString, "abcdef"));
		System.out.println(Pattern.matches(regString, "12as23as"));
		System.out.println(Pattern.matches(regString, "asd13!as@"));
		System.out.println(Pattern.matches(regString, "마나aso12@"));
		System.out.println(Pattern.matches(regString, "a_so12"));

		/*
		 * Pattern 클래스와 Matcher 클래스를 활용하여 입력된 패스워드에 대한 규칙(복잡도)검사
		 * 
		 * 규칙1. 패스워드 길이 : 영문자, 숫자, 특수문자(!@#$%) 조합 8자리~16자리 규칙2. 영문자(대,소문자),
		 * 숫자,특수문자(!@#!$%) 중 2가지 이상 조합 -> 4가지 모두 조합시 : 안전 -> 3가지 조합시 : 보통 -> 2가지 조합시 :
		 * 미흡 -> 1가지 조합시 : 사용불가능한 패스워드
		 */

		// 영문자(대문자 또는 소문자) 판별 정규표현식
//        String engRegex="[A-Za-z]";
		// 영문 대문자와 소문자를 별도로 구분하여 판별하는 정규표현식

		String engUpperRegex = "[A-Z]";// 대문자
		String engLowerRegex = "[a-z]";// 소문자
		String numRegex = "[0-9]";
		String specRegex = "[!@#$%]";
		// 패스워드 길이를 판별하는 정규표현식
		// 영문자(대,소문자), 숫자, 특수문자(!@#$%) 조합 8~16자리로 시작하고 끝
		String lengthRegex = "^[A-Za-z0-9!@#$%]{8,16}$";

		String[] passwords = { "Abcde123!", "abcde123@", "abcde123", "12345678", "abcde한글!" };
		// Pattern.matches() 메서드를 호출하여 패스워드가 길이 규칙에 일치하는지 여부 출력
		for (String s : passwords) {
			if (Pattern.matches(lengthRegex, s)) {
				// 패스워드 길이 체크를 통과했을 경우
//                System.out.println(s+" : 길이 규칙 일치");
				// 각 패턴(영문 대,소문자, 숫자,특수문자)이 포함되는지를 각각 검사
				// 검사 결과를 포인트화하여 패스워드 등급 계산하기 위해 변수 필요
				int count = 0;

				// 삼항연산자를 사용하여 표현하는 방법
				// 판별 결과가 true이면 1더하기 ,아니면 0 더하기
				count += Pattern.compile(engUpperRegex).matcher(s).find() ? 1 : 0;
				count += Pattern.compile(engLowerRegex).matcher(s).find() ? 1 : 0;
				count += Pattern.compile(numRegex).matcher(s).find() ? 1 : 0;
				count += Pattern.compile(specRegex).matcher(s).find() ? 1 : 0;

				// 점수를 판별하여 패스워드 복잡도 검사결과 출력
				switch (count) {
				case 4:
					System.out.println(s + " : 안전");
					break;
				case 3:
					System.out.println(s + " : 보통");
					break;
				case 2:
					System.out.println(s + " : 미흡");
					break;
				default:
					System.out.println(s + " : 사용불가능한 패스워드");
					break;
				}
			} else {
				// 패스워드 길이 체크를 통과하지 못했을 경우
				System.out.println(s + " : 영문자or숫자or특수문자 조합 8~16자리 필수");
			}
		}

	}

}
