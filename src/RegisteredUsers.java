import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class RegisteredUsers extends JFrame{
	MySql db = new MySql();
	JLabel title = new JLabel("Registered Users");
	JTable table = new JTable();
	JButton back = new JButton("BACK");
	JButton remove = new JButton("Remove");
	
	public RegisteredUsers(){
		super("Registered Users");
		setSize(801,601);
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\panel_ui.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f1 = new Font("Rockwell",Font.BOLD,20);
		title.setForeground(Color.WHITE);
		title.setFont(f1);
		title.setBounds(290,100,200,50);
		add(title);
		
		table.setModel(db.showRegisteredUsers());
		table.setFillsViewportHeight(true);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.DARK_GRAY);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(50,200,700,150);
		add(jsp);
		
		back.setBounds(50,40,80,40);
		add(back);
		
		remove.setBounds(60,370,90,30);
		add(remove);
		
		
		back.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
						AdminUI au = new AdminUI();
					}
				}
		);
		
		remove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int row = table .getSelectedRow();
				DefaultTableModel model= (DefaultTableModel)table.getModel();

				String selected = model.getValueAt(row, 0).toString();

				            if (row >= 0) {

				                model.removeRow(row);

				                try {
				                    Connection conn = (Connection) 
				                   DriverManager.getConnection("jdbc:mysql://localhost:3306/tfis-database", "root", "");
				                    PreparedStatement ps = conn.prepareStatement("delete from registered_users where Name ='"+selected+"' ");
				                    ps.executeUpdate();
				                }
				                catch (Exception w) {
				                	System.out.println(w);
				                }     
				                
				                JOptionPane.showMessageDialog(null,"User Removed Successfully");
				               
				            }
			}
		});
		
		
		
	}
	
	
	
}
