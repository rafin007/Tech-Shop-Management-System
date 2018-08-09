import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AdminRAM extends JFrame{
	MySql db = new MySql();
	JButton back = new JButton("BACK");
	String productList[] = db.RAMList();
	JComboBox productBox = new JComboBox(productList);
	JButton add = new JButton("Add RAM");
	JButton remove = new JButton("Remove RAM");
	String selected = null;
	JLabel title = new JLabel("Add or remove products");
	JLabel pro = new JLabel("SELECT A RAM");
	JLabel model = new JLabel("Product Model");
	JLabel id = new JLabel("Product ID");
	JLabel price = new JLabel("Regular Price");
	JLabel disPrice = new JLabel("Discounted Price");
	JLabel quantity = new JLabel("Product Quantity");
	JLabel info = new JLabel("Add a product below");
	
	JTextField modelText = new JTextField();
	JTextField idText = new JTextField();
	JTextField priceText = new JTextField();
	JTextField disPriceText = new JTextField();
	JTextField quantityText = new JTextField();
	
	//String iText = null;
	//String pText = null;
	String dpText = null;
	String qText = null;
	String mText = null;
	
	int realPrice = 0;
	int realDiscountPrice = 0;
	int realId = 0;
	int realQuantity = 0;
	
	public AdminRAM(){
		setSize(800,600);
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\panel_ui.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		title.setBounds(250,100,250,40);
		title.setFont(new Font("Rockwell",Font.BOLD,20));
		title.setForeground(Color.WHITE);
		add(title);
		
		pro.setBounds(100,160,170,30);
		pro.setForeground(Color.WHITE);
		add(pro);
		
		productBox.setBounds(100,200,200,40);
		productBox.setBackground(Color.LIGHT_GRAY);
		add(productBox);
		
		productBox.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent e){
						selected = String.valueOf(productBox.getSelectedItem());
					}
				}
		);
		
		remove.setBounds(480,200,150,40);
		remove.setBackground(Color.LIGHT_GRAY);
		add(remove);
		
		remove.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int choice = JOptionPane.showConfirmDialog(null,"Are you sure, you want to remove "+selected+"?");
						if(choice == JOptionPane.YES_OPTION){
							String sql = "Delete from `ram_list` where Model = '"+ selected +"'";
							db.removeProduct(sql);
							JOptionPane.showMessageDialog(null,"Product successfully removed!!");
							dispose();
							AdminRAM AR = new AdminRAM();
						}
					}
				}
		);
		
		back.setBounds(50,40,80,40);
		add(back);
		
		back.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
						AdminInventory p = new AdminInventory();
					}
				}
		);
		
		info.setBounds(270,300,200,40);
		info.setFont(new Font("Rockwell",Font.PLAIN,18));
		info.setForeground(Color.WHITE);
		add(info);
		
		id.setForeground(Color.WHITE);
		model.setForeground(Color.WHITE);
		price.setForeground(Color.WHITE);
		quantity.setForeground(Color.WHITE);
		disPrice.setForeground(Color.WHITE);
		
		id.setBounds(70,350,70,20);
		add(id);
		idText.setBounds(70,380,90,30);
		idText.setBackground(Color.LIGHT_GRAY);
		add(idText);
		
		model.setBounds(180,350,120,20);
		add(model);
		modelText.setBounds(180,380,180,30);
		modelText.setBackground(Color.LIGHT_GRAY);
		add(modelText);
		
		price.setBounds(380,350,120,20);
		add(price);
		priceText.setBounds(380,380,100,30);
		priceText.setBackground(Color.LIGHT_GRAY);
		add(priceText);
		
		disPrice.setBounds(500,350,100,20);
		add(disPrice);
		disPriceText.setBounds(500,380,100,30);
		disPriceText.setBackground(Color.LIGHT_GRAY);
		add(disPriceText);
		
		quantity.setBounds(620,350,100,20);
		add(quantity);
		quantityText.setBounds(620,380,100,30);
		quantityText.setBackground(Color.LIGHT_GRAY);
		add(quantityText);
		
		add.setBounds(320,500,120,40);
		add.setBackground(Color.LIGHT_GRAY);
		add(add);
		
		add.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int choice = JOptionPane.showConfirmDialog(null,"Are you sure, you want to add the Product?");
						if(choice == JOptionPane.YES_OPTION){
							mText = modelText.getText();
							try{
								realId = Integer.parseInt(idText.getText());
								realPrice = Integer.parseInt(priceText.getText());
								qText = quantityText.getText();
								realQuantity = Integer.parseInt(qText);
								dpText = disPriceText.getText();
								realDiscountPrice = Integer.parseInt(dpText);
							}catch(Exception e){}
							String sql = "INSERT INTO `ram_list` (`Product ID`, `Model`, `Regular Price`, `Discounted Price`, `Quantity`) VALUES ('"+ realId +"', '"+ mText +"', '"+ realPrice +"', '"+ realDiscountPrice +"', '"+ realQuantity +"')";
							db.addProduct(sql);
							JOptionPane.showMessageDialog(null,"Product successfully added!");
							dispose();
							AdminRAM AR = new AdminRAM();
						}
					}
				}
		);
	}
}
