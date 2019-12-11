import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectTime extends JFrame implements ActionListener {
    Window window;
    JTextField tfHour = new JTextField();
    JTextField tfMinut = new JTextField();

    public SelectTime(String title) {
        setTitle(title);
        setBounds(1000, 500, 250, 200);// Размеры и место формы
        setLayout(null);// Убираем лайаут и ориентируемся по пикселям
        setVisible(true);

        JButton btnOk = new JButton("OK");
        btnOk.setBounds(90, 100, 70, 50);
        btnOk.addActionListener(this);// Подписал кнопку на слушатель событий
        add(btnOk); //Добавляем кнопку в форму


        tfHour.setBounds(22, 40, 80, 40);
        tfHour.addActionListener(this);

        add(tfHour);


        tfMinut.setBounds(147, 40, 80, 40);
        tfMinut.addActionListener(this);
        add(tfMinut);


        JLabel doubleDot = new JLabel(":");
        doubleDot.setBounds(123, 40, 6, 40);
        add(doubleDot);


        JLabel hourLabel = new JLabel("Hour");
        hourLabel.setBounds(22, 20, 30, 20);
        add(hourLabel);

        JLabel minuteLabel = new JLabel("Minute");
        minuteLabel.setBounds(147, 20, 55, 20);
        add(minuteLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {// Слушатель событий

        String time = tfHour.getText() + ":" +tfMinut.getText();

        //    tfHour.setText(String.valueOf(Integer.valueOf(tfHour.getText()) + 1));
        window.addTime(time);
        dispose();
    }
    void a(Window window){
        this.window = window;

    }
}
