package br.com.guru.implementation.repository;

import br.com.guru.backend.usecases.port.UserRepository;
import br.com.guru.domain.UserModel;
import br.com.guru.implementation.repository.connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoPostgres implements UserRepository {
    @Override
    public UserModel findById(int id) {
        return null;
    }

    @Override
    public List<UserModel> findAll() {

        final List<UserModel> users = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROm usuario;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final UserModel userModel = new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setUsername(resultSet.getString("nome_usuario"));
                userModel.setPassword(resultSet.getString("senha"));

                users.add(userModel);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public List<UserModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public boolean update(UserModel userModel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE usuario SET nome_completo = ?";
        sql += "WHERE id = ?;";


        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, userModel.getFullName());
            preparedStatement.setInt(2, userModel.getId());

            preparedStatement.execute();

            preparedStatement.close();

            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public int create(UserModel userModel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO usuario(nome_usuario, senha, nome_completo)";
        sql += "VALUES(?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, userModel.getUsername());
            preparedStatement.setString(2, userModel.getPassword());
            preparedStatement.setString(3, userModel.getFullName());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                final int id = resultSet.getInt(1);
                userModel.setId(id);
            }

            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return userModel.getId();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
