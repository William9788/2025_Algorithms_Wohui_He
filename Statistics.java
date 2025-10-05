package utils;
import java.util.Arrays;
public class Statistics {
    public static void main(String[] args) {
        int[] randomArray = DataGenerator.getRandomArray(10);
    int [] hardcoded={10,20,10,20,60,10,5,60,5,60};
    System.out.println("random array:"+Arrays.toString(randomArray));
    System.out.println("hardcoded array:"+Arrays.toString(hardcoded));
    int max=NumberUtils.getMax(randomArray);
    if(max==-1) {
        System.out.println("no max or null");
    }
    else {
        int maxvalue = randomArray[max];
        int firstPos = NumberUtils.getPos(randomArray, maxvalue);
        int lastPos = NumberUtils.getLastPos(randomArray, maxvalue);
        System.out.println("max value:" + maxvalue);
        System.out.println("first pos:" + firstPos);
        System.out.println("last pos:" + lastPos);
    }
    boolean identical=NumberUtils.isIdentical(randomArray,hardcoded);
    boolean equal=NumberUtils.isEqual(randomArray,hardcoded);
    boolean subset=NumberUtils.isSubset(randomArray,hardcoded);
    if(identical) {
        System.out.println("identical");
    }
else if(equal) {
    System.out.println("equal");
}
else if(subset) {
System.out.println("subset");
}
else {
    System.out.println("not identical,not subset,not equal");
}
    }
}
