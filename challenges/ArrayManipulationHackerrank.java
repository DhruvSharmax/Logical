package challenges;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * problem statement given at C:\Users\erdhr\eclipse-workspace\Logical\Resources\Array Manipulation Hackerrank.docx
 *
 * My Understanding:
 * so we have given a 2D Array/2D List named queries, where columns of array will always be 3 with values a,b,k,
 * and rows can be a number given m, another parameter given will be size of array n, on which we will perform operations.
 * Initially array will contain all zeros,
 * So our task is to pick indexes given a to b (including the index itself) and add k in all those places.
 * At the end we need to return Maximum element in this modified array.
 */

public class ArrayManipulationHackerrank {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        Integer[] arr = new Integer[n+2];		// first +1 is because a,b index values will vary between 1 to a and java index starts from 0, second +1 is because after applying prefix sum Algo it will require one extra cell
        Arrays.fill(arr, 0);				// initializing with zero as suggested by problem statement
        for(List<Integer> i:queries) {
            int a = i.get(0);
            int b = i.get(1);
            int k = i.get(2);
            arr[a]+=k;
            arr[b+1]-=k;
        }
        long sum = 0;
        long max = Long.MIN_VALUE;
        for(int i:arr) {
            sum+=i;
            max = Math.max(sum, max);
        }
        return max;
    }

    @Test
    public void test1(){
        int n = 10;
        Integer[][] queries_arr = {{2,6,8},{3,5,7},{1,8,1},{5,9,15}};
        var queries = getLists(queries_arr);
        assertEquals(31,arrayManipulation(n, queries));
    }

    @Test
    public void test2(){
        int n = 5;
        Integer[][] queries_arr = {{1, 2, 100},{2,5,100},{3,4,100}};
        var queries = getLists(queries_arr);
        assertEquals(200,arrayManipulation(n, queries));
    }

    private static List<List<Integer>> getLists(Integer[][] queries_arr) {
        return Arrays.stream(queries_arr)
                .map(Arrays::asList)
                .collect(Collectors.toList());
    }
}