import java.util.Timer;

public class App {


    public static void main(String[] args) {
        /*
        0 = Game Of Life
        1 = War-Tor
        2 = Forest Fire
         */
        CAController ca = new CAController(0);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(ca,3000,1000);
    }
}
