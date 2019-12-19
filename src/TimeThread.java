import java.util.Date;

public class TimeThread extends Thread {
    private final long timeToAlarm;
    private  Logic logic;
    @Override
    public void run() {
        try {
            sleep(timeToAlarm);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logic.alarm(getName());
    }
    public TimeThread (long timeToAlarm,Logic logic) {
        this.timeToAlarm = timeToAlarm;
        this.logic = logic;
    }
}
