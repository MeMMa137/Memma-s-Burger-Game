import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameTimer {

    private int timeLeft;
    private Timer timer;
    private TimerListener listener;

    public GameTimer(int initialTime, TimerListener listener) {
        this.timeLeft = initialTime;
        this.listener = listener;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimer();
            }
        });
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    private void updateTimer() {
        if (timeLeft > 0) {
            timeLeft--;
            listener.onTimeUpdate(timeLeft);
        } else {
            timer.stop();
            listener.onTimeUp();
        }
    }

    public interface TimerListener {
        void onTimeUpdate(int timeLeft);
        void onTimeUp();
    }
}
