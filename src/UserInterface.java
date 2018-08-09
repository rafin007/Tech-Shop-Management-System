import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UserInterface extends JFrame implements ActionListener {
	
	
	
	JLabel login = new JLabel("Login Panel");
	
	JButton view_p_button = new JButton("Browse Products");
	JButton admin = new JButton("Admin");
	JButton emp = new JButton("Employee");
	JButton user = new JButton("User");
	JButton reg = new JButton("Up to 20% discount for registered user. Register Now !!!");
	
			public UserInterface(){
				super("Tech Forest IT Solution Management System");
				setSize(800,600);
				setLocationRelativeTo(null);
				setLayout(null);
			    setContentPane(new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\cover_ui.jpg")));
			    setLayout(null);				
			    setVisible(true); 
			    setResizable(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
			/*	name1.setBounds(220, 30, 610, 82);
				name1.setFont(new Font("Monotype Corsiva", Font.BOLD, 32));
				name1.setForeground(Color.RED);
				add(name1);
				
				name2.setBounds(132, 60, 610, 82);
				name2.setFont(new Font("Monotype Corsiva", Font.BOLD, 32));
				name2.setForeground(Color.RED);
				add(name2);
				 */
			    
				login.setBounds(570, 200 , 610, 82);
				login.setFont(new Font("Rockwell", Font.BOLD+Font.ITALIC, 20));
				login.setForeground(Color.WHITE);
				add(login);
				
				view_p_button.setBounds(50,246,240,49);
				view_p_button.setFont(new Font("Rockwell", Font.PLAIN, 20));
				view_p_button.setForeground(Color.BLACK);
				view_p_button.setBackground(Color.LIGHT_GRAY);
				view_p_button.setToolTipText("Click Here To Check Latest Products");
				add(view_p_button);
				
				admin.setBounds(570,267,120,47);
				admin.setFont(new Font("Rockwell", Font.PLAIN, 17));
				admin.setForeground(Color.BLACK);
				admin.setBackground(Color.LIGHT_GRAY);
				add(admin);
				
			/*	emp.setBounds(570,385,120,47);
				emp.setFont(new Font("Rockwell", Font.PLAIN, 17));
				emp.setForeground(Color.BLACK);
				add(emp); */
				
				user.setBounds(570,326,120,47);
				user.setFont(new Font("Rockwell", Font.PLAIN , 17));
				user.setForeground(Color.BLACK);
				user.setBackground(Color.LIGHT_GRAY);
				add(user);
				
				
				reg.setBounds(100,460,500,72);
				reg.setFont(new Font("Rockwell", Font.PLAIN,17 ));
				reg.setForeground(Color.BLACK);
				reg.setBackground(Color.LIGHT_GRAY);
				add(reg);
				
				view_p_button.addActionListener(this);
				admin.addActionListener(this);
				user.addActionListener(this);
				reg.addActionListener(this);
			}
			
			
			public void actionPerformed(ActionEvent event) {
				
				if(event.getSource()==view_p_button){
					Products ob1 = new Products();	
					this.dispose();
					

				}
			else if(event.getSource()==admin){
					AdminPanel ob3 = new AdminPanel();
					this.dispose();
					
				}
			else if(event.getSource()==user){
				UserPanel ob4 = new UserPanel();
				this.dispose();
				 }
			else if(event.getSource()==reg){
				this.dispose();
				NewUser ob5 = new NewUser();
				
					}
				
				
		}		
			
}	
	
	

			
