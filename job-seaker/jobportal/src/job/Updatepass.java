package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Updatepass {

	private JFrame frame;
	private JTextField t2;
	private JTextField t4;
	private JTextField t3;
	private JTextField t1;
	public String empid;
	Mysqlcl con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Updatepass window = new Updatepass();
		
	}
	
	 public Updatepass(String str) { 
	    	initialize();
	    	empid=str;
	    	t1.setText(str);
	    	selectdata();
	 }
	 
	 public void selectdata()
	 {
			try {
				  con = new Mysqlcl();
		        String sql = "select * from signup where emp_id=?";
				PreparedStatement st = con.c.prepareStatement(sql);
				st.setString(1, empid);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
		                    t2.setText(rs.getString("emp_name"));
		                    t3.setText(rs.getString("password"));
		                    t4.setText(rs.getString("con_password"));
		                   
				}
				}catch(Exception a) {
					a.printStackTrace();
				}
				
	 }
	/**
	 * Create the application.
	 */
	public Updatepass() {
		initialize();
		t1.setText(empid);
		
		JLabel lblPasswordUpadate = new JLabel("Password Update");
		lblPasswordUpadate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordUpadate.setForeground(Color.WHITE);
		lblPasswordUpadate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPasswordUpadate.setBackground(Color.WHITE);
		lblPasswordUpadate.setBounds(0, 0, 597, 45);
		frame.getContentPane().add(lblPasswordUpadate);
		selectdata();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(400, 100, 600, 435);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(139, 69, 19), 2), "Update_password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 43, 569, 345);
		frame.getContentPane().add(panel);
		
		t2 = new JTextField();
		t2.setForeground(new Color(165, 42, 42));
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setEditable(false);
		t2.setColumns(10);
		t2.setBounds(233, 101, 139, 22);
		panel.add(t2);
		
		t4 = new JTextField();
		t4.setForeground(new Color(50, 205, 50));
		t4.setFont(new Font("Tahoma", Font.BOLD, 13));
		t4.setColumns(10);
		t4.setBounds(233, 215, 139, 20);
		panel.add(t4);
		
		t3 = new JTextField();
		t3.setForeground(new Color(205, 92, 92));
		t3.setFont(new Font("Tahoma", Font.BOLD, 13));
		t3.setColumns(10);
		t3.setBounds(233, 157, 139, 20);
		panel.add(t3);
		
		JLabel l5 = new JLabel("con_Password");
		l5.setFont(new Font("Tahoma", Font.BOLD, 13));
		l5.setBounds(64, 215, 104, 21);
		panel.add(l5);
		
		JLabel l4 = new JLabel("password");
		l4.setFont(new Font("Tahoma", Font.BOLD, 13));
		l4.setBounds(64, 157, 104, 21);
		panel.add(l4);
		
		JLabel l2 = new JLabel("Name");
		l2.setFont(new Font("Tahoma", Font.BOLD, 13));
		l2.setBounds(64, 102, 75, 21);
		panel.add(l2);
		
		JButton Update = new JButton("update");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(t3.getText().trim().isEmpty()&& t4.getText().trim().isEmpty()) 
					{
						JOptionPane.showMessageDialog(null,"invalid........");
					}else {
					  String sql="Update signup SET password = ? , con_password=?  where emp_id= ?";
					  PreparedStatement  ps=con.c.prepareStatement(sql); 
			              ps.setString(1,t3.getText()); 
						  ps.setString(2,t4.getText());
						  ps.setString(3,t1.getText());
						  JDialog.setDefaultLookAndFeelDecorated(true);
							int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (response == JOptionPane.NO_OPTION) {
						  JOptionPane.showMessageDialog(null,"you have select no..");
					} else if (response == JOptionPane.YES_OPTION) {
			                    ps.executeUpdate();
			                    JOptionPane.showMessageDialog(null, "Update..!!");
			                    frame.setVisible(false);
					   }	
					}
					
				}catch(Exception a) {
						a.printStackTrace();
					}
			}
		});
		Update.setForeground(Color.BLACK);
		Update.setFont(new Font("Tahoma", Font.BOLD, 12));
		Update.setBackground(SystemColor.menu);
		Update.setBounds(387, 279, 101, 29);
		panel.add(Update);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		back.setForeground(Color.BLACK);
		back.setFont(new Font("Tahoma", Font.BOLD, 13));
		back.setBackground(SystemColor.menu);
		back.setBounds(260, 279, 101, 29);
		panel.add(back);
		
		t1 = new JTextField();
		t1.setForeground(SystemColor.controlDkShadow);
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		t1.setColumns(10);
		t1.setBounds(233, 33, 139, 20);
		panel.add(t1);
		
		JLabel l1 = new JLabel("emp_id");
		l1.setFont(new Font("Tahoma", Font.BOLD, 13));
		l1.setBounds(64, 29, 87, 29);
		panel.add(l1);
		frame.setVisible(true);
	}
}
