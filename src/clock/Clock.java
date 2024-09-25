package clock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends JPanel {

    private JLabel labelTime;
    private SimpleDateFormat formatTime;

    public Clock() {
        formatTime = new SimpleDateFormat("HH:mm:ss");
        labelTime = new JLabel();
        labelTime.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        labelTime.setHorizontalAlignment(SwingConstants.CENTER);

        labelTime.setOpaque(false);
        setOpaque(false);
        setLayout(new BorderLayout());
        add(labelTime, BorderLayout.CENTER);
        
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    private void updateTime() {
        String currentTime = formatTime.format(new Date());
        labelTime.setText(currentTime);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reloj Digital Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        Clock clock = new Clock();
        frame.add(clock);

        frame.setVisible(true);
    }
}

