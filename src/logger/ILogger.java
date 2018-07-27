package logger;

public class ILogger extends Logger {
    @Override
    void log(String msg) {
        System.out.println("logger -i: " + msg);
    }

    public ILogger(int mask) {
        super(mask);
    }
}
