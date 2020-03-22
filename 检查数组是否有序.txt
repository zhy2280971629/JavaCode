public class IsSorted {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,4,5,6,7,5,8};
        int[] array1 = {1,2,3,4,4,5,6,7,8,9};
        System.out.println(isSorted(array));
        System.out.println(isSorted(array1));
    }
    public static boolean isSorted(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            if (array[i]>array[i+1]){
                return false;
            }
        }
        return true;
    }
}