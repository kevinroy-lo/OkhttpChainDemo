package logger;

public class ELogger extends Logger{
    @Override
    void log(String msg) {
        System.out.println("logger -e: " + msg);
    }

    public ELogger(int mask) {
        super(mask);
    }
}
