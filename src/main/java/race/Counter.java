package race;

public class Counter {
    private int counter=0;
    public void increment(){
        counter++;
    }

    public int getCounter(){
        return counter;
    }

    public String toString(){
        return counter + "";
    }
}
