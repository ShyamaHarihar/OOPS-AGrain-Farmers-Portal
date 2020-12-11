package dbconn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import java.sql.Statement;

interface UserInfo
{
	default void Register()
	{
			   
		welcome w= new welcome();
		w.setVisible(true);
			   
	}     
default void fill_bank_details()
{
	   System.out.println("fill_bank_details method");
	   
}
default void make_transaction_placement()
{
	   System.out.println("make_transaction_placement method");
}
}
class seller implements UserInfo,stock
{
	public float Seller_rating;
}
class farmer implements UserInfo,stock,buy_product
{
	Scanner obj=new Scanner(System.in);
	int person_id;
	public long land_size;
	public String crops_harvested,irrigation_type,soil_type,fertilizers ;
	public farmer()
	{
		person_id=0;
		land_size=0;
		crops_harvested="";
		irrigation_type="";
		soil_type="";
		fertilizers="";
	}
     void farming_details()
     {
    	 System.out.println("Enter farming details....\nEnter person id\nEnter land_size\nEnter crops_harvested\nEnter irrigation_type\nEnter Soil type\nEnter fertilizers");
         person_id=obj.nextInt();
    	 land_size=obj.nextLong();
         crops_harvested=obj.next();
         irrigation_type=obj.next();
         soil_type=obj.next();
         fertilizers=obj.next();
		 try {
				
			 	String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
			 	String Username = "shyama";
			 	String password = "root";
				Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
				Statement stm=conn.createStatement();
				String query = "insert into farming_details(person_id,land_size,crops_harvested,irrigation_type,soil_type,fertilizers)"
		            + " values (?, ?, ?, ?, ?,?)";
		          PreparedStatement preparedStmt = conn.prepareStatement(query);
		          preparedStmt.setInt(1,person_id);
		          preparedStmt.setLong (2,land_size );
		          preparedStmt.setString (3, crops_harvested);
		          preparedStmt.setString (4, irrigation_type);
		          preparedStmt.setString (5, soil_type);
		          preparedStmt.setString (6, fertilizers);
		          preparedStmt.execute();
		          System.out.println("Data inserted!!");
	       stm.close();
	        conn.close();
          }
			catch(Exception e1)
			{
			System.out.println(e1);	
			System.out.println("Incorrect value...Reenter data");	
			farming_details();
			}
		 System.out.println("Enter 1 to view farming_details table ");
		 int g=obj.nextInt();
		 if(g==1)
			 view_farming_details();
     }
     void view_farming_details()
     {
    	 try {					
    		 String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
			 	String Username = "shyama";
			 	String password = "root";
				Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
				Statement stm=conn.createStatement();
				ResultSet rs;		
				rs = stm.executeQuery("select * from farming_details");  
				System.out.println("\nFarming details !!!! \n");
				System.out.println("person id"+"\t"+"land size"+"\t"+"crops harvested"+"\t\t"+"irrigation_type"+"\t\t"+"soil_type"+"\t"+"fertilizers"); 
 			      if (rs != null) 			    	  
 			          while (rs.next()) 
 			      {  
 			        	     System.out.println( rs.getString(1)+"\t\t"+rs.getString(2)+ "\t\t "+rs.getString(3)+"\t\t\t"+rs.getString(4)+"\t\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\n");
 			      }  		
 		stm.close();
 		conn.close();
     	}
 			
 					catch(Exception e1)
 					{
 					System.out.println(e1);	
 					}
     }
	void register_for_trainig()
	{
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter training details");
		System.out.println("Enter farmer_id");
		int id=obj.nextInt();
		System.out.println("Training options");
		System.out.println("1.Enter 1 for 10 days");
		System.out.println("2.Enter 2 for 20 days");
		System.out.println("3.Enter 3 for 30days");
		int days = 0;
		System.out.println("Enter your option");
		int input;
		input=obj.nextInt();
		switch(input)
		{
		case 1:days+=10;
		break;
		case 2:days+=20;
		break;
		case 3:days+=30;
		break;
		default:
			System.out.println("Enter valid option");
		}
		System.out.println("Course Details");
		System.out.println("1.Enter 1 for Farming Best Practises");
		System.out.println("2.Enter 2 for Irrigation Best Methods");
		System.out.println("3.Enter 3 for Business Ideas to Boost your sales");
		int input1=obj.nextInt();
		String course="";
		switch(input1)
		{
		case 1:
			course+="Farming Best Practises";
			break;
		case 2:
			course+="Irrigation Best Methods";
			break;
		case 3:
			course+="Business Ideas to Boost your sales";
		default:
			System.out.println("Enter valid details");
		}
		String url = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
	    String username = "shyama";
	    String passwd = "root";
	    Connection connect = null;
	    Statement st = null;
	    try 
	{
	connect = DriverManager.getConnection(url, username, passwd);
	st=connect.createStatement();
	String query1="insert into training values("+id+","+days+",'"+course+"');";
	JOptionPane.showMessageDialog(null,"Row inserted in training record");
	st.executeUpdate(query1);
	}
	    catch(SQLException e1) 
		{
		e1.printStackTrace();
		}finally
		{
		      try {
		        if (st != null) {
		          st.close();
		        }
		        if (connect!= null) {
		          connect.close();
		        }
		      } catch (Exception e2) {
		        e2.printStackTrace();
		      }
		}
	}
	void attend_training()
	{
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter training details");
		System.out.println("Enter farmer_id");
		int id=obj.nextInt();
		System.out.println("Training options");
		System.out.println("1.Enter 1 for 10 days");
		System.out.println("2.Enter 2 for 20 days");
		System.out.println("3.Enter 3 for 30days");
		int days = 0;
		System.out.println("Enter your option");
		int input;
		input=obj.nextInt();
		switch(input)
		{
		case 1:days+=10;
		break;
		case 2:days+=20;
		break;
		case 3:days+=30;
		break;
		default:
			System.out.println("Enter valid option");
		}
		System.out.println("Course Details");
		System.out.println("1.Enter 1 for Farming Best Practises");
		System.out.println("2.Enter 2 for Irrigation Best Methods");
		System.out.println("3.Enter 3 for Business Ideas to Boost your sales");
		int input1=obj.nextInt();
		String course="";
		switch(input1)
		{
		case 1:
			course+="Farming Best Practises";
			break;
		case 2:
			course+="Irrigation Best Methods";
			break;
		case 3:
			course+="Business Ideas to Boost your sales";
		default:
			System.out.println("Enter valid details");
		}
		String url = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
	    String username = "shyama";
	    String passwd = "root";
	    Connection connect = null;
	    Statement st = null;
	    try 
	{
	connect = DriverManager.getConnection(url, username, passwd);
	st=connect.createStatement();
	String query1="insert into attend_training values("+id+","+days+",'"+course+"','Yes'"+");";
	JOptionPane.showMessageDialog(null,"Row inserted in training record");
	st.executeUpdate(query1);
	}
	    catch(SQLException e1) 
		{
		e1.printStackTrace();
		}finally
		{
		      try {
		        if (st != null) {
		          st.close();
		        }
		        if (connect!= null) {
		          connect.close();
		        }
		      } catch (Exception e2) {
		        e2.printStackTrace();
		      }
		}
	}
	void upload_materials()	
	{
		Scanner o=new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
	    String username = "shyama";
	    String passwd = "root";
	    Connection connect = null;
	    Statement st = null;
	    System.out.println("enter id");
	    int id=o.nextInt();
	    String type="";
	    System.out.println("Enter the option for the appropriate type");
	    System.out.println("1.PDF");
	    System.out.println("2.DOCX");
	    System.out.println("3.MP3");
	    int input;
	    input=o.nextInt();
	    switch(input)
	    {
	    case 1:
	    	type+="PDF";
	    	break;
	    case 2:
	    	type+="DOCX";
	    	break;
	    case 3:
	    	type+="MP3";
	    	break;
	    	default:
	    		System.out.println("Upload type not supported");
	    }
	    System.out.println("Enter title for the material uploaded");
	    String title=o.next();
	    try 
		{
		connect = DriverManager.getConnection(url, username, passwd);
		st=connect.createStatement();
		String query1="insert into  upload_material values("+id+",'"+type+"'"+",'"+title+"');";
		st.executeUpdate(query1);
		JOptionPane.showMessageDialog(null,"Table  upload_material updated successfully");
		}
	    catch(SQLException e1) 
		{
		e1.printStackTrace();
		}finally
		{
		      try {
		        if (st != null) {
		          st.close();
		        }
		        if (connect!= null) {
		          connect.close();
		        }
		      } catch (Exception e2) {
		        e2.printStackTrace();
		      }
		}
	    
	    
	}
	void obtain_materials()
	{
		System.out.println("The user can obtain material by viewing the materials available");
		String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
	    String username = "shyama";
	    String passwd = "root";
	    Connection connect = null;
	    Statement st = null;
	    String rq2="select * from upload_material;";
	    try 
		{
		connect = DriverManager.getConnection(url, username, passwd);
		st=connect.createStatement();
	    ResultSet rs1=st.executeQuery(rq2);
	    while(rs1.next())
	    {
	    	String data=rs1.getString(1);
	    	String data1=rs1.getString(2);
	    	String data2=rs1.getString(3);
	    	System.out.print(data+","+data1+","+data2);
	    }
	    st.close();
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
}
class customer implements UserInfo,buy_product
{
	
	public int product_id;public String product_purchased;
	public customer()
	{
		product_id=0;
		product_purchased="";
	}

}
interface stock extends product_details
{
	class stock1
	{
	Scanner s=new Scanner(System.in);
    void add_stock(String usertype)
	{
		 System.out.println("Enter product id\nEnter product name\nEnter product price\nEnter quantity availabe\nEnter personal id\n");
		 int i=s.nextInt();
		 String n=s.next();
		 Double p=s.nextDouble();
		 Long qty=s.nextLong();
		 int pi=s.nextInt();	
		 try {
				
			 	String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
			 	String Username = "shyama";
			 	String password = "root";
				Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
				Statement stm=conn.createStatement();
				
			String sql;
			if(usertype.equals("farmer"))
			 sql="insert into farmer_profile(product_id,product_name,product_price,product_quantity,Sellers_id) values("+i+",'"+n+"',"+p+",'"+qty+"','"+pi+"')";
			else
			sql="insert into seller_repository(product_id,product_name,product_price,product_quantity,Sellers_id) values("+i+",'"+n+"',"+p+",'"+qty+"','"+pi+"')";
		    stm.executeUpdate(sql);		  
		    stm.close();
	        conn.close();
          }
			catch(Exception e1)
			{
			System.out.println(e1);	
			System.out.println("An item with the same product id already exists......renter data");	
			add_stock(usertype);
			}
	}
	 void update_stock(String usertype)
	{
		 try {				
				
			 	String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
			 	String Username = "shyama";
			 	String password = "root";
				Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
				Statement stm=conn.createStatement();
		   int c;	
			System.out.println("Enter 1 to add items into stock\nEnter 2 to remove items from stock\nEnter 3 to edit the content in the cart\n");
			c=s.nextInt();
			if(c==1)
			add_stock(usertype);
			else
			if(c==2)
			{
		 int sno;
		 System.out.println("enter Product id to delete");
		 sno=s.nextInt();
		 String query1;
		 if(usertype.equals("farmer"))
		      query1 = "delete from farmer_profile " +"where product_id="+sno;
		       else
			 query1 = "delete from seller_repository" +"where product_id="+sno;
				     stm.executeUpdate(query1);
				     System.out.println("Item deleted");		
				     			
			}
			else
			{
				if(c==3)
				{
				System.out.println("Enter product id of the item that has to be changed");
				int i1=s.nextInt();
				 System.out.println("Enter 1 to change product name\nEnter 2 to change product price\nEnter 3 to change product Quantity\n");
				 int c1=s.nextInt();
				 String sqlUpdate;
				 int rowAffected=0;
				 if(c1==1)
				 {
					String n1;
					System.out.println("Enter new product name");
					n1=s.next();					 
					if(usertype.equals("farmer"))
					    	   sqlUpdate = "UPDATE farmer_profile "+ "SET product_name = ? "+ "WHERE product_id = ?";
					               else
					               sqlUpdate = "UPDATE seller_repository "+ "SET product_name = ? "+ "WHERE product_id = ?"; 
					               PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
					               String pn=n1;
					               int id = i1;
					               pstmt.setString(1, pn);
					               pstmt.setInt(2, id);
					               rowAffected = pstmt.executeUpdate();
				 }
				if(c1==2)
				 {
					double p1;
					System.out.println("Enter new product price");
					p1=s.nextDouble();					 
					if(usertype.equals("farmer"))
					    	   sqlUpdate = "UPDATE farmer_profile "+ "SET product_price = ? "+ "WHERE product_id = ?";
					               else
					                sqlUpdate = "UPDATE seller_repository "+ "SET product_price = ? "+ "WHERE product_id = ?"; 
					               PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
					               double pp=p1;
					               int id = i1;
					               pstmt.setDouble(1, pp);
					               pstmt.setInt(2, id);
					             rowAffected = pstmt.executeUpdate();
					       }
				 if(c1==3)
				 {
					Long q1;
					System.out.println("Enter new quantity");
					q1=s.nextLong();					 
					if(usertype.equals("farmer"))
					    	   sqlUpdate = "UPDATE farmer_profile "+ "SET product_quantity = ? "+ "WHERE product_id = ?";
					               else
					               sqlUpdate = "UPDATE seller_repository "+ "SET product_quantity = ? "+ "WHERE product_id = ?"; 
					               PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
					               Long qty=q1;
					               int id = i1;
					               pstmt.setLong(1, qty);
					               pstmt.setInt(2, id);
					                rowAffected = pstmt.executeUpdate();
					               }
				 System.out.println(String.format("%d Qauntity updated ", rowAffected));
				}
			}         
					      
					     stm.close();
					     conn.close();
							}
						catch(Exception e1)
						{
						System.out.println(e1);	
						System.exit(0);
						}     	  
		 System.out.println("Enter 1 to view stock\n");
		 int g=s.nextInt();
		 if(g==1)
			 view_stock(usertype);
	}
	  void  recieve_feedback()
	{
		
	}
	void verify_transaction()
	{
		
	}
	void view_stock(String usertype)
	{
		try {					
			String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
		 	String Username = "shyama";
		 	String password = "root";
			Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
			Statement stm=conn.createStatement();
		ResultSet rs;
		if(usertype.equals("farmer"))		
		{
				 rs = stm.executeQuery("select * from farmer_profile");  
				 System.out.println("\nFarmer profile!! \n");				 
		}
		else
		{
			rs = stm.executeQuery("select * from seller_repository"); 
			System.out.println("\nSeller repsoitory!! \n");
		}
		System.out.println("product_id"+" \t"+"product_name"+"\t"+" product_price"+"\t\t"+"product_quantity"+"\t"+"Sellers_id\n"); 
			      if (rs != null) 			    	  
			          while (rs.next()) 
			      {  
			        	     System.out.println( rs.getString(1)+" \t\t"+rs.getString(2)+ "\t\t "+rs.getString(3)+"\t\t\t"+rs.getString(4)+"\t\t\t"+rs.getString(5)+"\n");
			      }  		
		stm.close();
		conn.close();
    	}
			
					catch(Exception e1)
					{
					System.out.println(e1);	
					}
	}
	}
	stock1 s1=new stock1();
	default void add_stock1(String usertype)
	{	
	s1.add_stock(usertype);
	}
	default void view_stock1(String usertype)
	{	
	s1.view_stock(usertype);
	}
	default void update_stock1(String usertype)
	{
		s1.update_stock(usertype);
	}
}
class training
{
	public int institute_id;
	public String institute_name;
	farmer farmer_training ;
	String feedback;
	Scanner obj=new Scanner(System.in);
	void provide_trainig_session()
	{
		
	}
	void verify_login()
	{
		
	}
	void verify_registration()
	{
		
	}
	void provide_trainig_update()
	{
		
	}
	void upload_material()
	{
		
	}
	void receive_feedback()
	{
		System.out.println("Enter your feedback");
		feedback=obj.next();
	}
}
interface buy_product extends product_details
{
	class buy_product1
	{
     Scanner s=new Scanner(System.in);
    void browse_product(String usertype)
	{
    	try {					
    		String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
		 	String Username = "shyama";
		 	String password = "root";
			Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
			Statement stm=conn.createStatement();
		ResultSet rs;
		if(usertype.equals("farmer"))
		{			
				 rs = stm.executeQuery("select * from seller_repository");  
				 System.out.println("\nSeller Repsoitory!!\n");
		}
		else
		{
			rs = stm.executeQuery("select * from farmer_profile"); 
			System.out.println("\nFarmer profile!!\n");
		}
		System.out.println("product_id"+" \t"+"product_name"+"\t\t"+"product_price"+"\t\t"+"product_quantity"+"\t"+"Sellers_id\n"); 
			      if (rs != null) 			    	  
			          while (rs.next()) 
			      {  
			          
			          System.out.println( rs.getString(1)+" \t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t "+rs.getString(4)+"\t\t\t"+rs.getString(5)+"\n");  
			      }  		
		stm.close();
		conn.close();
    	}
			
					catch(Exception e1)
					{
					System.out.println(e1);	
					System.exit(0);
					}
		  select_product(usertype);
		 
	}
	void select_product(String usertype)
	{	
	 int sno;
	 Long qty;
	 System.out.println("Enter product id\n Enter quantity to be bought");
	 sno=s.nextInt();
	 qty=s.nextLong();	 
	 add_to_cart(sno,qty,usertype);
		}
	void add_to_cart(int sno,long qty,String usertype)
	{
		int i=0,pi=0;
		String n="",query="";
		double p=0.0D;
		long q=0L;
			try {
				
				String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
			 	String Username = "shyama";
			 	String password = "root";
				//Class.forName(driver);
				Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
				Statement stm=conn.createStatement();
			if(usertype.equals("farmer"))
			{
				query = "select product_id, product_name,product_price,product_quantity,Sellers_id from seller_repository where product_id ="+sno;
			}
			else
			{
				query = "select product_id, product_name,product_price,product_quantity,Sellers_id from farmer_profile where product_id ="+sno;
			}
				ResultSet rs = stm.executeQuery(query);
		      while (rs.next()) {		        
		        i = rs.getInt("product_id");
		        n = rs.getString("product_name");
		        p = rs.getDouble("product_price");
		        q  = rs.getLong("product_quantity");
		        pi= rs.getInt("Sellers_id");
		        		      }
			}
			catch(Exception e1)
			{
			System.out.println(e1);	
			System.exit(0);
			}
		try {
					
			String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
		 	String Username = "shyama";
		 	String password = "root";
			//Class.forName(driver);
			Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
			Statement stm=conn.createStatement();
				if(q>=qty)
				{
				
				String sql="insert into cart(product_id,product_name,product_price,product_quantity,Sellers_id) values("+i+",'"+n+"',"+p*qty+",'"+qty+"','"+pi+"')";
			    stm.executeUpdate(sql);
			    }
			    else
			    System.out.println("Invalid quantity");
		       stm.close();
		        conn.close();
	             }
				catch(Exception e1)
				{
				System.out.println(e1);	
				System.out.println("\nAn item with the same product id already exists....renter values");	
				select_product(usertype);
				}
		check(usertype);
	}
	void check(String usertype)
	{
				int ch;
				System.out.println("Enter 1 to update cart or add items to cart\nEnter 2 to make payment\nEnter 3 to exit");
				ch=s.nextInt();
				if(ch==1)
				update_cart(usertype);
				else
				if(ch==2)
				 place_order();
				else
				if(ch==3)
				System.exit(0);
				else
				System.out.println("Invalid input");
	}
	void update_cart(String usertype)
	{
	    int c;	
		System.out.println("\nEnter 1 to add items into cart\nEnter 2 to remove items from cart \nEnter 3 to update quantity");
		c=s.nextInt();
		if(c==1)
		select_product(usertype);
		else
		if(c==2)
		{
	 int sno;
	 System.out.println("\nEnter product id ");
	 sno=s.nextInt();
	 try {
					
		 String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
		 	String Username = "shyama";
		 	String password = "root";
			//Class.forName(driver);
			Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
			Statement stm=conn.createStatement();
				 String query1 = "delete from cart " +"where product_id="+sno;
			     stm.executeUpdate(query1);
			     System.out.println("\nItem deleted");		
			     stm.close();
			     conn.close();
					}
				catch(Exception e1)
				{
				System.out.println(e1);	
				System.exit(0);
				}     	 
		}
		else
			if(c==3)
			{
				Long q1,pq=0L;
				int i1;
				System.out.println("\nEnter product id\nEnter new quantity");
				i1=s.nextInt();
				q1=s.nextLong();				
				 try {						
					 String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
					 	String Username = "shyama";
					 	String password = "root";
						//Class.forName(driver);
						Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
						Statement stm=conn.createStatement();
					  ResultSet rs = stm.executeQuery("select product_quantity from cart where product_id="+i1);
				      while(rs.next()) {
				         pq=rs.getLong("product_quantity");
				      }  
				       if(pq>=q1)
				       {
				    	   String sqlUpdate = "UPDATE cart "+ "SET product_quantity = ? "+ "WHERE product_id = ?";
				               PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
				               Long qty=q1;
				               int id = i1;
				               pstmt.setLong(1, qty);
				               pstmt.setInt(2, id);
				               int rowAffected = pstmt.executeUpdate();
				               System.out.println(String.format("%d Qauntity updated ", rowAffected));
				    	   }
				       else
				    	   System.out.println("Invalid quantity");   
				     stm.close();
				     conn.close();
						}
					catch(Exception e1)
					{
					System.out.println(e1);	
					System.exit(0);
					}     	 
			}
			else
		System.out.println("Invalid input");		
		place_order();
	}
	void place_order()
	{
		System.out.println("Want to view cart??..enter 1 for yes and 2 for no ");
		int c2=s.nextInt();
		if(c2==1)
		{
			try {					
				String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
			 	String Username = "shyama";
			 	String password = "root";
				//Class.forName(driver);
				Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
				Statement stm=conn.createStatement();
			 ResultSet rs = stm.executeQuery("select * from cart"); 
			 System .out.println("\n Products in the cart !!! \n");
			System.out.println("product_id"+" \t"+"product_name"+"\t\t"+"product_price"+"\t\t"+"product_quantity"+"\t"+" Sellers_id\n"); 
				      if (rs != null) 			    	  
				          while (rs.next()) 
				      {  				          
				          System.out.println( rs.getString(1)+" \t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(4)+"\t\t\t"+rs.getString(5)+"\n");  
				      }  		
			stm.close();
			conn.close();
	    	}
				
						catch(Exception e1)
						{
						System.out.println(e1);	
						System.exit(0);
						}
		}
		make_payment();
	}
	void make_payment()
	{
		System.out.println("processing payment");
	    
	}
	
   }
	default void product_Class(String usertype)
	{
	buy_product1 b=new buy_product1();
	b.browse_product(usertype);
	}
	
}
interface product_details
{
	/*public int product_id;
	public String product_name;
	public double product_price;
	public long product_quantity;*/
	
}
class portal 
{
	public int system_id,portal_rating;
	public String system_name;
	
	void verify_registration()
	{
		
	}
	void verify_login()
	{
		
	}
	void record_login_info()
	{
		
	}
	void diplay_frequently_used_item()
	{
		
	}
	void update_login_info()
	{
		
	}
	void verify_transaction()
	{
		
	}
	void process_payment_type()
	{
		
	}
	void update(String usertype)
	{
		try {					
			String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
		 	String Username = "shyama";
		 	String password = "root";
			//Class.forName(driver);
			Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
			Statement stm=conn.createStatement();
		int list[]=new int[30];
		long list1[]=new long[30];
		int slist[]=new int[30];
		long slist1[]=new long[30];
		String sqlUpdate;
		ResultSet rs = stm.executeQuery("select product_id,product_quantity from cart ");
		ResultSet rs1;
		int p=0,q=0;
		while(rs.next()){
			list[p]=rs.getInt("product_id");
			list1[p]=rs.getLong("product_quantity");
			p=p+1;
			}
		if(usertype.equals("farmer"))
		rs1 = stm.executeQuery("select product_id,product_quantity from seller_repository ");
		else
		rs1 = stm.executeQuery("select product_id,product_quantity from farmer profile ");
		while(rs1.next()){
			slist[q]=rs1.getInt("product_id");
			slist1[q]=rs1.getLong("product_quantity");
			q=q+1;
			}
				for (int i = 0; i<= p;i++)  		      
				{    
				for(int j = 0; j<=q;j++)
				{
					if(list[i]==slist[j])
				{
		if(usertype.equals("farmer"))
		sqlUpdate = "UPDATE seller_repository "+ "SET product_quantity = ? "+ "WHERE product_id = ?";
		else
		sqlUpdate = "UPDATE farmer_profile"+ "SET product_quantity = ? "+ "WHERE product_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
        long qq=slist1[j]-list1[i];
        int id=slist[j];
        pstmt.setLong(1, qq);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        }
			}
			}
		String query2;
		    	   if(usertype.equals("farmer"))
		    	   query2 = "delete from seller_repository where product_quantity=0";
		    	   else
		    		query2 = "delete farmer profile where product_quantity=0";
			     stm.executeUpdate(query2);
		       String query1 = "delete from cart ";
			     stm.executeUpdate(query1);
        stm.close();
        conn.close();
		}
		catch(Exception e1)
		{
		System.out.println(e1);	
		System.exit(0);
		} 
	}
}
class system_adminstrator
{ 
 void update_db(String usertype)
 {
portal p=new portal();
 p.update(usertype);
 }
public int admin_id;
public String admin_name;
public float salary;
void manage_downtime()
{
	   
}
}
class payment 
{	
	Bank b=new Bank();
	void pay()
	{
	b.enter_details();
	b.verify_account_no();	
	}	
	public int payment_id,c,c1;;
	public String payment_name;
	public double cost;
}
class Bank
{
	Scanner obj1=new Scanner(System.in);
    float interst_rate;
	String bank_name,branch_name,bank_Address;
	int IFSC_code;
	long account_number;
	int CVV;
	void enter_details()
	{ 
	System.out.println("Enter card details \nEnter account number \nEnter Cvv");
	account_number=Long.parseLong(obj1.nextLine());
	CVV=Integer.parseInt(obj1.nextLine());
	System.out.println("Enter IFSC code \nEnter bank name \nEnter branch name \nbank Address");	
	IFSC_code=Integer.parseInt(obj1.nextLine());
	bank_name=obj1.nextLine();
	branch_name=obj1.nextLine();
	bank_Address=obj1.nextLine(); 
	/*account_number=1243535;
	CVV=3456;
			IFSC_code=123;
			bank_name="SBI";
			branch_name="CBE";
			bank_Address="RAMANATHATPURAM - CBE,TAMIL NADU";*/
	}
	void verify_account_no()
	{
		int i=0,c=0;
		String bn="",brn="",ba="";
		double amt=0.0;
		try {
			
			String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
		 	String Username = "shyama";
		 	String password = "root";
			//Class.forName(driver);
			Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
			Statement stm=conn.createStatement();
		     try
		     {
		    String query = "select account_number,cvv,IFSC_code,bank_name,branch_name ,bank_Address,amount from bank_details where account_number ="+account_number;
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) 
		      {	
				c=rs.getInt("cvv");
				i=rs.getInt("IFSC_code");
				bn=rs.getString("bank_name");
				brn=rs.getString("branch_name");
				ba=rs.getString("bank_Address" );
				amt=rs.getDouble("amount");
		      }
			if((c==CVV)&&(i==IFSC_code)&&(bn.equals(bank_name))&&(brn.equals(branch_name))&&(ba.equals(bank_Address)))
			{
				System.out.println("\nCorrect account details..... Processing transaction");
				verify_balance(account_number,amt);
			}
			else
			{
				System.out.println("\nIncorrect account details \n Renter details");	
				enter_details();
			}
		      }
		     catch(Exception e)
				{
				System.out.println(e);	
				System.out.println("\nReneter details... account nuumber not found");	
				enter_details();
				}  	
	     stm.close();
	     conn.close();
			}
		catch(Exception e1)
		{
		System.out.println(e1);	
		}  	
	}
	void verify_balance(long account_number,double amount)
	{
		double p=0.0D;
		try {					
			String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
		 	String Username = "shyama";
		 	String password = "root";
			//Class.forName(driver);
			Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
			Statement stm=conn.createStatement();
		ResultSet rs = stm.executeQuery("select product_price from cart ");
	      while(rs.next()) {
	         p+=rs.getDouble("product_price");
	      }
		if(amount-p>=0)
	     allow_transaction(account_number,amount-p);
		else
			System.out.println("\nTransaction failed !! ...transactionnot possibe");
		stm.close();
		conn.close();
		}
		catch(Exception e1)
		{
		System.out.println(e1);	
		System.exit(0);
		}  	
	}
	void allow_transaction(long account_number ,double final_amt)
	{
		int c=0;
		System.out.println("\nProceed with transaction \nEnter 1 for yes \nEnter 2 for no and to exit");
		c=obj1.nextInt();
		if(c==1)
		{
			generate_OTP(account_number ,final_amt);
		}
		else
			System.exit(0);
	}
	void generate_OTP(long account_number ,double final_amt)
	{
		int c;
		int r = ( int )( Math.random() * 9999 );
		if( r <= 1000 ) 
		    r = r + 1000;
		if (r < 0) 
            r = -r;
	    System.out.println("\nOTP :"+r +" ....valid for 10 minutes");
	    System.out.println("\nEnter OTP");
	    int o=obj1.nextInt();
	    if(o==r)
	    {
	    	Random rd1 = new Random(); 
	    	long r1=rd1.nextLong();
	    	if (r1 < 0) 
	            r1 = -r1;
	    	System.out.print("\nPayment successful \nPayment id = "+r1);
	    	System.out.print("\nThank you for shopping with us...");
	    }
	    else
	    {
	    System.out.println("\nInvalid OTP \nEnter 1 to re send else enter 0");
	    c=obj1.nextInt();
	    if(c==1)
	    generate_OTP(account_number ,final_amt);
	    else
	    System.exit(0);
	    }
	   update_transaction_details(account_number ,final_amt)  ;
	}
	void update_transaction_details(long account_number ,double final_amt)
	{
		try {					
			String JdbcURL = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
		 	String Username = "shyama";
		 	String password = "root";
			Connection conn = DriverManager.getConnection(JdbcURL,Username,password);
			Statement stm=conn.createStatement();
		String sqlUpdate = "UPDATE bank_details "+ "SET amount = ? "+ "WHERE account_number = ?";
        PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
        double a=final_amt;
        long ac_no= account_number;
        pstmt.setDouble(1, a);
        pstmt.setLong(2, ac_no);
        pstmt.executeUpdate();  
        stm.close();
        conn.close();
		}
		catch(Exception e1)
		{
		System.out.println(e1);	
		System.exit(0);
		} 
	}
}

class online extends payment
{
	Scanner obj1=new Scanner(System.in);
		payment p=new payment();
	 void verify_transaction()
	    {	    
		p.pay();
		}
}
class offline extends payment
{
	Scanner obj=new Scanner(System.in);
	delivery_boy db=new delivery_boy ();
	public String Address;
	public long ph_number;
	void pay_offline()
	{
		System.out.println("Enter Address for deleivery\nEnter Contact phone_number");
		Address=obj.next();
		ph_number=obj.nextLong();
		System.out.println("Keep Cash ready on Delivery \nThank you for shopping with us!!!\n");
	}
}
class delivery_boy
{
	public int delivery_boy_id;
	public String delivery_boy_name;
	public long delivery_boy_ph_number;
	void search_address()
	{
		
	}
	void submit_product()
	{
		
	}
	void transfer_money_to_portal()
	{
		
	}
	void collect_money()
	{
		
	}
}
public class Agri_portal_main 
{
	public static void main(String[] args) 
	{
		Scanner obj=new Scanner(System.in);
		farmer ob1=new farmer();
		online on=new online();
		offline of=new offline();
		system_adminstrator sa= new system_adminstrator();
		seller ob3=new seller();
		customer ob2=new customer();
		System.out.println("Enter usertype..farmer or seller or customer");
		String usertype=obj.next();
		if(usertype.equals("farmer"))
		{
			ob1.Register();
		}
		else if(usertype.equals("seller")) {
			ob3.Register();
		}
		else {
			ob2.Register();
		}
		int ch,c,c1;
		int m=1;
		while(m!=0) 
{
			System.out.println("\n\nEnter 1 to view menu\nEnter 0 to exit");
			m=obj.nextInt();
			if(m==0)
			System.exit(0);
			System.out.println("Enter 1 make orders\nEnter 2 insert products into Stock\nEnter 3 to update stock\nEnter 4 to view stock\nEnter 5 to Enter farming details\nEnter 6 to view farming details table\nEnter 7 to register for training\nEnter 8 for attending the training\n Enter 9 for uploading materials\n Enter 10 for viewing materials");
			ch=obj.nextInt();
switch(ch)
{
case 1:
	if(usertype.equals("farmer"))
	ob1.product_Class(usertype);
	else
	if(usertype.equals("customer"))
	ob2.product_Class(usertype);
	else
	System.out.println("Cannot make orders");
	if(usertype.equals("farmer")||usertype.equals("customer"))
	{
	System.out.println("\nEnter 1 to proceed payment and 0 to exit");
	c=obj.nextInt();
	if(c==1)
	{
		System.out.println("\nEnter 1 to pay online 2 to pay offline and 0 to exit");
		c1=obj.nextInt();
		if(c1==1)
		on.verify_transaction();
		else
		of.pay_offline();
		
		sa.update_db(usertype);
	}
	else
	System.exit(0);	
	}
	else
		System.out.println("\nNot authorized to make payment");
	break;
case 2:
	if(usertype.equals("farmer"))
	ob1.add_stock1(usertype);
	else
		if(usertype.equals("seller"))
	 ob3.add_stock1(usertype);
		else
			System.out.println("Not authorized to add stock");
	break;
case 3:
	if(usertype.equals("farmer"))
		ob1.update_stock1(usertype);
		else
			if(usertype.equals("seller"))
		ob3.update_stock1(usertype);
			else
				System.out.println("Not authorized to update stock");
	break;
case 4:
	if(usertype.equals("farmer"))
		ob1.view_stock1(usertype);
	else
		if(usertype.equals("seller"))
			ob3.view_stock1(usertype);
	else
		System.out.println("Not authorized to view stock");
	break;
case 5:
	if(usertype.equals("farmer"))
	ob1.farming_details();
	else
		System.out.println("cannot Insert values ..only farmers are allowed");
	break;
case 6:
	ob1.view_farming_details();	
	break;
case 7:
	if(usertype.equals("farmer")) {
		ob1.register_for_trainig();
	}else {
		System.out.println("Not authorised to perform this action");
	}
	break;
case 8:
	if(usertype.equals("farmer"))
	{
		ob1.attend_training();
	}
	else {
		System.out.println("Not authorised to perform this action");
	}
	break;
case 9:
	if(usertype.equals("farmer"))
	{
		ob1.upload_materials();
	}
	else {
		System.out.println("Not authorised to perform this action");
	}
	break;
case 10:
	if(usertype.equals("farmer"))
	{
		ob1.obtain_materials();
	}
	else {
		System.out.println("Not authorised to perform this action");
	}
	break;
default:
	System.out.println("Invalid Input");
	}
	}
		
	}
	
}



