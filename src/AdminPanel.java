
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


class AdminPanel extends JFrame{ 
	MySql db = new MySql();
    JButton BackButton = new JButton("BACK");
    JButton LoginButton = new JButton("LOGIN");
    JLabel LoginPanelLabel = new JLabel("ADMIN LOGIN PANEL");
	JLabel label2 = new JLabel("Please Enter Your Username and Password");
	JLabel LabelUsername = new JLabel("Username");
	JLabel Password = new JLabel("Password");
	JTextField TextFieldUsername = new JTextField();
	JPasswordField TextFieldPassword = new JPasswordField();
	JButton ForgetPassword = new JButton("Forgot Password ?");
	

	public AdminPanel(){
		super("TSIF-Admin-Login");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\panel_ui.jpg")));   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(BackButton);
		add(LoginButton);
		add(LoginPanelLabel);
		add(LabelUsername);
		add(Password);
		add(ForgetPassword);
		add(TextFieldUsername);
		add(TextFieldPassword);
		add(label2);
		
		TextFieldUsername.setBackground(Color.LIGHT_GRAY);
		TextFieldPassword.setBackground(Color.LIGHT_GRAY);
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
		Password.setForeground(Color.WHITE);
		Password.setFont(f1);
		
		BackButton.setBounds(50,40,80,40);
		LoginPanelLabel.setBounds(280,60,500,50);
		label2.setBounds(210,150,500,50);
		
		LabelUsername.setBounds(200,250,80,30);
		TextFieldUsername.setBounds(300,255,200,30);
		Password.setBounds(200,300,80,30);
		TextFieldPassword.setBounds(300,300,200,30);
		
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
		
		LoginButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						if(db.adminCheckLogin(TextFieldUsername.getText(), new String(TextFieldPassword.getPassword())) == true){
							dispose();
							AdminUI u = new AdminUI();
						}else{
							JOptionPane.showMessageDialog(null,"Incorrect Username or Password!");
						}
					}
				}
		);
	 }
	 
}	  