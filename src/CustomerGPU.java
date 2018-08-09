import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class CustomerGPU extends Products{
	MySql db = new MySql();
	JButton back;
	JButton addCart;
	JButton viewCart;
	Image bg;
	Font font;
	JComboBox cpuBox;
	JLabel info;
	String cpuList[] = db.gpuList();
	JLabel price = new JLabel("Regular Price");
	JTextField rp = new JTextField();
	JLabel price2 = new JLabel("Discounted Price");
	JTextField dp = new JTextField();
	JComboBox quantity;
	String quantityList[] = {"1","2","3","4","5","6","7","8","9","10"};
	JLabel q = new JLabel("SELECT QUANTITY");
	JButton checkOut = new JButton("Checkout!");
	UserMethods um = new UserMethods();
	String x = new String();
	String y = new String();
	String p1 = new String();
	String p2 = new String();
	String productQuantity = new String();
	
	public CustomerGPU(){
		
		setLocationRelativeTo(null);
		setSize(800,600);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\panel_ui.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		font = new Font("Rockwell",Font.BOLD,30);
		Font f1 = new Font("Rockwell",Font.PLAIN,15);
		back = new JButton("BACK");
		back.setBounds(50,40,80,40);
		add(back);
		addCart = new JButton("ADD TO CART");
		addCart.setBounds(630,40,130,40);
		add(addCart);
		viewCart = new JButton("VIEW CART");
		viewCart.setBounds(500,40,100,40);
		add(viewCart);
		//info.setFont(font);
		info = new JLabel("SELECT A GRAPHICS PROCESSOR");
		info.setBounds(50,150,200,40);
		info.setForeground(Color.WHITE);
		add(info);
		cpuBox = new JComboBox(cpuList);
		cpuBox.setBounds(50,200,200,40);
		cpuBox.setForeground(Color.DARK_GRAY);
		add(cpuBox);
		
		price.setBounds(320,240,100,30);
		price.setForeground(Color.WHITE);
		price.setFont(f1);
		add(price);
		
		rp.setBounds(320,280,110,30);
		rp.setBackground(Color.LIGHT_GRAY);
		rp.setEditable(false);
		add(rp);
		
		price2.setBounds(320,320,130,30);
		price2.setForeground(Color.WHITE);
		price2.setFont(f1);
		add(price2);
		
		dp.setBounds(320,360,110,30);
		dp.setBackground(Color.LIGHT_GRAY);
		dp.setEditable(false);
		add(dp);
		
		q.setBounds(550,150,150,40);
		q.setForeground(Color.WHITE);
		add(q);
		
		quantity = new JComboBox(quantityList);
		quantity.setBounds(550,200,50,40);
		quantity.setForeground(Color.DARK_GRAY);
		add(quantity);
		
		checkOut.setBounds(320,500,130,40);
		checkOut.setBackground(Color.LIGHT_GRAY);
		add(checkOut);
		
		back.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
						customerProducts p = new customerProducts();
					}
				}
		);
		
		cpuBox.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						x = String.valueOf(cpuBox.getSelectedItem());
						p1 = db.showGPURegularPrice(x);
						rp.setText(p1);
						y = String.valueOf(cpuBox.getSelectedItem());
						p2 = db.showGPUDiscountedPrice(y);
						dp.setText(p2);
					}
				}
		);
		
		quantity.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						productQuantity = String.valueOf(quantity.getSelectedItem());
					}
				}
		);
		
		addCart.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int disPrice = 0;
						int realQuantity = 0;
						try{
							disPrice = Integer.parseInt(p2);
							realQuantity = Integer.parseInt(productQuantity);
						}catch(Exception e){}
						String sql = "select * from `gpu_list`";
						int currentQuantity = db.checkQuantity(sql);
						int newQuantity = currentQuantity - realQuantity;
						um.addToCart(y,disPrice,realQuantity);
						String sql2 = "UPDATE `gpu_list` SET `Quantity`='"+ newQuantity +"' WHERE Model = '"+ y +"'";
						db.changeQuantity(sql2);
						db.purchaseHistory(y,disPrice,realQuantity);
						JOptionPane.showMessageDialog(null,"Added to Cart!");
					}
				}
		);
		
		
		viewCart.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						um.viewCart();
						dispose();
					}
				}
		);
		
	}
}

