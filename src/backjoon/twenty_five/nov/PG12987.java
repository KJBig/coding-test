package backjoon.twenty_five.nov;

import java.util.*;

public class PG12987 {
    class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;
            List<Integer> numbers = new ArrayList<>();
            for (int i=0; i<B.length; i++) {
                numbers.add(B[i]);
            }
            numbers.sort(Comparator.naturalOrder());

            for (int i=0; i<A.length; i++) {
                int target = A[i]+1;
                int start = 0;
                int end = numbers.size()-1;
                int mid = (start+end)/2;
                int beforSize = numbers.size();
                while (start<=end) {
                    mid = (start+end)/2;
                    if (numbers.get(mid) > target) {
                        end = mid-1;
                    } else if (numbers.get(mid) < target) {
                        start = mid+1;
                    } else {
                        break;
                    }
                }

                if (numbers.get(mid) > target-1) {
                    numbers.remove(mid);
                    answer++;
                } else if (numbers.size()-1 > mid) {
                    numbers.remove(mid+1);
                    answer++;
                }
            }

            return answer;
        }
    }
}
