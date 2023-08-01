package mod13les4.task2.data;

/***
 * -  Response - общий класс ответа; содержит:
 *    *  код ответа
 *    *  запрашиваемый объект
 */
public class Response {
    public int getResponceCode() {
        return responceCode;
    }

    private int responceCode;
    private Object responceObj;

    public Response(int responceCode, Object responceObj) {
        this.responceCode = responceCode;
        this.responceObj = responceObj;
    }

    public Object getResponceObj() {
        return responceObj;
    }
}
