/**
 * @param arr The array of interger searching
 * @param find the integer
 * @return return the find when its the first time in arr
 *
 */
package utils;
import java.util.Arrays;
public class NumberUtils {
    public static int getPos(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for(int i =0; i<arr.length; i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param arr for searing using.
     * @param target to find the last element.
     * @return if-1 that means couldn find it or nullso return-1,if i then yes
     */
    public static int getLastPos(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        if(arr==null){
            throw new NullPointerException("arr is null");
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param x its the first arrays to compare
     * @param y its the second arrays to copare
     * @return false or the code is true:same length and same order
     */
    public static boolean isIdentical(int[]x, int[]y) {
        if (x== y) {
            return true;
        }
        if (x == null || y == null || x.length != y.length) {
            return false;
        }
            for (int i = 0; i < x.length; i++) {
                if (x[i] != y[i]) {
                    return false;
                }
            }
            return true;
        }

    /**
     *
     * @param x its the first arrays to compare
     * @param y its the second arrays to copare
     * @return true if all arrays its the same elements
     */
    public static boolean  isEqual(int[]x, int[]y) {
        if(x==y){
            return true;
        }
        if(x==null||y==null||x.length!=y.length) {
            return false;
        }
        int[] samex=Arrays.copyOf(x, x.length);
        int[] samey=Arrays.copyOf(y, y.length);
        Arrays.sort(samex);
        Arrays.sort(samey);
        return Arrays.equals(samex,samey);
    }

    /**
     *
     * @param x its the array for test.
     * @param y its the array for test .
     * @return true if x subset to y, false  if x null or y null or both of them
     * x is longer or equal to y or not contain anything
     */
    public static boolean isSubset(int[]x, int[]y) {
        if(x==null||y==null||x.length==0||x.length>=y.length){
            return false;
        }
        int[] samex=Arrays.copyOf(x, x.length);
        int[] samey=Arrays.copyOf(y, y.length);
        Arrays.sort(samex);
        Arrays.sort(samey);
        int i=0,j=0;
        while(i<samex.length&&j<samey.length){
            if(samex[i]==samey[j]){
                i++;
                j++;
            }
            else if(samex[i]>samey[j]){
                j++;}
            else
            {
                return false;
            }
        }
        return i==samex.length;
    }

    /**
     *
     * @param arr use array for serching  intergers
     * @return if -1 that means code is null or not contains anything /the largest number
     */
    public static int getMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        return max;
    }
}