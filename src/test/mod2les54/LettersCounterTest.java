package mod2les54;

import mod2les54.task1.EntryPoint54_1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LettersCounterTest {

    @Test
    @DisplayName("Тест подсчета буквы в фразе")
    @Tag("letterCounter")
    void letterCounterTest(){
        Assertions.assertEquals(7, EntryPoint54_1.lettersCount('а'));
    }
}
