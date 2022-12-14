package Member;

public class Player {

	private int playerNo;         // 번호
	private String playerName;	  // 이름
	private int salary;			  // 연봉
	private int enroll;			  // 입단년도
	private String team;		  // 팀
	private String password;	  // 비밀번호
	private String division; 	  // 구분

	private int TimeAtBat;		  // 타수
	private int hit;			  // 안타
	private int homerun;		  // 홈런
	private double avgBat;		  // 타율 hit/ba
	
	private int victory;		  // 승리
	private int lose;			  // 패배
	private double inning;		  // 이닝
	private int er;               // 실점
	private double era;			  // 방어율 (er x 9 ) / inning
	
	public Player() {}

	public Player(int playerNo, String playerName, int salary, int enroll, String team, String password,
			int TimeAtBat, int hit, int homerun, double avgBat, int victory, int lose, double inning, int er,
			double era, String division) {
		super();
		this.playerNo = playerNo;
		this.playerName = playerName;
		this.salary = salary;
		this.enroll = enroll;
		this.team = team;
		this.password = password;
		this.TimeAtBat = TimeAtBat;
		this.hit = hit;
		this.homerun = homerun;
		this.avgBat = avgBat;
		this.victory = victory;
		this.lose = lose;
		this.inning = inning;
		this.er = er;
		this.era = era;
		this.division = division;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Player(int playerNo, String playerName, int salary, String password) {
	}


	public Player(int playerNo, int ba, int hit, int hr) {
	}

	public Player(int playerNo2, String string, int int1, int int2, String string2, String password2, String string3) {
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getEnroll() {
		return enroll;
	}

	public void setEnroll(int enroll) {
		this.enroll = enroll;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTimeAtBat() {
		return TimeAtBat;
	}

	public void setTimeAtBat(int TimeAtBat) {
		this.TimeAtBat = TimeAtBat;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getHomerun() {
		return homerun;
	}

	public void setHomerun(int homerun) {
		this.homerun = homerun;
	}

	public double getAvgBat() {
		return avgBat;
	}

	public void setAvgBat(double avgBat) {
		this.avgBat = avgBat;
	}

	public int getVictory() {
		return victory;
	}

	public void setVictory(int victory) {
		this.victory = victory;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getInning() {
		return inning;
	}

	public void setInning(double inning) {
		this.inning = inning;
	}

	public int getEr() {
		return er;
	}

	public void setEr(int er) {
		this.er = er;
	}

	public double getEra() {
		return era;
	}

	public void setEra(double era) {
		this.era = era;
	}
	
	
	
	
	
	
	
	
}



