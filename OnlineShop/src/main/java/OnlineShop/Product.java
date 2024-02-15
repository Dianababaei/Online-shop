package OnlineShop;

public class Product {
    private int id,price;
    private String name,tag;
    private String seller_name;
    public Product(int i,int p,String n,String t){
        this.id=i;
        this.price=p;
        this.name=n;
        this.tag=t;
    }
    public String getSeller_name() {
        return seller_name;
    }
    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
