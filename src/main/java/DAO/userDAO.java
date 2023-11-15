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
	
	//insert data
	public void insertUser(User user) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try
	    {
			String sql = "INSERT INTO user(USERID, PERID, USERNAME, PASSWORD, FULLNAME, BIRTHDATE, PHONENUMBER, EMAIL, HOMEADDRESS) VALUES(?,?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			//thay thế biến thành dữ liệu đầu vào
			preparedStmt.setInt(1,this.getCount()+1);
			preparedStmt.setInt(2,user.getPerID());
			preparedStmt.setString(3,user.getUsername());
			preparedStmt.setString(4,user.getPassword());
			preparedStmt.setString(5,user.getFullname());
			preparedStmt.setString(6,user.getBirthdate());
			preparedStmt.setString(7,user.getPhoneNumber());
			preparedStmt.setString(8,user.getEmail());
			preparedStmt.setString(9,user.getHomeAddress());

			preparedStmt.executeUpdate();
			System.out.println("insert success");
			if(preparedStmt.executeUpdate() > 0)
				System.out.println("insert success");
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
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		//lấy cơ sở dữ liệu vào lớp Story
		while (rs.next()) {
			count++;
			int userId = rs.getInt("USERID");
			int perId = rs.getInt("PERID");
			String userName = rs.getString("USERNAME");
			String passWord = rs.getString("PASSWORD");
			String fullName = rs.getString("FULLNAME");
			String birthDay = rs.getString("BIRTHDATE");
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
	
	public User getUser(String username, String password) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try
	    {
			String sql = "SELECT * FROM user WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "';";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt("USERID"));
				user.setPerID(rs.getInt("PERID"));
				user.setUsername(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setFullname(rs.getString("FULLNAME"));
				user.setBirthdate(rs.getString("BIRTHDATE"));
				user.setPhoneNumber(rs.getString("PHONENUMBER"));				
				user.setEmail(rs.getString("EMAIL"));
				user.setHomeAddress(rs.getString("HOMEADDRESS"));
				return user;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		return null;
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
			if(rs.next()) {
				System.out.println("Tài khoản tồn tại!");
				return true;
			}
		}catch(Exception e) {
			
		}
		return false;
	}
	
	public void updateUser(int userid, User ud) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try {
			String sql = "UPDATE user SET USERNAME=?, PASSWORD=?, FULLNAME=?, BIRTHDATE=?, PHONENUMBER=?, EMAIL=?, HOMEADDRESS=? where USERID=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,ud.getUsername());
			ps.setString(2,ud.getPassword());
			ps.setString(3,ud.getFullname());
			ps.setString(4,ud.getBirthdate());
			ps.setString(5,ud.getPhoneNumber());
			ps.setString(6,ud.getEmail());
			ps.setString(7,ud.getHomeAddress());
			ps.setInt(8,userid);
			
			int rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("UPDATE thành công!");
			}
		}catch(Exception e) {
			
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        userDAO u = new userDAO();
        
        
    }
}
