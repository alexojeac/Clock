import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockBean extends JPanel implements Serializable {

    private JLabel labelTime;
    private SimpleDateFormat formatTime;
    private String format;

    public ClockBean() {
        this.format = "HH:mm:ss";
        formatTime = new SimpleDateFormat(format);
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
        this.formatTime = new SimpleDateFormat(format);
    }

    public int getFontSize() {
        return labelTime.getFont().getSize();
    }

    public void setFontSize(int size) {
        labelTime.setFont(new Font("Verdana", Font.PLAIN, size));
    }
}

