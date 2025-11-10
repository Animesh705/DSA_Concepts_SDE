package Arrays;


import java.util.ArrayList;
import java.util.*;
public class remove_dupli_unsorted {
    public static void main(String[] args) {
        int[] arr = {4, 5, 4, 2, 2, 3, 1};
        ArrayList<Integer> result = removeDuplicates(arr);
        System.out.print("Array after removing duplicates: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

        public static ArrayList<Integer> removeDuplicates(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[i] != arr[j]) {
                        System.out.print(arr[i] + " ");
                    }
                    else {
                        continue;
                    }
                    }
                }
return null;
            }
}
