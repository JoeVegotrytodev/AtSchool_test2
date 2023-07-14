package mod12les2t1;

import mod12les2t1.data.Director;
import mod12les2t1.database.Database;
import mod12les2t1.database.DirectorRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class DbTests {

    @Test
    @Order(1)
    public void getClientByIdTest(){
        DirectorRepositoryImpl directorRepositoryImpl = new DirectorRepositoryImpl(Database.getConnection());
        Director expectedDirector = new Director(1, "Ivanov", "Petr", Date.valueOf(LocalDate.of(2023, 7, 13)), "Russia");

        Assertions.assertTrue(expectedDirector.equals(directorRepositoryImpl.get(1)));
    }

    @Test
    @Order(2)
    public void saveDirectorTest(){
        DirectorRepositoryImpl directorRepositoryImpl = new DirectorRepositoryImpl(Database.getConnection());
        Director directorToSave = new Director(2, "Petrov", "Ivan", Date.valueOf(LocalDate.now()), "Greece");

        directorRepositoryImpl.save(directorToSave);

        Assertions.assertTrue(directorToSave.equals(directorRepositoryImpl.get(2)));
    }

    @Test
    @Order(3)
    public void deleteDirectorTest(){
        DirectorRepositoryImpl directorRepositoryImpl = new DirectorRepositoryImpl(Database.getConnection());
        Director directorToDelete = new Director(2, "Petrov", "Ivan", Date.valueOf(LocalDate.now()), "Greece");

        directorRepositoryImpl.delete(directorToDelete);

        Assertions.assertNull(directorRepositoryImpl.get(2));
    }
}
