package mod2les43.task3;

public class EntryPoint43_3 {
    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);

        if ((year < 0) | (year > 3000)){
            System.out.println("Year out of range..");
            return;
        }

        if (((year % 4 == 0) && (year % 100 != 0)) | (year % 400 == 0))
            System.out.println("Yes");
        else System.out.println("No");
    }
}
