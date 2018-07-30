import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * A Class to perform some sets math operations not definied by HashSet implementation.
 *
 * @author Talisson Galho - trgalho at GitHub
 *
 * @param <E> type of element that is contained in your set.
 */

public class SetUtils <E>{
    /**
     *  Returns  all subsets of a set using Truth Table input method.
 	 *	First we created all possible subsets (2^n, where n is size of set)
 	 *	Then we distribute all elements in all possible subsets following this pattern:
	 *	For the first element, we add it to the first subset then not add it to second one. Then we repeated the pattern until run out of sets.
	 *	Next element will be added it to the first and the second one, and not to third and the fourth one. Repeat in the same way.
	 *	We repeat the pattern until run out of elements, as result the last element being added to the first n/2 sets and not added to others. 
	 *
     * @param set - any set
     * @return A Set contain all subsets of the argument.
     */
    public Set<Set<E>> powerSet(Set<E> set){
        E[] setAsArray = (E[]) set.toArray();
        int pwrStsize = (int) (Math.pow(2, (double) set.size()));

        ArrayList<HashSet<E>> powerArray= new ArrayList<>();
        for (int i = 0; i < pwrStsize; i++) {
            powerArray.add(new HashSet<>());
        }

        for (int i = 0; i < setAsArray.length; i++) {
            int n = (int) (Math.pow(2,(i)));
            addElementToSubsets( setAsArray[i], powerArray,n);
        }
        return new HashSet<Set<E>>(powerArray);
    }

    /**
     * Method used to print all subsets from a set ordering them by size.
     * Useful for check if the powerSet was sucessfully created.
     * @param set - Any set of sets.
     */
    public void printSubSetsSortedBySize(Set<Set> set){
        ArrayList<Set> setAsArray = new ArrayList<>(set);
        setAsArray.sort(new Comparator<Set>() {
            @Override
            public int compare(Set o1, Set o2) {
                return o1.size() - o2.size();
            }
        });
        for(Set subset : setAsArray) {
            System.out.println(subset);
        }
    }

    /**
     * Method to add an element to all corresponding subsets.
     *
     * @param element element to add in the set
     * @param power powerset contain the set to receive the element
     * @param n numbers of set to add the element before alternate
     */
    private void addElementToSubsets(E element, ArrayList<HashSet<E>> power, int n){
        for (int i = 0; i < power.size(); i+=2*n) {
            for (int j = 0; j < n; j++) {
                power.get(j+i).add(element);
            }
        }
    }

    /**
     * Test method creating a powerSet for a predefined set of size 4.
     * @param args
     */
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        SetUtils setUtils = new SetUtils<Integer>();
        System.out.println("Test for the set: "+set);
        setUtils.printSubSetsSortedBySize(setUtils.powerSet(set));
    }
}
