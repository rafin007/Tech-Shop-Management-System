
public class UserMethods {
	MySql db = new MySql();
	
	public void addToCart(String name, int price, int quantity){
		db.addsToCart(name, price, quantity);
	}
	
	public void viewCart(){
		ProductViewer pv = new ProductViewer();
	}
}
