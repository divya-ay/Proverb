package coordination;

public class AccumulatorSafe implements Accumulator{
    int[] nums = new int[2];

    int n=0;

    public synchronized void put(int parcela){
        while (n==2){
            try {
                wait();
            }catch (InterruptedException ignored){

            }
        }
        nums[n++] = parcela;
        notifyAll();
    }
    public synchronized int getSum(){
        while (n<2){
            try {
                wait();
            }catch (InterruptedException ignored){
            }
        }
        n = 0;
        notifyAll();
        return nums[0] + nums[1];
    }
}
