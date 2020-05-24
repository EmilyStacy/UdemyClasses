package thread;

import static thread.ThreadColor.ANSI_RED;

public class MyRunable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "my runnable thread");
    }
}
