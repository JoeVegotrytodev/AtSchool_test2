package mod7les9.task2.vegetables;

import java.util.Random;

public class Cucumber implements Vegetable {

    public String toString(){
        Random random = new Random();
        return "Огурец" + random.nextInt();
    }

/*    А еще говорилось на вебинаре про другой вариант задания, что ключ-объект
      Но я сделал по заданию, с ключом  стрингой
      Но при другом варианте, переоделил бы хэш код по примеру ниже, заменив на тот же рендом
      или с помощью счетчика

    @Override
    public int hashCode(){
        Random random = new Random();
        return hashCode() - random.nextInt();
    }  */
}
