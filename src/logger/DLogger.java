package logger;

public class DLogger extends Logger{
    public DLogger(int mask) {
        super(mask);
    }

    @Override
    void log(String msg) {
        System.out.println("logger -d: " + msg);
    }
}
