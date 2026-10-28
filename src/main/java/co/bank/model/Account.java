package co.bank.model;

public class Account {

   private long account_id;
   private long user_id;
   private String account_number;
   private String account_type;
   private String currency;
   private double openning_balance;


   public Account(long account_id, long user_id, String account_number, String account_type, String currency,
        double openning_balance) {
            
            this.account_id = account_id;
            this.user_id = user_id;
            this.account_number = account_number;
            this.account_type = account_type;
            this.currency = currency;
            this.openning_balance = openning_balance;
   }


   public long getAccount_id() {
    return account_id;
   }


   public void setAccount_id(long account_id) {
    this.account_id = account_id;
   }


   public long getUser_id() {
    return user_id;
   }


   public void setUser_id(long user_id) {
    this.user_id = user_id;
   }


   public String getAccount_number() {
    return account_number;
   }


   public void setAccount_number(String account_number) {
    this.account_number = account_number;
   }


   public String getAccount_type() {
    return account_type;
   }


   public void setAccount_type(String account_type) {
    this.account_type = account_type;
   }


   public String getCurrency() {
    return currency;
   }


   public void setCurrency(String currency) {
    this.currency = currency;
   }


   public double getOpenning_balance() {
    return openning_balance;
   }


   public void setOpenning_balance(double openning_balance) {
    this.openning_balance = openning_balance;
   }

    
    
}
