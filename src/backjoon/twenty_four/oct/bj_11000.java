package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import java.util.*;
import java.io.*;

public class bj_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N==1) {
            System.out.println(1);
            return;
        }

        PriorityQueue<ClassRoom> classRooms = new PriorityQueue<>(Comparator.comparing(ClassRoom::getEndTime));
        List<Lecture> lectures = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            lectures.add(new Lecture(start, end));
        }
        lectures.sort(Comparator.comparing(Lecture::getStartTime));

        for (Lecture lecture : lectures) {
            int start = lecture.startTime;
            int end = lecture.endTime;

            if (classRooms.isEmpty()) {
                classRooms.add(new ClassRoom(end));
            } else {
                ClassRoom peek = classRooms.peek();
                if (peek.endTime <= start) {
                    ClassRoom poll = classRooms.poll();
                    poll.endTime = end;
                    classRooms.add(poll);
                } else {
                    classRooms.add(new ClassRoom(end));
                }
            }
        }


        System.out.println(classRooms.size());

    }

    private static class Lecture {
        private int startTime;
        private int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    private static class ClassRoom {
        private int endTime;

        public ClassRoom(int endTime) {
            this.endTime = endTime;
        }

        public int getEndTime() {
            return endTime;
        }

    }
}