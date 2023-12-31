package DTO;
import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	private int UserID;
	private int PerID;
	private String Username;
	private String Password;
	private String Fullname;
	private String Birthdate;
	private String PhoneNumber;
	private String Email;
	private String HomeAddress;
	private String FileName;
	
	public User() {}
	public User(int UserID, int PerID, String Username, String Password, String Fullname, String Birthdate, String PhoneNumber, String Email, String HomeAddress, String FileName) {
		this.UserID = UserID;
		this.PerID = PerID;
		this.Username = Username;
		this.Password = Password;
		this.Fullname = Fullname;
		this.Birthdate = Birthdate;
		this.PhoneNumber = PhoneNumber;
		this.Email = Email;
		this.HomeAddress = HomeAddress;
		this.FileName = FileName;
	}
	

	public int getUserID(){
		return UserID;
	}
	

	public void setUserID(int UserID) {
		this.UserID = UserID;
	}
	

	public int getPerID() {
		return PerID;
	}
	

	public void setPerID(int PerID) {
		this.PerID = PerID;
	}
	

	public String getUsername() {
		return Username;
	}
	

	public void setUsername(String Username) {
		this.Username = Username;
	}
	

	public String getPassword() {
		return Password;
	}
	
	
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	
	public String getFullname() {
		return Fullname;
	}
	
	public void setFullname(String Fullname) {
		this.Fullname = Fullname;
	}
	
	
	public String getBirthdate() {
		return Birthdate;
	}
	
	public void setBirthdate(String Birthdate) {
		this.Birthdate = Birthdate;
	}
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	
	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getHomeAddress() {
		return HomeAddress;
	}
	
	public void setHomeAddress(String HomeAddress) {
		this.HomeAddress = HomeAddress;
	}
	
	public String getFileName() {
		return FileName;
	}
	
	public void setFileName(String filename) {
		this.FileName = filename;
	}
}
