package Arrays;

import java.util.Scanner;
import java.util.Arrays;

    public class rough {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter size of the array: ");
            int n = sc.nextInt();
            int[] arr = new int[n];

            System.out.println("Enter the elements:");
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            countFrequency(arr);
        }

        // Frequency count only using arrays (works if range is small and positive)
        public static void countFrequency(int[] arr) {
            int max = Arrays.stream(arr).max().getAsInt();  // largest element
            int[] freq = new int[max + 1];  // frequency array

            for(int num : arr) {
                freq[num]++;
            }

            System.out.println("Element frequencies:");
            for(int i = 0; i < freq.length; i++) {
                if(freq[i] > 0) {
                    System.out.println(i + " -> " + freq[i]);
                }
            }
        }
    }


