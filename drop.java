package dbconn;
import java.sql.*;

import javax.swing.JOptionPane;
public class drop {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
	    String username = "shyama";
	    String passwd = "root";
	    Connection connect = null;
	    Statement st = null;
	    try 
	{
	connect = DriverManager.getConnection(url, username, passwd);
	st = connect.createStatement();
    st.executeUpdate("drop table register;");
    System.out.println("register dropped");
    st.executeUpdate("drop table seller_repository;");
    System.out.println("seller_repository dropped");
    st.executeUpdate("drop table farmer_profile;");
    System.out.println("farmer_profile dropped");
    st.executeUpdate("drop table cart;");
    System.out.println("cart dropped");
    st.executeUpdate("drop table farming_details");
    System.out.println("farming_details dropped");
    st.executeUpdate("drop table bank_details;");
    System.out.println("bank_details dropped");
    st.executeUpdate("drop table training;");
    System.out.println("training dropped");
    st.executeUpdate("drop table attend_training;");
    System.out.println("attend_training dropped");
    st.executeUpdate("drop table upload_material;");
    System.out.println("upload_material dropped");
    JOptionPane.showMessageDialog(null,"All the tables have been dropped successfully ");
	}
	    catch(SQLException e) 
	{
	e.printStackTrace();
	}

	}

}
