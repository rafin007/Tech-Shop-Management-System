import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AdminInventory extends JFrame implements ActionListener{
	private JButton gpu = new JButton("Graphics Card");
	private JButton cpu = new JButton("Processor");
	private JButton printers = new JButton("Printers");
	private JButton component = new JButton("I/O device");
	private JButton memory = new JButton("RAM");
	private JButton flashdrive = new JButton("Storage device"); 
	
	private JLabel cpu_l = new JLabel();
	private JLabel gpu_l = new JLabel();
	private JLabel hdd_l = new JLabel();
	private JLabel printer_l = new JLabel();
	private JLabel component_l = new JLabel();
	private JLabel memory_l = new JLabel();
	private JButton menu = new JButton("MENU");
	
	public AdminInventory(){
		super("TSIF-Admin");
		setSize(800,600);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\panel_ui.jpg")));   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cpu.setBounds(137,145,108,51);
		
		cpu.setFont(new Font("Rockwell", Font.ITALIC, 15));
		
		cpu.setToolTipText("Most Upgraded Intel & AMD CPU are now on TFIS ! Check now !! ");
		add(cpu);
		
		gpu.setBounds(305,145,120,51);
		gpu.setToolTipText("Info: We have best branded GPU models click here for view the latest GPU Products");
		add(gpu);
		
		flashdrive.setBounds(470,145,120,51);
		flashdrive.setToolTipText("We have Internal or External Harddisk,SSD,Pendrive many more, Click for more");
		add(flashdrive);
		
		printers.setBounds(137,350,108,51);
		printers.setToolTipText("Latest Printers at low price ! click here for more");
		add(printers);
		
		component.setBounds(302,350,108,51);
		component.setToolTipText("Keyboard,Mouse,DVD Drive etc.  Check now ! ");
		add(component);
		
		memory.setBounds(467,350,108,51);
		memory.setToolTipText("Latest DDR4 memory are available now");
		add(memory);
		
		cpu_l.setBounds(137,15,120,120);
		cpu_l.setIcon(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\cpu.jpg"));
		add(cpu_l);
		
		gpu_l.setBounds(305,15,150,150);
		gpu_l.setIcon(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\gpu.jpg"));
		add(gpu_l);
		
		hdd_l.setBounds( 470, 15, 120, 120);
		hdd_l.setIcon(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\hdd.jpg"));
		add(hdd_l);
		
		printer_l.setBounds(137, 220, 120, 120);
		printer_l.setIcon(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\printer.jpg"));
		add(printer_l);
		
		component_l.setBounds(302, 220, 120, 120);
		component_l.setIcon(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\io.jpg"));
		add(component_l);
		
		memory_l.setBounds( 467, 220 , 120, 120);
		memory_l.setIcon(new ImageIcon("C:\\Users\\Fahim\\workspace\\ShopManagement\\src\\icon\\ram.jpg"));
		add(memory_l);
		
		menu.setBounds(50,40,80,40);
		menu.setBackground(Color.LIGHT_GRAY);
		add(menu);
		
		menu.addActionListener(this);
		cpu.addActionListener(this);
		gpu.addActionListener(this);
		flashdrive.addActionListener(this);
		printers.addActionListener(this);
		component.addActionListener(this);
		memory.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==cpu){
			this.dispose();
			AdminCPU c = new AdminCPU();
		}
		else if(event.getSource()==gpu){
			this.dispose();
			AdminGPU g = new AdminGPU();
		}
		else if(event.getSource()==memory){
			this.dispose();
			AdminRAM r = new AdminRAM();
		}
		else if(event.getSource()==printers){
			this.dispose();
			AdminPrinter p = new AdminPrinter();
		}
		else if(event.getSource()==flashdrive){
			this.dispose();
			AdminStorage s = new AdminStorage();
		}
		else if(event.getSource()==component){
			this.dispose();
			AdminIO io = new AdminIO();
		}
		else if(event.getSource() == menu){
			this.dispose();
			AdminUI au = new AdminUI();
		}
	}
}