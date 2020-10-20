package en11;

public class Item {
    private int item_id;
    private String itemname;
    private int price;
    private int stock;

	public Item(int item_id, String itemname, int price, int stock) {
		super();
		this.item_id = item_id;
		this.itemname = itemname;
		this.price = price;
		this.stock = stock;
	}

	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}


    //alertを返すメソッド
    public boolean alert(){
        if(stock<5) return true;
        else return false;
    }

    @Override
    public String toString(){
        String str = "item_id=" + item_id + ", item_name=" + itemname
                + ", price=" + price + ", stock=" + stock +  " ";

        if(alert())
            str += "(品薄)";

        return str;

    }



}