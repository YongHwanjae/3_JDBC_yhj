package service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import Member.Player;
import dao.PlayerDAO;

public class PlayerService {

	PlayerDAO dao = new PlayerDAO();
	
	
	
	public Player login(int playerNo, String password) throws Exception{
		
		Connection conn = getConnection();
		
		Player loginPlayer = dao.login(conn, playerNo, password);
		
		close(conn);
		
		return loginPlayer;
	}

	public int dup(int playerNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.dup(conn, playerNo);
		
		if(result >0) commit(conn);
		else         rollback(conn);
		
		close(conn);
		return result;
		}

	public int enroll(Player player) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.enroll(conn, player);
		
		if(result > 0 ) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		return result;
	}



	

}
