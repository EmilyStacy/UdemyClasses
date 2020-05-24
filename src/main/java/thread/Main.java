package thread;

import static thread.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_BLUE+ "Hello from the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("anotherThread");
        anotherThread.start();

        System.out.println(ANSI_GREEN+ "Hello again from the main thread");

        new Thread(){
            public void run(){
                System.out.println(ANSI_RESET+"New thread");
            }
        }.start();

        Thread myrunableThread = new Thread(new MyRunable()){
            @Override
            public void run() {
                System.out.println(ANSI_CYAN+ "hello from override myruuable");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_CYAN+ "Another thread terminated, so I am running again");
                }catch(InterruptedException e){
                    System.out.println(ANSI_BLUE + "I couldn't wait. I was interrupted");
                }
            }
        };

        myrunableThread.start();
        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE+ "My runnable New thread");
    }



}
