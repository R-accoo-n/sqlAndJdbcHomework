package com.example.sqlandjdbchomework.dao;

import com.example.sqlandjdbchomework.database.DatabaseConnection;
import com.example.sqlandjdbchomework.models.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {
    private static final String INSERT_COMPANY_SQL = "INSERT INTO companies (name, address) VALUES (?, ?)";
    private static final String SELECT_COMPANY_BY_ID = "SELECT id, name, address FROM companies WHERE id = ?";
    private static final String UPDATE_COMPANY_SQL = "UPDATE companies SET name = ?, address = ? WHERE id = ?";
    private static final String DELETE_COMPANY_SQL = "DELETE FROM companies WHERE id = ?";
    private static final String SELECT_ALL_COMPANIES = "SELECT * FROM companies";

    public void addCompany(Company company) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMPANY_SQL)) {
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Company getCompanyById(int id) {
        Company company = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMPANY_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                company = new Company(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public void updateCompany(Company company) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMPANY_SQL)) {
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getAddress());
            preparedStatement.setInt(3, company.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCompany(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COMPANY_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMPANIES);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Company company = new Company(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("address"));
                companies.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }
}
