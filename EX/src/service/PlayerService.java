package service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import Member.Player;
import dao.PlayerDAO;

public class PlayerService {

	PlayerDAO dao = new PlayerDAO();
	
	
	
	/** 선수 로그인
	 * @param playerNo
	 * @param password
	 * @return loginPlayer
	 * @throws Exception
	 */
	public Player login(int playerNo, String password) throws Exception{
		
		Connection conn = getConnection();
		
		Player loginPlayer = dao.login(conn, playerNo, password);
		
		close(conn);
		
		return loginPlayer;
	}


	
	/** 선수 등록
	 * @param player
	 * @return result
	 * @throws Exception
	 */
	public int enroll(Player player) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.enroll(conn, player);
		
		if(result > 0 ) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 타자 성적 추가
	 * @param player
	 * @throws exception
	 * @return result
	 */
	public int insertHitter(Player player) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.insertHitter(conn, player);
		
		if(result > 0) commit(conn);
		else          rollback(conn);
		close(conn);
		return result;
	}



	/** 타자 성적 조회
	 * @param playerNo
	 * @return player
	 * @throws Exception
	 */
	public Player selectHitter(int playerNo) throws Exception{
		Player player = new Player();
		
		Connection conn = getConnection();
		
		player = dao.selectHitter(conn, playerNo);
		
		close(conn);
		return player;
	}



	/** 투수 성적 추가
	 * @param player
	 * @return result
	 * @throws Exception
	 */
	public int insertPitcher(Player player) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.insertPitcher(conn, player);
		
		if(result >0) commit(conn);
		else          rollback(conn);
		
		close(conn);
		return result;
	}



	/** 투수 성적 조회
	 * @param playerNo
	 * @return player
	 * @throws Exception
	 */
	public Player selectPitcher(int playerNo) throws Exception{
		
		Connection conn = getConnection();
		
		Player player = dao.selectPitcher(conn, playerNo);
		
		close(conn);
		
		return player;
	}



	/** 연봉 변경 서비스
	 * @param player
	 * @return result
	 * @throws Exception
	 */
	public int updateSalary(Player player) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updateSalary(conn, player);
		
		if(result >0) commit(conn);
		else        rollback(conn);
		
		close(conn);
		return result;
	}



	/** 팀 변경 서비스
	 * @param player
	 * @return result
	 * @throws Exception
	 */
	public int updateTeam(Player player) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.updateTeam(conn, player);
		
		if(result > 0) commit(conn);
		else         rollback(conn);
		
		close(conn);
		
		return result;
	}



	
	}



	
	



	
	



	


