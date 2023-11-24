package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

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
			preparedStmt.setString(4,encrypt(user.getPassword()));
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
	public ArrayList<User> getUsers() throws Exception {
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
			String filename = rs.getString("FILENAME");
			
			User user = new User();
			user.setUserID(userId);
			user.setPerID(perId);
			user.setUsername(userName);
			user.setPassword(decrypt(passWord));
			user.setFullname(fullName);
			user.setBirthdate(birthDay);
			user.setPhoneNumber(phoneNumber);
			user.setEmail(email);
			user.setHomeAddress(homeaddress);
			user.setFileName(filename);
			
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
			String sql = "SELECT * FROM user WHERE USERNAME = '" + username + "' AND PASSWORD = '" + encrypt(password) + "';";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt("USERID"));
				user.setPerID(rs.getInt("PERID"));
				user.setUsername(rs.getString("USERNAME"));
				user.setPassword(decrypt(rs.getString("PASSWORD")));
				user.setFullname(rs.getString("FULLNAME"));
				user.setBirthdate(rs.getString("BIRTHDATE"));
				user.setPhoneNumber(rs.getString("PHONENUMBER"));				
				user.setEmail(rs.getString("EMAIL"));
				user.setHomeAddress(rs.getString("HOMEADDRESS"));
				user.setFileName(rs.getString("FILENAME"));
				return user;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
	public User getUser(String email) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try
	    {
			String sql = "SELECT * FROM user WHERE EMAIL = '" + email + "';";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt("USERID"));
				user.setPerID(rs.getInt("PERID"));
				user.setUsername(rs.getString("USERNAME"));
				user.setPassword(decrypt(rs.getString("PASSWORD")));
				user.setFullname(rs.getString("FULLNAME"));
				user.setBirthdate(rs.getString("BIRTHDATE"));
				user.setPhoneNumber(rs.getString("PHONENUMBER"));				
				user.setEmail(rs.getString("EMAIL"));
				user.setHomeAddress(rs.getString("HOMEADDRESS"));
				user.setFileName(rs.getString("FILENAME"));
				return user;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
	public int getCount() throws Exception {
		return this.getUsers().size();
	}
	
	public boolean checkExitAccount(String username, String password) throws ClassNotFoundException, SQLException {
		if(conn ==  null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try {
			String sql = "SELECT * FROM user WHERE USERNAME = '" + username + "' AND PASSWORD = '" + encrypt(password) + "';";
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
			String sql = "UPDATE user SET USERNAME=?, PASSWORD=?, FULLNAME=?, BIRTHDATE=?, PHONENUMBER=?, EMAIL=?, HOMEADDRESS=?, FILENAME=? where USERID=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,ud.getUsername());
			ps.setString(2,encrypt(ud.getPassword()));
			ps.setString(3,ud.getFullname());
			ps.setString(4,ud.getBirthdate());
			ps.setString(5,ud.getPhoneNumber());
			ps.setString(6,ud.getEmail());
			ps.setString(7,ud.getHomeAddress());
			ps.setString(8,ud.getFileName());
			ps.setInt(9,userid);
			
			int rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("UPDATE thành công!");
			}
		}catch(Exception e) {
			System.out.println("UPDATE thất bại!");
		}
	}
	
	public void updatePassword(String pass, String email) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try {
			String sql = "UPDATE user SET PASSWORD=? where EMAIL=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,encrypt(pass));
			ps.setString(2,email);
			
			int rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("UPDATE thành công!");
			}
		}catch(Exception e) {
			
		}
	}
	private static final String ALGORITHM = "AES";
    private static final String KEY = "key_word_1234567";

    public static String encrypt(String password) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encrypted = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encryptedPassword) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
        return new String(original);
    }
	public static void main(String[] args) throws Exception, Throwable  {
        userDAO u = new userDAO();
        //User user = new User( 1, 1, "VuNguyen", "vunguyen", "nguyenleuyvu", "2003-12-27", "0909658447", "uyvu.ng003@gmail.com", "", "");
        //u.updateUser(1,user);
        System.out.println(u.getUser("VuNguyen", "Thuy0302"));
        
        
        
    }
}