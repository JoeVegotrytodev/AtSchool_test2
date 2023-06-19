package mod2les54.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static mod2les54.task2.EntryPoint54_2.pathCutter;

public class pathCutterTest {

    @Test
    @DisplayName("Тест выделения пути до файла в ОС Виндовс")
    @Tag("pathCutter")
    void pathCutterWindowsTest(){
        String[] inputPath = new String[1];
        inputPath[0] = "C:\\ProgramFiles\\Java\\bin\\java";

        Assertions.assertEquals("C:\\ProgramFiles\\Java\\bin\\", pathCutter(inputPath)[0]);
        Assertions.assertEquals("java", pathCutter(inputPath)[1]);
    }

    @Test
    @DisplayName("Тест выделения пути до файла в ОС Убунту")
    @Tag("pathCutter")
    void pathCutterUbuntuTest(){
        String[] inputPath = new String[1];
        inputPath[0] = "bin/java";

        Assertions.assertEquals("bin/", pathCutter(inputPath)[0]);
        Assertions.assertEquals("java", pathCutter(inputPath)[1]);
    }
}
