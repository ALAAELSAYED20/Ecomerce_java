package models;
import java.time.LocalDate;

public class ExpirableProduct extends Products {
    private LocalDate expireDate;

    public ExpirableProduct(String name ,double price,int quantity ,LocalDate expireDate ) {
          super(name,price,quantity);
          this.expireDate = expireDate; 
    }
    public LocalDate getExpireDate(){
        return expireDate;
    }
    public  boolean isExpire(){
        return expireDate.isBefore(LocalDate.now());
    }
    @Override
    public String toString(){
        return  super.toString()+"Expire Date"+expireDate ;
    }

}
