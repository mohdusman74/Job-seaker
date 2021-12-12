package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.demo.DateChooserPanel;
import oracle.sql.DATE;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddJob {
    Mysqlcl con;
    JDateChooser dateChooser;
	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	JComboBox comboBox;
	private JTextField txtCompanyJob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		AddJob window = new AddJob();
		
	}
	
	public void random() {
		Random rd=new Random();
		tf1.setText("" +rd.nextInt(9999+1));
	}

	/**
	 * Create the application.
	 */
	public AddJob() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Job portal system");
		frame.setResizable(false);
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 50, 831, 529);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Job", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.inactiveCaptionText));
		panel.setBounds(10, 70, 801, 433);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Job", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.inactiveCaptionText));
		panel_1.setBounds(0, 0, 800, 433);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Company Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(29, 60, 104, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblCompanyName_1 = new JLabel("Company name");
		lblCompanyName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyName_1.setBounds(29, 144, 119, 26);
		panel_1.add(lblCompanyName_1);
		
		JLabel lblEmailId_1 = new JLabel("Email id");
		lblEmailId_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailId_1.setBounds(29, 226, 104, 26);
		panel_1.add(lblEmailId_1);
		
		JLabel lblSalery_1 = new JLabel("Location");
		lblSalery_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalery_1.setBounds(29, 311, 104, 26);
		panel_1.add(lblSalery_1);
		
		JLabel lblSelectJob_1 = new JLabel("Select Job");
		lblSelectJob_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectJob_1.setBounds(470, 60, 104, 26);
		panel_1.add(lblSelectJob_1);
		
		JLabel lblSalary_1 = new JLabel("Salary");
		lblSalary_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalary_1.setBounds(470, 144, 104, 26);
		panel_1.add(lblSalary_1);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tf2.getText().trim().isEmpty()&& tf3.getText().trim().isEmpty()&& tf4.getText().trim().isEmpty()
						&& tf5.getText().trim().isEmpty() && tf6.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Field is Empty....");	
				}else{
				try {
				con=new Mysqlcl();
				String sql="INSERT INTO company (`company_id`, `company_name`, `email_id`, `location`, `jobs`, `salary`, `experience`, `date`) VALUES (?,?,?,?,?,?,?,?)";
			
				PreparedStatement st=con.c.prepareStatement(sql);
				st.setString(1, tf1.getText());
				st.setString(2, tf2.getText());
				 st.setString(3, tf3.getText());
				st.setString(4, tf4.getText());
				 st.setString(5, (String) comboBox.getSelectedItem());
				st.setString(6, tf5.getText());
				 st.setString(7, tf6.getText());
				 st.setString(8, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText()); 
				 st.executeUpdate();

					JOptionPane.showMessageDialog(null,"data insert...");
					tf2.setText("");
 	                tf3.setText("");
 	                tf4.setText("");
 	                tf5.setText("");
 	                tf6.setText("");
 	              	
				
				}catch(Exception a) {
					System.out.print("Error"+a.getMessage());
					a.printStackTrace();
				}
			}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBounds(662, 343, 104, 29);
		panel_1.add(btnNewButton_1);
		
		tf1 = new JTextField();
		tf1.setEditable(false);
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf1.setColumns(10);
		tf1.setBounds(166, 54, 180, 25);
		panel_1.add(tf1);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf2.setColumns(10);
		tf2.setBounds(166, 145, 180, 25);
		panel_1.add(tf2);
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf3.setColumns(10);
		tf3.setBounds(166, 227, 180, 25);
		panel_1.add(tf3);
		
		tf4 = new JTextField();
		tf4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf4.setColumns(10);
		tf4.setBounds(166, 312, 180, 25);
		panel_1.add(tf4);
		
		tf5 = new JTextField();
		tf5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf5.setColumns(10);
		tf5.setBounds(584, 145, 180, 25);
		panel_1.add(tf5);
		
		tf6 = new JTextField();
		tf6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf6.setColumns(10);
		tf6.setBounds(584, 226, 180, 25);
		panel_1.add(tf6);
		
		JLabel lblData = new JLabel("Experience");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(470, 226, 104, 26);
		panel_1.add(lblData);
		
		JLabel lblEmailId = new JLabel("Email id");
		lblEmailId.setBounds(29, 226, 104, 26);
		panel_1.add(lblEmailId);
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(470, 144, 104, 26);
		panel_1.add(lblSalary);
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblSelectJob = new JLabel("Select Job");
		lblSelectJob.setBounds(470, 60, 104, 26);
		panel_1.add(lblSelectJob);
		lblSelectJob.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"it", "software", "java"}));
		comboBox.setBounds(584, 55, 180, 26);
		panel_1.add(comboBox);
		
		JLabel lblDate = new JLabel("date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(470, 290, 104, 26);
		panel_1.add(lblDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(586, 287, 180, 29);
		panel_1.add(dateChooser);
		
		JButton btnNewButton_1_1 = new JButton("Cancel");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1_1.setBounds(530, 343, 104, 29);
		panel_1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("Edit details :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(603, 382, 104, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblClick = new JLabel("click");
		lblClick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Job_update obj=new Job_update();
				frame.setVisible(false);
			    
			    
			}
		});
		lblClick.setForeground(Color.BLUE);
		lblClick.setBackground(Color.WHITE);
		lblClick.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblClick.setBounds(716, 382, 50, 26);
		panel_1.add(lblClick);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		lblBack.setForeground(Color.BLUE);
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBack.setBackground(Color.WHITE);
		lblBack.setBounds(716, 10, 50, 26);
		panel_1.add(lblBack);
		
		txtCompanyJob = new JTextField();
		txtCompanyJob.setEditable(false);
		txtCompanyJob.setText("Company Job");
		txtCompanyJob.setHorizontalAlignment(SwingConstants.CENTER);
		txtCompanyJob.setForeground(Color.BLACK);
		txtCompanyJob.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtCompanyJob.setColumns(10);
		txtCompanyJob.setBackground(new Color(95, 158, 160));
		txtCompanyJob.setBounds(0, 0, 831, 60);
		frame.getContentPane().add(txtCompanyJob);
		frame.setUndecorated(true);
		frame.setVisible(true);
		random();
	}
}
