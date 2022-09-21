package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import Member.Member;
import service.Service;

public class View {

	private Scanner sc = new Scanner(System.in);
	
	private Member loginMember;
	
	Service service = new Service();

	
	public void Menu() {
		
	int input = -1;
	
	do {
		if(loginMember== null) {
		try {
			System.out.println("============================================================================");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("0. 종료");
			
			System.out.println("\n 메뉴 선택 : ");
			input = sc.nextInt();
			sc.nextLine(); 
			
			System.out.println();
			
			switch(input){
			case 1: login(); break;
			case 2: join(); break;
			case 0: System.out.println("종료"); break;
			default: System.out.println("보이는 숫자만 입력");
			}
			
			
			
			
		} catch(InputMismatchException e) {
			System.out.println("잘못눌렀어");
		}
	
		
	
	}else {
		System.out.println("==============================================================================");
		System.out.println("1. 주소 수정");
		System.out.println("2. 번호 수정");
		System.out.println("3. 메일 수정");
		System.out.println("4. 회원 탈퇴");
	}
	
	}	 while(input !=0);
	
	}
	private void login() {
		System.out.print("회원번호 입력 : ");
		int memberNumber = sc.nextInt();
		
		
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		
		loginMember= service.login(memberNumber, memberPw);
		
		
		
	}
	
	private void join() {
		
	}
	
}
