import array.sorting;

public class SortingArray {
    public static void main(String[] args) throws Exception {
        sorting array = new sorting();
        int[] arr = {3,2,4,1,5};
        System.out.println("Array Sebelum Sorting");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Array Setelah Sorting");
        array.setArray(arr);
        array.sortArray();
        arr = array.getArray();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
    }
}
