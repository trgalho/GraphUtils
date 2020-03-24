import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * A Class to perform some sets math operations not definied by HashSet implementation.
 *
 * @author Talisson Galho - trgalho at GitHub
 */

public class SetUtils {
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
    public static <T> Set<Set<T>> powerSet(Set<T> set){
        T[] setAsArray = (T[]) set.toArray();
        int pwrStsize = (int) (Math.pow(2, (double) set.size()));

        ArrayList<HashSet<T>> powerArray= new ArrayList<>();

        for (int i = 0; i < pwrStsize; i++) {
            powerArray.add(new HashSet<>());
        }

        for (int i = 0; i < setAsArray.length; i++) {
            int n = (int) (Math.pow(2,(i)));
            addElementToSubsets( setAsArray[i], powerArray,n);
        }
        return new HashSet<Set<T>>(powerArray);
    }

    /**
     * Method to add an element to all corresponding subsets.
     *
     * @param element element to add in the set
     * @param power powerset contain the set to receive the element
     * @param n numbers of set to add the element before alternate
     */
    private static <T> void addElementToSubsets(T element, ArrayList<HashSet<T>> power, int n){
        for (int i = 0; i < power.size(); i+=2*n) {
            for (int j = 0; j < n; j++) {
                power.get(j+i).add(element);
            }
        }
    }

}
