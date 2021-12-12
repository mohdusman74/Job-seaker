package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;

public class Emp_detail {

	private JFrame frame;
	private JTable table;
	private JTextField search;
	Mysqlcl con;
	private JTextField txtEmloyeeDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Emp_detail window = new Emp_detail();
			}

	/**
	 * Create the application.
	 */
	public Emp_detail() {
		initialize();
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	public void showtable() {
		try {
			con=new Mysqlcl();
			 String sql = "select * from emp_info;";
	            PreparedStatement st = con.c.prepareStatement(sql);
	            ResultSet rs = st.executeQuery();
	           table.setModel(DbUtils.resultSetToTableModel(rs));
	            rs.close();
	            st.close();
	            con.c.close(); 
			}catch(Exception a) {
				a.printStackTrace();
				showtable();
			}
	
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 50, 1425, 675);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBorder(new TitledBorder(null, "Employee Detail", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 63, 1391, 600);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 59, 1391, 541);
		panel.add(scrollPane);
		
		table = new JTable();
		/*table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				search.setText(table.getModel().getValueAt(row, 0).toString());
			}
		});*/
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		JButton btnShowtable = new JButton("search");
		btnShowtable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					con=new Mysqlcl();
					 String sql = "select * from emp_info where concat(emp_id) like ?";
					 // String sql = "select *from emp_info";
			            PreparedStatement st = con.c.prepareStatement(sql);
			            st.setString(1, "%" + search.getText() + "%");
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
		btnShowtable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShowtable.setBounds(1212, 16, 130, 33);
		panel.add(btnShowtable);
		
		search = new JTextField();
		search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		search.setColumns(10);
		search.setBounds(881, 20, 299, 25);
		panel.add(search);
		
		JLabel lblNewLabel = new JLabel("back");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(27, 20, 67, 25);
		panel.add(lblNewLabel);
		
		txtEmloyeeDetails = new JTextField();
		txtEmloyeeDetails.setText("Emloyee Details");
		txtEmloyeeDetails.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmloyeeDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtEmloyeeDetails.setEditable(false);
		txtEmloyeeDetails.setColumns(10);
		txtEmloyeeDetails.setBackground(new Color(95, 158, 160));
		txtEmloyeeDetails.setBounds(0, 0, 1430, 53);
		frame.getContentPane().add(txtEmloyeeDetails);
		frame.setUndecorated(true);
		frame.setVisible(true);
		showtable();
	}

}
