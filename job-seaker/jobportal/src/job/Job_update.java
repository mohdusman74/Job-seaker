package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class Job_update {

	private JFrame frame;
   	Emp_login obj;
   	String s;
   	private JTextField compid;
   	private JTextField compname;
   	private JTextField emailid;
   	private JTextField location;
   	private JTextField salary;
   	private JTextField experience;
   	private JTextField txtUpdateCompanyInformation;
   	Mysqlcl con;
   	private JTextField selectjob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Job_update window = new Job_update();
		
		
	}

	public Job_update() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 100, 868, 449);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Update", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 76, 834, 322);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		compid = new JTextField();
		compid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		compid.setColumns(10);
		compid.setBounds(162, 31, 180, 25);
		panel.add(compid);
		
		compname = new JTextField();
		compname.setEditable(false);
		compname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		compname.setColumns(10);
		compname.setBounds(162, 149, 180, 25);
		panel.add(compname);
		
		emailid = new JTextField();
		emailid.setEditable(false);
		emailid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailid.setColumns(10);
		emailid.setBounds(162, 213, 180, 25);
		panel.add(emailid);
		
		location = new JTextField();
		location.setFont(new Font("Tahoma", Font.PLAIN, 14));
		location.setColumns(10);
		location.setBounds(592, 31, 180, 25);
		panel.add(location);
		
		salary = new JTextField();
		salary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salary.setColumns(10);
		salary.setBounds(592, 173, 180, 25);
		panel.add(salary);
		
		experience = new JTextField();
		experience.setFont(new Font("Tahoma", Font.PLAIN, 14));
		experience.setColumns(10);
		experience.setBounds(592, 254, 180, 25);
		panel.add(experience);
		
		JLabel lblData = new JLabel("Experience");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(478, 254, 104, 26);
		panel.add(lblData);
		
		JLabel lblSalary_1 = new JLabel("Salary");
		lblSalary_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalary_1.setBounds(478, 172, 104, 26);
		panel.add(lblSalary_1);
		
		JLabel lblSelectJob_1 = new JLabel("Select Job");
		lblSelectJob_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectJob_1.setBounds(478, 108, 104, 26);
		panel.add(lblSelectJob_1);
		
		JLabel lblNewLabel_1 = new JLabel("Company Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(25, 37, 104, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblCompanyName_1 = new JLabel("Company name");
		lblCompanyName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyName_1.setBounds(25, 148, 119, 26);
		panel.add(lblCompanyName_1);
		
		JLabel lblEmailId_1 = new JLabel("Email id");
		lblEmailId_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailId_1.setBounds(25, 212, 104, 26);
		panel.add(lblEmailId_1);
		
		JLabel lblSalery_1 = new JLabel("Location");
		lblSalery_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalery_1.setBounds(478, 30, 104, 26);
		panel.add(lblSalery_1);
		
		JButton btnNewButton_1_1 = new JButton("Search");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(compid.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "wrong employee id....");
				 }else {

				try {
					  con = new Mysqlcl();
			                String sql = "select *from company where company_id=?";
					PreparedStatement st = con.c.prepareStatement(sql);

					st.setString(1, compid.getText());
					ResultSet rs = st.executeQuery();
					while (rs.next()) {
			                    compname.setText(rs.getString("company_name"));
			                    emailid.setText(rs.getString("email_id"));
			                    location.setText(rs.getString("location"));
			                    selectjob.setText(rs.getString("jobs"));
			                    salary.setText(rs.getString("salary"));
			                    experience.setText(rs.getString("experience"));
					     }
           					}catch(Exception a) {
						a.printStackTrace();
					}	            	

		        }

			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1_1.setBounds(246, 84, 96, 25);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(location.getText().trim().isEmpty()&& selectjob.getText().trim().isEmpty()&& salary.getText().trim().isEmpty() &&
						experience.getText().trim().isEmpty() && compid.getText().trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"invalid........");
				}else {
				try {
				con=new Mysqlcl();
				String sql="update company set location=?, jobs=?, salary=? , experience=? where  company_id=?";
				PreparedStatement st = con.c.prepareStatement(sql);
				st.setString(1, location.getText());
				st.setString(2, selectjob.getText());
				st.setString(3, salary.getText());
				st.setString(4, experience.getText());
				st.setString(5, compid.getText());
			    st.executeUpdate();
	        	  JOptionPane.showMessageDialog(null, "update data........");
	        	  frame.setVisible(false);
					
				}catch(Exception a)
				{
					a.printStackTrace();
				}
			  }
			}
		});
		btnNewButton_1.setBounds(238, 274, 104, 29);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JButton btnNewButton_1_2 = new JButton("back");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1_2.setBounds(102, 274, 104, 29);
		panel.add(btnNewButton_1_2);
		
		selectjob = new JTextField();
		selectjob.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selectjob.setColumns(10);
		selectjob.setBounds(592, 108, 180, 25);
		panel.add(selectjob);
		
		txtUpdateCompanyInformation = new JTextField();
		txtUpdateCompanyInformation.setText("Update company Information");
		txtUpdateCompanyInformation.setHorizontalAlignment(SwingConstants.CENTER);
		txtUpdateCompanyInformation.setForeground(Color.BLACK);
		txtUpdateCompanyInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtUpdateCompanyInformation.setEditable(false);
		txtUpdateCompanyInformation.setColumns(10);
		txtUpdateCompanyInformation.setBackground(new Color(95, 158, 160));
		txtUpdateCompanyInformation.setBounds(0, 0, 854, 60);
		frame.getContentPane().add(txtUpdateCompanyInformation);
		frame.setVisible(true);
	}
	
}
