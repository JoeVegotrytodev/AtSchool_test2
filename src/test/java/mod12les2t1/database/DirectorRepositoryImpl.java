package mod12les2t1.database;

import mod12les2t1.data.Director;
import mod12les2t1.data.DirectorRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorRepositoryImpl implements DirectorRepository {
    Connection connection;
    ResultSet resultSet;

    public static final String selectDirectorByIdQuery = "SELECT * " +
            "FROM \"TestSchema\".\"Directors\" " +
            "WHERE id = ?";

    public static final String updateDirectorQuery = "INSERT INTO \"TestSchema\".\"Directors\" " +
            "VALUES (?, ?, ?, ?, ?)";

    public static final String deleteDirectorQuery = "DELETE FROM \"TestSchema\".\"Directors\" "+
            "WHERE id = ?";

    public DirectorRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Director get(int id){
//        String selectDirectorByIdQuery = "SELECT * " +
//                "FROM \"TestSchema\".\"Directors\" " +
//                "WHERE id = ?";
        Director resultDirector = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(selectDirectorByIdQuery)){
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                resultDirector = new Director(resultSet.getInt(1), resultSet.getString(3),
                        resultSet.getString(4),  resultSet.getDate(2), resultSet.getString(5));
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return resultDirector;
    }

    @Override
    public void save(Director director){
//        String updateDirectorQuery = "INSERT INTO \"TestSchema\".\"Directors\" " +
//                "VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(updateDirectorQuery)){
            preparedStatement.setInt(1, director.getId());
            preparedStatement.setDate(2, director.getBirthDate());
            preparedStatement.setString(3, director.getFirstName());
            preparedStatement.setString(4, director.getLastName());
            preparedStatement.setString(5, director.getCountry());

            preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public void delete(Director director){
//        String deleteDirectorQuery = "DELETE FROM \"TestSchema\".\"Directors\" "+
//                "WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteDirectorQuery)){
            preparedStatement.setInt(1, director.getId());

           preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();

        }
    }
}
