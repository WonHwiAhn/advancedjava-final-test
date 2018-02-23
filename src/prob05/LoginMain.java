package prob05;
//exception 처리 if문으로 하는 문제
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LoginMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//가입된 유저리스트를 담기 위한 리스트 생성.
		List<User> joinUsers = new ArrayList<User>();
		//ID: jogn, PW: 1234의 유저 생성
		joinUsers.add( new User( "john", "1234") );
		
		System.out.print("아이디를 입력하시오 : ");
		String id = scanner.nextLine();
		
		System.out.print("비밀번호를 입력하시오 : ");
		String password = scanner.nextLine();
		
		//while(true) {
			try {
				login(joinUsers, new User(id, password));
			} catch (UserNotFoundException | PasswordDismatchException e) {
				e.printStackTrace();
			}
		//}

		if(scanner != null)
			scanner.close();
	}
	
	public static void login(List<User> users, User user ) throws UserNotFoundException, PasswordDismatchException {
		if( !users.contains(user) ){
			System.out.println(
								new UserNotFoundException().getMessage()
							  );
			//throw new UserNotFoundException();
		}
		
		User savedUser = users.get( users.indexOf( user ) );
		
		if( !savedUser.getPassword().equals( user.getPassword()) ){
			System.out.println(
								new PasswordDismatchException().getMessage()
							  );
			//throw new PasswordDismatchException();
		}
	}
}
