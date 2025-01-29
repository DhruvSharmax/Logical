package challenges;

import java.util.ArrayList;
import java.util.List;

public class AllCombinationsAddUpToSum {
    static List<Integer> output = new ArrayList<>();
    static int[] arr = {3, 7, 9, 2, 6, 15, 8, 1};
    public static void main(String[] args) {
        var target = 9;
        findCombinations(target,0);
    }

    private static void findCombinations(int target, int statIndex) {
        if(target==0){
            System.out.println(output);
            return;
        }
        for (var i=statIndex;i<arr.length;i++){
            if(arr[i]<=target){
                output.add(arr[i]);
                findCombinations(target-arr[i],i+1);
                output.remove(output.size()-1);
            }
        }
    }
}
