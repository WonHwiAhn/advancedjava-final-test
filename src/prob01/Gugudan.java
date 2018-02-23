package prob01;
import java.util.Scanner;


public class Gugudan {
	
	static int resultNumber = 0; //사용자 입력
	
	public static void main( String[] args ) {
		int l = randomize( 1, 9 ); //1~9까지 랜덤 숫자
		int r = randomize( 1, 9 );
		
		resultNumber = l * r; //정답.

		//보기 생성
		int[] answerNumbers = randomizeAnswers();
		int loc = randomize( 0, 8 );
		
		//중복 체크 bool
		boolean dup = false;
		//생성된 보기에 랜덤한 위치에 정답을 삽입.
		for(int i=0;i<answerNumbers.length;i++) {
			if(answerNumbers[i] == resultNumber){
				dup = true;
				break;
			}
		}
		
		if(!dup)
			answerNumbers[ loc ] = resultNumber;
		
		//질문 생성
		System.out.println( l + " x " + r + " = ?" );
		
		int length = answerNumbers.length;
		for( int i = 0; i < length; i++ ) {
			//3개 생성 후 한 줄 뜀
			if( i % 3 == 0 ) {
				System.out.print( "\n" );
			} else { //탭만큼 밀어줌
				System.out.print( "\t" );
			}
			
			System.out.print( answerNumbers[ i ] );
		}

		System.out.print( "\n\n" );
		System.out.print( "answer: " );

		Scanner s = new Scanner( System.in );

		if(s.nextInt() == resultNumber)
			System.out.println("\n정답");
		else
			System.out.println("\n오답");
		
		if(s != null)
			s.close();
	}

	private static int randomize( int lNum, int rNum ) {
        int random = (int) ( Math.random() * rNum ) + lNum;
        return random;
	}
	
	private static int[] randomizeAnswers() {

		final int COUNT_ANSWER_NUMBER = 9; // 보기 화면에 나오는 숫자 개수
		final int MAX_ANSWER_NUMBER = 81; // 정답의 최댓값
		
		// 보기 배열 생성
		int[] boardNumbers = new int[ COUNT_ANSWER_NUMBER ];
		int occupied = 0;
		
		//보기만큼 반복 (9번 반복)
		while( occupied < COUNT_ANSWER_NUMBER ) {
			
			//1~81까지
	        int random = ( int )( Math.random() * MAX_ANSWER_NUMBER ) + 1;
	        
	        //중복체크 위한 변수
	        boolean evaluted = false;
	        
	        //보기를 비교하면서 중복값을 찾는 반복문
	        for( int i = 0; i < occupied; i++ ) {
	        	//현재 i번째 배열값과 random으로 생성된 값이 일치하면 evaluted값 true로 변경
	        	if(random == boardNumbers[i]) {
	        		evaluted = true;
	        		break;
	        	}
	        }
	        
	        //중복이 아닐 경우 보기 값 추가 및 occupied값 증가
	        if( !evaluted ) {
	        	boardNumbers[ occupied++ ] = random;
	        }
		}
		
        return boardNumbers;
	}	
}
