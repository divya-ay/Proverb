package coordination;
import java.util.Random;

public class SumViewer implements Runnable{
    private Accumulator acc;

    public SumViewer(Accumulator acc){
        this.acc = acc;
    }

    public void run(){
        Random random = new Random();

        while (true){
            System.out.println(" The result is :" + acc.getSum());

            try{
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException ignored){

            }
        }
    }
}
