package takeyoufwd.basicmath;

import challenges.stringPlay.CountFrequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static takeyoufwd.basicmath.ArrayStaticUtil.myarr;

public class CountArrayFrequency {
    public static void main(String[] args) {
        int[] arr = myarr;
        countFrequencies(arr);
        // similar code written in below method
        CountFrequency.eachCharCount("AAAABBCCDD");
        System.out.println();
        countFreqWithMap(arr);
    }
    public static void countFrequencies(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt()+1;
        int min = Arrays.stream(arr).min().getAsInt();

        int[] arr2 = new int[max];
        for (int i : arr)
            arr2[i]++;

        for(int i=min;i<max;i++)
            if(arr2[i]>0)
                System.out.println(i+":"+arr2[i]);
    }

    public static void countFreqWithMap(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:arr) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        System.out.println(map);
    }
}
