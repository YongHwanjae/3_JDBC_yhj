package Member;

public class Member {
	
	private int memberNumber;
	private String memberName;
	private String memberGender;
	private int age;
	private String address;
	private String phoneNumber;
	private String email;
	private String grade;
	private String enrolldate;
	private String memberPw;

public Member() {}


public Member(int memberNumber, String memberName, String memberGender, int age, String address, String phoneNumber,
		String email, String grade, String enrolldate, String memberPw) {
	super();
	this.memberNumber = memberNumber;
	this.memberName = memberName;
	this.memberGender = memberGender;
	this.age = age;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.grade = grade;
	this.enrolldate = enrolldate;
	this.memberPw = memberPw;
}


public int getMemberNumber() {
	return memberNumber;
}


public void setMemberNumber(int memberNumber) {
	this.memberNumber = memberNumber;
}


public String getMemberName() {
	return memberName;
}


public void setMemberName(String memberName) {
	this.memberName = memberName;
}


public String getMemberGender() {
	return memberGender;
}


public void setMemberGender(String memberGender) {
	this.memberGender = memberGender;
}


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getPhoneNumber() {
	return phoneNumber;
}


public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getGrade() {
	return grade;
}


public void setGrade(String grade) {
	this.grade = grade;
}


public String getEnrolldate() {
	return enrolldate;
}


public void setEnrolldate(String enrolldate) {
	this.enrolldate = enrolldate;
}

public String getMemberPw() {
	return memberPw;
}

public void setMemberPw(String memberPw) {
	this.memberPw = memberPw;
}











}


