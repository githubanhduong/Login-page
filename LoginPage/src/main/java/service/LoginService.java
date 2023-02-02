package service;

import model.Account;
import repository.LoginRepository;

import java.sql.SQLException;

public class LoginService {

    public Account getRoleAcc(String mail, String passWord) throws SQLException, ClassNotFoundException {
        Account account = new Account();

        try{
            LoginRepository loginRepository = new LoginRepository();
            String role = loginRepository.getRoleAcc(mail, passWord).getRole();
            account.setRole(role);
        } catch (Exception e){
            System.out.println("Loi o LoginService ");
        }

        return account;
    }
}
