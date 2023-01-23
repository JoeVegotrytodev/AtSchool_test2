package mod2les39.task2;

public class Summa {
    int a, b;
    double x, y, z;

    int sum(int a, int b){
        return a + b;
    }

    double sum(int x, int y, int z){
        return x + y + z;
    }

    /*ошибся с пониманием задания, исправил ниже
    double sum(double... w){
        int sum = 0;
        for(double i : w){
            sum += i;
        }
        return sum;
    }*/

    double sum(double x, double y){
        return x + y;
    }
    double sum(double x, double y, double z){
        return x + y + z;
    }

    double sum(double x, double y, int z){
        return (double)x + y + z;
    }

    //назвал иначе, конфликтует с методом - int sum(int a, int b)
    //совпадает сигнатура, по заданию строго указаны кол-во параметров,
    //их тип, и местами поменять нет смысла
    //этот метод убрали из задания
    double sum_double(int y, int z){
        return (double)y + z;
    }

    double sum(Integer y, Integer z){
        return y.doubleValue() + z.doubleValue();
    }

}
