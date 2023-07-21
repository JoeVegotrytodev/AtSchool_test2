package mod12les2t2;

import mod12les2t1.data.Director;
import mod12les2t1.database.Database;
import mod12les2t2.data.Movie;
import mod12les2t2.data.MovieRepository;
import mod12les2t2.database.MoviesRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbTask2Test {

    static MovieRepository movieRepository;
    @BeforeAll
    static void init(){
        movieRepository = new MoviesRepositoryImpl(Database.getConnection());
    }

    @Test
    @Order(1)
    public void getMovieByIdTest(){

        Movie expectedMovie = new Movie(1,
                "the fast and the furious",
                "action",
                Date.valueOf(LocalDate.of(2001, 10, 18)),
                new Director(1, "Ivanov", "Petr", Date.valueOf(LocalDate.of(2023, 7, 13)), "Russia"));

        Assertions.assertTrue(expectedMovie.equals(movieRepository.get(1)));
    }

    @Test
    @Order(2)
    public void saveMovieTest(){

        Movie movieToSave = new Movie(2,
                "2 Fast 2 Furious",
                "action",
                Date.valueOf(LocalDate.of(2003, 7, 23)),
                new Director(1, "Ivanov", "Petr",
                        Date.valueOf(LocalDate.of(2023, 7, 13)), "Russia"));

        movieRepository.save(movieToSave);

        Assertions.assertTrue(movieToSave.equals(movieRepository.get(2)));
    }

    @Test
    @Order(3)
    public void getFilmsByAuthorTest(){

        ArrayList<Movie> expectedMoviesList = new ArrayList<>();
        Director someDirector = new Director(1, "Ivanov", "Petr",
                Date.valueOf(LocalDate.of(2023, 7, 13)), "Russia");
        Movie movieToSave = new Movie(2,
                "2 Fast 2 Furious",
                "action",
                Date.valueOf(LocalDate.of(2003, 7, 23)),
                someDirector);

        expectedMoviesList.add(movieToSave);
        expectedMoviesList.add(new MoviesRepositoryImpl(Database.getConnection()).get(1));


        movieRepository.save(movieToSave);

        Assertions.assertEquals(expectedMoviesList.get(1),movieRepository.get(someDirector).get(0));
        Assertions.assertEquals(expectedMoviesList.get(0),movieRepository.get(someDirector).get(1));
    }

    @Test
    @Order(4)
    public void deleteMovieTest(){

        Movie movieToDelete = new Movie(2,
                "2 Fast 2 Furious",
                "action",
                Date.valueOf(LocalDate.of(2003, 7, 23)),
                new Director(1, "Ivanov", "Petr",
                        Date.valueOf(LocalDate.of(2023, 7, 13)), "Russia"));

        movieRepository.delete(movieToDelete);

        Assertions.assertNull(movieRepository.get(2));
    }

    @Test
    @Order(5)
    public void getDirectorsByGenresTest(){
        MovieRepository movieRepository = new MoviesRepositoryImpl(Database.getConnection());

        List<String> genres = new ArrayList<>();
        genres.add("action");

        List<Director> directors = movieRepository.get(genres);

        directors.stream().forEach((director -> Assertions.assertEquals(new Director(1, "Ivanov",
                "Petr",
                Date.valueOf(LocalDate.of(2023, 7, 13)),
                "Russia"), director)));

    }
}
