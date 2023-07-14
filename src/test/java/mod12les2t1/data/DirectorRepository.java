package mod12les2t1.data;

public interface DirectorRepository {
    Director get(int id);
    void save(Director director);
    void delete(Director director);
}
