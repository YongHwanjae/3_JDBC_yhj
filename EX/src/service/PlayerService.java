package service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import Member.Player;
import dao.PlayerDAO;

public class PlayerService {

	PlayerDAO dao = new PlayerDAO();
	
	
	
	public Player login(int playerNo, String password) {
		
		Connection conn = getConnection();
		
		
		
		
		return ;
	}

}
