import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logic {
    ArrayList <TimeThread> times = new ArrayList<>();
    public void setTime(long time){
        Date now = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd,hh:mm");
        Date today = null;
        try {
            today = formatForDateNow.parse(now.getYear()+"."+now.getMonth()+"."+now.getDay()+",00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        brain(time-(now.getTime()-today.getTime()));
    }
    public void delete(String time){

        for (TimeThread t : times) {
            if(t.getName().equals(time)) {
                times.remove(t);
                break;
            }
        }
        //todo stap to thread
    }
    public void brain(long dateTo){
        if(dateTo<=0)
            return;
        TimeThread timeThread = new TimeThread(dateTo,this);
        timeThread.start();
        timeThread.setName((String.valueOf(dateTo)));
        times.add(timeThread);
    }
    public void alarm(String time){
        WindowNotify windowNotify = new WindowNotify(time);

        //+ music
    }
}