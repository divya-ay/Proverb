package race;

public class RaceWorker implements Runnable{
    private final int max;
    private final String name;
    private final Counter counter;

    public RaceWorker(int max, String name, Counter counter){
        this.max= max;
        this.name= name;
        this.counter= counter;
    }

    @Override
    public void run(){
        for(int i = 0; i<max; i++){
            counter.increment();
            System.out.println("[" + name + "] counter: " +  counter);
        }
    }
}
