package backjoon.twenty_five.oct;

import java.util.*;


public class PG49993 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            HashMap<String, String> precedeSkills = new HashMap<>();
            HashMap<String, Boolean> skillLearnStatus = new HashMap<>();

            String[] skills = skill.split("");

            for (int i=0; i<skills.length; i++) {
                skillLearnStatus.put(skills[i], false);
                if (i != 0) {
                    precedeSkills.put(skills[i], skills[i-1]);
                }
            }

            for (int i=0; i<skill_trees.length; i++) {
                String[] skillTree = skill_trees[i].split("");
                boolean skipFlag = false;
                for (int j=0; j<skillTree.length; j++) {
                    String nowSkill = skillTree[j];

                    // 검사 대상일 경우
                    if (precedeSkills.containsKey(nowSkill)) {
                        String precedeSkill = precedeSkills.get(nowSkill);
                        // 선행 스킬을 배우지 않았을 경우 -> 불가능
                        if (!skillLearnStatus.get(precedeSkill)) {
                            skipFlag = true;
                        }
                    }

                    // 불가능한 스킬트리면 다음으로 이동
                    if (skipFlag) {
                        break;
                    }

                    if (skillLearnStatus.containsKey(nowSkill)) {
                        skillLearnStatus.put(nowSkill, true);
                    }
                }
                if (!skipFlag) {
                    answer++;
                }
                clearHistory(skillLearnStatus);

            }


            return answer;
        }

        private void clearHistory(HashMap<String, Boolean> skillLearnStatus) {
            for (String key : skillLearnStatus.keySet()) {
                skillLearnStatus.put(key, false);
            }
        }
    }
}
