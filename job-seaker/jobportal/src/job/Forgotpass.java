package job;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;
import javax.swing.SwingConstants;



public class Forgotpass {

	private JFrame frame;
	 private JPanel contentPane, panel;
	    private JTextField t1,t2,t4,t5;
	    private JButton b1,b3;
	    Mysqlcl con;
	    private JButton btnUpdate;
        String empid;
        private JTextField txtUpdatePassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Forgotpass window = new Forgotpass();
	}
// parameter method
	 /*public void back1() {
				
			try {
				  con = new Mysqlcl();
		        String sql = "select * from signup where emp_id=?";
				PreparedStatement st = con.c.prepareStatement(sql);

				st.setString(1, empid);
				st.setString(1, t1.getText());
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
		                    t2.setText(rs.getString("emp_name"));
		                    t4.setText(rs.getString("password"));
		                    t5.setText(rs.getString("con_password"));
		                   // t6.setText(rs.getString("sec_q"));
		                    
				}
				}catch(Exception a) {
					a.printStackTrace();
				}
			
			
     }
	*/ 
//not parameter method
	
	 public void back2() {
		 b3 = new JButton("Back");
			b3.setBounds(250, 240, 101, 29);
			panel.add(b3);
			b3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
              frame.setVisible(false);	      	
				}
				
			});
			b3.setFont(new Font("Tahoma", Font.BOLD, 13));
			b3.setBackground(SystemColor.control);
			b3.setForeground(SystemColor.desktop);
			
					t1 = new JTextField();
					t1.setBounds(233, 33, 139, 20);
					panel.add(t1);
					t1.setFont(new Font("Tahoma", Font.BOLD, 13));
					t1.setForeground(new Color(105, 105, 105));
					t1.setColumns(10);
					
							JLabel l1 = new JLabel("emp_id");
							l1.setBounds(64, 29, 87, 29);
							panel.add(l1);
							l1.setFont(new Font("Tahoma", Font.BOLD, 13));
							
									b1 = new JButton("Search");
									b1.setBounds(399, 29, 80, 29);
									panel.add(b1);
									b1.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											try {
											  con = new Mysqlcl();
									        String sql = "select * from signup where emp_id=?";
											PreparedStatement st = con.c.prepareStatement(sql);

											st.setString(1, empid);
											st.setString(1, t1.getText());
											ResultSet rs = st.executeQuery();

											while (rs.next()) {
									                    t2.setText(rs.getString("emp_name"));
									                    t4.setText(rs.getString("password"));
									                    t5.setText(rs.getString("con_password"));
									                   // t6.setText(rs.getString("sec_q"));
									                    
											}
											}catch(Exception a) {
												a.printStackTrace();
											}
											

										}
									});
									b1.setFont(new Font("Tahoma", Font.BOLD, 12));
									b1.setBackground(SystemColor.control);
									b1.setForeground(SystemColor.desktop);
							
							
     }
	 
    public Forgotpass(String str) { 
    	initialize();
    	empid=str;
    	t1.setText(str);
    	
      
    }
	
	
	public Forgotpass() {
		initialize();
		back2();
	//	String str=empid;
		//t1.setText(str);
	
	}
    
     
     
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Forgot password");
		frame.setResizable(false);
		frame.setBounds(100, 100, 595, 431);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
	        contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setLayout(null);
	        

		
		
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(139, 69, 19), 2), "Update_password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel.setBounds(10, 63, 569, 345);
	        panel.setBackground(Color.WHITE);
		contentPane.add(panel);
				panel.setLayout(null);
		
				t2 = new JTextField();
				t2.setBounds(233, 78, 139, 22);
				panel.add(t2);
				t2.setEditable(false);
				t2.setFont(new Font("Tahoma", Font.BOLD, 13));
				t2.setForeground(new Color(165, 42, 42));
				t2.setColumns(10);
					
						
						
								t5 = new JTextField();
								t5.setBounds(233, 192, 139, 20);
								panel.add(t5);
								t5.setFont(new Font("Tahoma", Font.BOLD, 13));
								t5.setForeground(new Color(50, 205, 50));
								t5.setColumns(10);
								
										t4 = new JTextField();
										t4.setBounds(233, 134, 139, 20);
										panel.add(t4);
										t4.setFont(new Font("Tahoma", Font.BOLD, 13));
										t4.setForeground(new Color(205, 92, 92));
										t4.setColumns(10);
										
												JLabel l5 = new JLabel("con_Password");
												l5.setBounds(64, 192, 104, 21);
												panel.add(l5);
												l5.setFont(new Font("Tahoma", Font.BOLD, 13));
												
														JLabel l4 = new JLabel("password");
														l4.setBounds(64, 134, 104, 21);
														panel.add(l4);
														l4.setFont(new Font("Tahoma", Font.BOLD, 13));
														
																JLabel l2 = new JLabel("Name");
																l2.setBounds(64, 79, 75, 21);
																panel.add(l2);
																l2.setFont(new Font("Tahoma", Font.BOLD, 13));
																
																btnUpdate = new JButton("update");
																btnUpdate.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		try {
																		if(t4.getText().trim().isEmpty()&& t5.getText().trim().isEmpty()&& t1.getText().trim().isEmpty()) 
																		{
																			JOptionPane.showMessageDialog(null,"invalid........");
																		}else {
																																				  String sql="Update signup SET password = ? , con_password=?  where emp_id= ?";
																		  PreparedStatement  ps=con.c.prepareStatement(sql); 
																              ps.setString(1,t4.getText()); 
																			  ps.setString(2,t5.getText());
																			  ps.setString(3,t1.getText());
																			  
																			  JDialog.setDefaultLookAndFeelDecorated(true);
																				int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
																				if (response == JOptionPane.NO_OPTION) {
																			  JOptionPane.showMessageDialog(null,"you have select no..");
																		} else if (response == JOptionPane.YES_OPTION) {
																                    ps.executeUpdate();
																                    JOptionPane.showMessageDialog(null, "Update..!!");
																                    Emp_login obj=new Emp_login();
																                    frame.setVisible(false);
																		   }	
																		}
																		
																	}catch(Exception a) {
																			a.printStackTrace();
																		}
																		 																		 
																	}	
																	
																});
																frame.setUndecorated(true);
																frame.setVisible(true);
																btnUpdate.setForeground(Color.BLACK);
																btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
																btnUpdate.setBackground(SystemColor.control);
																btnUpdate.setBounds(377, 240, 101, 29);
																panel.add(btnUpdate);	
																
																txtUpdatePassword = new JTextField();
																txtUpdatePassword.setText("Update password");
																txtUpdatePassword.setHorizontalAlignment(SwingConstants.CENTER);
																txtUpdatePassword.setFont(new Font("Tahoma", Font.BOLD, 20));
																txtUpdatePassword.setEditable(false);
																txtUpdatePassword.setColumns(10);
																txtUpdatePassword.setBackground(new Color(95, 158, 160));
																txtUpdatePassword.setBounds(0, 0, 595, 53);
																contentPane.add(txtUpdatePassword);
	}

}
