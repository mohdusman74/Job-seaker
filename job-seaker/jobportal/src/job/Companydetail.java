package job;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Companydetail {
    
	Mysqlcl con;
	private JFrame frmDetails;
	private JTextField search;
	private JTable table;
	private JTextField txtCompanyDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Companydetail window = new Companydetail();
	
	}

	/**
	 * Create the application.
	 */
	public void show() {
		try {
			con=new Mysqlcl();
		    String sql = "select * from company";
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
	
	
	public Companydetail() {
		initialize();
		show();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDetails = new JFrame();
		frmDetails.setResizable(false);
		frmDetails.setTitle("Details");
		frmDetails.getContentPane().setEnabled(false);
		frmDetails.getContentPane().setBackground(SystemColor.activeCaption);
		frmDetails.setBounds(100, 100, 1114, 589);
		frmDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDetails.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBorder(new TitledBorder(null, "company Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 78, 1091, 491);
		frmDetails.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 1071, 412);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// int row = table.getSelectedRow();
				//	search.setText(table.getModel().getValueAt(row, 0).toString());
			            
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		search = new JTextField();
		search.setBounds(673, 10, 279, 25);
		panel.add(search);
		search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		search.setColumns(10);
		
		JButton btn2 = new JButton("Search");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=new Mysqlcl();
				    String sql = "select * from company where concat(company_id) like ?";
					
					//  String sql = "select *from company";
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
		btn2.setBounds(962, 10, 119, 25);
		panel.add(btn2);
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("back");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frmDetails.setVisible(false);
			}
		});
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 21, 88, 25);
		panel.add(lblNewLabel);
		
		txtCompanyDetails = new JTextField();
		txtCompanyDetails.setEditable(false);
		txtCompanyDetails.setText("Job List");
		txtCompanyDetails.setHorizontalAlignment(SwingConstants.CENTER);
		txtCompanyDetails.setForeground(Color.BLACK);
		txtCompanyDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtCompanyDetails.setColumns(10);
		txtCompanyDetails.setBackground(new Color(95, 158, 160));
		txtCompanyDetails.setBounds(0, 0, 1114, 60);
		frmDetails.getContentPane().add(txtCompanyDetails);
		frmDetails.setUndecorated(true);
		frmDetails.setVisible(true);
	
	}
}
