package mod2les54;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static mod2les54.TestDataProvider.getPath;
import static mod2les54.task2.EntryPoint54_2.pathCutter;

public class PathCutterTest {

    int getPathCounter = 0;

    @Test
    @DisplayName("Тест выделения пути до файла с обратным слэшем")
    @Tag("pathCutter")
    void pathCutterWindowsTest() {
        String inputPath = getPath(getPathCounter++);

        System.out.println(inputPath);
        Assertions.assertEquals("C:\\ProgramFiles\\Java\\bin\\", pathCutter(inputPath)[0]);
        Assertions.assertEquals("java", pathCutter(inputPath)[1]);
    }

    @Test
    @DisplayName("Тест выделения пути до файла со слешем")
    @Tag("pathCutter")
    void pathCutterUbuntuTest(){
        String inputPath = getPath(1);

        Assertions.assertEquals("bin/", pathCutter(inputPath)[0]);
        Assertions.assertEquals("java", pathCutter(inputPath)[1]);
    }
}
