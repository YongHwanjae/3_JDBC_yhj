package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import Member.Player;
import service.PlayerService;

public class PlayerView {
		
	
	PlayerService service = new PlayerService();
	
	Scanner sc = new Scanner(System.in);

	private Player loginPlayer;
	
	public void mainMenu() {
		
		
		int input = -1;
		
		do {
			try {
				if(loginPlayer == null) {
						
					
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
					} 
					else {
					
						System.out.println("-------------------------------------------");
						System.out.println(loginPlayer.getPlayerName() + "님 환영합니다!");
						System.out.println();
						System.out.println("선수 유형을 선택해주세요");
						System.out.println("1. 타자");
						System.out.println("2. 투수");
						System.out.println("3. 관리자");
						System.out.print("번호 입력 : ");
						int num = sc.nextInt();
						
						if(num == 1) {
							System.out.println("1. 경기 결과 입력");
							System.out.println("2. 성적 조회");
							System.out.println("3. 돌아가기");
							System.out.print("번호 입력 : ");
							int num1 = sc.nextInt();
							
							switch(num1) {
							case 1 : //insertHitter(); break;
							case 2 : //selectHitter(); break;
							case 3 : break;
							}
							
							
						} else if(num == 2) {
							System.out.println("1. 경기 결과 입력");
							System.out.println("2. 성적 조회");
							System.out.println("3. 돌아가기");
							System.out.println("메뉴 입력 : ");
							int num2 = sc.nextInt();
							
							switch(num2) {
							case 1 : break;
							case 2 : break;
							case 3 : break;
							}
							
							
						} else if(num == 3) {
							System.out.println("1. 연봉 변경");
							System.out.println("2. 소속 변경");
							System.out.println("3. 돌아가기");
							System.out.print("메뉴 입력 : ");
							int num3 = sc.nextInt();
							
							switch(num3) {
							case 1 : break;
							case 2 : break;
							case 3 : break;
							}
							
							
						} else {
							System.out.println("잘못 입력하셨습니다.");
						}
					
				
				
				
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
		String password = sc.next().toUpperCase();
		
		try {
			loginPlayer = service.login(playerNo, password);
			
			if(loginPlayer != null) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패");
			}
			
		} catch(Exception e) {
			System.out.println("로그인 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
	
	private void enrollService() {
		System.out.println("<< 선수 등록 페이지 >>");
		
	
		try {	
		 int playerNo = 0;
				
				while(true) {
				
				System.out.print("번호 입력 : ");
				playerNo = sc.nextInt();
				
				int result = service.dup(playerNo);
				
				if(result == 0) {
					System.out.println("번호를 등록할 수 있습니다.");
					break;
				} else {
					System.out.println("번호가 중복입니다. 다른 번호를 선택해주세요.");
				}
				}
			
				System.out.print("이름 입력 : ");
				String playerName = sc.next();
			
				
				System.out.print("연봉 입력 : ");
				int salary = sc.nextInt();
				
				System.out.print("비밀번호 입력 : ");
				String password = sc.next();
				
			
				Player player = new Player(playerNo, playerName, salary, password);
				
				int result = service.enroll(player);
				
				if(result > 0) {
					System.out.println("등록 성공");
				} else {
					System.out.println("등록 실패");
				}
			} catch(Exception e) {
				System.out.println("예외 발생");
				e.printStackTrace();
		}
	}
	
	
}
