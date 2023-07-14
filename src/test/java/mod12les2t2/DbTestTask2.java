package mod12les2t2;

import mod12les2t1.data.Director;
import mod12les2t1.database.Database;
import mod12les2t1.database.DirectorRepositoryImpl;
import mod12les2t2.data.Movie;
import mod12les2t2.data.MovieRepository;
import mod12les2t2.database.MoviesRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class DbTestTask2 {

    @Test
    @Order(1)
    public void getMovieByIdTest(){
        MoviesRepositoryImpl moviesRepositoryImpl = new MoviesRepositoryImpl(Database.getConnection());

        Movie expectedMovie = new Movie(1,
                "the fast and the furious",
                "action",
                Date.valueOf(LocalDate.of(2001, 10, 18)),
                new Director(1, "Ivanov", "Petr", Date.valueOf(LocalDate.of(2023, 7, 13)), "Russia"));

        Assertions.assertTrue(expectedMovie.equals(moviesRepositoryImpl.get(1)));
    }

    @Test
    @Order(2)
    public void saveMovieTest(){
        MoviesRepositoryImpl moviesRepositoryImpl = new MoviesRepositoryImpl(Database.getConnection());

        Movie movieToSave = new Movie(2,
                "2 Fast 2 Furious",
                "action",
                Date.valueOf(LocalDate.of(2003, 7, 23)),
                new Director(1, "Ivanov", "Petr",
                        Date.valueOf(LocalDate.of(2023, 7, 13)), "Russia"));

        moviesRepositoryImpl.save(movieToSave);

        Assertions.assertTrue(movieToSave.equals(moviesRepositoryImpl.get(2)));
    }

    @Test
    @Order(3)
    public void getFilmsByAuthor(){
        MoviesRepositoryImpl movierRepositoryImpl = new MoviesRepositoryImpl(Database.getConnection());

        ArrayList<Movie> expectedMoviesList = new ArrayList<>();
        Director someDirector = new Director(1, "Ivanov", "Petr",
                Date.valueOf(LocalDate.of(2023, 7, 13)), "Russia");

        expectedMoviesList.add(new Movie(2,
                "2 Fast 2 Furious",
                "action",
                Date.valueOf(LocalDate.of(2003, 7, 23)),
                someDirector));
        expectedMoviesList.add(new MoviesRepositoryImpl(Database.getConnection()).get(1));

        System.out.println(movierRepositoryImpl.get(someDirector).size());

        Assertions.assertEquals(expectedMoviesList.get(1),movierRepositoryImpl.get(someDirector).get(0));
        Assertions.assertEquals(expectedMoviesList.get(0),movierRepositoryImpl.get(someDirector).get(1));


    }

    @Test
    @Order(4)
    public void deleteMovieTest(){
        MoviesRepositoryImpl movierRepositoryImpl = new MoviesRepositoryImpl(Database.getConnection());

        Movie movieToDelete = new Movie(2,
                "2 Fast 2 Furious",
                "action",
                Date.valueOf(LocalDate.of(2003, 7, 23)),
                new Director(1, "Ivanov", "Petr",
                        Date.valueOf(LocalDate.of(2023, 7, 13)), "Russia"));

        movierRepositoryImpl.delete(movieToDelete);

        Assertions.assertNull(movierRepositoryImpl.get(2));
    }
}
