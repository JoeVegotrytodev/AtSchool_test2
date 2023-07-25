package mod12les2t1.data;

import java.util.ArrayList;
import java.util.List;

public interface DirectorRepository {
    Director get(int id);
    void save(Director director);
    void delete(Director director);

    //раз для задания 2 пришлось ввести новый метод - доавбил дефолт реализацию
    default List<Director> get(List<String> genres){
        return new ArrayList<>();
    };
}
