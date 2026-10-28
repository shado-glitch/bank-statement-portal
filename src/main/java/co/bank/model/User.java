package co.bank.model;

import java.time.Instant;
import java.util.Objects;

public class User {
    
    private final String username;
    private final Long userId;
    private final String role;
    

    
    public User(Long userId, String username,  String role){
      this.username=username;
      this.userId= userId;
      this.role = role;
    }


    public String getUsername() {
        return username;
    }



    public Long getUserId() {
        return userId;
    }



    



    public String getRole() {
        return role;
    }


    @Override
    public boolean equals(Object o){
        
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return true ;

        User person = (User) o;
        return Objects.equals(userId, person.userId);
    }

    @Override 
    public int hashCode(){
        return Objects.hash(userId);
    }

    
}
