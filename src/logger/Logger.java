package logger;



abstract class Logger {

    private Logger next;
    private int mask;

    public Logger(int mask) {
        this.mask = mask;
    }

    Logger setNext(Logger next) {
        this.next = next;
        return this;
    }

    public final void sentLog(String msg, int priority) {
        if (mask <= priority) {
            log(msg);
            if (next != null) {
                next.sentLog(msg, priority);
            }
        }
    }

    abstract void log(String msg);


}
