package logger;

/**
 * wiki:
 * 责任链模式在面向对象程式设计里是一种软件设计模式，它包含了一些命令对象和一系列的处理对象。每一个处理对象决定它能处理哪些命令对象，
 * 它也知道如何将它不能处理的命令对象传递给该链中的下一个处理对象。该模式还描述了往该处理链的末尾添加新的处理对象的方法。
 */
public class AllLogger extends Logger {
    public static final int ERROE = 4;
    public static final int DEBUG = 3;
    public static final int INFO = 2;
    public static final int ALL = 1;

    @Override
    void log(String msg) {
        System.out.println("logger -all: " + msg);
    }

    public AllLogger(int mask) {
        super(mask);
    }

    public static void main(String[] msg) {
        Logger logger = new AllLogger(ALL)
                .setNext(new ILogger(INFO)
                        .setNext(new DLogger(DEBUG)
                                .setNext(new ELogger(ERROE))));
        logger.sentLog("hello", DEBUG);
    }
}
