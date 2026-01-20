package backjoon.twenty_six.jan;

public class PG92335 {

    class Solution {
        public int solution(int n, int k) {
            int answer = 0;

            // k 진수로 바꾸기
            StringBuilder sb = new StringBuilder();
            while (n >= k) {
                int value = n%k;
                sb.append(value);
                n = n/k;
            }
            sb.append(n);
            sb.reverse();

            String convertedNumber = sb.toString();

            // P 탐색
            for (int i=0; i<convertedNumber.length(); i++) {
                StringBuilder sbNumber = new StringBuilder();
                int counterIndex = 0;
                char nowWord = convertedNumber.charAt(i);

                if (nowWord == '0') {
                    continue;
                }

                // P 후보군 만들기
                while (nowWord != '0') {
                    sbNumber.append(nowWord);

                    counterIndex++;
                    if  (i+counterIndex < convertedNumber.length()) {
                        nowWord = convertedNumber.charAt(i+counterIndex);
                    }

                    if (nowWord == '0') {
                        break;
                    }

                    if (i+counterIndex >= convertedNumber.length()) {
                        break;
                    }
                }

                // 소수 체크
                if(isPrime(Long.parseLong(sbNumber.toString()))) {
                    answer++;
                }

                i+=counterIndex;
            }

            return answer;
        }

        private boolean isPrime(long n) {
            if (n < 2) return false;
            if (n == 2 || n == 3) return true;
            if (n%2 == 0) return false;

            for (long i=3; i<=(n/i); i+=2) {
                if (n%i == 0) {
                    return false;
                }
            }

            return true;
        }
    }

}
