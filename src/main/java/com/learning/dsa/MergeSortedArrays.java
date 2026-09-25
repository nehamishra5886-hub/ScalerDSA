package com.learning.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArrays {
    public static void main(String[] args) {
        //int A [][] = {{1,3},{2,6},{8,10},{15,18}};
        //int A [][] = {{2,10},{4,9},{6,7}};
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1,3)));
        input.add(new ArrayList<>(Arrays.asList(2,6)));
        input.add(new ArrayList<>(Arrays.asList(8,10)));
        input.add(new ArrayList<>(Arrays.asList(15,18)));
        //input.add(new ArrayList<>(Arrays.asList(1,3)));

        ArrayList<ArrayList<Integer>> merged = mergeinetrvals(input);

        System.out.println("Merged : "+merged);

    }

    public static ArrayList<ArrayList<Integer>>  mergeinetrvals(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> merged = new ArrayList<>();

        for (ArrayList<Integer> interval : A) {
            // If merged list is empty or there is no overlap
            if(merged.isEmpty() || merged.get(merged.size()-1).get(1)<interval.get(0)) {
                merged.add(new ArrayList<>(interval));
                System.out.println("merged now "+merged);
                //System.out.println("last now ");
            } else {
                //Overlapping intervals: merge them
                ArrayList<Integer> last =merged.get(merged.size()-1);
                last.set(1, Math.max(last.get(1), interval.get(1)));
                System.out.println("last "+last);
            }

        }

        return merged;

    }
}
