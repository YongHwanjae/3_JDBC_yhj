package Member;

public class Player {

	private int playerNo;
	private String playerName;
	private int salary;
	private int enroll;
	private String team;
	private String password;

	private int batAtTime;
	private int hit;
	private int homerun;
	private double avgBat;
	
	private int victory;
	private int lose;
	private double inning;
	private int er;
	private double era;
	
	public Player() {}

	public Player(int playerNo, String playerName, int salary, int enroll, String team, String password,
			int batAtTime, int hit, int homerun, double avgBat, int victory, int lose, double inning, int er,
			double era) {
		super();
		this.playerNo = playerNo;
		this.playerName = playerName;
		this.salary = salary;
		this.enroll = enroll;
		this.team = team;
		this.password = password;
		this.batAtTime = batAtTime;
		this.hit = hit;
		this.homerun = homerun;
		this.avgBat = avgBat;
		this.victory = victory;
		this.lose = lose;
		this.inning = inning;
		this.er = er;
		this.era = era;
	}

	public Player(int playerNo, String playerName, int salary, String password) {
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

	public int getBatAtTime() {
		return batAtTime;
	}

	public void setBatAtTime(int batAtTime) {
		this.batAtTime = batAtTime;
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



