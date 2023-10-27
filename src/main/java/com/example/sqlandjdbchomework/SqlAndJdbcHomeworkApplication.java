package com.example.sqlandjdbchomework;

import com.example.sqlandjdbchomework.dao.CompanyDAO;
import com.example.sqlandjdbchomework.dao.UserDAO;
import com.example.sqlandjdbchomework.database.DatabaseConnection;
import com.example.sqlandjdbchomework.models.Company;
import com.example.sqlandjdbchomework.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqlAndJdbcHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlAndJdbcHomeworkApplication.class, args);
        DatabaseConnection.createTables();

        UserDAO userDAO = new UserDAO();
        User user = new User("Joe Biden", "joe.biden@mail.com");

        userDAO.addUser(user);

        User retrievedUser = userDAO.getUserById(1);
        System.out.println("Retrieved User: " + retrievedUser);

        retrievedUser.setEmail("new_email@mail.com");
        userDAO.updateUser(retrievedUser);

        retrievedUser = userDAO.getUserById(1);
        System.out.println("Retrieved User: " + retrievedUser);

        userDAO.deleteUser(1);

        CompanyDAO companyDAO = new CompanyDAO();
        Company company = new Company("Monsters Inc.", "666 Devil St");

        companyDAO.addCompany(company);

        Company retrievedCompany = companyDAO.getCompanyById(1);
        System.out.println("Retrieved Company: " + retrievedCompany);

        retrievedCompany.setAddress("999 Angel St");
        companyDAO.updateCompany(retrievedCompany);

        retrievedCompany = companyDAO.getCompanyById(1);
        System.out.println("Retrieved Company: " + retrievedCompany);

        companyDAO.deleteCompany(1);
    }

}
