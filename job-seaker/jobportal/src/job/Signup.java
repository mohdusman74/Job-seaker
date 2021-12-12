package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class Signup{

	private JFrame frame;
	private JTextField txtEmployeeSignup;
	private JTextField id;
	private JTextField name;
	private JTextField email;
	private JTextField phonenum;
	private JTextField address;
	private JPasswordField pass;
	private JPasswordField conpass;
	JDateChooser dateChooser;
	JComboBox comboBox3 ,comboBox1,comboBox2;
    Mysqlcl con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
					window.frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void random() {
		Random rd=new Random();
		id.setText("" +rd.nextInt(9999+1));
	}
	
	/**
	 * Create the application.
	 */
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Registration");
		frame.setTitle("Signup");
		frame.setResizable(false);
		frame.setBackground(new Color(176, 224, 230));
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 938, 521);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtEmployeeSignup = new JTextField();
		txtEmployeeSignup.setEditable(false);
		txtEmployeeSignup.setText("Employee signup");
		txtEmployeeSignup.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmployeeSignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtEmployeeSignup.setColumns(10);
		txtEmployeeSignup.setBackground(new Color(95, 158, 160));
		txtEmployeeSignup.setBounds(0, 0, 924, 53);
		frame.getContentPane().add(txtEmployeeSignup);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Signup", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.textHighlightText);
		panel.setBounds(10, 62, 904, 410);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(609, 355, 96, 27);
		panel.add(cancel);
		cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton submit_1 = new JButton("Submit");
		submit_1.setBounds(740, 355, 96, 27);
		panel.add(submit_1);
		submit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=new Mysqlcl();
					String s="INSERT INTO `signup` (`emp_id`, `emp_name`, `email_id`, `phone_num`, `DOB`, `gander`, `state`, `country`, `address`, `password`, `con_password`) "
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement st=con.c.prepareStatement(s);
				st.setString(1, id.getText());
				st.setString(2, name.getText());
				 st.setString(3, email.getText());
				st.setString(4, phonenum.getText());
				 st.setString(5, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText()); 
				 st.setString(6, (String) comboBox3.getSelectedItem());
				 st.setString(7, (String) comboBox1.getSelectedItem());
				 st.setString(8, (String) comboBox2.getSelectedItem());
				st.setString(9, address.getText());
				 st.setString(10, pass.getText());
				 st.setString(11, conpass.getText());
				 int i=st.executeUpdate();
					if(i>0) {
						
						JOptionPane.showMessageDialog(null,"insert data.......");
	     	                frame.setVisible(false);
	     	               Emp_login obj=new Emp_login();
	     	               obj.main(null);
						
					}else{
						
						JOptionPane.showMessageDialog(null,"data not insert......");
						 id.setText("");
	     	                name.setText("");
	     	                email.setText("");
	     	                phonenum.setText("");
	     	                address.setText("");
	     	                pass.setText("");
	     	                conpass.setText("");
					}
				
				
				
				}catch(Exception a) {
					System.out.print("Error"+a.getMessage());
					a.printStackTrace();
				}
			}
		});
		submit_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		comboBox3 = new JComboBox();
		comboBox3.setBounds(167, 353, 220, 30);
		panel.add(comboBox3);
		comboBox3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {"male", "Female"}));
		
		phonenum = new JTextField();
		phonenum.setBounds(165, 231, 227, 27);
		panel.add(phonenum);
		phonenum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phonenum.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone num.");
		lblNewLabel_1_3.setBounds(48, 229, 111, 30);
		panel.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("Email_id");
		lblNewLabel_1_2.setBounds(48, 162, 111, 30);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		email = new JTextField();
		email.setBounds(165, 164, 227, 27);
		panel.add(email);
		email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email.setColumns(10);
		
		name = new JTextField();
		name.setBounds(165, 99, 227, 27);
		panel.add(name);
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("name");
		lblNewLabel_1_1.setBounds(48, 97, 111, 30);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setBounds(48, 31, 111, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		id = new JTextField();
		id.setBounds(165, 33, 227, 27);
		panel.add(id);
		id.setEditable(false);
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(167, 289, 225, 30);
		panel.add(dateChooser);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("DOB");
		lblNewLabel_1_3_2.setBounds(50, 289, 111, 30);
		panel.add(lblNewLabel_1_3_2);
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_5 = new JLabel("Select gander");
		lblNewLabel_1_5.setBounds(48, 353, 111, 30);
		panel.add(lblNewLabel_1_5);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		comboBox1 = new JComboBox();
		comboBox1.setBounds(617, 31, 227, 30);
		panel.add(comboBox1);
		comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Up", "uk", "mp", "dehli"}));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("State");
		lblNewLabel_1_2_1.setBounds(503, 31, 111, 30);
		panel.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Countery");
		lblNewLabel_1_2_1_1.setBounds(503, 106, 111, 30);
		panel.add(lblNewLabel_1_2_1_1);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Address");
		lblNewLabel_1_3_1.setBounds(502, 171, 111, 30);
		panel.add(lblNewLabel_1_3_1);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Password");
		lblNewLabel_1_3_1_1.setBounds(503, 238, 111, 30);
		panel.add(lblNewLabel_1_3_1_1);
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("Con Password");
		lblNewLabel_1_3_1_2.setBounds(503, 295, 111, 30);
		panel.add(lblNewLabel_1_3_1_2);
		lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		address = new JTextField();
		address.setBounds(617, 173, 227, 27);
		panel.add(address);
		address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		address.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(617, 227, 227, 30);
		panel.add(pass);
		
		conpass = new JPasswordField();
		conpass.setBounds(617, 295, 227, 30);
		panel.add(conpass);
		
		comboBox2 = new JComboBox();
		comboBox2.setBounds(617, 108, 227, 30);
		panel.add(comboBox2);
		comboBox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"india", "pakistan", "america"}));
		random();
	}
}
