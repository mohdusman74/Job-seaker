package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Admin_login{

	private JFrame frame;
	private JPasswordField password;
	private JTextField username;
	ResultSet rs;
	Mysqlcl con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_login window = new Admin_login();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("job portal");
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(400, 100, 594, 383);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 39, 553, 289);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME or EMAIL_ID");
		lblNewLabel.setBounds(21, 54, 194, 21);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		username = new JTextField();
		username.setBounds(248, 51, 271, 30);
		panel.add(username);
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(248, 145, 271, 34);
		panel.add(password);
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(72, 144, 119, 32);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton button1 = new JButton("Login");
		button1.setBounds(369, 207, 150, 34);
		panel.add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					    con=new Mysqlcl();
						java.sql.Statement st= con.c.createStatement();
						String sql="select *from comp_login where username='"+username.getText()+"' or email_id='"+username.getText() +"' and password='" +password.getText()+"'";
					
						rs=st.executeQuery(sql);
					 if(username.getText().trim().isEmpty()&&password.getText().trim().isEmpty())
				   {
					JOptionPane.showMessageDialog(null,"field is Empty....");
                  }else	if(rs.next()) {
						JOptionPane.showMessageDialog(null, "login successfull");
						Admin obj1=new Admin();
						frame.setVisible(false);
						
				      
					}
					else {
						JOptionPane.showMessageDialog(null,"username and password incorrect");
					}
					
				}catch(Exception a) {
					a.printStackTrace();
				}
			}
		});
		button1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblJobPortalSystem = new JLabel("Job Portal System");
		lblJobPortalSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblJobPortalSystem.setForeground(Color.WHITE);
		lblJobPortalSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblJobPortalSystem.setBackground(Color.WHITE);
		lblJobPortalSystem.setBounds(0, 0, 597, 45);
		frame.getContentPane().add(lblJobPortalSystem);
	}
}
