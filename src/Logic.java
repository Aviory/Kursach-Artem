import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logic {
    ArrayList <TimeThread> times = new ArrayList<>();
    public void setTime(String time){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd,hh:mm");
        Date dateTo = null;

        try {
            dateTo = formatForDateNow.parse("2019.12.14,"+time);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

        brain(dateTo,time);
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
    public void brain(Date dateTo,String time){
        Date dateNow = new Date();
        long timeToAlarm = dateTo.getTime()-dateNow.getTime();
        TimeThread timeThread = new TimeThread(timeToAlarm,this);
        timeThread.start();
        timeThread.setName(time);
        times.add(timeThread);
    }
    public void alarm(String time){
        WindowNotify windowNotify = new WindowNotify(time);

        //+ music
    }
}
