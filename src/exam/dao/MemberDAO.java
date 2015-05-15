package exam.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import exam.dto.*;

public class MemberDAO {
	private Connection con = null; // try안에 있는 것을 밖으로 빼줌	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 생성자
	public MemberDAO() {
		System.out.println("생성자");
		
		// 1. JDBC 드라이버 로드
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }

		// 2. 데이터베이스와 연결
				
		try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jspuserc", "jsp1234");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }	
		
	}
	
		// 회원가입
		public void insertMember(Member member) {
			System.out.println("회원가입");
			String sql = "insert into member values(?, ?, ?, ?, ?, ?, default)";
		
			String id = member.getId();
			String pass = member.getPass();
			String name = member.getName();
			int age = member.getAge();
			String gender = member.getGender();
			String addr = member.getAddr();
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, id);
				pstmt.setString(2, pass);
				pstmt.setString(3, name);
				pstmt.setInt(4, age);
				pstmt.setString(5, gender);
				pstmt.setString(6, addr);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// 로그인
		// 1) DTO 미사용
		public int loginMember(String id, String pwd) {
			String sql = "select * from member where id=? and password=?";	
			int result = 0;
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				
				rs = pstmt.executeQuery();
				
				if(rs.next())  // 로그인 성공
					result = 1;
				else  		  // 로그인 실패	
					result = 0;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result; // void를 int로 변경
		}
		
		// 2) DTO 미사용
		public int loginMember(Member member) {
			return 0;
			
		}
		
		// 회원리스트
		public List<Member> listMember() {
			String sql = "select * from member order by id desc";
			
			List<Member> list = new ArrayList<Member>();
			
		
			try {
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Member m = new Member();
					
					m.setId(rs.getString("id"));
					m.setName(rs.getString("name"));
					
					list.add(m); // while 안에 있어야함
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list; // void에 List<Member>로 변경
		}
		
		// 회원 상세보기
		public void detailMember() {
			
		}
		
		// 회원 삭제
		public void deleteMember() {
			System.out.println("회원삭제");
		}
}
