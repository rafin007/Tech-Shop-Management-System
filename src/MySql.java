import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


class MySql{  

public void userReg(String name, String email, String password, String gender, String address){
	String sql1= "INSERT INTO `registered_users` (`Name`, `Email`, `Password`, `Gender`, `Address`) VALUES ('"+ name +"', '"+ email +"', '"+ password +"', '"+ gender +"', '"+ address +"')";
	
   Statement stmt=null;
   ResultSet rs = null;
  
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tfis-database","root","");  
		  
		  
		 stmt=con.createStatement();  
		  
		 stmt.executeUpdate(sql1);  
		
		  
		con.close();  
		  
		}catch(Exception e){ System.out.println(e);}  
		  
		}  
	
	
	




public boolean userCheckLogin(String username, String password){
	String sql2= "Select * from `registered_users` where Email = '"+ username +"' and Password='"+ password +"' ";
	
	   Statement stmt=null;
	   ResultSet rs = null;
	   boolean status = false;
	  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/tfis-database","root","");  

			 stmt=con.createStatement();  
 
			 rs = stmt.executeQuery(sql2);    
			
			
			status = rs.next();
			
			
			con.close();
			
			
			}catch(Exception e){ System.out.println(e);}  
			  
			return status;
			
	}

public boolean adminCheckLogin(String username, String password){
		 String sql = "Select * from `admin` where Email = '"+ username +"'and Password = '"+ password +"' ";
		 Statement stmt=null;
		 ResultSet rs = null;
		 boolean status = false;
		 try{
			 Class.forName("com.mysql.jdbc.Driver");  
			 Connection con=DriverManager.getConnection(  
			 "jdbc:mysql://localhost:3306/tfis-database","root","");  
			 stmt=con.createStatement();  
			 rs = stmt.executeQuery(sql);    
			 status = rs.next();
			 con.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
		 return status;
	}

public void addsToCart(String name, int price, int quantity){
	 int newPrice = price * quantity;
	 String sql = "INSERT INTO `invoice` (`Model`, `Price`, `Quantity`) VALUES ('"+ name +"', '"+ newPrice +"', '"+ quantity +"')";
	 Statement stmt = null;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement(); 
		 stmt.executeUpdate(sql);
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
}


 public String[] cpuList(){
	 String sql = "Select * from `cpu_list`";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String list[] = new String[10];
	 int i = 0;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 if(rs.getString("Model")!=null){
				 list[i] = rs.getString("Model");
				 i++;
			 }
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return list;
 }
 
 public String[] gpuList(){
	 String sql = "Select * from `gpu_list`";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String list[] = new String[10];
	 int i = 0;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 if(rs.getString("Model")!=null){
				 list[i] = rs.getString("Model");
				 i++;
			 }
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return list;
 }
 
 public String showCPURegularPrice(String value){
	 String sql = "Select * from `cpu_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Regular Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public String showCPUDiscountedPrice(String value){
	 String sql = "Select * from `cpu_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Discounted Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public String showGPURegularPrice(String value){
	 String sql = "Select * from `gpu_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Regular Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public String showGPUDiscountedPrice(String value){
	 String sql = "Select * from `gpu_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Discounted Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 

 public String[] IOList(){
	 String sql = "Select * from `io_list`";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String list[] = new String[10];
	 int i = 0;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 if(rs.getString("Model")!=null){
				 list[i] = rs.getString("Model");
				 i++;
			 }
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return list;
 }
 
 public String[] printerList(){
	 String sql = "Select * from `printer_list`";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String list[] = new String[10];
	 int i = 0;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 if(rs.getString("Model")!=null){
				 list[i] = rs.getString("Model");
				 i++;
			 }
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return list;
 }
 
 public String[] storageList(){
	 String sql = "Select * from `storage_list`";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String list[] = new String[10];
	 int i = 0;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 if(rs.getString("Model")!=null){
				 list[i] = rs.getString("Model");
				 i++;
			 }
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return list;
 }
 
 public String showPrinterRegularPrice(String value){
	 String sql = "Select * from `printer_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Regular Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public String showIORegularPrice(String value){
	 String sql = "Select * from `io_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Regular Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public String showStorageRegularPrice(String value){
	 String sql = "Select * from `storage_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Regular Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public String showPrinterDiscountedPrice(String value){
	 String sql = "Select * from `printer_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Discounted Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public String showStorageDiscountedPrice(String value){
	 String sql = "Select * from `storage_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Discounted Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public String showIODiscountedPrice(String value){
	 String sql = "Select * from `io_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Discounted Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public String[] RAMList(){
	 String sql = "Select * from `ram_list`";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String list[] = new String[10];
	 int i = 0;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 if(rs.getString("Model")!=null){
				 list[i] = rs.getString("Model");
				 i++;
			 }
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return list;
 }
 
 public String showRAMDiscountedPrice(String value){
	 String sql = "Select * from `ram_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Discounted Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public String showRAMRegularPrice(String value){
	 String sql = "Select * from `ram_list` where Model = '"+ value +"'";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price = new String();
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);    
		 while(rs.next()){
			 price = rs.getString("Regular Price");
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public TableModel viewsCart(){
	 String sql = "Select * from `invoice`";
	 Statement stmt = null;
	 ResultSet rs = null;
	 DefaultTableModel model = new DefaultTableModel(new String[]{"Model","Price","Quantity"}, 0);
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);
		 while(rs.next())
         {
             String col1 = rs.getString("Model");
             String col2 = rs.getString("Price");
             String col3 = rs.getString("Quantity");                                
             model.addRow(new Object[]{col1, col2, col3});
         }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return model;
 }
 
 public String[] totalPrice(){
	 String sql = "Select * from `invoice`";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price[] = new String[20];
	 int i = 0;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);
		 while(rs.next()){
			 if(rs.getString("Price")!=null){
				 price[i] = rs.getString("Price");
				 i++;
			 }
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public void checkOut(){
	 String sql = "DELETE FROM `invoice` WHERE 1";
	
	 Statement stmt = null;
	 ResultSet rs = null;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 stmt.executeUpdate(sql);
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }
 
 public TableModel showRegisteredUsers(){
	 String sql = "Select * from `registered_users`";
	 Statement stmt = null;
	 ResultSet rs = null;
	 DefaultTableModel model = new DefaultTableModel(new String[]{"Name","Email","Password","Gender","Address"}, 0);
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);
		 while(rs.next())
         {
             String col1 = rs.getString("Name");
             String col2 = rs.getString("Email");
             String col3 = rs.getString("Password");
             String col4 = rs.getString("Gender");
             String col5 = rs.getString("Address");
             model.addRow(new Object[]{col1, col2, col3, col4, col5});
         }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return model;
 }
 
 public void removeProduct(String sql){
	 Statement stmt = null;
	 ResultSet rs = null;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 stmt.executeUpdate(sql);
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }
 
 public void addProduct(String sql){
	 Statement stmt = null;
	 ResultSet rs = null;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 stmt.executeUpdate(sql);
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }
 
 public void purchaseHistory(String name, int price, int quantity){
	 int newPrice = price * quantity;
	 String sql = "INSERT INTO `purchase_history` (`Product Model`, `Price`, `Product Quantity`) VALUES ('"+ name +"', '"+ newPrice +"', '"+ quantity +"')";
	 Statement stmt = null;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement(); 
		 stmt.executeUpdate(sql);
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }
 
 public String[] totalSale(){
	 String sql = "Select * from `purchase_history`";
	 Statement stmt = null;
	 ResultSet rs = null;
	 String price[] = new String[50];
	 int i = 0;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);
		 while(rs.next()){
			 if(rs.getString("Price")!=null){
				 price[i] = rs.getString("Price");
				 i++;
			 }
		 }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return price;
 }
 
 public TableModel showHistory(){
	 String sql = "Select * from `purchase_history`";
	 Statement stmt = null;
	 ResultSet rs = null;
	 DefaultTableModel model = new DefaultTableModel(new String[]{"Product Model","Price","Product Quantity"}, 0);
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 rs = stmt.executeQuery(sql);
		 while(rs.next())
         {
             String col1 = rs.getString("Product Model");
             String col2 = rs.getString("Price");
             String col3 = rs.getString("Product Quantity");
             model.addRow(new Object[]{col1, col2, col3});
         }
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return model;
 }
 
 public void clearHistory(){
	 String sql = "DELETE FROM `purchase_history` WHERE 1";
	 Statement stmt = null;
	 ResultSet rs = null;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement();  
		 stmt.executeUpdate(sql);
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }
 
 public int checkQuantity(String sql){
	 Statement stmt = null;
	 ResultSet rs = null;
	 int quantity = 0;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement(); 
		 rs = stmt.executeQuery(sql);
		 while(rs.next()){
			 quantity = rs.getInt("Quantity");
		 }
		 con.close();
	 }catch(Exception e){}
	 
	 return quantity;
}

public void changeQuantity(String sql){
	 Statement stmt = null;
	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/tfis-database","root","");  
		 stmt=con.createStatement(); 
		 stmt.executeUpdate(sql);
		 con.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
}
  
}