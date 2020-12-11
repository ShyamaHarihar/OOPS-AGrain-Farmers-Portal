package dbconn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf7;
	private JTextField tf8;
	private JTextField ut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public register() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 753);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION TO A GRAIN PORTAL");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id1=Integer.parseInt(tf1.getText());
				String name1=tf2.getText();
				int phno1=Integer.parseInt(tf3.getText());
				String Address1=tf4.getText();
				int age1=Integer.parseInt(tf5.getText());
				int accountNo1=Integer.parseInt(tf6.getText()); 
				JRadioButton rb1=null;
				String gender1="";
				String usertype=ut.getText();
				int aadharno1=Integer.parseInt(tf7.getText());
				String pwd=tf8.getText();
				String url = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
			    String username = "shyama";
			    String passwd = "root";
			    Connection connect = null;
			    Statement st = null;
			    try 
				{
				connect = DriverManager.getConnection(url, username, passwd);
				st=connect.createStatement();
				String query1="insert into register values("+id1+",'"+usertype+"','"+name1+"',"+phno1+",'"+Address1+"',"+age1+","+accountNo1+","+aadharno1+",'"+pwd+"');";
				st.executeUpdate(query1);
				JOptionPane.showMessageDialog(null,"Row Inserted");
				
				}
				    catch(SQLException e1) 
					{
					e1.printStackTrace();
					}
			    finally
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
					      }}}});
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		
		tf6 = new JTextField();
		tf6.setColumns(10);
		
		tf7 = new JTextField();
		tf7.setColumns(10);
		
		tf8 = new JTextField();
		tf8.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter id");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter name");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Enter PhoneNo");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Enter Address");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Enter age");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Enter accountNo");
		lblNewLabel_1_1_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1_6 = new JLabel("Enter AadharNo");
		lblNewLabel_1_1_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1_7 = new JLabel("Enter password");
		lblNewLabel_1_1_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton rb1 = new JRadioButton("male");
		
		
		JRadioButton rb2 = new JRadioButton("Female");
		
		JLabel lblNewLabel_2 = new JLabel("Enter user type");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		ut = new JTextField();
		ut.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(349)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(389, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(94, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(32))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(101))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(60))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(22)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rb1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(rb2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addComponent(tf8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(579, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(519, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(529))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(ut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(tf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(tf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rb1)
						.addComponent(rb2))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(tf7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(tf8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(btnNewButton)
					.addGap(54))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
