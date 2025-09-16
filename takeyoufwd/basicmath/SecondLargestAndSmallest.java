package takeyoufwd.basicmath;

import java.util.Arrays;

import static takeyoufwd.basicmath.ArrayStaticUtil.myarr;

public class SecondLargestAndSmallest {
    void main() {
        int[] arr = myarr;
        System.out.println("Arr: "+ Arrays.toString(arr));
        largest(arr);
        smallest(arr);
    }

    public void largest(int[] arr) {
        int largest = arr[0], slargest = -1;
        for(int i =1; i<arr.length;i++){
            if(arr[i]>largest){
                slargest = largest;
                largest = arr[i];
            } else if(arr[i]!=largest && arr[i]>slargest)
                slargest = arr[i];
        }
        System.out.println("largest="+largest +"\nslargest="+ slargest);
    }

    private void smallest(int[] arr) {
        int smallest = arr[0];
        int ssmallest = Integer.MAX_VALUE;
        for(int i=1; i<arr.length;i++) {
            if(arr[i]<smallest) {
                ssmallest = smallest;
                smallest = arr[i];
            } else if (arr[i]!=smallest && arr[i]<ssmallest)
                ssmallest = arr[i];
        }
        System.out.println("smallest="+smallest +"\nssmallest="+ ssmallest);
    }

}
