/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package OnlineShop;
import java.util.*;

public class App {
    public static ArrayList<User> users;
    public static ArrayList<Product> products;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        users = new ArrayList<User>();
        products = new ArrayList<Product>();
        MainMenu();
    }
    public static void MainMenu(){
        System.out.println("hello, welcome to out online shop, here's a list of available commands:");
        System.out.println("1: Sign up");
        System.out.println("2: Log in");
        System.out.println("3: Close");
        int a = sc.nextInt();
        switch(a) {
            case 1:
                SignUp();
                break;
            case 2:
                LogIn();              
                break;
            default:
                int x = 0;
          }
    }
    public static void SignUp(){
        sc = new Scanner(System.in);
        String inp = sc.nextLine();
        if(inp.equals("back"))
            MainMenu();
        else{
            String[] splitted = inp.split(" ");
            int found = -1;
            for(User u : users){
                if(u.getUsername().equals(splitted[3])){
                    found = 1;
                    break;
                }
            }
            if(found==1)
                System.out.println("sorry, this username has already been chosen.");
            else{
                users.add(new User(splitted[3],splitted[4],splitted[2],0));
                sc = new Scanner(System.in);
                inp = sc.nextLine();
                if(inp.equals("back"))
                    MainMenu();
            }

        }
    }
    public static void LogIn(){
        sc = new Scanner(System.in);
        String inp = sc.nextLine();
        User user = new User();
        if(inp.equals("back"))
            MainMenu();
        else{
            String[] splitted = inp.split(" ");
            int found = -1;
            if(splitted[2].equals("admin") && splitted[3].equals("admin")){
                ShowAdminMenu();
            } else{
                for(User u : users){
                    if((u.getUsername().equals(splitted[2])) && (u.getPassword().equals(splitted[3]))){
                        found = 1;
                        user = u;
                        break;
                    }
                }
                if(found!=1){
                    System.out.println("sorry, the username or password is wrong.");
                    MainMenu();
                } else {
                    System.out.println("Logged in.");
                    switch(user.getRole()) {
                        case "customer":
                            ShowCustomerMenu(user);
                            break;
                        case "seller":
                            ShowSellerMenu(user);
                            break;
                        default:
                            int x = 0;
                    }
                }
            }
        }
    }
    
    private static void ShowCustomerMenu(User user) {
        System.out.println("list of available commands:");
        System.out.println("1. account info");
        System.out.println("2. add balance");
        System.out.println("3. list of items");
        System.out.println("4. search by tag [tag_name]");
        System.out.println("5. log out");

        int a = sc.nextInt();
        switch(a) {
            case 1:
                PrintUserInfo(user);
                sc = new Scanner(System.in);
                String inp = sc.nextLine();
                if(inp.equals("back"))
                    ShowCustomerMenu(user);
                break;
            case 2:
                AddBalance(user);              
                break;
            case 3:
                ShowListOfProducts(user);
            case 4:
                ShowListOfProductsUsingTag(user);
            case 5:
                MainMenu();
            default:
                int x = 0;
          }
    }
    private static void ShowListOfProducts(User user) {
        for(Product p:products){
            System.out.println(p.getId()+" : "+p.getName()+" "+p.getPrice());
        }
        sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String[] splitted = inp.split(" ");
        if(inp.equals("back"))
            ShowCustomerMenu(user);
        else{
            int found = -1;
            for(Product p:products){
                if((p.getId()+"").equals(splitted[1])){
                    if(user.getBalance()>=p.getPrice()){
                        user.addBalance(-p.getPrice());
                        found = 1;
                        break;
                    }
                    else
                        System.out.println("sorry, you don’t have enough balance to buy this item.");
                }
            }   
            if(found == 1){
                ArrayList<Product> temp = new ArrayList<Product>();
                for(Product p:products){
                    if(!(p.getId()+"").equals(splitted[1])){
                        temp.add(p);
                    }
                }
                products = temp;            
            }
            sc = new Scanner(System.in);
            inp = sc.nextLine();
            if(inp.equals("back"))
                ShowCustomerMenu(user);
            }
    }
    private static void ShowListOfProductsUsingTag (User user) {
        System.out.println("Enter tag_name");
        sc = new Scanner(System.in);
        String tag = sc.nextLine();

        for(Product p:products){
            if(p.getTag().equals(tag))
                System.out.println(p.getId()+" : "+p.getName()+" "+p.getPrice());
        }
        sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String[] splitted = inp.split(" ");
        if(inp.equals("back"))
            ShowCustomerMenu(user);
        else{
            int found = -1;
            for(Product p:products){
                if((p.getId()+"").equals(splitted[1])){
                    if(user.getBalance()>=p.getPrice()){
                        user.addBalance(-p.getPrice());
                        found = 1;
                        break;
                    }
                    else
                        System.out.println("sorry, you don’t have enough balance to buy this item.");
                }
            }   
            if(found == 1){
                ArrayList<Product> temp = new ArrayList<Product>();
                for(Product p:products){
                    if(!(p.getId()+"").equals(splitted[1])){
                        temp.add(p);
                    }
                }
                products = temp;            
            }
            sc = new Scanner(System.in);
            inp = sc.nextLine();
            if(inp.equals("back"))
                ShowCustomerMenu(user);
        }
    }
    private static void PrintUserInfo(User user) {
        System.out.println("Username: "+user.getUsername());
        System.out.println("Password: "+user.getPassword());
        System.out.println("Role: "+user.getRole());
        if(user.getRole().equals("customer"))
            System.out.println("Balance: "+user.getBalance());
        else{
            System.out.println("Verified: "+user.isVerified());
        }
    }
    private static void AddBalance(User user) {        
        sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String[] splitted = inp.split(" ");
        if(inp.equals("back"))
            ShowCustomerMenu(user);
        else{
            user.addBalance(Integer.parseInt(splitted[1]));
            sc = new Scanner(System.in);
            inp = sc.nextLine();
            if(inp.equals("back"))
                ShowCustomerMenu(user);
        }
    }
    private static void ShowSellerMenu(User user) {
        System.out.println("list of available commands:");
        System.out.println("1. account info");
        System.out.println("2. add item [item_name] [price] [tag]");
        System.out.println("3. remove item [item_name]");
        System.out.println("4. log out");

        int a = sc.nextInt();
        switch(a) {
            case 1:
                PrintUserInfo(user);
                sc = new Scanner(System.in);
                String inp = sc.nextLine();
                if(inp.equals("back"))
                    ShowSellerMenu(user);
                break;
            case 2:
                AddItem(user);
                break;
            case 3:
                RemoveItem(user);
            case 4:
                MainMenu();
            default:
                int x = 0;
          }
    }
    private static void RemoveItem(User user) {
        sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String[] splitted = inp.split(" ");

        int item_id = Integer.parseInt(splitted[2]);

        int index = -1;
        for(Product p : products){
            if(p.getId()==item_id){
                if(!p.getSeller_name().equals(user.getUsername())){
                    System.out.println("you can’t remove this item.");
                }
                else{
                    index = 1;
                }
            }
        }
        if(index==1){
            ArrayList<Product> temp = new ArrayList<Product>();
            for(Product p:products){
                if(p.getId()!=item_id){
                    temp.add(p);
                }
            }
            products = temp;  
            System.out.println("item was removed successfully.");
        }

        sc = new Scanner(System.in);
                inp = sc.nextLine();
                if(inp.equals("back"))
                    ShowSellerMenu(user);
    }
    private static void AddItem(User user) {
        sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String[] splitted = inp.split(" ");

        String item_name = splitted[2];
        int item_price = Integer.parseInt(splitted[3]);
        String item_tag = splitted[4];

        int last_id = 0;
        if(products.size()!=0)
            last_id = products.get(products.size()-1).getId();
        
        Product p = new Product(last_id+1,item_price,item_name,item_tag);
        p.setSeller_name(user.getUsername());
        if(user.isVerified()){
            products.add(p);
        } else {
            System.out.println("you don't have the permission to add an item.");
        }

        sc = new Scanner(System.in);
                inp = sc.nextLine();
                if(inp.equals("back"))
                    ShowSellerMenu(user);
    }
    public static void ShowAdminMenu(){
        System.out.println("list of available commands:");
        System.out.println("1. list of unverified users");
        System.out.println("2. list of all users");
        System.out.println("3. remove user [username]");
        System.out.println("4. remove item [item_id]");
        System.out.println("5. log out");

        int a = sc.nextInt();
        switch(a) {
            case 1:
                ShowUnverifiedUsers();
                break;
            case 2:
                ShowUsers();
                break;
            case 3:
                RemoveUsername();
            case 4:
                RemoveItemAdmin();
            case 5:
                MainMenu();
            default:
                int x = 0;
          }
    }
    private static void RemoveUsername() {
        sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String[] splitted = inp.split(" ");

        String item_username = splitted[2];

        ArrayList<User> temp = new ArrayList<User>();
        for(User u : users){
            if(!u.getUsername().equals(item_username)){
                temp.add(u);
            }
        }
        users = temp;  
        System.out.println("user with username "+item_username+" was removed successfully.");

        sc = new Scanner(System.in);
        inp = sc.nextLine();
        if(inp.equals("back"))
            ShowAdminMenu();
    }
    private static void RemoveItemAdmin() {
        sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String[] splitted = inp.split(" ");

        int item_id = Integer.parseInt(splitted[2]);

        ArrayList<Product> temp = new ArrayList<Product>();
        for(Product p:products){
            if(p.getId()!=item_id){
                temp.add(p);
            }
        }
        products = temp;  
        System.out.println("item with id "+item_id+" was removed successfully.");
        sc = new Scanner(System.in);
        inp = sc.nextLine();
        if(inp.equals("back"))
            ShowAdminMenu();
    }
    private static void ShowUnverifiedUsers() {
        for(User u : users){
            if(!u.isVerified() && u.getRole().equals("seller")){
                PrintUserInfo(u);
            }
        }
        sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String[] splitted = inp.split(" ");
        String username = splitted[1];
        for(User u : users){
            if(u.getUsername().equals(username)){
                u.setVerified(true);
            }
        }
        sc = new Scanner(System.in);
        inp = sc.nextLine();
        if(inp.equals("back")){
            ShowAdminMenu();
        }
    }
    public static void ShowUsers(){
        for(User u : users){
            PrintUserInfo(u);
        }
        sc = new Scanner(System.in);
        String inp = sc.nextLine();
        if(inp.equals("back")){
            ShowAdminMenu();
        }   
    }
}
