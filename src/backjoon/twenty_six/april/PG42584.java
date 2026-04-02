package backjoon.twenty_six.april;

import java.util.*;

public class PG42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                Stock stock = stack.pop();
                answer[stock.index] = i - stock.index;
            }
            stack.push(new Stock(i, prices[i]));
        }

        while (!stack.isEmpty()) {
            Stock stock = stack.pop();
            answer[stock.index] = (prices.length-1) - stock.index;
        }

        return answer;
    }

    class Stock {
        int index;
        int price;

        public Stock (int index, int price) {
            this.index = index;
            this.price = price;
        }
    }
}
