package job;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Emp_select {

	private JFrame frame;
	private JTable table;
    Mysqlcl con;
    private JTextField tf1;
    private JTextField txtYouHaveSelect;
    public String empid;
	/**
	 * Launch the application.
	 */	public static void main(String[] args) {
		Emp_select window = new Emp_select();
		
	}
	  public void selectdata() {
		  try{
	          con = new Mysqlcl();
	             String sql = "select  *from job_apply where emp_id='"+empid+"' ";
			PreparedStatement st = con.c.prepareStatement(sql);			
			ResultSet rs = st.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

	              rs.close();
	              st.close();

	          }
			catch(Exception a) {
				a.printStackTrace();
			}
		  
		  try {
				con=new Mysqlcl();
				  String sql = "SELECT count(emp_id) FROM job_apply WHERE emp_id=?";		 
		            PreparedStatement st = con.c.prepareStatement(sql);
		            st.setString(1, empid);
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
	  public Emp_select(String str) {
		     empid=str;
			initialize();
			selectdata();
		}
	  
	  
	public Emp_select() {
		initialize();
		selectdata();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 106, 1010, 335);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("your apply job..");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setBounds(10, 60, 125, 22);
		frame.getContentPane().add(lblNewLabel);
		
		tf1 = new JTextField();
		tf1.setEditable(false);
		tf1.setHorizontalAlignment(SwingConstants.CENTER);
		tf1.setFont(new Font("Tahoma", Font.BOLD, 15));
		tf1.setBounds(138, 58, 116, 27);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		lblBack.setForeground(new Color(0, 0, 255));
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblBack.setBounds(949, 63, 61, 33);
		frame.getContentPane().add(lblBack);
		
		txtYouHaveSelect = new JTextField();
		txtYouHaveSelect.setText("you have select job");
		txtYouHaveSelect.setHorizontalAlignment(SwingConstants.CENTER);
		txtYouHaveSelect.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtYouHaveSelect.setEditable(false);
		txtYouHaveSelect.setColumns(10);
		txtYouHaveSelect.setBackground(new Color(95, 158, 160));
		txtYouHaveSelect.setBounds(0, -1, 1011, 53);
		frame.getContentPane().add(txtYouHaveSelect);
		frame.setBounds(100, 100, 1011, 443);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
}
