package chain;

interface Chain {
    Response proceed(Request request);
    Request request();

}
