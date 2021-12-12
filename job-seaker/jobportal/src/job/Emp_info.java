package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;


import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Emp_info {

	private JFrame frame;
	Mysqlcl con;
	private JTextField email;
	private JTextField empname;
	private JTextField empid;
	private JTextField college12;
	private JTextField collegeug;
	private JTextField college10;
	JDateChooser ug ,class12, class10;
	JComboBox comboBox2,comboBox3, comboBox4, comboBox5, comboBox6, comboBox7;
	private JTextField txtAddInformation;
	private JTextField comboBox1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Emp_info window = new Emp_info();
			}

	/*public Emp_info(String st) {
		
		initialize();
	}*/

	
	public Emp_info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Add Information");
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 50, 968, 619);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("AddInformation");
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 63, 945, 546);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmployeeName = new JLabel("Employee name");
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeName.setBounds(27, 72, 119, 26);
		panel.add(lblEmployeeName);
		
		JLabel lblNewLabel_1 = new JLabel("Employee id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(27, 23, 104, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblEmailId_1 = new JLabel("Email id");
		lblEmailId_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailId_1.setBounds(27, 120, 104, 26);
		panel.add(lblEmailId_1);
		
		JLabel lblAddress = new JLabel("country");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(27, 172, 104, 26);
		panel.add(lblAddress);
		
		email = new JTextField();
		email.setEditable(false);
		email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(164, 121, 180, 25);
		panel.add(email);
		
		empname = new JTextField();
		empname.setEditable(false);
		empname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		empname.setColumns(10);
		empname.setBounds(164, 73, 180, 25);
		panel.add(empname);
		
		empid = new JTextField();
		empid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		empid.setColumns(10);
		empid.setBounds(164, 24, 180, 25);
		panel.add(empid);
		
		JLabel lblCompanyName_1 = new JLabel("college");
		lblCompanyName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyName_1.setBounds(511, 120, 119, 26);
		panel.add(lblCompanyName_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("course");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(511, 72, 104, 26);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblEmailId_1_1 = new JLabel("percentage");
		lblEmailId_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailId_1_1.setBounds(511, 172, 104, 26);
		panel.add(lblEmailId_1_1);
		
		JLabel lblCourse = new JLabel("course");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourse.setBounds(27, 263, 104, 26);
		panel.add(lblCourse);
		
		college12 = new JTextField();
		college12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		college12.setColumns(10);
		college12.setBounds(648, 121, 180, 25);
		panel.add(college12);
		
		JLabel lblSalery_1_1 = new JLabel("UG & PG ");
		lblSalery_1_1.setForeground(Color.BLUE);
		lblSalery_1_1.setBackground(Color.BLUE);
		lblSalery_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSalery_1_1.setBounds(27, 227, 104, 26);
		panel.add(lblSalery_1_1);
		
		JLabel lblSalery_1_2 = new JLabel("college");
		lblSalery_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalery_1_2.setBounds(27, 319, 104, 26);
		panel.add(lblSalery_1_2);
		
		JLabel lblSalery_1_3 = new JLabel("percentage");
		lblSalery_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalery_1_3.setBounds(27, 371, 104, 26);
		panel.add(lblSalery_1_3);
		
		JLabel lblSalery_1 = new JLabel("year");
		lblSalery_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalery_1.setBounds(27, 426, 104, 26);
		panel.add(lblSalery_1);
		
		JLabel lblCompanyName_1_1 = new JLabel("10+2th & diploma");
		lblCompanyName_1_1.setForeground(Color.BLUE);
		lblCompanyName_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCompanyName_1_1.setBounds(511, 23, 170, 26);
		panel.add(lblCompanyName_1_1);
		
		JLabel lblCompanyName_1_2 = new JLabel("10th class");
		lblCompanyName_1_2.setForeground(Color.BLUE);
		lblCompanyName_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCompanyName_1_2.setBounds(511, 269, 119, 26);
		panel.add(lblCompanyName_1_2);
		
		JLabel lblCompanyName_1_3 = new JLabel("year");
		lblCompanyName_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyName_1_3.setBounds(511, 221, 119, 26);
		panel.add(lblCompanyName_1_3);
		
		JLabel lblCompanyName_1_4 = new JLabel("course");
		lblCompanyName_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyName_1_4.setBounds(511, 337, 119, 26);
		panel.add(lblCompanyName_1_4);
		
		JLabel lblCompanyName_1_5 = new JLabel("college");
		lblCompanyName_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyName_1_5.setBounds(511, 389, 119, 26);
		panel.add(lblCompanyName_1_5);
		
		JLabel lblCompanyName_1_6 = new JLabel("percentage");
		lblCompanyName_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyName_1_6.setBounds(511, 444, 119, 26);
		panel.add(lblCompanyName_1_6);
		
		JLabel lblCompanyName_1_7 = new JLabel("year");
		lblCompanyName_1_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyName_1_7.setBounds(511, 489, 119, 26);
		panel.add(lblCompanyName_1_7);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=new Mysqlcl();
					String s="INSERT INTO `emp_info` (`emp_id`, `emp_name`, `email_id`,`ug_course`, `ug_college`, `ug_per`, `ug_year`, `course_12`, `college_12`, `per_12`, "
							+ "`year_12`, `course_10`, `college_10`, `per_10`, `year_10`, `country`)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+comboBox1.getText()+"')";
							
                     PreparedStatement st=con.c.prepareStatement(s);
					st.setString(1, empid.getText());
					st.setString(2, empname.getText());
					 st.setString(3, email.getText());
					//st.setString(4, comboBox1.getText());
					st.setString(4, (String) comboBox2.getSelectedItem() );
					 st.setString(5, collegeug.getText());
					st.setString(6, (String) comboBox3.getSelectedItem() );
					st.setString(7, ((JTextField) ug.getDateEditor().getUiComponent()).getText()); 
					st.setString(8, (String) comboBox4.getSelectedItem() );
					st.setString(9, college12.getText());
					st.setString(10, (String) comboBox5.getSelectedItem() );
					st.setString(11, ((JTextField) class12.getDateEditor().getUiComponent()).getText()); 
					 st.setString(12, (String) comboBox6.getSelectedItem());
					 st.setString(13, college10.getText());
					 st.setString(14, (String) comboBox7.getSelectedItem());
					 st.setString(15, ((JTextField) class10.getDateEditor().getUiComponent()).getText()); 
					
					int i=st.executeUpdate();
					
					if(i>0) {
						
						JOptionPane.showMessageDialog(null,"insert data.......");
					}else{
						JOptionPane.showMessageDialog(null,"data not insert......");
					}
					
					}catch(Exception a) {
						System.out.print("Error"+a.getMessage());
						a.printStackTrace();
					}
				}
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(277, 489, 126, 26);
		panel.add(btnNewButton);
		
		collegeug = new JTextField();
		collegeug.setFont(new Font("Tahoma", Font.PLAIN, 14));
		collegeug.setColumns(10);
		collegeug.setBounds(164, 320, 180, 25);
		panel.add(collegeug);
		
		college10 = new JTextField();
		college10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		college10.setColumns(10);
		college10.setBounds(648, 386, 180, 25);
		panel.add(college10);
		
		comboBox4 = new JComboBox();
		comboBox4.setModel(new DefaultComboBoxModel(new String[] {"10+2 ", "Diploma"}));
		comboBox4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox4.setBounds(645, 68, 183, 30);
		panel.add(comboBox4);
		
		comboBox6 = new JComboBox();
		comboBox6.setModel(new DefaultComboBoxModel(new String[] {"10 class"}));
		comboBox6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox6.setBounds(648, 333, 183, 30);
		panel.add(comboBox6);
		
		comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"bca", "b.tech", "m.tech"}));
		comboBox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox2.setBounds(164, 263, 183, 30);
		panel.add(comboBox2);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(128, 489, 126, 26);
		panel.add(btnCancel);
		
		comboBox3 = new JComboBox();
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {"60-65", "65-70", "70-75", "75-80", "80-90", "90-100"}));
		comboBox3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox3.setBounds(164, 371, 183, 30);
		panel.add(comboBox3);
		
		comboBox5 = new JComboBox();
		comboBox5.setModel(new DefaultComboBoxModel(new String[] {"60-65", "65-70", "70-75", "75-80", "80-90", "90-100"}));
		comboBox5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox5.setBounds(648, 172, 183, 30);
		panel.add(comboBox5);
		
		comboBox7 = new JComboBox();
		comboBox7.setModel(new DefaultComboBoxModel(new String[] {"60-65", "65-70", "70-75", "75-80", "80-90", "90-100"}));
		comboBox7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox7.setBounds(648, 431, 183, 30);
		panel.add(comboBox7);
		
		ug = new JDateChooser();
		ug.setBounds(164, 426, 180, 26);
		panel.add(ug);
		
		class10 = new JDateChooser();
		class10.setBounds(648, 489, 180, 26);
		panel.add(class10);
		
	    class12 = new JDateChooser();
		class12.setBounds(648, 227, 180, 26);
		panel.add(class12);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  con = new Mysqlcl();
			                String sql = "select * from signup where emp_id=?";
					PreparedStatement st = con.c.prepareStatement(sql);

					st.setString(1, empid.getText());
					ResultSet rs = st.executeQuery();

					while (rs.next()) {
			                    empname.setText(rs.getString("emp_name"));
			                    email.setText(rs.getString("email_id"));
			                    comboBox1.setText(rs.getString("country"));
					}
					}catch(Exception a) {
						a.printStackTrace();
					}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(354, 23, 85, 26);
		panel.add(btnSearch);


		comboBox1 = new JTextField();
		comboBox1.setEditable(false);
		comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox1.setColumns(10);
		comboBox1.setBounds(164, 173, 180, 25);
		panel.add(comboBox1);
		JLabel lblCompanyName_1_2_1 = new JLabel("Back");
		lblCompanyName_1_2_1.setBounds(875, 10, 60, 26);
		panel.add(lblCompanyName_1_2_1);
		lblCompanyName_1_2_1.setBackground(new Color(255, 255, 255));
		lblCompanyName_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		lblCompanyName_1_2_1.setForeground(new Color(0, 0, 205));
		lblCompanyName_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtAddInformation = new JTextField();
		txtAddInformation.setEditable(false);
		txtAddInformation.setText("Add Information ");
		txtAddInformation.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtAddInformation.setColumns(10);
		txtAddInformation.setBackground(new Color(95, 158, 160));
		txtAddInformation.setBounds(0, 0, 979, 53);
		frame.getContentPane().add(txtAddInformation);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
}
