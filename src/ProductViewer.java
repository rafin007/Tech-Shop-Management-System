import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProductViewer extends JFrame{
	
	MySql db = new MySql();
	JLabel title = new JLabel("Your Current Cart");
	JTable table = new JTable();
	JButton back = new JButton("BACK");
	JLabel sum = new JLabel("Total: ");
	JLabel total = new JLabel("");
	JButton checkOut = new JButton("Checkout!");
	String[] price = db.totalPrice();
	
	public ProductViewer(){
		super("View Cart");
		setSize(800,600);
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\panel_ui.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f1 = new Font("Rockwell",Font.BOLD,20);
		title.setForeground(Color.WHITE);
		title.setFont(f1);
		title.setBounds(280,100,200,50);
		add(title);
		
		table.setModel(db.viewsCart());
		table.setFillsViewportHeight(true);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.DARK_GRAY);
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(100,200,580,150);
		add(jsp);
		
		sum.setForeground(Color.WHITE);
		sum.setFont(new Font("Rockwell",Font.PLAIN,18));
		sum.setBounds(300,350,70,40);
		add(sum);
		
		Integer totalSum = 0;
		int[] realPrice = new int[20];
		try{
			for(int i=0; i<price.length; i++){
				realPrice[i] = Integer.parseInt(price[i]);
			}
		}catch(Exception e){}
		
		for(int i=0; i<realPrice.length; i++){
			 totalSum += realPrice[i];
		}
		
		total.setForeground(Color.WHITE);
		total.setFont(new Font("Rockwell",Font.PLAIN,18));
		total.setText(totalSum.toString()+" BDT");
		total.setBounds(370,350,130,40);
		add(total);
		
		back.setBounds(50,40,80,40);
		add(back);
		
		back.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
						Products p = new Products();
					}
				}
		);
		
		checkOut.setBounds(320,500,130,40);
		checkOut.setBackground(Color.LIGHT_GRAY);
		add(checkOut);
		
		checkOut.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int choice = JOptionPane.showConfirmDialog(null,"Are you sure, you want to Checkout?");
						if(choice == JOptionPane.YES_OPTION){
							JOptionPane.showMessageDialog(null,"Thank you for shopping with us!");
							db.checkOut();
							dispose();
							UserInterface u1 = new UserInterface();
						}
					}
				}
		);
	}
}