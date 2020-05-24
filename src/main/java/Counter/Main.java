package Counter;

public class Main {
    public static void main(String[] args) {
        CountDown countDown = new CountDown();

        CountDownThread t1 = new CountDownThread(countDown);
        t1.setName("Thread 1");
        CountDownThread t2 = new CountDownThread(countDown);
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }

}

 class CountDown{
    private int i;
    //synchronized makes sure a thread will finish running before decrementing the next i
    //cannot synchronize counstructor
     // public synchronized void doCountDown()
     //only local string can avoid the lock competition; other variables will cause thread interference
public void doCountDown(){


        String color = null;
        switch(Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            case "Thread 3":
                color = ThreadColor.ANSI_GREEN;
                break;
        }
    // intrinsic lock
    synchronized (this) {
        for (i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + " :i= " + i);
        }
    }
        }
        }

class CountDownThread extends Thread{
    private CountDown threadCountDown;

    public CountDownThread(CountDown countDown){
        threadCountDown = countDown;
    }

    public void run(){
        threadCountDown.doCountDown();
    }
}