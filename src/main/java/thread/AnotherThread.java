package thread;

import static thread.ThreadColor.ANSI_BLACK;
import static thread.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLACK + currentThread().getName());

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            System.out.println(ANSI_BLUE + "Another thread wakes up");
        }

        System.out.println("Three seconds passed and I am awaken " + currentThread().getName());
    }


}
