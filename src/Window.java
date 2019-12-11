import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
import java.util.Date;

public class Window extends JFrame implements ActionListener {

    Logic logic = new Logic();
    JPanel  greedContainer= new JPanel ();
    GridLayout layout = new GridLayout(0, 3, 5, 12);
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

    public void addTime(String time){
        layout.setRows(layout.getRows()+1);
        JLabel l  = new JLabel(time);
        l.setSize(50,50);
        greedContainer.add(l);
        JButton b1 = new JButton("edit");
        b1.setName(time);
        b1.setSize(50,50);
        greedContainer.add(b1);
        del = new JButton("del");
        del.addActionListener(this);
        greedContainer.add(del);

        setSize(getWidth(),getHeight()+70);
        repaint();
        logic.setTime(time);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (btnPlus.equals(source)) {//код для "плюса"
            SelectTime selectTime = new SelectTime("Select Time");
            selectTime.a(this);

        } else if (del.equals(source)) {//код для кнопки "делит"
            JButton b = (JButton)source;
            logic.delete(b.getName());
            System.out.println("del");
        }

    }

}
