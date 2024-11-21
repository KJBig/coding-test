package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bj_5464 {

    static Queue<Car> carQueue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int answer = 0;

        List<Car> cars = new ArrayList<>();
        Queue<Integer> commends = new LinkedList<>();
        int[] fee = new int[N];
        boolean[] place = new boolean[N];

        for (int i=0; i<N; i++) {
            fee[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<M; i++) {
            cars.add(new Car(i+1, Integer.parseInt(br.readLine())));
        }

        for (int i=0; i<M*2; i++) {
            commends.add(Integer.parseInt(br.readLine()));
        }

        while (!commends.isEmpty()) {
            Integer commend = commends.poll();
            if (commend > 0) {
                answer += insertToPlace(place, fee, cars, commend-1);
            } else {
                answer += pollFromPlace(place, fee, cars, (commend*-1)-1);
            }
        }

        System.out.println(answer);
    }

    private static int pollFromPlace(boolean[] place, int[] fee, List<Car> cars, Integer commend) {
        place[cars.get(commend).nowPlace] = false;

        int targetFee = 0;
        int carWeight = 0;
        if (!carQueue.isEmpty()) {
            Car car = carQueue.poll();
            place[cars.get(commend).nowPlace] = true;
            targetFee = fee[cars.get(commend).nowPlace];
            car.nowPlace = cars.get(commend).nowPlace;
            carWeight = car.weight;
        }
        return targetFee*carWeight;
    }

    private static int insertToPlace(boolean[] place, int[] fee, List<Car> cars, Integer commend) {
        int targetFee = 0;
        boolean flag = false;
        for (int i=0; i<place.length; i++) {
            if (!place[i]) {
                place[i] = true;
                targetFee = fee[i];
                cars.get(commend).nowPlace = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            return targetFee*cars.get(commend).weight;
        } else {
            carQueue.add(cars.get(commend));
            return 0;
        }

    }

    private static class Car {
        public int id;
        public int weight;
        public Integer nowPlace;

        public Car(int id, int weight) {
            this.id = id;
            this.weight = weight;
            this.nowPlace = null;
        }

    }
}
