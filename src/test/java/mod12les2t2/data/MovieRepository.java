package mod12les2t2.data;

import mod12les2t1.data.Director;

import java.util.List;

public interface MovieRepository {
    Movie get(int id);

    void save(Movie movie);

    void delete(Movie movie);

    List<Movie> get(Director d);
}
