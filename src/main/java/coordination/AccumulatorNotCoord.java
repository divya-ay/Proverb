package coordination;

public class AccumulatorNotCoord implements Accumulator{
    int[] nums = new int[2];
    int n = 0;
    public void put ( int parcela){
        nums[n++] = parcela;
    }

    public int getSum(){
        n = 0;
        return nums[0] + nums[1];
    }
}
