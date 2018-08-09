import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class PurchaseHistory extends JFrame{
	MySql db = new MySql();
	JLabel title = new JLabel("Purchase History");
	JTable table = new JTable();
	JButton back = new JButton("BACK");
	JButton clear = new JButton("Clear History");
	
	public PurchaseHistory(){
		 super("TSIF-Admin");
		 setSize(800,600);
		 setContentPane(new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\panel_ui.jpg")));   
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setLayout(null);
		 setLocationRelativeTo(null);
		 setVisible(true);
		 setResizable(false);	
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 Font f1 = new Font("Rockwell",Font.BOLD,20);
		 title.setForeground(Color.WHITE);
		 title.setFont(f1);
		 title.setBounds(290,100,200,50);
		 add(title);
		 
		 table.setModel(db.showHistory());
		 table.setFillsViewportHeight(true);
		 table.setForeground(Color.WHITE);
		 table.setBackground(Color.DARK_GRAY);
		 JScrollPane jsp = new JScrollPane(table);
		 jsp.setBounds(100,200,600,250);
		 add(jsp);
		 
		 back.setBounds(50,40,80,40);
		 add(back);
		 
		 back.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							dispose();
							AdminUI au = new AdminUI();
						}
					}
		 );
		 
		 clear.setBounds(320,500,170,40);
		 clear.setBackground(Color.LIGHT_GRAY);
		 add(clear);
		 
		 clear.addActionListener(
				 new ActionListener(){
					 	public void actionPerformed(ActionEvent event){
					 		int choice = JOptionPane.showConfirmDialog(null,"Are you sure, you want to delete History?");
					 		if(choice == JOptionPane.YES_OPTION){
					 			db.clearHistory();
					 			JOptionPane.showMessageDialog(null,"History deleted!");
						 		dispose();
						 		PurchaseHistory ph = new PurchaseHistory();
					 		}
					 	}
				 }
		 );
	}
}
