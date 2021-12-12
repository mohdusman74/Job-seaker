package job;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import com.mysql.cj.xdevapi.Statement;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Emp_page {

	public JFrame frame;
	JLabel lb2;
	private JTextField tf1;
	private JTable table;
	Mysqlcl con;
	JComboBox comboBox;
	JPanel panel;
	private JTextField tf2;
	private JTextField tf3;
    String empid, empemail, empname;
    String compid, compname,compjob, location;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Emp_page window = new Emp_page();

	
	}

	 /**
	  * @wbp.parser.entryPoint
	  */
	 public Emp_page(String st, String st2) {
		   initialize();
		   empid=st;
		  empid= st2;
		  tf1.setText(st);
		//  textField.setText(st2);
	   }

	public Emp_page() {
		initialize();

	}
	
	public void selectdata() {
			
		try {
			  con = new Mysqlcl();
	                String sql = "select  *from signup where emp_id=?";
			PreparedStatement st = con.c.prepareStatement(sql);

			st.setString(1,empid);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				        empname=rs.getString("emp_name");
				        empemail=rs.getString("email_id");
				        
	                    //textField_1.setText(empname);
	                    //textField_2.setText(empemail);                 
			}
			}catch(Exception a) {
				a.printStackTrace();
			}
		try {
			  con = new Mysqlcl();
	                String sql = "select * from company where company_id=?";
			PreparedStatement st = con.c.prepareStatement(sql);

			st.setString(1, compid);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				        compname=rs.getString("company_name");
				        compjob=rs.getString("jobs");
				        location=rs.getString("location");
				        
	                  //  textField_3.setText(compname);
	                 //   textField_4.setText(compjob);
	                  //  textField_5.setText(location);
	                   // t6.setText(rs.getString("sec_q"));
	                    
			}
			}catch(Exception a) {
				a.printStackTrace();
			}
		if(compid==null) {
			JOptionPane.showMessageDialog(null, "not !!");
		  }else {
		try {
			 con = new Mysqlcl();
	         String sql = "insert into job_apply(job_id, comp_name, job, location, emp_id, emp_name, emp_email) values(?,?,?,?,?,?,?)";
			PreparedStatement st = con.c.prepareStatement(sql);
			st.setString(1, compid);
			st.setString(2, compname);
			st.setString(3, compjob);
			st.setString(4, location);
			st.setString(5, empid);
			st.setString(6, empname);
			st.setString(7, empemail);
		//	int rs = st.executeUpdate();
			JDialog.setDefaultLookAndFeelDecorated(true);
			int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.NO_OPTION) {
			 	JOptionPane.showMessageDialog(null,"you have select no..");
			} else if (response == JOptionPane.YES_OPTION) {
	                    int rs = st.executeUpdate();
	                    JOptionPane.showMessageDialog(null, "Apply job !!");
	                    
	                } else if (response == JOptionPane.CLOSED_OPTION) {
	                //	JOptionPane.showMessageDialog(null,"you have select no..");
	                }
          
			}catch(Exception a) {
				a.printStackTrace();
			}
		compid=null;
		tf3.setText("");
		}
}
	
	public void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\tmu icon.png"));
		frame.setTitle("Home");
		//ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("third.png"));
		frame.setBounds(50,50,1225,768);
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		
		JMenuBar mb1 = new JMenuBar();
		mb1.setBounds(0, 0, 53, 27);
		JMenu menu1 = new JMenu("Home");
		menu1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JMenuItem item1 = new JMenuItem("Profile");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 emp_profile a=new emp_profile(empid);					
			}
		});
		menu1.add(item1);
		JMenuItem item2 = new JMenuItem("pass change");
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   Updatepass obj=new Updatepass(empid);
				
			}
		});
		menu1.add(item2);
		mb1.add(menu1);
		frame.getContentPane().add(mb1);

		
		
		
		
	    panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "portal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 48, 1191, 673);
		panel.setBackground(new Color(102, 205, 170));
		panel.setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(mb1);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 464, 1191, 223);
		panel.add(scrollPane);
		
		
		table = new JTable();    
				try {	
					con=new Mysqlcl();
					 String sql = "select company_id, company_name, location, jobs,  salary, experience from company;";
					 // String sql = "select *from emp_info";
					 
			            PreparedStatement st = con.c.prepareStatement(sql);
			            ResultSet rs = st.executeQuery();
			           table.setModel(DbUtils.resultSetToTableModel(rs));
			            rs.close();
			            st.close();
			            con.c.close();
					}catch(Exception a) {
						a.printStackTrace();
					}
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int row = table.getSelectedRow();
				 compid=table.getModel().getValueAt(row, 0).toString();
					tf3.setText(compid);
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(table); 
			
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					con=new Mysqlcl();
					 String sql = "select company_id, company_name, location, jobs,  salary, experience from company where concat(jobs) like ?;";
					 // String sql = "select *from emp_info";
					 
			            PreparedStatement st = con.c.prepareStatement(sql);
			            st.setString(1, "%" + tf2.getText()+ "%");
			            ResultSet rs = st.executeQuery();
			           table.setModel(DbUtils.resultSetToTableModel(rs));
			            rs.close();
			            st.close();
			            con.c.close();
					}catch(Exception a) {
						a.printStackTrace();
					}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(1023, 328, 85, 26);
		panel.add(btnNewButton_1);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Tahoma", Font.BOLD, 15));
		tf2.setColumns(10);
		tf2.setBounds(880, 329, 133, 26);
		panel.add(tf2);
		
		tf3 = new JTextField();
		tf3.setEditable(false);
		tf3.setFont(new Font("Tahoma", Font.BOLD, 15));
		tf3.setColumns(10);
		tf3.setBounds(482, 329, 133, 26);
		panel.add(tf3);
		
		JButton btn2 = new JButton("Apply Job");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectdata();
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn2.setBounds(630, 328, 103, 26);
		panel.add(btn2);
		
		JLabel btn4 = new JLabel("select skills.");
		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btn4.setBounds(880, 356, 103, 21);
		panel.add(btn4);
		
		JMenuBar menu4 = new JMenuBar();
		menu4.setBounds(110, 0, 60, 27);
		JMenu mnNewMenu = new JMenu("Logout");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		JMenuItem item6=new JMenuItem("Logout");
		item6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emp_login obj=new Emp_login();
				frame.setVisible(false);
				}
		});
		mnNewMenu.add(item6);
		JMenuItem item7=new JMenuItem("Exit");
		item7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnNewMenu.add(item7);
		menu4.add(mnNewMenu);
		frame.getContentPane().add(menu4);

		tf1 = new JTextField();
		tf1.setEditable(false);
		tf1.setFont(new Font("Tahoma", Font.BOLD, 15));
		tf1.setBounds(1048, 10, 153, 26);
		frame.getContentPane().add(tf1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(57, 0, 50, 27);
		JMenu menu2 = new JMenu("help");
		menu2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JMenuItem item8=new JMenuItem("help");
		item8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About obj=new About();
			}
		});
		menu2.add(item8);
		menuBar.add(menu2);	
		frame.getContentPane().add(menuBar);
		
		 
		
		    
		    JLabel lb1 = new JLabel();
		    lb1.setBounds(82, 72, 213, 215);
		    ImageIcon icon1=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\second.png");
			 Image img1=icon1.getImage();
			Image imgscale1=img1.getScaledInstance(lb1.getWidth(),lb1.getHeight(),Image.SCALE_DEFAULT);
			ImageIcon image1=new ImageIcon(imgscale1);
			lb1.setIcon(image1);
		    panel.add(lb1);
		    
		    JLabel lb3 = new JLabel();
		    lb3.setBounds(482, 72, 213, 215);
		    ImageIcon icon3=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\fourth.png");
			 Image img3=icon3.getImage();
			Image imgscale3=img3.getScaledInstance(lb3.getWidth(),lb3.getHeight(),Image.SCALE_DEFAULT);
			ImageIcon image3=new ImageIcon(imgscale3);
			lb3.setIcon(image3);
		    panel.add(lb3);
		    
		    JLabel lb4 = new JLabel();
		    lb4.setBounds(880, 72, 213, 215);
		    ImageIcon icon4=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\eight.png");
			 Image img4=icon4.getImage();
			Image imgscale4=img4.getScaledInstance(lb4.getWidth(),lb4.getHeight(),Image.SCALE_DEFAULT);
			ImageIcon image4=new ImageIcon(imgscale4);
			lb4.setIcon(image4);
		    panel.add(lb4);
		    
		    JButton btnSelectJob = new JButton("select job");
		    btnSelectJob.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		Emp_select obj=new Emp_select(empid);
		    	}
		    });
		    btnSelectJob.setFont(new Font("Tahoma", Font.BOLD, 14));
		    btnSelectJob.setBounds(118, 328, 142, 26);
		    panel.add(btnSelectJob);
		    
		    JLabel btn4_1 = new JLabel("select skills.");
		    btn4_1.setForeground(Color.WHITE);
		    btn4_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		    btn4_1.setBounds(10, 433, 177, 21);
		    panel.add(btn4_1);
		   
		  		    
		tf1.setColumns(10);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    

		lb2 = new JLabel("Hom page ");
		lb2.setForeground(new Color(70, 130, 180));
		lb2.setBackground(Color.WHITE);
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		lb2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb2.setBounds(-10, 0, 1232, 45);
		frame.getContentPane().add(lb2);

		JLabel lblYourName = new JLabel("Name :");
		lblYourName.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblYourName.setBounds(981, 14, 67, 21);
		frame.getContentPane().add(lblYourName);
		
		
		
	
	}
}
