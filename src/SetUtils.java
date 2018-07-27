import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetUtils <E>{

    public  Set<Set<E>> powerSet(Set<E> set){
        E[] setAsArray = (E[]) set.toArray();
        int pwrStsize = (int) (Math.pow(2, (double) set.size()));

        ArrayList<HashSet<E>> powerArray= new ArrayList<>();
        for (int i = 0; i < pwrStsize; i++) {
            powerArray.add(new HashSet<>());
        }

        for (int i = 0; i < setAsArray.length; i++) {
            int n = (int) (pwrStsize/(Math.pow(2,(i+1))));
            addSubset( setAsArray[i], powerArray,n);
        }
        return null;
    }

    private void addSubset(E element, ArrayList<HashSet<E>> power, int n){
        System.out.println(n);
        for (int i = 0; i < power.size(); i+=2*n) {
            for (int j = 0; j < n; j++) {
                System.out.println("j "+ j+ " i:" + i + "  j+i:"+ (j+i));
                power.get(j+i).add(element);
            }
        }
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        SetUtils setUtils = new SetUtils<Integer>();
        setUtils.powerSet(set);
    }
}
