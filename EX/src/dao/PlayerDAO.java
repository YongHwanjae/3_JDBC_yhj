package dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
	
	
	public Player login(Connection conn, int playerNo, String password) throws Exception{
		
		Player loginPlayer = null;
		
		try {
			String sql = prop.getProperty("loginPlayer");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, playerNo);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				
				loginPlayer = new Player();
				loginPlayer.setPlayerNo(playerNo); 
				loginPlayer.setPlayerName(rs.getString("PLAYER_NM"));
				loginPlayer.setSalary(rs.getInt("PLAYER_SALARY"));
				loginPlayer.setEnroll(rs.getInt("PLAYER_ENROLL"));
				loginPlayer.setTeam(rs.getString("PLAYER_TEAM"));
				loginPlayer.setPassword(password);
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		
		return loginPlayer;
	}


	public int enroll(Connection conn, Player player) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("enroll");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, player.getPlayerNo());
			pstmt.setString(2, player.getPlayerName());
			pstmt.setInt(3, player.getSalary());
			pstmt.setString(4, player.getPassword());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}


	public int dup(Connection conn, int playerNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("dup");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, playerNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
