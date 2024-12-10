package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class bj_18869 {
    public static void main(String[] args) throws IOException {
        /*
        1 1 1
        1 1 1
        =-=
        1 1 2
        1 1 1
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int M = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);

        List<Universe> universes = new ArrayList<>();

        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            List<Planet> planets = new ArrayList<>();
            List<String> exits = new ArrayList<>();
            for (int j=0; j<N; j++) {
                String size = input[j];
                if (!exits.contains(size)){
                    planets.add(new Planet(j, Integer.parseInt(size)));
                    exits.add(size);
                } else {
                    planets.add(new Planet(j, -1));
                }
            }
            universes.add(new Universe(planets));
        }

        for (Universe universe : universes) {
            universe.getPlanets().sort(Comparator.comparing(Planet::getValue));
        }

        int answer = 0;

        for (int i=0; i<M; i++) {
            if (universes.get(i).hasPartner) {
                continue;
            }
            List<Planet> nowPlanets = universes.get(i).getPlanets();
            for (int j=i+1; j<M; j++) {
                if (universes.get(j).hasPartner) {
                    continue;
                }
                boolean flag = true;
                List<Planet> targetPlanets = universes.get(j).getPlanets();

                for (int k=0; k<N; k++) {
                    if (nowPlanets.get(k).index != targetPlanets.get(k).index) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                    universes.get(i).setHasPartner(true);
                    universes.get(j).setHasPartner(true);
                }

            }
        }
        System.out.println(answer);

    }

    private static class Universe {
        private List<Planet> planets;
        private boolean hasPartner;

        public Universe(List<Planet> planets) {
            this.planets = planets;
            this.hasPartner = false;
        }

        public List<Planet> getPlanets() {
            return planets;
        }

        public boolean getHasPartner() {
            return hasPartner;
        }

        public void setHasPartner(boolean hasPartner) {
            this.hasPartner = hasPartner;
        }

    }
    private static class Planet {
        private int index;
        private int value;

        public Planet(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }

    }
}
