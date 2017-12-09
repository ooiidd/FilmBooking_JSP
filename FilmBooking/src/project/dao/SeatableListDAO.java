package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project.beans.MovieSeatBeans;

public class SeatableListDAO {
	private SeatableListDAO() {}
	private static SeatableListDAO instance = new SeatableListDAO();
	public static SeatableListDAO getInstance() {
		return instance;
	}
	public List<MovieSeatBeans> getSeatsList(int film_id){
		List<MovieSeatBeans> seats = new ArrayList<MovieSeatBeans>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from seat natural join seatable where id_film=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, film_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieSeatBeans seat = new MovieSeatBeans();
				seat.setId_seat(rs.getInt("id_seat"));
				seat.setId_film(rs.getInt("id_film"));
				seat.setNum(rs.getInt("num"));
				seat.setPossible(rs.getInt("possible"));
				
				seats.add(seat);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return seats;
	}
}
