package chain;

public class CInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) {
        Response proceed = new Response();
        proceed.msg = "data from server... \n";
        System.out.println("get data... \n");
        return proceed;
    }
}
