package co.bank.config;

import co.bank.model.Account;
import co.bank.model.User;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConfig {
    // CHANGE THESE to your postgres
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/wtcbank";
    private static final String DB_USER = "bank_app";
    private static final String DB_PASS = "wtc";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static User login(String username, String password) {
        // NOTE: You have password_hash. For now doing plain compare.
        // Later use BCrypt.checkpw(password, hash)
        String sql = "SELECT user_id, username, password_hash, role FROM users WHERE username = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String hash = rs.getString("password_hash");
                // TEMP: if your hash is plain text '1234', this works. If bcrypt, replace with BCrypt.
                if (hash.equals(password)) { 
                    return new User(rs.getLong("user_id"), rs.getString("username"), rs.getString("role"));
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public static List<Account> getAccountsByUserId(long userId) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT account_id, user_id, account_number, account_type, currency, opening_balance FROM accounts WHERE user_id = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                    rs.getLong("account_id"),
                    rs.getLong("user_id"),
                    rs.getString("account_number"),
                    rs.getString("account_type"),
                    rs.getString("currency"),
                    rs.getDouble("opening_balance")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
