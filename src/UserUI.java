import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class UserUI extends JFrame implements MenuListener{
	JMenuBar mb = new JMenuBar();
	JMenu inventory = new JMenu("Show Inventory");
	JMenu logout = new JMenu("Log Out");
	JMenu accountInfo = new JMenu("Show Account");
	JLabel welcome = new JLabel("Welcome User");
	JLabel user = new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\admin.jpg"));
	JLabel name = new JLabel("Name");
	JLabel account = new JLabel("Balance");
	
	public UserUI(){
		super("TSIF-Admin");
		setSize(800,600);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\panel_ui.jpg")));   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f1 = new Font("Rockwell",Font.PLAIN,25);
		Font f2 = new Font("Rockwell",Font.PLAIN,17);
		 
		welcome.setFont(f1);
		welcome.setForeground(Color.WHITE);
		welcome.setBounds(50,150,210,25);
		add(welcome);
		
		mb.setBounds(0,1,800,30);
		mb.add(inventory);
		//mb.add(accountInfo);
		mb.add(logout);
		mb.setBackground(Color.WHITE);
		add(mb);
		 
		user.setBounds(50,180,300,360);
		add(user);
		 
		name.setBounds(450,180,60,20);
		name.setForeground(Color.WHITE);
		name.setFont(f2);
		//add(name);
		 
		account.setBounds(450,210,70,20);
		account.setForeground(Color.WHITE);
		account.setFont(f2);
		//add(account);
		
		logout.addMenuListener(this);
		inventory.addMenuListener(this);
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		if(e.getSource()==logout){
			int choice = JOptionPane.showConfirmDialog(null,"Are you sure, you want to Logout?");
			if(choice == JOptionPane.YES_OPTION){
				UserInterface ob1 = new UserInterface();
				dispose();
			}
		}
		else if(e.getSource() == inventory){
			customerProducts p1 = new customerProducts();
			dispose();
		}
		
	}
}
