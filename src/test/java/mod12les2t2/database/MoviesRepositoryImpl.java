package mod12les2t2.database;

import mod12les2t1.data.Director;
import mod12les2t1.database.DirectorRepositoryImpl;
import mod12les2t2.data.Movie;
import mod12les2t2.data.MovieRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesRepositoryImpl implements MovieRepository {
    Connection connection;
    ResultSet resultSet;

    public MoviesRepositoryImpl(Connection connection){
        this.connection = connection;
    }

    public Movie get(int id){
        String selectMovieByIdQuery = "SELECT * " +
                "FROM \"TestSchema\".\"Movies\" " +
                "WHERE id = ?";

        Movie resultMovie = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(selectMovieByIdQuery)){
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                resultMovie = new Movie(resultSet.getInt(1), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getDate(2), new DirectorRepositoryImpl(connection).get(resultSet.getInt(3)));
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return resultMovie;
    }

    public void save(Movie movie){
        String updateMovieQuery = "INSERT INTO \"TestSchema\".\"Movies\" " +
                "VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(updateMovieQuery)){
            preparedStatement.setInt(1, movie.getId());
            preparedStatement.setDate(2, movie.getRelease());
            preparedStatement.setInt(3, movie.getDirector().getId());
            preparedStatement.setString(4, movie.getTitle());
            preparedStatement.setString(5, movie.getGenre());

            preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void delete(Movie movie){
        String deleteMovieQuery = "DELETE FROM \"TestSchema\".\"Movies\" "+
                "WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteMovieQuery)){
            preparedStatement.setInt(1, movie.getId());

            preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();

        }
    }

    public List<Movie> get(Director d){
        String getMovieListByDirectorQuery = "SELECT * " +
                "FROM \"TestSchema\".\"Movies\"" +
                "WHERE \"TestSchema\".\"Movies\".\"Director\" = ?";

        List<Movie> resultListOfMovies = new ArrayList<>();

        try(PreparedStatement preparedStatement = connection.prepareStatement(getMovieListByDirectorQuery)){
            preparedStatement.setInt(1, d.getId());

            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            do{
                resultListOfMovies.add(new Movie(resultSet.getInt(1),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(2),
                        new DirectorRepositoryImpl(connection).get(d.getId())));
            }while (resultSet.next());

        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();

        }

        return resultListOfMovies;
    }
}
