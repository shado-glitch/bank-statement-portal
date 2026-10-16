package co.bank.model;

import java.time.Instant;
import java.util.Objects;

public class User {
    
    private final String username;
    private final Long userId;
    private final String passwodHash;
    private final String role;
    private final Instant createdAt;

    public User(){
    }

    public User(Long userId, String username, String passwordHash, String role, Instant createdAt){
      this.username=username;
      this.userId= userId;
      this.passwodHash = passwordHash;
      this.role = role;
      this.createdAt = createdAt;
    }


    public String getUsername() {
        return username;
    }



    public Long getUserId() {
        return userId;
    }



    public String getPasswodHash() {
        return passwodHash;
    }



    public String getRole() {
        return role;
    }



    public Instant getCreatedAt() {
        return createdAt;
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
