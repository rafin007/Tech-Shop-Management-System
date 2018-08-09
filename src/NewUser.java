import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class NewUser extends JFrame{
	MySql db = new MySql ();
	JLabel label1 = new JLabel("Get upto 20% discount!!");
	JLabel name = new JLabel("Name *");
	JLabel email = new JLabel("Email *");
	JLabel pass = new JLabel("New Password *");
	JLabel confirmPass = new JLabel("Confirm Password *");
	JLabel address = new JLabel("Enter Address");
	JTextField enterName = new JTextField(20);
	JTextField enterEmail = new JTextField(20);
	JTextArea enterAddress = new JTextArea();
	JPasswordField enterPass = new JPasswordField();
	JPasswordField enterPass2 = new JPasswordField();
	JButton back = new JButton("BACK");
	JButton register = new JButton("SIGN ME UP!!");
	JLabel gender = new JLabel("Select Gender *");
	JLabel message = new JLabel("* Fields are mandatory");
	String[] comboListSex = {
	         "Male",
	         "Female",
	         "Other"
	};
	JComboBox genderList;
	
	public NewUser(){
		super("TSIF-User Registration");
		setSize(800,600);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\panel_ui.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f1 = new Font("Rockwell",Font.BOLD+Font.ITALIC,30);
		Font f2 = new Font("Rockwell",Font.PLAIN,16);
		//Font f3 = new Font("Rockwell",Font.PLAIN,15);
		genderList = new JComboBox(comboListSex);
		
		genderList.setBounds(270,287,80,20);
		add(genderList);
		
		label1.setBounds(200,50,350,30);
		label1.setFont(f1);
		label1.setForeground(Color.WHITE);
		add(label1);
		
		name.setBounds(100,120,60,20);
		name.setFont(f2);
		name.setForeground(Color.WHITE);
		add(name);
		
		email.setBounds(100,160,60,20);
		email.setFont(f2);
		email.setForeground(Color.WHITE);
		add(email);
		
		pass.setBounds(100,200,120,20);
		pass.setFont(f2);
		pass.setForeground(Color.WHITE);
		add(pass);
		
		confirmPass.setBounds(100,240,150,20);
		confirmPass.setFont(f2);
		confirmPass.setForeground(Color.WHITE);
		add(confirmPass);
		
		enterName.setBounds(260,120,180,25);
		enterName.setBackground(Color.LIGHT_GRAY);
		add(enterName);
		
		enterEmail.setBounds(260,160,180,25);
		enterEmail.setBackground(Color.LIGHT_GRAY);
		add(enterEmail);
		
		enterPass.setBounds(260,200,180,25);
		enterPass.setBackground(Color.LIGHT_GRAY);
		add(enterPass);
		
		enterPass2.setBounds(260,240,180,25);
		enterPass2.setBackground(Color.LIGHT_GRAY);
		add(enterPass2);
		
		back.setBounds(50,40,80,40);
		back.setBackground(Color.LIGHT_GRAY);
		add(back);
		
		gender.setBounds(100,280,120,20);
		gender.setFont(f2);
		gender.setForeground(Color.WHITE);
		add(gender);
		
		
		
		address.setBounds(100,380,120,20);
		address.setFont(f2);
		address.setForeground(Color.WHITE);
		add(address);
		
		enterAddress.setBounds(260,380,180,40);
		enterAddress.setBackground(Color.LIGHT_GRAY);
		add(enterAddress);
		
		register.setBounds(280,490,120,30);
		register.setBackground(Color.LIGHT_GRAY);
		add(register);
		
		message.setBounds(230,550,240,20);
		message.setFont(f2);
		message.setForeground(Color.WHITE);
		add(message);
		
		back.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						dispose();
						UserInterface u = new UserInterface();
					}
				}
		);
		
		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(enterName.getText()== null || new String(enterPass.getPassword())== null || new String(enterPass2.getPassword())== null || enterEmail.getText()== null){
					JOptionPane.showMessageDialog(null,"Please complete the mandatory fields!");
				}
				if(!new String(enterPass.getPassword()).equals(new String(enterPass2.getPassword()))){
					JOptionPane.showMessageDialog(null,"Password does not match, Please Check and try again");
				}
				else{
					db.userReg(enterName.getText(),enterEmail.getText(),new String(enterPass.getPassword()),genderList.getSelectedItem().toString(), enterAddress.getText());
					JOptionPane.showMessageDialog(null,"Registration Successful , Please Login using your Email and Password");
					UserPanel u = new UserPanel();
					dispose();
				}
		
			}
		});
		
		
	}
	
	public void userDatabase(){
		
		
		
		
	}
	
	
	
}
