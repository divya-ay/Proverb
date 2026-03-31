package coordination;

public class CoordinationMain {
    public static void main(String[] args){
        Accumulator acc = new AccumulatorNotCoord();
        (new Thread(new ParcelGenerator(acc))). start();
        (new Thread(new SumViewer(acc))). start();

    }
}
