package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.beans.MemberBeans;

public class MemberListDAO {
	private MemberListDAO() {}
	private static MemberListDAO instance = new MemberListDAO();
	public static MemberListDAO getInstance() {
		return instance;
	}
	public void updateMember(String id,String password,int age_mem) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("update member set password=?,age_mem=? where id_mem=?");
			pstmt.setString(1, password);
			pstmt.setInt(2, age_mem);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void removeMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("delete from member where id_mem=?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	public void setMember(String id,String pwd,int age) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("insert into member values(?,?,'no',?,default)");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setInt(3, age);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	public int confirmID(String userid) {
		int result=-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select id_mem from member where id_mem=?");
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}else {
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
		
	}
	public List<MemberBeans> getMemberList(){
		List<MemberBeans> members = new ArrayList<MemberBeans>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberBeans member = new MemberBeans();
				member.setId_mem(rs.getString("id_mem"));
				member.setPassword(rs.getString("password"));
				member.setName_mem(rs.getString("name_mem"));
				member.setAge_mem(rs.getInt("age_mem"));
				member.setRegister_date(rs.getDate("register_date"));
				members.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return members;
	}
	public MemberBeans matchIdpwd(String id,String pwd) {
		MemberBeans member = new MemberBeans();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select * from member where id_mem=? and password=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member.setAge_mem(rs.getInt("age_mem"));
				member.setId_mem(rs.getString("id_mem"));
				member.setName_mem(rs.getString("name_mem"));
				member.setPassword(rs.getString("password"));
				member.setRegister_date(rs.getDate("register_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return member;
	}
}
