package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
					
						System.out.println("\n-------------------------------------------\n");
						System.out.println(loginPlayer.getPlayerName() + "님 환영합니다!");
						System.out.println();
						System.out.println("선수 유형을 선택해주세요");
						System.out.println("1. 타자");
						System.out.println("2. 투수");
						System.out.println("3. 관리자");
						System.out.println("0. 로그아웃");
						System.out.print("번호 입력 : ");
						int num = sc.nextInt();
						
						if(num == 1 && loginPlayer.getDivision().equals("HIT")) {
							System.out.println("1. 경기 결과 입력");
							System.out.println("2. 개인 성적 조회");
							System.out.println("3. 돌아가기");
							System.out.print("번호 입력 : ");
							int num1 = sc.nextInt();
							
							switch(num1) {
							case 1 : insertHitter(); break;
							case 2 : selectHitter(); break;
							case 3 : break;
							}
							
							
						} else if(num == 2 && loginPlayer.getDivision().equals("PIT")) {
							System.out.println("1. 경기 결과 입력");
							System.out.println("2. 개인 성적 조회");
							System.out.println("3. 돌아가기");
							System.out.print("메뉴 입력 : ");
							int num2 = sc.nextInt();
							
							switch(num2) {
							case 1 : insertPitcher(); break;
							case 2 : selectPitcher(); break;
							case 3 : break;
							}
							
							
						} else if(num == 3) {
							System.out.println("1. 연봉 변경");
							System.out.println("2. 소속 변경");
							System.out.println("3. 투수 전체 성적 조회");
							System.out.println("4. 타자 전체 성적 조회");
							System.out.println("0. 돌아가기");
							System.out.print("메뉴 입력 : ");
							int num3 = sc.nextInt();
							
							switch(num3) {
							case 1 : updateSalary(); break;
							case 2 : updateTeam(); break;
//							case 3 : selectPitcherAll(); break;
//							case 4 : selectHitterAll(); break;
							
							}
							
							
						} else if (num == 0) {
							loginPlayer = null;
						} else {
							System.out.println("잘못 입력하셨습니다.");
						}
					
				
			}
				} catch(InputMismatchException e) {
				System.out.println("입력 형식이 올바르지 않습니다. ");
				e.printStackTrace();
				sc.nextLine();
			}
			
			
		} while(input !=0);
	}

	
	/**
	 * 로그인
	 */
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
	
	
	/**
	 * 선수 등록
	 */
	private void enrollService() {
		System.out.println("<< 선수 등록 페이지 >>");
		
	
		try {	
				System.out.print("번호 입력 : ");
				int playerNo = sc.nextInt();
				
			
				System.out.print("이름 입력 : ");
				String playerName = sc.next();
			
				
				System.out.print("연봉 입력 : ");
				int salary = sc.nextInt();
				
				System.out.print("비밀번호 입력 : ");
				String password = sc.next();
				
				System.out.print("투수(PIT) / 타자(HIT) 입력 : ");
				String division = sc.next().toUpperCase();
			
				Player player = new Player();
				player.setPlayerNo(playerNo);
				player.setPlayerName(playerName);
				player.setSalary(salary);
				player.setPassword(password);
				player.setDivision(division);
				
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
	
	/**
	 * 타자 성적 추가
	 */
	private void insertHitter() {
		try {
			System.out.println("======================================");
			System.out.print("1. 타수 입력 : ");
			int ab = sc.nextInt();
			
			System.out.print("2. 안타 입력 : ");
			int hit = sc.nextInt();
			
			System.out.print("3. 홈런 입력 : ");
			int hr = sc.nextInt();
			
			Player player = new Player();
			player.setPlayerNo(loginPlayer.getPlayerNo());
			player.setTimeAtBat(ab);
			player.setHit(hit);
			player.setHomerun(hr);
			
				
			
			int result = service.insertHitter(player);
			
			if(result >0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			
			
		} catch(Exception e) {
			System.out.println("예외");
			e.printStackTrace();
		}
	}	
	
	/**
	 * 타자 조회
	 */
	private void selectHitter() {
		
		try {
		
			System.out.println("-------------------------------");
			System.out.println("시즌 경기 결과 출력");
			System.out.println();
			
			Player player = service.selectHitter(loginPlayer.getPlayerNo());
			
			if(player == null) {
				System.out.println("조회 결과가 없습니다.");
			} else {
			System.out.println("번호 | 타수 | 안타 | 홈런 | 타율");
			System.out.printf(" %d | %d | %d | %d | %f |",  
					           player.getPlayerNo(),   
				               player.getTimeAtBat(),
				               player.getHit(),
				               player.getHomerun(),
				               player.getAvgBat());}
					
		} catch(Exception e) {
			System.out.println("예외");
			e.printStackTrace();
		}
		
	}
		
	
	/**
	 * 투수 결과 추가
	 */
	private void insertPitcher() {
		
		try {
		
			System.out.println("----------------------------------");
			System.out.print("1. 승리 추가 : ");
			int victory = sc.nextInt();
			
			System.out.print("2. 패배 추가 : ");
			int lose = sc.nextInt();
			
			System.out.println("0.1이닝은 0.33/ 0.2 이닝은 0.67/");
			System.out.print("3. 이닝 추가 : ");
			double inning = sc.nextInt();
			
			System.out.print("4. 실점 추가 : ");
			int er = sc.nextInt();
			
			Player player = new Player();
			player.setPlayerNo(loginPlayer.getPlayerNo());
			player.setVictory(victory);
			player.setLose(lose);
			player.setInning(inning);
			player.setEr(er);
			
			int result = service.insertPitcher(player);
			
			if(result > 0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
		} catch(Exception e) {
			System.out.println("예외");
			e.printStackTrace();
		}
		
		
		
	}
		
	
	/**
	 * 투수 성적 조회
	 */
	private void selectPitcher() {
		try {
			System.out.println("[투수 개인 성적 조회]");
			
			Player player = new Player();
			player.setPlayerNo(loginPlayer.getPlayerNo());
			
			player = service.selectPitcher(player.getPlayerNo());
			
			if(player == null) {
				System.out.println("조회 결과가 없습니다.");
			} else {
				System.out.println("| 번호 | 승리 | 패배 |    이닝    | 방어율 |");
				System.out.printf("| %d  | %d  | %d | %f | %f |", 
									player.getPlayerNo(),
									player.getVictory(),
									player.getLose(),
									player.getInning(),
									player.getEra());
			}
			
		}catch(Exception e) {
			System.out.println("예외");
			e.printStackTrace();
		}
		
		
	}
		
		
	
	/**
	 * 연봉 변경
	 */
	private void updateSalary() {
		try {	
			System.out.println("[연봉 변경]");
			System.out.print("연봉을 바꿀 선수의 번호를 입력하세요 : ");
			int playerNo = sc.nextInt();
			
			System.out.print("변경할 연봉을 입력해주세요 : ");
			int salary = sc.nextInt();
			
			Player player = new Player();
			player.setPlayerNo(playerNo);
			player.setSalary(salary);
			
			int result = service.updateSalary(player);
			
			if(result > 0) {
				System.out.println("변경 성공");
			} else {
				System.out.println("변경 실패");
			}
				
		} catch(Exception e) {
			System.out.println("예외");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 팀 변경
	 */
	private void updateTeam() {
		try {
			System.out.println("[소속 팀 변경]");
			System.out.print("팀을 변경할 선수의 번호를 입력해주세요 : ");
			int playerNo = sc.nextInt();
			
			System.out.print("이적할 팀을 입력해주세요 : ");
			String team = sc.next();
			
			Player player = new Player();
			player.setPlayerNo(playerNo);
			player.setTeam(team);
			
			int result = service.updateTeam(player);
			
			
			if(result > 0) {
				System.out.println("변경 성공");
			} else {
				System.out.println("변경 실패");
			} 
		} catch(Exception e) {
			System.out.println("예외");
			e.printStackTrace();
		}
	}
}
