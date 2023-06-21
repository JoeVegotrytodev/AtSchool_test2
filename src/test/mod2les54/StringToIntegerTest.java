package mod2les54;

import mod2les54.task6.EntryPoint54_6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class StringToIntegerTest {

    @Test
    @DisplayName("Тест проверки явлется ли переданное число интом")
    @Tag("toInt")
    void isIntegerTest(){
        Assertions.assertTrue(EntryPoint54_6.isInteger("45"));

        Assertions.assertFalse(EntryPoint54_6.isInteger("4f5"));
        Assertions.assertFalse(EntryPoint54_6.isInteger("@"));
    }

    @Test
    @DisplayName("Тест приведения строки к числу")
    @Tag("toInt")
    void toIntTest(){
        Assertions.assertEquals(90, EntryPoint54_6.toInt("45"));
        Assertions.assertEquals(-810, EntryPoint54_6.toInt("-405"));
    }

    @Test
    @DisplayName("Тест проверки вхоядщей строки на некорректные символы")
    @Tag("toInt")
    void argumentCheckTest(){
        Assertions.assertFalse(EntryPoint54_6.argumentCheck("d4g3"));
        Assertions.assertFalse(EntryPoint54_6.argumentCheck("-$#@"));

        Assertions.assertTrue(EntryPoint54_6.argumentCheck("5443323"));
        Assertions.assertTrue(EntryPoint54_6.argumentCheck("-430024"));

        Assertions.assertFalse(EntryPoint54_6.argumentCheck("2147483649"));
        Assertions.assertFalse(EntryPoint54_6.argumentCheck("-2147483649"));
    }
}
