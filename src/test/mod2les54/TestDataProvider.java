package mod2les54;

/**
 * не совсем понял, что такое дата провайдер.
 * Сделал как понимаю самостоятельно.
 */
public class TestDataProvider {

    public static String getPath(int getPathCounter) {
        String[] pathsPull = new String[2];
        pathsPull[0] = "C:\\ProgramFiles\\Java\\bin\\java";
        pathsPull[1] = "bin/java";

        switch (getPathCounter) {
            case (0):
                return pathsPull[0];
            case (1):
                return pathsPull[1];
            default: return null;
        }
    }

    public static String getString(int getStringCounter){
        String[] stringsPull = new String[6];
        stringsPull[0] = "45";
        stringsPull[1] = "4f5";
        stringsPull[2] = "@";
        stringsPull[3] = "-405";
        stringsPull[4] = "2147483649";
        stringsPull[5] = "-2147483649";

        switch (getStringCounter) {
            case (0):
                return stringsPull[0];
            case (1):
                return stringsPull[1];
            case (2):
                return stringsPull[2];
            case (3):
                return stringsPull[3];
            case (4):
                return stringsPull[4];
            case (5):
                return stringsPull[5];
            default: return null;
        }
    }
}
