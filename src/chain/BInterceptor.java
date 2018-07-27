package chain;

public class BInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) {
        RealInterceptChain interceptChain = (RealInterceptChain) chain;
        Request request = chain.request();
        System.out.println("open HttpCodec...\n");
        Response proceed = interceptChain.proceed(request, interceptChain.getStreamAllocation(), new HttpCodec(), null);
        return proceed;
    }
}
