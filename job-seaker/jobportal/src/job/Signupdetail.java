package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signupdetail {

	private JFrame frame;
	private JTable table;
	Mysqlcl con;
	private JTextField tf1;
	private JTextField txtSignupDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signupdetail window = new Signupdetail();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public void show() {
	try {
		con=new Mysqlcl();

		  String sql = "select *from signup";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

           table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close(); 
	
		}catch(Exception a) {
			a.printStackTrace();
		}
}
	/**
	 * Create the application.
	 */
	public Signupdetail() {
		initialize();
		show();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(143, 188, 143));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 100, 1162, 642);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "SignupDetails", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 71, 1134, 551);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 1114, 468);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		tf1 = new JTextField();
		tf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		tf1.setEditable(false);
		tf1.setFont(new Font("Tahoma", Font.BOLD, 15));
		tf1.setBounds(136, 20, 165, 27);
		panel.add(tf1);
		tf1.setColumns(10);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(1030, 20, 94, 27);
		panel.add(btnBack);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Total signed");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					con=new Mysqlcl();
					  String sql = "SELECT count(emp_id) FROM `signup` WHERE emp_id";
							 
			            PreparedStatement st = con.c.prepareStatement(sql);
			            ResultSet rs = st.executeQuery();
                       while(rs.next()) {
                    	   tf1.setText(rs.getString("count(emp_id)"));
                      }
			           
			            rs.close();
			            st.close();
			            con.c.close(); 
				
					}catch(Exception a) {
						a.printStackTrace();
					}
			}
		});
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBackground(Color.BLUE);
		lblNewLabel_1_1_1.setBounds(10, 21, 113, 26);
		panel.add(lblNewLabel_1_1_1);
		
		txtSignupDetails = new JTextField();
		txtSignupDetails.setEditable(false);
		txtSignupDetails.setText("Signup Details");
		txtSignupDetails.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignupDetails.setForeground(Color.BLACK);
		txtSignupDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtSignupDetails.setColumns(10);
		txtSignupDetails.setBackground(new Color(95, 158, 160));
		txtSignupDetails.setBounds(0, 1, 1170, 60);
		frame.getContentPane().add(txtSignupDetails);
		frame.setUndecorated(true);
	}
}
