package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ2461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] school = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                school[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(school[i]);
        }

        int nowMax = Integer.MIN_VALUE;

        PriorityQueue<Student> eachClassMinStudents = new PriorityQueue<>(Comparator.comparing(student -> student.power));

        for (int i=0; i<N; i++) {
            int eachClassMin = school[i][0];
            eachClassMinStudents.add(new Student(i, 0, eachClassMin));
            nowMax = Math.max(nowMax, eachClassMin);
        }

        int answer = Integer.MAX_VALUE;
        while (true) {
            Student minestStudent = eachClassMinStudents.poll();

            answer = Math.min(answer, nowMax-minestStudent.power);

            if (minestStudent.index >= M-1) {
                break;
            }
            int nextPower = school[minestStudent.classNumber][minestStudent.index+1];
            eachClassMinStudents.add(new Student(minestStudent.classNumber, minestStudent.index+1, nextPower));
            nowMax = Math.max(nowMax, nextPower);
        }

        System.out.println(answer);
    }

    static class Student {
        int classNumber;
        int index;
        int power;

        public Student(int classNumber, int index, int power) {
            this.classNumber = classNumber;
            this.index = index;
            this.power = power;
        }
    }
}
