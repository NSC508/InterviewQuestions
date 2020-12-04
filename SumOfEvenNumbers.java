import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * We have an array A of integers, and an array queries of queries.

For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.

(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)

Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 */

 public class SumOfEvenNumbers {
    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] tbr = new int[queries.length];
        //Find the indices of the even numbers 
        Set<Integer> evenIndices = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                evenIndices.add(i);
            }
        }
        int sum = 0; 
        for (int i : evenIndices) {
            sum += A[i];
        }
        //Loop over queries
        for (int i = 0; i < queries.length; i++) {
            int internalSum = sum;
            //If adding even number to already even, add that much to the sum 
            if (queries[i][0] % 2 == 0 && evenIndices.contains(queries[i][1])) {
                internalSum += queries[i][0];
                A[queries[i][1]] += queries[i][0];
            }
            //If adding odd number to even number, still stays odd (no change)
            //If adding odd number to odd number, number is now even. Add the amount to the sum and the indices of even numbers  
            if (queries[i][0] % 2 != 0 && !evenIndices.contains(queries[i][1])) {
                evenIndices.add(queries[i][1]);
                A[queries[i][1]] += queries[i][0];
                internalSum += A[queries[i][1]];
            }
            tbr[i] = internalSum;
        }
        return tbr;
    }

    public static void main(String[] args) {
        //Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
        //Output: [8,6,2,4]
        int[] A = new int[]{1, 2, 3, 4};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        System.out.println(Arrays.toString(sumEvenAfterQueries(A, queries)));
    }
 }