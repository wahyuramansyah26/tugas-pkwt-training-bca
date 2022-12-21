import java.util.HashSet;
import java.util.Set;

public class FindSameValueArray {
    public static void main(String[] args) throws Exception {
        int[] array1 = {2,3,4,5};
        int[] array2 = {1,3,5,7};

        FindSameElementArray(array1, array2);
    }

    public static void FindSameElementArray(int[] array1, int[] array2) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < array1.length; i++) {
            for(int j = 0; j < array2.length; j++)  {
                if(array1[i] == array2[j]) {
                    set.add(array1[i]);
                    break;
                }
            }
        }

        for (Integer integer : set) {
            System.out.print(integer + " ");
        }
    }
}
