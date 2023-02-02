package repository;

import config.MySQLConfig;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository {
    public Account getRoleAcc(String mail, String passWord) throws SQLException, ClassNotFoundException {
        Account account = new Account();
        String query = "select * from account.Account as acc where acc.Mail = ? and acc.PassWord = ?;";

        Connection connection = MySQLConfig.getConnect();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, mail);
            statement.setString(2, passWord);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String role = resultSet.getString("Role");
                account.setRole(role);
            }
        } catch (Exception e){
            System.out.println("  Loi o LoginRepository ");
        } finally {
            connection.close();
        }

        return account;
    }
}
