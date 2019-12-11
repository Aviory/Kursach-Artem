import javax.swing.*;

public class WindowNotify extends JFrame {
    JPanel panel = new JPanel();

    public WindowNotify(String s) {
        setTitle("Alarm");
        setBounds(700, 900, 200, 200);

        JLabel time = new JLabel(s);
        JButton ok = new JButton("OK");
        ok.setBounds(60,70,60,40);


        time.setBounds(75,30,30,40);

    panel.setLayout(null);
        panel.add(time);
        panel.add(ok);
        getContentPane().add(panel);
        setVisible(true);
    }

}
