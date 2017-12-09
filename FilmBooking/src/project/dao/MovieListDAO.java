package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.beans.MovieListBeans;

public class MovieListDAO {
	private MovieListDAO() {}
	private static MovieListDAO instance = new MovieListDAO();
	public static MovieListDAO getInstance() {
		return instance;
	}
	public MovieListBeans selectMovie(int id_film) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MovieListBeans movie = new MovieListBeans();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select * from movies where id_film=?");
			pstmt.setInt(1, id_film);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				movie.setAge_phase(rs.getInt("age_phase"));
				movie.setDate(rs.getDate("date"));
				movie.setEnddate(rs.getDate("enddate"));
				movie.setId_film(rs.getInt("id_film"));
				movie.setFilm_name(rs.getString("film_name"));
				movie.setSeat_num(rs.getInt("seat_num"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt, rs);
		}
		return movie;
	}
	public void insertSeatable(int id_seat,int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("insert into seatable values(?,?,?)");
			pstmt.setInt(1, id_seat);
			pstmt.setInt(3, 1);
			for(int i=1;i<=num;i++) {
				pstmt.setInt(2, i);
				pstmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt );
		}
	}
	public void insertSeat(int id_film,int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int id_seat;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("insert into seat values(default,?)");
			pstmt.setInt(1, id_film);
			pstmt.executeUpdate();
			pstmt2 = conn.prepareStatement("select id_seat from seat where id_film=?");
			pstmt2.setInt(1, id_film);
			rs = pstmt2.executeQuery();
			if(rs.next()) {
				id_seat = rs.getInt("id_seat");
				insertSeatable(id_seat,num);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt,pstmt2,rs);
		}
	}
	public void insertMovie(String title,int age,int seat,Date date, Date enddate) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int id_film;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("insert into movies values(default,?,?,?,?,?)");
			pstmt.setString(1, title);
			pstmt.setInt(2, age);
			pstmt.setInt(3, seat);
			pstmt.setDate(4, date);
			pstmt.setDate(5, enddate);
			pstmt.executeUpdate();
			pstmt2 = conn.prepareStatement("select id_film from movies where film_name=? and age_phase=?"
					+ " and seat_num=? and date=? and enddate=?");
			pstmt2.setString(1, title);
			pstmt2.setInt(2, age);
			pstmt2.setInt(3, seat);
			pstmt2.setDate(4, date);
			pstmt2.setDate(5, enddate);
			rs=pstmt2.executeQuery();
			if(rs.next()) {
				id_film = rs.getInt("id_film");
				insertSeat(id_film,seat);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt,pstmt2,rs);
		}
	}
	public void removeMovie(int id_film) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("delete from movies where id_film=?");
			pstmt.setInt(1, id_film);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt);
		}
	}
	public List<MovieListBeans> getMovieList(){
		List<MovieListBeans> movies = new ArrayList<MovieListBeans>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from movies";
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MovieListBeans movie = new MovieListBeans();
				movie.setAge_phase(rs.getInt("age_phase"));
				movie.setDate(rs.getDate("date"));
				movie.setEnddate(rs.getDate("enddate"));
				movie.setId_film(rs.getInt("id_film"));
				movie.setFilm_name(rs.getString("film_name"));
				movie.setSeat_num(rs.getInt("seat_num"));
				movies.add(movie);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return movies;
	}
}
