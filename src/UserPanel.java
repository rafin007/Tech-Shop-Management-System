
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


class UserPanel extends JFrame{ 
	MySql db = new MySql();
    JButton BackButton = new JButton("BACK");
    JButton LoginButton = new JButton("LOGIN");
    JLabel LoginPanelLabel = new JLabel("USER LOGIN PANEL");
	JLabel label2 = new JLabel("Please Enter Your Username and Password");
	JLabel LabelUsername = new JLabel("Username");
	JLabel LabelPassword = new JLabel("Password");
	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JButton ForgetPassword = new JButton("Forgot Password ?");
	
	

	public UserPanel(){
		super("TSIF-User-Login");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\panel_ui.jpg")));   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(BackButton);
		add(LoginButton);
		add(LoginPanelLabel);
		add(LabelUsername);
		add(LabelPassword);
		add(ForgetPassword);
		add(username);
		add(password);
		add(label2);
		
		username.setBackground(Color.LIGHT_GRAY);
		password.setBackground(Color.LIGHT_GRAY);
		BackButton.setBackground(Color.LIGHT_GRAY);
		LoginButton.setBackground(Color.LIGHT_GRAY);
		ForgetPassword.setBackground(Color.LIGHT_GRAY);
		
		Font f = new Font("Rockwell",Font.BOLD,17);
		Font f1 = new Font("Rockwell",Font.PLAIN,15);
		Font f2 = new Font("Rockwell",Font.PLAIN,25);
		label2.setForeground(Color.WHITE);
		label2.setFont(f);
		LoginPanelLabel.setForeground(Color.WHITE);
		LoginPanelLabel.setFont(f2);
		LabelUsername.setForeground(Color.WHITE);
		LabelUsername.setFont(f1);
		LabelPassword.setForeground(Color.WHITE);
		LabelPassword.setFont(f1);
		
		BackButton.setBounds(50,40,80,40);
		LoginPanelLabel.setBounds(280,60,500,50);
		label2.setBounds(210,150,500,50);
		
		LabelUsername.setBounds(200,250,80,30);
		username.setBounds(300,255,200,30);
		LabelPassword.setBounds(200,300,80,30);
		password.setBounds(300,300,200,30);
		
		LoginButton.setBounds(350,380,80,40); 
		ForgetPassword.setBounds(310,440,150,30);
		
		BackButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
						UserInterface u = new UserInterface();
					}
				}
		);
	 

	LoginButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){

				if(db.userCheckLogin(username.getText(), new String(password.getPassword()))==true){
					UserUI u = new UserUI();
					dispose();
				}else{
					JOptionPane.showMessageDialog(null,"Incorrect Username or Password!");
				}
		}
		
		
	});
	
	}



}
	
	 
	  