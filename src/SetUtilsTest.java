import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class SetUtilsTest {
    /** Inner counter to track tests */
    private static int counter=0;

    /**
     * Method used create a powerset from a target set and print all subsets from a set ordering them by size.
     *
     * Useful for check if the powerSet was successfully created.
     *
     * @param targetSet - Any set.
     */
    private static <T> Set<Set<T>> testPowerSetMethod(Set<T> targetSet){
        System.out.println("Test #"+ ++counter);
        System.out.println("targetSet = "+ targetSet );

        Set<Set<T>> powerSet = SetUtils.powerSet(targetSet);

        ArrayList<Set> setAsArray = new ArrayList<>(powerSet);

        setAsArray.sort(new Comparator<Set>() {
            @Override
            public int compare(Set o1, Set o2) {
                return o1.size() - o2.size();
            }
        });

        for(Set subset : setAsArray) {
            System.out.println(subset);
        }

        System.out.println();

        return powerSet;
    }


    /**
     * Test the method for create powersets.
     * @param args
     */
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        SetUtilsTest.testPowerSetMethod(set);

        set.add(1);
        SetUtilsTest.testPowerSetMethod(set);

        set.add(2);
        SetUtilsTest.testPowerSetMethod(set);

        set.add(3);
        SetUtilsTest.testPowerSetMethod(set);

        set.add(4);
        SetUtilsTest.testPowerSetMethod(set);
    }
}
