import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class AdminUI extends JFrame implements MenuListener{
	MySql db = new MySql();
	JMenuBar mb = new JMenuBar();
	JMenu inventory = new JMenu("Show Inventory");
	JMenu history = new JMenu("Purchase History");
	JMenu logout = new JMenu("Log Out");
	JMenu showUser = new JMenu("Show Registered Customers");
	JLabel welcome = new JLabel("Welcome Admin");
	JLabel admin = new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\admin.jpg"));
	JLabel account = new JLabel("Total Sale:");
	JLabel money = new JLabel();
	String[] price = db.totalSale();
	Integer totalSum = 0;
	int[] totalSale = new int[50];
	
 public AdminUI(){
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
	 mb.add(showUser);
	 mb.add(history);
	 mb.add(logout);
	 mb.setBackground(Color.WHITE);

	 add(mb);
	 
	 admin.setBounds(50,180,300,360);
	 add(admin);
	 
	 account.setBounds(450,210,100,20);
	 account.setForeground(Color.WHITE);
	 account.setFont(f2);
	 add(account);
	 
	 logout.addMenuListener(this);
	 inventory.addMenuListener(this);
	 showUser.addMenuListener(this);
	 history.addMenuListener(this);
	 
	 try{
		 for(int i=0; i<price.length; i++){
			 totalSale[i] = Integer.parseInt(price[i]);
		 }
	 }catch(Exception e){}
	 
	 for(int i=0; i<totalSale.length; i++){
		 totalSum += totalSale[i];
	 }
	 
	 money.setBounds(560,210,150,20);
	 money.setForeground(Color.WHITE);
	 money.setFont(f2);
	 money.setText(totalSum.toString()+" BDT");
	 add(money);
  }
 
 public void menuSelected(MenuEvent event){
	 if(event.getSource()==logout){
		 int choice = JOptionPane.showConfirmDialog(null,"Are you sure, you want to Logout?");
		 if(choice == JOptionPane.YES_OPTION){
			 UserInterface ob1 = new UserInterface();
			 dispose();
		 }
	 }
	 else if(event.getSource() == inventory){
		 AdminInventory ai = new AdminInventory();
		 dispose();
	 }
	 else if(event.getSource() == showUser){
		 RegisteredUsers ru = new RegisteredUsers();
		 dispose();
	 }
	 else if(event.getSource() == history){
		 PurchaseHistory ph = new PurchaseHistory();
		 dispose();
	 }
  }


 @Override
 public void menuCanceled(MenuEvent arg0) {
	// TODO Auto-generated method stub
	
  }


 @Override
 public void menuDeselected(MenuEvent arg0) {
	// TODO Auto-generated method stub
	
 	}
}
	 
	 
	 
 
 
 


