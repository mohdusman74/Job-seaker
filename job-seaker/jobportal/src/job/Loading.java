package job;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class Loading extends JFrame implements Runnable {

	private JFrame frame;
	private JPanel panel;
	private JProgressBar progressBar;
	int s;
	Loading obj;
	Thread th;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Loading obj1 =new Loading();
		obj1.setUploading();
	}

	///Create the application

	public void setUploading() {
        th.start();
	}
	
	public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    frame.setVisible(false);
            //        Emp_page obj1=new Emp_page();
              //      obj1.main(null);
           		  
                  
                }
                Thread.sleep(50);
            }
        } catch (Exception a) {
       	System.out.println("errror: "+a.getMessage());
	    a.printStackTrace();
        }
     }
	
	public Loading() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 th = new Thread((Runnable) this);
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setTitle("Laoding");
		frame.setBounds(100, 100, 658, 356);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlightText);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Loading", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 626, 298);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbllibraryManagement = new JLabel("Smart Job Portal System");
        lbllibraryManagement.setForeground(new Color(72, 209, 204));
        lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lbllibraryManagement.setBounds(103, 21, 458, 41);
        panel.add(lbllibraryManagement);
	
        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        panel.add(progressBar);

        JLabel lblNewLabel_2 = new JLabel("Please Wait....");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(160, 82, 45));
        lblNewLabel_2.setBounds(244, 82, 125, 27);
        panel.add(lblNewLabel_2);
        
	}
}
