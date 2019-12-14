import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTime extends JFrame implements ActionListener {
    Window window;
    JTextField Interval = new JTextField();
    JTextField NumOfLit = new JTextField();

    public SelectTime(String title) {
        setTitle(title);
        setBounds(1000, 500, 350, 300);// Размеры и место формы
        setLayout(null);// Убираем лайаут и ориентируемся по пикселям
        setVisible(true);

        JButton btnOk = new JButton("OK");
        btnOk.setBounds(135, 200, 70, 50);
        btnOk.addActionListener(this);// Подписал кнопку на слушатель событий
        add(btnOk); //Добавляем кнопку в форму


        Interval.setBounds(220, 40, 80, 40);
        Interval.addActionListener(this);

        add(Interval);


        NumOfLit.setBounds(220, 100, 80, 40);
        NumOfLit.addActionListener(this);
        add(NumOfLit);




        JLabel hourLabel = new JLabel("Interval");
        hourLabel.setBounds(60, 50, 100, 20);
        add(hourLabel);

        JLabel minuteLabel = new JLabel("Number of liters");
        minuteLabel.setBounds(60, 110, 100, 20);
        add(minuteLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {// Слушатель событий

        String time = Interval.getText() + ":" +NumOfLit.getText();

        //    tfHour.setText(String.valueOf(Integer.valueOf(tfHour.getText()) + 1));
        window.createGraphics(Integer.valueOf(Interval.getText()),Integer.valueOf(NumOfLit.getText()));
        dispose();
    }
    void a(Window window){
        this.window = window;

    }
}
