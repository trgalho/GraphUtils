import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetUtils <E>{
    public  Set<Set<E>> powerSet(Set<E> set){
       E[] setAsArray = (E[]) set.toArray();
       /* for (int i = 0; i < setAsArray.length; i++) {
            for (int j = i; j < setAsArray.length; j++) {
                Set<E> subset = new HashSet<>();
                subset.add(setAsArray[i]);
                for (int k = 0; k < j+1; k++) {
                    subset.add(setAsArray[i + k +1]);
                }
                pwrSt.add(subset);
                System.out.println(subset);
            }
        }*/
        int pwrStsize = (int) (Math.pow(2, new Double(set.size())));
        System.out.println("Set size "+setAsArray.length);
        System.out.println("Set pwrStsize "+pwrStsize);


        ArrayList<HashSet<E>> powerArray= new ArrayList<>();
        for (int i = 0; i < pwrStsize; i++) {
            powerArray.add(new HashSet<>());
        }

        for (int i = 0; i < setAsArray.length; i++) {

            int n = (int) (pwrStsize/(2*(i+1)));
            addSubset( setAsArray[i], powerArray,n);
            System.out.println("Parametros "+setAsArray[i]+" "+ n);
        }
        System.out.println(powerArray);
        return null;
    }

    private void addSubset(E element, ArrayList<HashSet<E>> power, int n){
        System.out.println(n);
        for (int i = 0; i < power.size(); i+=n) {
            for (int j = 0; j < n; j++) {
                System.out.println("j "+ j+ " i:" + i + "  j+i:"+ (j+i));
                power.get(j+i).add(element);
            }
        }
    }

    public static void main(String[] args) {
        Set set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        SetUtils setUtils = new SetUtils<Integer>();
        setUtils.powerSet(set);
    }
}
