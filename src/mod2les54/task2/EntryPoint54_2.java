package mod2les54.task2;

/**
 * Через аругмент командной строки передается строка - путь до некоторого файла -
 * содержащая знак «/» или «\». Например, "/bin/java" или "C:\Program Files\Java\bin\java".
 * <p>
 * Напишите программу, которая для обоих вариантов разделителей, может вывести отдельно путь
 * и имя файла. Если имя файла отсутствует, т.е. строка оканчивается на "\" или "/",
 * то выдать ошибку: "Введен некорректный путь до файла."
 */
public class EntryPoint54_2 {
    public static void main(String[] args) {

        String[] cuttedPath = pathCutter(args);

        if (cuttedPath != null) {
            System.out.println("Путь: " + cuttedPath[0]);
            System.out.println("Имя файла: " + cuttedPath[1]);
        }
        else
            System.out.println("Введен некорректный путь до файла.");

        //храним номер, где встретили разделитель
//        int position = 0;
//
//        //с конца строки ищем разделитеь
//        for(int i = path.length() - 1; i > 0; i--){
//            if ((path.charAt(i) == '\\') | (path.charAt(i) == '/')){
//                //запоминаем его позицию
//                position = i + 1;
//                //выходим из цикла
//                break;
//            }
//        }
//
//        //если строка не пустая
//        if(position != 0) {
//            System.out.println("Путь: " + path.substring(0, position));
//            System.out.println("Имя файла: " + path.substring(position));
//        }
//        //иначе
//        else
//            System.out.println("Введен некорректный путь до файла.");
    }

    public static String[] pathCutter(String[] inputPath) {

        StringBuilder fullPath = new StringBuilder();

        for (String str : inputPath) {
            fullPath.append(str);
        }

        //храним номер, где встретили разделитель
        int position = 0;

        //с конца строки ищем разделитеь
        for (int i = fullPath.length() - 1; i > 0; i--) {
            if ((fullPath.charAt(i) == '\\') | (fullPath.charAt(i) == '/')) {
                //запоминаем его позицию
                position = i + 1;
                //выходим из цикла
                break;
            }
        }

        String[] outputStringArray = new String[2];

        //если строка не пустая
        if (position != fullPath.length() - 1) {
            outputStringArray[0] =  fullPath.substring(0, position);
            outputStringArray[1] =  fullPath.substring(position);
            return outputStringArray;
        }
        else
            return null;

    }
}
