package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Emp_login {

	private JFrame frmLogin;
	private JTextField tf1;
	private JPasswordField tf2;
	Mysqlcl con;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Emp_login window = new Emp_login();
		
	}
  
	/**
	 * Create the application.
	 */
	public Emp_login() {
		initialize();
	}
	public void initialize() {
		
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setResizable(false);
		frmLogin.getContentPane().setBackground(new Color(143, 188, 143));
		frmLogin.setBounds(400, 100, 665, 540);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBorder(new TitledBorder(null, "emp_Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(24, 49, 604, 440);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(88, 79, 100, 24);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("password :");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(88, 164, 100, 24);
		panel.add(lblPassword);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf1.setBounds(214, 80, 201, 24);
		panel.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JPasswordField();
		tf2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf2.setBounds(214, 165, 201, 24);
		panel.add(tf2);
		frmLogin.setVisible(false);
		JButton btn1 = new JButton("Login");
	   
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					con=new Mysqlcl();
					String q="select emp_name , emp_id from signup  where email_id=? and password=?";
					PreparedStatement st=con.c.prepareStatement(q);
					
					st.setString(1,tf1.getText());
					st.setString(2,tf2.getText());
					ResultSet rs=st.executeQuery();
					
					if(rs.next()) {
						
						      String st1, st2;
						      st2=rs.getString("emp_id");
						      st1=rs.getString("emp_name");
						 	JOptionPane.showMessageDialog(null,"Walcome to.."+st1);
							frmLogin.setVisible(false);
							 Emp_page a=new Emp_page(st1,st2);					
					}else {
						JOptionPane.showMessageDialog(null,"Invalid Login");
					}
					
				}catch(Exception a) {
					a.printStackTrace();
				}
				
			}
			
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn1.setBounds(329, 231, 85, 21);
		panel.add(btn1);
		
		JLabel lblNewLabel_1 = new JLabel("New account create  :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(122, 284, 141, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("new account");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signup obj1=new Signup();
				frmLogin.setVisible(false);
				obj1.main(null);
			}
		});
		lblNewLabel_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_1.setBounds(273, 284, 100, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Forgot password  :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(122, 338, 141, 24);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Forgotpass obj1=new Forgotpass();
				frmLogin.setVisible(false);
			}
		});
		lblNewLabel_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_1_1.setBounds(273, 334, 100, 24);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblJobPortalSystem = new JLabel("Job Portal System");
		lblJobPortalSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblJobPortalSystem.setForeground(Color.WHITE);
		lblJobPortalSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblJobPortalSystem.setBackground(Color.WHITE);
		lblJobPortalSystem.setBounds(0, 0, 651, 45);
		frmLogin.getContentPane().add(lblJobPortalSystem);
		frmLogin.setVisible(true);
	}
}
