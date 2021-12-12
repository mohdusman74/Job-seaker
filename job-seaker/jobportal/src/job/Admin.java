package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class Admin {

	private JFrame frame;
	private JMenu top, menu1,menu2, menu3;
	private JMenuItem item1, item2;
	 JLabel lb1, lb2,lb3,lb4,lb5,lb6,lb7,lb8, lb9;


	
	public static void main(String[] args) {
		Admin window = new Admin();

			}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(255, 182, 193));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\jobs.jpg"));
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(50, 50, 1550, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 40, 22);
		menuBar.setBackground(SystemColor.inactiveCaption);
		top=new JMenu("menu");
		item1 = new JMenuItem("Employee signup");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup obj=new Signup();
				obj.main(null);
			}
		});
		 item2 = new JMenuItem("job Add");
		 item2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		AddJob obj=new AddJob();
		 	}
		 });
		 top.add(item1);
		 top.add(item2);
		 menuBar.add(top);
		  JPanel panel = new JPanel();
		  panel.setBounds(10, 49, 1516, 357);
		  panel.setBorder(new TitledBorder(null, "Employee Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  panel.setBackground(new Color(119, 136, 153));
		  
		  
		  JButton btnNewButton_1 = new JButton("Employee login");
		  btnNewButton_1.setBounds(189, 297, 213, 30);
		  btnNewButton_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Emp_login obj4=new Emp_login();
		  	}
		  });
		  btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		  
		  JButton btnNewButton_1_1 = new JButton("Employee infprmation");
		  btnNewButton_1_1.setBounds(1123, 295, 213, 32);
		  btnNewButton_1_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Emp_detail obj3=new Emp_detail();
		  		obj3.main(null);
		  	}
		  });
		  btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		  
		  JButton btnNewButton_1_1_1 = new JButton("singup details");
		  btnNewButton_1_1_1.setBounds(671, 297, 213, 30);
		  btnNewButton_1_1_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Signupdetail obj2=new Signupdetail();
		  		obj2.main(null);
		  	}
		  });
		  btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		  
		  JPanel panel_1 = new JPanel();
		  panel_1.setBounds(10, 416, 1516, 366);
		  panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "company Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		  panel_1.setBackground(new Color(119, 136, 153));
		  
		  JButton btnNewButton_2 = new JButton("select & short list");
		  btnNewButton_2.setBounds(837, 285, 210, 33);
		  btnNewButton_2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Select_job_table obj=new Select_job_table();
		  		obj.main(null);
		  		
		  	}
		  });
		  btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		  
		 
		  
		  JButton btnNewButton_2_2 = new JButton("company details");
		  btnNewButton_2_2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Companydetail obj1=new Companydetail();
		  		obj1.main(null);
		  	}
		  });
		  btnNewButton_2_2.setBounds(464, 286, 211, 33);
		  btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		  
		  JButton btnNewButton_1_1_2 = new JButton("Comany job");
		  btnNewButton_1_1_2.setBounds(66, 288, 221, 31);
		  btnNewButton_1_1_2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		AddJob obj1=new AddJob();
		  		obj1.main(null);
		  	}
		  });
		  btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		  
		  JLabel lb6 = new JLabel();
		        lb6.setBounds(464, 37, 211, 220);
		        lb6.setBackground(new Color(240, 240, 240));
			    ImageIcon icon6=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\company.jpg");
				Image img6=icon6.getImage();
				Image imgscale6=img6.getScaledInstance(lb6.getHeight(),lb6.getWidth(),Image.SCALE_SMOOTH);
				ImageIcon image6=new ImageIcon(imgscale6);
				lb6.setIcon(image6);
				
				
		  JLabel lb7 = new JLabel();
		 lb7.setBounds(837, 37, 210, 219);
		  lb7.setBackground(new Color(240, 240, 240));
			 ImageIcon icon7=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\list.jpg");
			Image img7=icon7.getImage();
			Image imgscale7=img7.getScaledInstance(lb7.getHeight(),lb7.getWidth(),Image.SCALE_SMOOTH);
			ImageIcon image7=new ImageIcon(imgscale7);
			lb7.setIcon(image7);
		  
		  JLabel lb8 = new JLabel();
		  lb8.setBounds(66, 38, 221, 220);
		 lb8.setBackground(new Color(240, 240, 240));
			 ImageIcon icon8=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\jobs.jpg");
			Image img8=icon8.getImage();
			Image imgscale8=img8.getScaledInstance(lb8.getHeight(),lb8.getWidth(),Image.SCALE_SMOOTH);
			ImageIcon image8=new ImageIcon(imgscale8);
			lb8.setIcon(image8);
		  
		  lb1= new JLabel();	  
		  lb1.setBounds(189, 48, 213, 215);
		 // lb1.setBackground(new Color(240, 240, 240));
		 
		ImageIcon icon1=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\fourth.png");
		 Image img1=icon1.getImage();
		Image imgscale1=img1.getScaledInstance(lb1.getWidth(),lb1.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image1=new ImageIcon(imgscale1);
		lb1.setIcon(image1);
		  
		  lb2 = new JLabel();
		 lb2.setBounds(671, 48, 213, 215);
		  lb1.setBackground(new Color(240, 240, 240));
		 ImageIcon icon2=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\second.png");
		Image img2=icon2.getImage();
		Image imgscale2=img2.getScaledInstance(lb2.getHeight(),lb2.getWidth(),Image.SCALE_SMOOTH);
		ImageIcon image2=new ImageIcon(imgscale2);
		lb2.setIcon(image2);
		  
		
		  lb3 = new JLabel();
		  lb3.setBounds(1123, 47, 213, 215);
		 lb3.setBackground(new Color(240, 240, 240));
			 ImageIcon icon3=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\fifth.png");
			Image img3=icon3.getImage();
			Image imgscale3=img3.getScaledInstance(lb3.getWidth(),lb3.getHeight(),Image.SCALE_DEFAULT);
			ImageIcon image3=new ImageIcon(imgscale3);
			lb3.setIcon(image3);
			
			/*
			 ImageIcon icon4=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\tmu icon.png");
			Image img4=icon4.getImage();
			ImageIcon image4=new ImageIcon(imgscale2);
			 ImageIcon icon5=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\tmu icon.png");
			Image img5=icon5.getImage();*/
			
		//	ImageIcon image5=new ImageIcon(imgscale5);
		  frame.getContentPane().setLayout(null);
		  frame.getContentPane().add(menuBar);

		  frame.getContentPane().add(panel_1);
		  panel_1.setLayout(null);
		  panel_1.add(lb6);
		  panel_1.add(btnNewButton_1_1_2);
		  panel_1.add(lb7);
		  panel_1.add(btnNewButton_2);
		  panel_1.add(lb8);
		  panel_1.add(btnNewButton_2_2);
		  
		  JLabel lb9 = new JLabel();
		  lb9.setBounds(1201, 38, 213, 215);
		//  lb9.setBackground(new Color(240, 240, 240));
		  ImageIcon icon9=  new ImageIcon("C:\\Users\\mohdusman\\eclipse-workspace\\jobportal\\pic\\about.jpg");
			Image img9=icon9.getImage();
			Image imgscale9=img9.getScaledInstance(lb9.getWidth(),lb9.getHeight(),Image.SCALE_SMOOTH);
			ImageIcon image9=new ImageIcon(imgscale9);
			lb9.setIcon(image9);
		  panel_1.add(lb9);
		  
		  JButton btnNewButton_2_1 = new JButton("About");
		  btnNewButton_2_1.setBounds(1201, 282, 213, 33);
		  panel_1.add(btnNewButton_2_1);
		  btnNewButton_2_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		About obj =new About();
		  	}
		  });
		  btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		  frame.getContentPane().add(panel);
		  panel.setLayout(null);
		  panel.add(lb1);
		  panel.add(btnNewButton_1);
		  panel.add(lb2);
		  panel.add(btnNewButton_1_1_1);
		  panel.add(lb3);
		  panel.add(btnNewButton_1_1);
		  
		  JMenuBar menuBar_1 = new JMenuBar();
		  menuBar_1.setBounds(73, 0, 40, 22);
		  menu2 = new JMenu("help  ");
		  JMenuItem itme1 = new JMenuItem("About");
		  itme1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	}
		  });
		  
		  
		  menu2.add(itme1);
		  menuBar_1.add(menu2);
		  frame.getContentPane().add(menuBar_1);
		  
		  JMenuBar mb2=new JMenuBar();
		  mb2.setBounds(40,0,33,22);
		  menu3=new JMenu("Exit");
		  
		  JMenuItem itme4=new JMenuItem("Exit");
		  itme4.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		frame.setVisible(false);
		  	}
		  });
		  JMenuItem itme3 = new JMenuItem("Logout"); 
		  itme3.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		frame.setVisible(false);
		  		Admin_login al=new Admin_login();
		 		al.main(null);
		  	}
		  });
		  menu3.add(itme4);
		  menu3.add(itme3);
		  mb2.add(menu3);
		  frame.getContentPane().add(mb2);
		  
		  JLabel lblJobPortalSystem = new JLabel("Job Portal System");
		  lblJobPortalSystem.setHorizontalAlignment(SwingConstants.CENTER);
		  lblJobPortalSystem.setForeground(new Color(255, 255, 255));
		  lblJobPortalSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		  lblJobPortalSystem.setBackground(Color.WHITE);
		  lblJobPortalSystem.setBounds(0, 0, 1536, 45);
		  frame.getContentPane().add(lblJobPortalSystem);
		  menu1 = new JMenu("exit");
		  
		frame.setVisible(true);
		  frame.setExtendedState(frame.MAXIMIZED_BOTH);
		  
		 
	}
}
