import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Window extends JFrame implements ActionListener {

    Logic logic = new Logic();
    JPanel  greedContainer= new JPanel ();
    GridLayout layout = new GridLayout(0, 2, 5, 12);
    JButton del;
    JButton btnPlus;
    public Window(String title) {
        setTitle(title);
        setSize(500,400);
        Container container = getContentPane();//вытаскиваем контейнер из окна
        container.setLayout(new BorderLayout());//добавляем на него layout
        container.add(greedContainer,BorderLayout.CENTER);


        greedContainer.setLayout(layout);
        greedContainer.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));


        getContentPane().add(greedContainer);
        pack();
        setVisible(true);


         btnPlus = new JButton("+");//созд и  описываем кнопу
        btnPlus.setSize(30,30);
        btnPlus.addActionListener(this);

        container.add(btnPlus, BorderLayout.SOUTH);// Добавляем кнопку в контейнер снизу

        setDefaultCloseOperation( EXIT_ON_CLOSE );//закрытие проги по крестику
        setVisible(true);


    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void createGraphics(int interval, int liters){
        //расчитываем время на интервалы от 8 утра до 22 вечера

        long currentTime = 480000;
        long partTime = 840000 / interval;

        int stakan = liters * 1000 / interval;
        for (int i = 0; i < interval; i++) {
            logic.setTime(currentTime);

            double time = round(currentTime/1000/60,2);
            addViewElement(time+" выпить " + stakan+"ml");
            currentTime += partTime;
//            double min =  time%10;
        }


        setSize(getWidth(),getHeight()+30*interval);
        repaint();
    }
    public void addViewElement(String value){
        layout.setRows(layout.getRows()+1);
        JLabel timeToAlarm = new JLabel(value);
        timeToAlarm.setBounds(15,10,50,30);
        greedContainer.add(timeToAlarm);
        JButton iDrink = new JButton("Я попил");
        iDrink.setBounds(60,10,50,30);
        greedContainer.add(iDrink);
        iDrink.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (btnPlus.equals(source)) {//код для "плюса"
            SelectTime selectTime = new SelectTime("Select Time");
            selectTime.a(this);

        } else if (source instanceof JButton) {//код для кнопки "делит"
            JButton b = (JButton)source;
            if(b.getText().equals("Я попил")){
                b.setText("Выпито");
            }
            //logic.delete(b.getName());
           // System.out.println("del");
        }

    }

}
