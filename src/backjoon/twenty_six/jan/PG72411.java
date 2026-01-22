package backjoon.twenty_six.jan;

import java.util.*;

public class PG72411 {

    class Solution {

        static Map<String, Integer> COURSES = new HashMap<>();

        public String[] solution(String[] orders, int[] course) {
            String[] answer = {};

            for (int i=0; i<course.length; i++) {
                int nowLen = course[i];

                for (String order : orders) {
                    pushCourse(order, nowLen, 0, "");
                }
            }

            CourseData[] mostCourseData = new CourseData[course[course.length-1]+1];

            // 글자 수에 따라 분리
            for (String key : COURSES.keySet()) {
                int index = key.length();

                if (mostCourseData[index] == null) {
                    if (COURSES.get(key) < 2) {
                        continue;
                    }
                    CourseData courseData = new CourseData(COURSES.get(key));
                    courseData.courses.add(key);
                    mostCourseData[index] = courseData;
                } else if (mostCourseData[index].count < COURSES.get(key)) {
                    CourseData courseData = new CourseData(COURSES.get(key));
                    courseData.courses.add(key);
                    mostCourseData[index] = courseData;
                } else if (mostCourseData[index].count == COURSES.get(key)) {
                    mostCourseData[index].courses.add(key);
                }
            }

            // 글자 수 별로 최다 빈출 코스 찾기
            PriorityQueue<String> queue = new PriorityQueue<>();

            for (int i=0; i<course.length; i++) {
                int nowSize = course[i];
                if (mostCourseData[nowSize] == null) {
                    continue;
                }

                for (String anCourse : mostCourseData[nowSize].courses) {
                    queue.add(anCourse);
                }

            }

            // 출력
            answer = new String[queue.size()];

            int index = 0;
            while(!queue.isEmpty()) {
                answer[index] = queue.poll();
                index++;
            }

            return answer;
        }

        private void pushCourse(String order, int nowLen, int start, String now) {
            if (now.length() == nowLen) {
                String candidate = getOrderString(now);

                if (!COURSES.containsKey(candidate)) {
                    COURSES.put(candidate, 1);
                } else {
                    COURSES.put(candidate, COURSES.get(candidate)+1);
                }

                return;
            }

            for (int i=start; i<order.length(); i++) {
                pushCourse(order, nowLen, i+1, now+order.charAt(i));
            }
        }

        private String getOrderString(String now) {
            String[] word = now.split("");
            Arrays.sort(word);

            StringBuilder sb = new StringBuilder();
            for (String str : word) {
                sb.append(str);
            }

            return sb.toString();
        }

        class CourseData {
            int count;
            List<String> courses = new ArrayList<>();

            public CourseData(int count) {
                this.count = count;
            }
        }
    }
}
