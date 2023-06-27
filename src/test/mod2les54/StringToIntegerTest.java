package mod2les54;

import mod2les54.task6.EntryPoint54_6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class StringToIntegerTest {

    int getStringTointCounter;

    @Test
    @DisplayName("Тест проверки явлется ли переданное число интом")
    @Tag("toInt")
    void isIntegerTest(){
        getStringTointCounter = 0;
        String testData = TestDataProvider.getString(getStringTointCounter++);
        Assertions.assertTrue(EntryPoint54_6.isInteger(testData));

        testData = TestDataProvider.getString(getStringTointCounter++);
        Assertions.assertFalse(EntryPoint54_6.isInteger(testData));

        testData = TestDataProvider.getString(getStringTointCounter++);
        Assertions.assertFalse(EntryPoint54_6.isInteger(testData));
    }

    @Test
    @DisplayName("Тест приведения строки к числу")
    @Tag("toInt")
    void toIntTest(){
        getStringTointCounter = 0;
        String testData = TestDataProvider.getString(getStringTointCounter);
        Assertions.assertEquals(90, EntryPoint54_6.toInt(testData));

        getStringTointCounter = 3;
        testData = TestDataProvider.getString(getStringTointCounter);
        Assertions.assertEquals(-810, EntryPoint54_6.toInt(testData));
    }

    @Test
    @DisplayName("Тест проверки вхоядщей строки на некорректные символы")
    @Tag("toInt")
    void argumentCheckTest(){
        getStringTointCounter = 1;
        String testData = TestDataProvider.getString(getStringTointCounter++);
        Assertions.assertFalse(EntryPoint54_6.argumentCheck(testData));

        testData = TestDataProvider.getString(getStringTointCounter);
        Assertions.assertFalse(EntryPoint54_6.argumentCheck(testData));

        testData = TestDataProvider.getString(getStringTointCounter+=2);
        Assertions.assertFalse(EntryPoint54_6.argumentCheck(testData));

        testData = TestDataProvider.getString(getStringTointCounter+=1);
        Assertions.assertFalse(EntryPoint54_6.argumentCheck(testData));
    }
}
