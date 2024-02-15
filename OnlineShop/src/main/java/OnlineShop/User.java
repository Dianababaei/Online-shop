package OnlineShop;

public class User {
    private String username,password,role;
    private int balance;
    private boolean verified;
    public User(String un,String p,String r,int b){
        this.setUsername(un);
        this.setPassword(p);
        this.setRole(r);
        this.setBalance(b);
    }
    public boolean isVerified() {
        return verified;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    public void addBalance(int b){
        this.balance += b;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public User() {
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
