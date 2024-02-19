package mod12les2t1;

import mod12les2t1.data.Director;
import mod12les2t1.data.DirectorRepository;
import mod12les2t1.database.Database;
import mod12les2t1.database.DirectorRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.time.LocalDate;

public class DbTests {

    static DirectorRepository directorRepositoryImpl;
    private static Logger logger;

    @BeforeAll
    static void init(){
        logger = LoggerFactory.getLogger(DbTests.class);
        directorRepositoryImpl = new  DirectorRepositoryImpl(Database.getConnection());
    }

    @Test
    @Order(1)
    public void getClientByIdTest(){

        Director expectedDirector = new Director(1, "Ivanov", "Petr", Date.valueOf(LocalDate.of(2023, 7, 13)), "Russia");

        System.out.println("NULL ??? = " + expectedDirector);
        logger.info("- - - - LOG _ - - - - " + expectedDirector);
        Director dirFromDB = directorRepositoryImpl.get(1);
        logger.info("- - - - LOG _ - - - - " + " in DB = "+ dirFromDB);

        Assertions.assertNotNull(expectedDirector);
        Assertions.assertNotNull(dirFromDB);

        Assertions.assertEquals(expectedDirector, dirFromDB);
    }

    @Test
    @Order(2)
    public void saveDirectorTest(){

        Director directorToSave = new Director(2, "Petrov", "Ivan", Date.valueOf(LocalDate.now()), "Greece");

        directorRepositoryImpl.save(directorToSave);

        Assertions.assertTrue(directorToSave.equals(directorRepositoryImpl.get(2)));
    }

    @Test
    @Order(3)
    public void deleteDirectorTest(){

        Director directorToDelete = new Director(2, "Petrov", "Ivan", Date.valueOf(LocalDate.now()), "Greece");

        directorRepositoryImpl.delete(directorToDelete);

        Assertions.assertNull(directorRepositoryImpl.get(2));
    }
}
