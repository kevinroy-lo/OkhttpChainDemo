package chain;

public class AInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) {
        RealInterceptChain interceptChain = (RealInterceptChain) chain;
        Request request = chain.request();
        System.out.println("open StreamAllocation...\n");
        Response proceed = interceptChain.proceed(request, new StreamAllocation(), null, null);
        return proceed;
    }
}
