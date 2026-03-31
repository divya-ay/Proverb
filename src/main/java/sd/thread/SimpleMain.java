package sd.thread;


public class SimpleMain {
    public static void main(String[] args){
        new SimpleWorker(10, "A").run();
        new SimpleWorker(10, "B").run();


        new Thread(new SimpleWorker(10, "C")).start();
        new Thread(new SimpleWorker(10, "\t\tD")).start();

    }
}
