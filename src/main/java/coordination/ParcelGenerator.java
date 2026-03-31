package coordination;
import java.util.Random;

public class ParcelGenerator implements Runnable{
    private Accumulator acc;

    public ParcelGenerator(Accumulator acc){
        this.acc = acc;
    }

    public void run(){
        Random random = new Random();
        while(true){
            int a = random.nextInt(5000);
            System.out.println("Putting: " + a);
            acc.put(a);

            try{
                Thread.sleep(a);
            }
            catch (InterruptedException ignored){

            }
        }
    }
}
