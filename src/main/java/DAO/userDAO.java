package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import DTO.User;

public class userDAO {
	Connection conn = null;
	PreparedStatement preparedStmt = null;
	
	//insert data
	public void insertUser(User user) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try
	    {
			String sql = "INSERT INTO user(USERID, PERID, USERNAME, PASSWORD, FULLNAME, BIRTHDATE, PHONENUMBER, EMAIL, HOMEADDRESS) VALUES(?,?,?,?,?,?,?,?,?);";
			preparedStmt = (PreparedStatement) conn.prepareStatement(sql);
			//thay thế biến thành dữ liệu đầu vào
			preparedStmt.setInt(1,user.getUserID());
			preparedStmt.setInt(2,user.getPerID());
			preparedStmt.setString(3,user.getUsername());
			preparedStmt.setString(4,user.getPassword());
			preparedStmt.setString(5,user.getFullname());
			preparedStmt.setString(6,user.getBirthdate());
			preparedStmt.setString(7,user.getPhoneNumber());
			preparedStmt.setString(8,user.getEmail());
			preparedStmt.setString(9,user.getHomeAddress());
			System.out.println(sql);
			preparedStmt.executeUpdate();
			
	    }
		catch (Exception e){
			
		}
	}
	
	//count user	
	public int count = 0;
	//list user 
	public ArrayList<User> getUsers() throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		//tạo list User để lưu truyện về
		ArrayList<User> list = new ArrayList<User>();
		//câu truy vấn
		String sql = "Select * from User";
		PreparedStatement preparedStmt = conn.prepareStatement(sql);
		ResultSet rs = preparedStmt.executeQuery();
		//lấy cơ sở dữ liệu vào lớp Story
		while (rs.next()) {
			count++;
			int userId = rs.getInt("USERID");
			int perId = rs.getInt("PERID");
			String userName = rs.getString("USERNAME");
			String passWord = rs.getString("PASSWORD");
			String fullName = rs.getString("FULLNAME");
			String birthDay = rs.getDate("BIRTHDATE").toString();
			String phoneNumber = rs.getString("PHONENUMBER");
			String email = rs.getString("EMAIL");
			String homeaddress = rs.getString("HOMEADDRESS");
			
			User user = new User();
			user.setUserID(userId);
			user.setPerID(perId);
			user.setUsername(userName);
			user.setPassword(passWord);
			user.setFullname(fullName);
			user.setBirthdate(birthDay);
			user.setPhoneNumber(phoneNumber);
			user.setEmail(email);
			user.setHomeAddress(homeaddress);
			
			list.add(user);
		}
		return list;
	}
	
	public int getCount() throws ClassNotFoundException, SQLException, ParseException {
		return this.getUsers().size();
	}
	
	public boolean checkExitAccount(String username, String password) throws ClassNotFoundException, SQLException {
		if(conn ==  null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try {
			String sql = "SELECT * FROM user WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "';";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Tài khoản tồn tại!");
				return true;
			}
		}catch(Exception e) {
			
		}
		return false;
	}
}
