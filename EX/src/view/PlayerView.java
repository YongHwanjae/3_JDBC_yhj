package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import Member.Player;
import service.PlayerService;

public class PlayerView {
		
	
	PlayerService service = new PlayerService();
	
	Scanner sc = new Scanner(System.in);

	public static Player loginPlayer;
	
	public void mainMenu() {
		
		
		int input = -1;
		
		do {
			try {
				System.out.println("------------------------------------------");
				System.out.println("1. 로그인");
				System.out.println("2. 선수 등록");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				
				case 1 : loginService(); break;
				case 2 : enrollService(); break;
				case 0 : System.out.println("종료"); break;
				default : System.out.println("위에 보이는 숫자만 입력하세요");
				}
				
				
				
			} catch(InputMismatchException e) {
				System.out.println("입력 형식이 올바르지 않습니다. ");
				e.printStackTrace();
			}
			
			
		} while(input !=0);
	}

	
	private void loginService() {
		System.out.println("[로그인]");
		
		System.out.print("번호 입력 : ");
		int playerNo = sc.nextInt();
		
		System.out.print("비밀번호 입력 : ");
		String password = sc.next();
		
		try {
			loginPlayer = service.login(playerNo, password);
			
		} catch(Exception e) {
			System.out.println("로그인 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
	
	private void enrollService() {
		
	}
	
	
}
