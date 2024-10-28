package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class bj_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            students.add(new Student(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3])));
        }

        students.sort(Comparator.comparing(Student::getKor, Comparator.reverseOrder())
                .thenComparing(Student::getEn)
                .thenComparing(Student::getMath, Comparator.reverseOrder())
                .thenComparing(Student::getName)
        );

        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.getName()).append("\n");
        }

        System.out.println(sb);

    }

    static class Student {
        private String name;
        private int kor;
        private int en;
        private int math;

        public Student(String name, int kor, int en, int math) {
            this.name = name;
            this.kor = kor;
            this.en = en;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public int getKor() {
            return kor;
        }

        public int getMath() {
            return math;
        }

        public int getEn() {
            return en;
        }
    }

}
