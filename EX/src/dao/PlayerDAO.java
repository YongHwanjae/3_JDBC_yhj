package dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import Member.Player;

public class PlayerDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public PlayerDAO() {
	  try {
		prop = new Properties();
		prop.loadFromXML(new FileInputStream("player-query.xml"));
	  } catch(Exception e) {
		  e.printStackTrace();
	  }
		
	}
	
	
	/** 선수 로그인
	 * @param conn
	 * @param player
	 * @return loginPlayer
	 * @throws Exception
	 */
	public Player login(Connection conn, Player player) throws Exception{
		
		Player loginPlayer = null;
		
		try {
			String sql = prop.getProperty("loginPlayer");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, player.getPlayerNo());
			pstmt.setString(2, player.getPassword());
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				
				loginPlayer = new Player();
				loginPlayer.setPlayerNo(player.getPlayerNo()); 
				loginPlayer.setPlayerName(rs.getString("PLAYER_NM"));
				loginPlayer.setSalary(rs.getInt("PLAYER_SALARY"));
				loginPlayer.setEnroll(rs.getInt("PLAYER_ENROLL"));
				loginPlayer.setTeam(rs.getString("PLAYER_TEAM"));
				loginPlayer.setPassword(player.getPassword());
				loginPlayer.setDivision(rs.getString("PLAYER_DIV"));
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		
		return loginPlayer;
	}


	/** 선수 등록
	 * @param conn
	 * @param player
	 * @return result
	 * @throws Exception
	 */
	public int enroll(Connection conn, Player player) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("enroll");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, player.getPlayerNo());
			pstmt.setString(2, player.getPlayerName());
			pstmt.setInt(3, player.getSalary());
			pstmt.setString(4, player.getPassword());
			pstmt.setString(5, player.getDivision());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}



	/** 타자 성적 등록
	 * @param conn
	 * @param player
	 * @return result
	 * @throws Exception
	 */
	public int insertHitter(Connection conn, Player player) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("insertHitter");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, player.getPlayerNo());
			pstmt.setInt(2, player.getTimeAtBat());
			pstmt.setInt(3, player.getHit());
			pstmt.setInt(4, player.getHomerun());
			

			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/** 타자 성적 추가
	 * @param conn
	 * @param player
	 * @return result
	 * @throws Exception
	 */
	public int updateHitter(Connection conn, Player player) throws Exception {
		
		int result =  0;
		
		try {
			String sql = prop.getProperty("updateHitter");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, player.getTimeAtBat());
			pstmt.setInt(2, player.getHit());
			pstmt.setInt(3, player.getHomerun());
			pstmt.setInt(4, player.getPlayerNo());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	
	

	/** 타자 성적조회
	 * @param conn
	 * @param playerNo
	 * @return player
	 * @throws Exception
	 */
	public Player selectHitter(Connection conn, int playerNo) throws Exception{
		Player player = null;
		
		try {
			String sql = prop.getProperty("selectHitter");
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setInt(1, playerNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				player = new Player();
				player.setPlayerNo(playerNo);
				player.setTimeAtBat(rs.getInt("PLAYER_AB"));
				player.setHit(rs.getInt("PLAYER_HIT"));
				player.setHomerun(rs.getInt("PLAYER_HOME"));
				player.setAvgBat(rs.getDouble(5));
				
			}
					
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return player;
	}


	/** 투수 성적 입력
	 * @param conn
	 * @param player
	 * @return result
	 * @throws Exception
	 */
	public int insertPitcher(Connection conn, Player player) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertPitcher");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, player.getPlayerNo());
			pstmt.setInt(2, player.getVictory());
			pstmt.setInt(3, player.getLose());
			pstmt.setDouble(4, player.getInning());
			pstmt.setInt(5, player.getEr());
			

			result = pstmt.executeUpdate();
			
		} finally {
		
			close(pstmt);
			
		}
		
		
		return result;
	}
	

	public int updatePitcher(Connection conn, Player player) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updatePitcher");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, player.getVictory());
			pstmt.setInt(2, player.getLose());
			pstmt.setDouble(3, player.getInning());
			pstmt.setInt(4, player.getEr());
			pstmt.setInt(5, player.getPlayerNo());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
			return result;
	}



	/** 투수 성적 조회
	 * @param conn
	 * @param playerNo
	 * @return player
	 * @throws Exception
	 */
	public Player selectPitcher(Connection conn, int playerNo) throws Exception{
		
		Player player = null;
		try {
			String sql = prop.getProperty("selectPitcher");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, playerNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				player = new Player();
				player.setPlayerNo(playerNo);
				player.setVictory(rs.getInt("PLAYE_VIC"));
				player.setLose(rs.getInt("PLA_LOSE"));
				player.setInning(rs.getDouble("PLY_INN"));
				player.setEr(rs.getInt("PLA_ER"));
				player.setEra(rs.getDouble(6));
			}
			
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return player;
	}


	/** 연봉변경 DAO
	 * @param conn
	 * @param player
	 * @return result
	 * @throws Exception
	 */
	public int updateSalary(Connection conn, Player player) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateSalary");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, player.getSalary());
			pstmt.setInt(2, player.getPlayerNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}


	/** 팀 변경 DAO
	 * @param conn
	 * @param player
	 * @return result
	 * @throws Exception
	 */
	public int updateTeam(Connection conn, Player player) throws Exception{

		int result = 0;
		
		try {
			String sql = prop.getProperty("updateTeam");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, player.getTeam());
			pstmt.setInt(2, player.getPlayerNo());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 투수 전체 조회 DAO
	 * @param conn
	 * @return playerList
	 * @throws Exception
	 */
	public List<Player> selectPitcherAll(Connection conn) throws Exception {
		
		List<Player> playerList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectPitcherAll");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int playerNo = rs.getInt("PLAYER_NO");
				String playerName = rs.getString("PLAYER_NM");
				int victory = rs.getInt("PLAYE_VIC");
				int lose = rs.getInt("PLA_LOSE");
				double inning = rs.getDouble("PLY_INN");
				double era = rs.getDouble(6);
				
				Player player = new Player();
				player.setPlayerNo(playerNo);
				player.setPlayerName(playerName);
				player.setVictory(victory);
				player.setLose(lose);
				player.setInning(inning);
				player.setEra(era);
				
				playerList.add(player);
			}
			
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return playerList;
	}


	/** 타자 전체 조회 DAO
	 * @param conn
	 * @return playerList
	 * @throws Exception
	 */
	public List<Player> selectHitterAll(Connection conn) throws Exception{
		
		List<Player> playerList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectHitterAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int playerNo = rs.getInt("PLAYER_NO");
				String playerName = rs.getString("PLAYER_NM");
				int timeAtBat = rs.getInt("PLAYER_AB");
				int hit = rs.getInt("PLAYER_HIT");
				int homerun = rs.getInt("PLAYER_HOME");
				double avg = rs.getDouble(6);
				
				Player player = new Player();
				player.setPlayerNo(playerNo);
				player.setPlayerName(playerName);
				player.setTimeAtBat(timeAtBat);
				player.setHit(hit);
				player.setHomerun(homerun);
				player.setAvgBat(avg);
				
				playerList.add(player);		
			
			}
			
		} finally {
			close(rs);
			close(stmt);
			
		}
		
		return playerList;
	}


	public int numberDupCheck(Connection conn, int playerNo) throws Exception {
		
		int result = 0;
		
		try {
		 String sql = prop.getProperty("numberDupCheck");
		 
		 pstmt = conn.prepareStatement(sql);
		 
		 pstmt.setInt(1, playerNo);
		 
		 rs = pstmt.executeQuery();
		 
		 if(rs.next()) {
			 result = rs.getInt(1);
		 }
		 
		 
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}


	public List<Player> selectPlayerAll(Connection conn) throws Exception{
	
		List<Player> playerList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectPlayerAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int playerNo = rs.getInt("PLAYER_NO");
				String playerName = rs.getString("PLAYER_NM");
				int salary = rs.getInt("PLAYER_SALARY");
				int enroll = rs.getInt("PLAYER_ENROLL");
				String division = rs.getString("PLAYER_DIV");
				
			
				Player player = new Player();
				player.setPlayerNo(playerNo);
				player.setPlayerName(playerName);
				player.setSalary(salary);
				player.setEnroll(enroll);
				player.setDivision(division);
				
				
				playerList.add(player);
				
			}
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return playerList;
	}


	





	
}
