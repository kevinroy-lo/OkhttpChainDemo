package chain;

interface Interceptor {
    Response intercept(Chain chain);
}
