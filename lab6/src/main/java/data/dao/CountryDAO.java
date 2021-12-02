package data.dao;

import data.dto.CountryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    public static CountryDTO findById(long id) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql =
                    "SELECT * "
                            + "FROM countries "
                            + "WHERE id_co = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            CountryDTO country = null;
            if (resultSet.next()) {
                country = new CountryDTO();
                country.setId(resultSet.getLong(1));
                country.setName(resultSet.getString(2));
            }
            preparedStatement.close();
            return country;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CountryDTO findByName(String name) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql =
                    "SELECT * "
                            + "FROM countries "
                            + "WHERE name = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            CountryDTO country = null;
            if (resultSet.next()) {
                country = new CountryDTO();
                country.setId(resultSet.getLong(1));
                country.setName(resultSet.getString(2));
            }
            preparedStatement.close();
            return country;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean update(CountryDTO country) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql =
                    "UPDATE countries "
                            + "SET name = ? "
                            + "WHERE id_co = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, country.getName());
            preparedStatement.setLong(2, country.getId());
            int result = preparedStatement.executeUpdate();
            preparedStatement.close();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean insert(CountryDTO country) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql =
                    "INSERT INTO countries (id_co, name) "
                            + "VALUES (" + System.currentTimeMillis() / 1000 +", ?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, country.getName());
            System.out.println(preparedStatement);
            System.out.println(preparedStatement.execute());
            preparedStatement = connection.prepareStatement("SELECT LAST_INSERT_ID();");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                country.setId(resultSet.getLong(1));
            } else
                return false;
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete(CountryDTO country) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql =
                    "DELETE FROM countries "
                            + "WHERE id_co = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, country.getId());
            int result = preparedStatement.executeUpdate();
            preparedStatement.close();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<CountryDTO> findAll() {
        try (Connection connection = DBConnection.getConnection()) {
            String sql =
                    "SELECT * "
                            + "FROM countries";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CountryDTO> list = new ArrayList<>();
            while (resultSet.next()) {
                CountryDTO country = new CountryDTO();
                country.setId(resultSet.getLong(1));
                country.setName(resultSet.getString(2));
                list.add(country);
            }
            preparedStatement.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
