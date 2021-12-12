package job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class About {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		About window = new About();
		
		}

	/**
	 * Create the application.
	 */
	public About() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.getContentPane().setLayout(null);
		
		JLabel lblJobPortalSystem = new JLabel("Job Portal System");
		lblJobPortalSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblJobPortalSystem.setForeground(Color.WHITE);
		lblJobPortalSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblJobPortalSystem.setBackground(Color.WHITE);
		lblJobPortalSystem.setBounds(0, 0, 898, 45);
		frame.getContentPane().add(lblJobPortalSystem);
		
		JLabel lblThisProjectjob = new JLabel("this project (Job portal System) ");
		lblThisProjectjob.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisProjectjob.setForeground(Color.WHITE);
		lblThisProjectjob.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThisProjectjob.setBackground(Color.WHITE);
		lblThisProjectjob.setBounds(0, 90, 898, 215);
		frame.getContentPane().add(lblThisProjectjob);
		frame.setBounds(200, 200, 912, 577);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
