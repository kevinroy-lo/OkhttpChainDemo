package chain;

import java.util.ArrayList;

public class RealCall {
    public static void main(String[] arg) {
        ArrayList<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new AInterceptor());
        interceptors.add(new BInterceptor());
        interceptors.add(new CInterceptor());

        Request request = new Request();
        RealInterceptChain chain = new RealInterceptChain(interceptors, 0, request, null, null, null);
        Response response = chain.proceed(request);
        System.out.println("response.msg = " + response.msg);
    }
}
