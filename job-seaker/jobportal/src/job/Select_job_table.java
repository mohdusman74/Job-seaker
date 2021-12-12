package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Select_job_table {

	private JFrame frame;
	private JTextField search;
	private JTable table;
	Mysqlcl con;
	private JTable table_1;
	private JTextField textField;
	private JTextField tf3, tf4;
	public String jobid, compname, job,location , empid, empname, empemail;
	private JTextField txtSelectAndShort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	//	Select_job_table window = new Select_job_table();
		
			}
public void select() {
	//select data job_apply
	  try{
          con = new Mysqlcl();
             String sql = "select * from job_apply";
		PreparedStatement st = con.c.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
              rs.close();
              st.close();

          }
		catch(Exception a) {
			a.printStackTrace();
		}
	  //count data job apply
	  try {
			con=new Mysqlcl();
			  String sql = "SELECT count(job_id) FROM `job_apply` WHERE job_id";		 
	            PreparedStatement st = con.c.prepareStatement(sql);
	            ResultSet rs = st.executeQuery();
             while(rs.next()) {
          	   textField.setText(rs.getString("count(job_id)"));
            }
	            rs.close();
	            st.close();
	            con.c.close(); 
			}catch(Exception a) {
				a.printStackTrace();
			}
	  
	  //short list table select data
	  try{
          con = new Mysqlcl();
             String sql = "select * from short_list";
		PreparedStatement st = con.c.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		table_1.setModel(DbUtils.resultSetToTableModel(rs));
              rs.close();
              st.close();

          }
		catch(Exception a) {
			a.printStackTrace();
		}
	  //count tha data in select job table
	  //count data job apply
	  try {
			con=new Mysqlcl();
			  String sql = "SELECT count(job_id) FROM `short_list` WHERE job_id";		 
	            PreparedStatement st = con.c.prepareStatement(sql);
	            ResultSet rs = st.executeQuery();
             while(rs.next()) {
          	   tf3.setText(rs.getString("count(job_id)"));
            }
	            rs.close();
	            st.close();
	            con.c.close(); 
			}catch(Exception a) {
				a.printStackTrace();
			}
	  
	  
}
	public void selectdata() {
		try {
			  con = new Mysqlcl();
	                String sql = "select  *from job_apply where job_id=?";
			PreparedStatement st = con.c.prepareStatement(sql);
			st.setString(1,jobid);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				      //  jobid=rs.getString("job_id");
				        compname=rs.getString("comp_name");
				      //  tf3.setText(compname);
				        job=rs.getString("job");
	                    location=rs.getString("location");
	                    empid=rs.getString("emp_id");
	                    empname=rs.getString("emp_name");
	                    empemail=rs.getString("emp_email");  
	                    
			}
			}catch(Exception a) {
				a.printStackTrace();
			}
		try {
			 if(search.getText().trim().isEmpty()) {
		     JOptionPane.showMessageDialog(null,"you have no select Job_d.");
			 }  else if( jobid!=null){
			  con = new Mysqlcl();
	        String sql = "insert into short_list(job_id, comp_name, job, location, emp_id, emp_name, emp_email) values(?,?,?,?,?,?,?)";
	        PreparedStatement st = con.c.prepareStatement(sql);
			st.setString(1, jobid);
			st.setString(2, compname);
			st.setString(3, job);
			st.setString(4, location);
			st.setString(5, empid);
			st.setString(6, empname);
			st.setString(7, empemail);
			int rs = st.executeUpdate();
	                JOptionPane.showMessageDialog(null, "this Employee short list !!");
	                jobid=null;
		 }else {
			 JOptionPane.showMessageDialog(null," Already selected...");
			}
		}
			 catch(Exception a) {
				a.printStackTrace();
			}
		
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public Select_job_table() {
		initialize();
		select();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(50, 50, 1202, 780);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlightText);
		panel.setBorder(new TitledBorder(null, "Apply_job", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 101, 1167, 265);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 47, 1167, 245);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  int row = table.getSelectedRow();
					jobid=table.getModel().getValueAt(row, 0).toString();
					search.setText(jobid);
			            
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlightText);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Select_Emloyee", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 414, 1167, 301);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 22, 1167, 279);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_1.setViewportView(table_1);
		
		search = new JTextField();
		search.setHorizontalAlignment(SwingConstants.CENTER);
		search.setEditable(false);
		search.setBounds(784, 62, 167, 29);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
		/*JButton btn = new JButton("Search");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 try{
		            con = new Mysqlcl();
		               String sql = "select * from job_apply where concat(job_id, emp_name) like ?";
		          //  String sql = "select *from job_apply";
				PreparedStatement st = con.c.prepareStatement(sql);
			    st.setString(1, "%" + search.getText() + "%");
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
				jobid=rs.getString("job_id");
				tf3.setText(jobid);
				}
				table.setModel(DbUtils.resultSetToTableModel(rs));
		                rs.close();
		                st.close();
		            }
				catch(Exception a) {
					
				}
			}
		});
		btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn.setBounds(818, 34, 103, 25);
		frame.getContentPane().add(btn);
		*/
		JLabel lblNewLabel = new JLabel("select employee");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(660, 68, 126, 23);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(133, 68, 156, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("count apply job :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 68, 126, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(1074, 62, 103, 25);
		frame.getContentPane().add(btnBack);
		
		JButton btnShortlist = new JButton("Short_list");
		btnShortlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectdata();
				con=new Mysqlcl();;
			try {	
				
				
			}catch(Exception a){
				a.printStackTrace();
			}
		  }
		});
		btnShortlist.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnShortlist.setBounds(961, 62, 103, 25);
		frame.getContentPane().add(btnShortlist);
		
		JLabel lblNewLabel_1_2 = new JLabel("Selected Employee");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(20, 376, 156, 28);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		tf3 = new JTextField();
		tf3.setHorizontalAlignment(SwingConstants.CENTER);
		tf3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf3.setEditable(false);
		tf3.setColumns(10);
		tf3.setBounds(156, 380, 165, 24);
		frame.getContentPane().add(tf3);
		
		txtSelectAndShort = new JTextField();
		txtSelectAndShort.setText("Select and Short List");
		txtSelectAndShort.setHorizontalAlignment(SwingConstants.CENTER);
		txtSelectAndShort.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtSelectAndShort.setEditable(false);
		txtSelectAndShort.setColumns(10);
		txtSelectAndShort.setBackground(new Color(95, 158, 160));
		txtSelectAndShort.setBounds(0, -1, 1188, 53);
		frame.getContentPane().add(txtSelectAndShort);
		
		JButton refrash = new JButton("Refreh");
		refrash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Select_job_table obj=new Select_job_table();
			}
		});
		refrash.setFont(new Font("Tahoma", Font.PLAIN, 13));
		refrash.setBounds(1074, 379, 103, 25);
		frame.getContentPane().add(refrash);
		frame.setVisible(true);
		
	}
}
