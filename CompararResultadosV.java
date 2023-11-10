import java.util.Comparator;
import java.util.stream.Collector;

public class CompararResultadosV implements Comparator <int[]>{
    @Override
    public int compare(int[] o1, int[] o2) {
        // TODO Auto-generated method stub
       return -(o1[0]-o2[0]);
    }

}