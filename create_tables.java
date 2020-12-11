package dbconn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class create_tables {
	public static void main(String[] args) 
	{
	    String url = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
	    String username = "shyama";
	    String passwd = "root";
	    Connection connect = null;
	    Statement st = null;
	    try 
	{
	connect = DriverManager.getConnection(url, username, passwd);
	st = connect.createStatement();
	st.executeUpdate("create table register(id int,usertype varchar(30),name varchar(30),phoneno int,address varchar(30),age int,accountNo int,aadharNo int,password varchar(30));");
	System.out.println("Table Register Created");
	st.execute("create table seller_repository(product_id int NOT NULL PRIMARY KEY,product_name varchar(100) not null,product_price double not null,product_quantity long not null,Sellers_id int not null);");
	System.out.println("seller repository table created");
	st.execute("create table farmer_profile(product_id int NOT NULL PRIMARY KEY,product_name varchar(100) not null,product_price double not null,product_quantity long not null,Sellers_id int not null);");
	System.out.println("Farmer profile table is created");
	st.execute("create table cart(product_id int NOT NULL PRIMARY KEY,product_name varchar(100) not null,product_price double not null,product_quantity long not null,Sellers_id int not null);");
	System.out.println("Table cart is created");
	st.execute("create table farming_details(person_id int not null,land_size long not null,crops_harvested varchar(100) not null,irrigation_type varchar(100) not null,soil_type varchar(100) not null,fertilizers varchar(100) not null);");
	System.out.println("Table farming_details created");
	st.execute("create table bank_details(Sno int NOT NULL AUTO_INCREMENT PRIMARY KEY ,account_number long NOT NULL  ,cvv int NOT NULL unique ,IFSC_code int NOT NULL ,bank_name varchar(100) NOT NULL,branch_name varchar(100) NOT NULL,bank_Address varchar(100) not null,amount double not null);");
	System.out.println("Bank details created");
	st.execute("create table training(id int,days int,course varchar(50));");
	System.out.println("Table training created");
	st.execute("create table attend_training(id int,days int,course varchar(30),confirmation varchar(10));");
	System.out.println("Table attend_training created");
	st.execute("create table upload_material(id int,material_type varchar(30),title varchar(50));");
	System.out.println("Table upload materials is created");
	JOptionPane.showMessageDialog(null,"All the tables are created");
	}catch(SQLException e) 
	{
	e.printStackTrace();
	}finally
	{
	      try {
	        if (st != null) {
	          st.close();
	        }
	        if (connect!= null) {
	          connect.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
}}
}
