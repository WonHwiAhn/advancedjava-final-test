package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.print( "두 정수와 연산자를 입력하시오 >> " );
		
		//int a = scanner.nextInt();
		//int b = scanner.nextInt();
		String operation = scanner.nextLine();
		
		// 사용자의 입력 형태 : 3 4 +
		// 마지막에 연산자가 들어감.
		
		String[] datas = operation.split("\\s");
		
		//마지막 배열의 값은 연산자
		String oper = datas[datas.length-1];
		int num1 = Integer.parseInt(datas[0]);
		int num2 = Integer.parseInt(datas[1]);
		
		//다형성 활용 및 배열로 생성
		Arithmetic[] calc = {
								new Add(),
								new Sub(),
								new Mul(),
								new Div()
							};
		
		switch (oper) {
			case "+":
				System.out.println( "\n" + 
									calc[0].calculate(num1, num2)
								  );
				break;
			case "-":
				System.out.println( "\n" + 
									calc[1].calculate(num1, num2)
								  );
				break;
			case "*":
				System.out.println( "\n" + 
									calc[2].calculate(num1, num2)
								  );
				break;
			case "/":
				System.out.println( "\n" + 
									calc[3].calculate(num1, num2)
								  );
				break;
			default:
				System.out.println("ㅎㅎ 연산자 확인 부탁요 ㅎㅎ");
				break;
		}
		/* operation에 따라 4칙 연산 객체를 생성하고 caculate 메서드를 호출합니다. */
		
		if(scanner != null)
			scanner.close();
	}
}
