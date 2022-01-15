package repository;

import empty.Category;
import empty.Response;
import utills.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRespository {

    public static List<Category> getCategories() throws SQLException {
        Connection ulanish = DbConfig.ulanish();
        Statement statement = ulanish.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from category");
        List<Category> categoryList = new ArrayList<>();
        while (resultSet.next()) {
            Category category = new Category();
            //row bitta
            category.setId(resultSet.getInt(1));
            category.setName(resultSet.getString(2));
            category.setActive(resultSet.getBoolean(3));
            categoryList.add(category);
        }
        return categoryList;
    }

    public static boolean addCategory(int id, String name) throws SQLException {
        Connection connection = DbConfig.ulanish();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into category values(?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setBoolean(3, true);
        boolean execute = preparedStatement.execute();

        return execute;

    }

    public static Response callFunction(String name, String type, String n_name) throws SQLException {
        Response response = new Response();
        Connection connection = DbConfig.ulanish();
        CallableStatement callableStatement = connection.prepareCall("{call category_crud(?,?,?,?,?)}");
        callableStatement.setString(2, name);
        callableStatement.setString(2, type);
        callableStatement.setString(2, n_name);
        callableStatement.registerOutParameter(4, Types.VARCHAR);
        callableStatement.registerOutParameter(5, Types.BOOLEAN);
        ResultSet resultSet = callableStatement.executeQuery();

        while (resultSet.next()) {

            response.setSuccess(callableStatement.getBoolean(1));
            response.setMessage(resultSet.getString(2));
        }

        return response;

    }
}