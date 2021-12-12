package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class emp_profile {

	private JFrame frame;
	Mysqlcl con;
   // public String empid;
    private JTextField tf1;
    private JTextField empname1;
    private JTextField gander1;
    private JTextField state;
    private JTextField phonenum;
    private JTextField country1;
    private JTextField emailid;
    private JTextField doB;
    private JTextField address;
    String empid="2661";
    private JTextField txtProfile;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	emp_profile obj=new emp_profile();
	
	}

	/**
	 * Create the application.
	 */
	public emp_profile() {
		initialize();
    	//String empid="2661";
		//tf1.setText(empid);
		//show();
	}
	public emp_profile(String st3) {
		initialize();
		empid=st3;
		tf1.setText(st3);
		show();		
	}

	 public void show() {
		 try {
			  con = new Mysqlcl();
	                String sql = "select * from signup where emp_id=?";
			PreparedStatement st = con.c.prepareStatement(sql);

			st.setString(1,empid);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
	                    empname1.setText(rs.getString("emp_name"));
	                    emailid.setText(rs.getString("email_id"));
	                    phonenum.setText(rs.getString("phone_num"));
	                    doB.setText(rs.getString("DOB"));
	                    gander1.setText(rs.getString("gander"));
	                    state.setText(rs.getString("state"));
	                    country1.setText(rs.getString("country"));
	                    address.setText(rs.getString("address"));
	                    
			}
			}catch(Exception a) {
				a.printStackTrace();
			}

	 }
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("profile");
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 865, 437);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		txtProfile = new JTextField();
		txtProfile.setBounds(0, 0, 865, 53);
		frame.getContentPane().add(txtProfile);
		txtProfile.setText("Profile");
		txtProfile.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfile.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtProfile.setEditable(false);
		txtProfile.setColumns(10);
		txtProfile.setBackground(new Color(95, 158, 160));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 63, 840, 357);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Profile Edit", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		
		tf1 = new JTextField();
		tf1.setEditable(false);
		//tf1.setText("5418");
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf1.setColumns(10);
		tf1.setBounds(191, 69, 180, 25);
		panel_1.add(tf1);
		
		empname1 = new JTextField();
		empname1.setEditable(false);
		empname1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		empname1.setColumns(10);
		empname1.setBounds(191, 128, 180, 25);
		panel_1.add(empname1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Emp id");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(54, 75, 104, 26);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel gander = new JLabel("gander");
		gander.setFont(new Font("Tahoma", Font.BOLD, 14));
		gander.setBounds(426, 75, 104, 26);
		panel_1.add(gander);
		
		gander1 = new JTextField();
		gander1.setEditable(false);
		gander1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gander1.setColumns(10);
		gander1.setBounds(563, 76, 180, 25);
		panel_1.add(gander1);
		
		state = new JTextField();
		state.setFont(new Font("Tahoma", Font.PLAIN, 14));
		state.setColumns(10);
		state.setBounds(563, 129, 180, 25);
		panel_1.add(state);
		
		JLabel State1 = new JLabel("State");
		State1.setFont(new Font("Tahoma", Font.BOLD, 14));
		State1.setBounds(426, 128, 104, 26);
		panel_1.add(State1);
		
		JLabel lblSelectJob_1_1 = new JLabel("Email id");
		lblSelectJob_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectJob_1_1.setBounds(54, 179, 104, 26);
		panel_1.add(lblSelectJob_1_1);
		
		JLabel lblSalary_1_1 = new JLabel("Phone num");
		lblSalary_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalary_1_1.setBounds(54, 228, 104, 26);
		panel_1.add(lblSalary_1_1);
		
		phonenum = new JTextField();
		phonenum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phonenum.setColumns(10);
		phonenum.setBounds(191, 229, 180, 25);
		panel_1.add(phonenum);
		
		country1 = new JTextField();
		country1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		country1.setColumns(10);
		country1.setBounds(563, 180, 180, 25);
		panel_1.add(country1);
		
		JLabel country = new JLabel("Country");
		country.setFont(new Font("Tahoma", Font.BOLD, 14));
		country.setBounds(426, 179, 104, 26);
		panel_1.add(country);
		
		emailid = new JTextField();
		emailid.setEditable(false);
		emailid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailid.setColumns(10);
		emailid.setBounds(191, 179, 180, 25);
		panel_1.add(emailid);
		
		doB = new JTextField();
		doB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		doB.setColumns(10);
		doB.setBounds(191, 286, 180, 25);
		panel_1.add(doB);
		
		JLabel dob = new JLabel("DOB");
		dob.setFont(new Font("Tahoma", Font.BOLD, 14));
		dob.setBounds(54, 285, 104, 26);
		panel_1.add(dob);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 14));
		address.setColumns(10);
		address.setBounds(563, 229, 180, 25);
		panel_1.add(address);
		
		JLabel Address1 = new JLabel("Address");
		Address1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Address1.setBounds(426, 228, 104, 26);
		panel_1.add(Address1);
		
		JButton update = new JButton("Update");
		update.setBounds(515, 299, 104, 29);
		panel_1.add(update);
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String sql="Update signup SET phone_num=? , DOB=? , state=? , country=? , address=? where emp_id= ?";
					 
					  PreparedStatement  ps=con.c.prepareStatement(sql); 
					      
			              ps.setString(1,phonenum.getText()); 
						  ps.setString(2,doB.getText());
						  ps.setString(3,state.getText());
						  ps.setString(4,country1.getText());
						  ps.setString(5,address.getText());
						  ps.setString(6,empid);
						//  ps.executeUpdate();
						  
						  JDialog.setDefaultLookAndFeelDecorated(true);
							int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (response == JOptionPane.NO_OPTION) {
							 	JOptionPane.showMessageDialog(null,"you have select no..");
							} else if (response == JOptionPane.YES_OPTION) {
					                    ps.executeUpdate();
					                    JOptionPane.showMessageDialog(null, "Update..!!");
					                    frame.setVisible(false);
					                   
							}
						  
						/*  
						  
						  if(ps.equals(ps)){
							  JOptionPane.showMessageDialog(null,"data Update.....");
						  }else {
							  JOptionPane.showMessageDialog(null,"not Update......");
						  }*/

					}catch(Exception a) {
						a.printStackTrace();
					}
			}
		});
		update.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JButton back = new JButton("back");
		back.setBounds(639, 299, 104, 29);
		panel_1.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		     	frame.setVisible(false);
			
			}
		});
		back.setBackground(new Color(240, 240, 240));
		back.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel empname = new JLabel("Emp name");
		empname.setBounds(64, 127, 119, 26);
		panel_1.add(empname);
		empname.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 840, 357);
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Edit profile", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.textHighlightText);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Back");
		lblNewLabel_1_1_1.setBounds(778, 10, 52, 26);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			  frame.setVisible(false);
			}
		});
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBackground(Color.BLUE);
		frame.setVisible(true);
		
	}
}
