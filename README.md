# OkhttpChineDemo
okhttp中用到的经典的责任链模式。

```
/**
 * 责任链模式：
 * 可以看到，这个类其实本质就是一个中转的类，用来存储已经实例化好的StreamAllocation，RealConnection，HttpCodec
 * 每个Interceptor相当于一层，跟http协议很相似，每一层都有自己的使命。上一层没问题，才会将Request传达到下一层。
 * 与logger中的流程其实是一样的。
 *
 */
public class RealInterceptChain implements Chain {

    private final List<Interceptor> interceptors;
    private final int index;
    private Request request;

    private final StreamAllocation streamAllocation;
    private final HttpCodec httpCodec;

    private final RealConnection connection;

    public RealInterceptChain(List<Interceptor> interceptors,
                              int index, Request request,
                              StreamAllocation streamAllocation,
                              HttpCodec httpCodec, RealConnection connection) {
        this.interceptors = interceptors;
        this.index = index;
        this.request = request;
        this.streamAllocation = streamAllocation;
        this.httpCodec = httpCodec;
        this.connection = connection;
    }

    @Override
    public Request request() {
        return request;
    }

    public StreamAllocation getStreamAllocation() {
        return streamAllocation;
    }

    public HttpCodec getHttpCodec() {
        return httpCodec;
    }

    public RealConnection getConnection() {
        return connection;
    }

    @Override
    public Response proceed(Request request) {
        return proceed(request, streamAllocation, httpCodec, connection);
    }

    public Response proceed(Request request, StreamAllocation streamAllocation,
                            HttpCodec httpCodec, RealConnection connection) {
        RealInterceptChain interceptChain =
                new RealInterceptChain(interceptors, index + 1, request, streamAllocation, httpCodec, connection);
        Interceptor interceptor = interceptors.get(index);
        return interceptor.intercept(interceptChain);
    }
}
```
