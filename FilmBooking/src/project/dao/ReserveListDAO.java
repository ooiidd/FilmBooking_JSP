package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import project.beans.MovieReservationBeans;


public class ReserveListDAO {
	private ReserveListDAO() {}
	private static ReserveListDAO instance = new ReserveListDAO();
	public static ReserveListDAO getInstance() {
		return instance;
	}
	public void updateReserve(int id_resv) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement("update reservation set status='ok' where id_resv=?");
			pstmt.setInt(1, id_resv);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void removeReserve(int id_resv) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement("delete from reservation where id_resv=?");
			pstmt2 = conn.prepareStatement("select num,id_seat from seat natural join seatable"
					+ " natural join reservation where id_resv=?");
			pstmt3 = conn.prepareStatement("update seatable set possible=1 where id_seat=? and num=?");
			
			pstmt.setInt(1, id_resv);
			pstmt2.setInt(1, id_resv);
			rs = pstmt2.executeQuery();

			while(rs.next()) {
				pstmt3.setInt(1, rs.getInt("id_seat"));
				pstmt3.setInt(2, rs.getInt("num"));
				pstmt3.executeUpdate();
			}
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt,pstmt2,pstmt3,rs);
		}
	}
	public List<MovieReservationBeans> getReserveList(String id){
		List<MovieReservationBeans> reserves = new ArrayList<MovieReservationBeans>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select * from reservation where id_mem=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieReservationBeans reserve = new MovieReservationBeans();
				reserve.setFilm_name(rs.getString("film_name"));
				reserve.setId_resv(rs.getInt("id_resv"));
				reserve.setId_mem(rs.getString("id_mem"));
				reserve.setId_film(rs.getInt("id_film"));
				reserve.setResv_date(rs.getDate("resv_date"));
				reserve.setDate(rs.getDate("date"));
				reserve.setEnddate(rs.getDate("enddate"));
				reserve.setNum(rs.getInt("num"));
				reserve.setStatus(rs.getString("status"));
				reserves.add(reserve);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt , rs);
		}
		return reserves;
	}
	public void setReserve(String id,int id_seat,int num){
		List<MovieReservationBeans> seats = new ArrayList<MovieReservationBeans>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String sql = "select id_seat,id_film,film_name,date,enddate,num " + 
				"from seat natural join seatable natural join movies " + 
				"where seatable.num=? and id_seat=?;";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement("insert into reservation values(default,?,?,?,?,?,default,?,?)");
			pstmt3 = conn.prepareStatement("update seatable set possible=0 where id_seat=? and num=?");
			pstmt.setInt(1, num);
			pstmt.setInt(2,id_seat);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pstmt2.setString(1, id);//id
				pstmt2.setInt(2, rs.getInt("id_film"));
				pstmt2.setString(3, rs.getString("film_name"));
				pstmt2.setDate(4, rs.getDate("date"));
				pstmt2.setDate(5, rs.getDate("enddate"));
				pstmt2.setInt(6, num);
				pstmt2.setString(7, "-");
				
				pstmt3.setInt(1, rs.getInt("id_seat"));
				pstmt3.setInt(2, rs.getInt("num"));
				
				pstmt3.executeUpdate();
				pstmt2.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt,pstmt2,pstmt3, rs);
		}
	}
}
