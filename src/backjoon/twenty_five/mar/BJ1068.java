package backjoon.twenty_five.mar;

import java.io.*;
import java.util.*;

public class BJ1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Node> nodeMap = new HashMap<>();

        char signal = 'A';

        for (int i=0; i<N; i++) {
            String nowNodeName = String.valueOf(signal);
            nodeMap.put(nowNodeName, new Node(nowNodeName, null, null));
            signal++;
        }

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            String nowSignal = input[0];
            String nowLeft = input[1];
            String nowRight = input[2];
            Node nowNode = nodeMap.get(nowSignal);
            Node leftNode = null;
            Node rightNode = null;
            if (!nowLeft.equals(".")) {
                leftNode = nodeMap.get(nowLeft);
            }

            if (!nowRight.equals(".")) {
                rightNode = nodeMap.get(nowRight);
            }

            nowNode.left = leftNode;
            nowNode.right = rightNode;
        }

        StringBuilder startFirst = new StringBuilder();
        StringBuilder middleFirst = new StringBuilder();
        StringBuilder endFirst = new StringBuilder();

        Node rootNode = nodeMap.get("A");
        startFirstSearch(rootNode, startFirst);
        middleFirstSearch(rootNode, middleFirst);
        endFirstSearch(rootNode, endFirst);

        System.out.println(startFirst);
        System.out.println(middleFirst);
        System.out.println(endFirst);

        
    }

    private static void startFirstSearch(Node rootNode, StringBuilder startFirst) {
        startFirst.append(rootNode.name);
        if (rootNode.left == null) {
            if (rootNode.right != null) {
                startFirstSearch(rootNode.right, startFirst);
            }
            return;
        }

        startFirstSearch(rootNode.left, startFirst);
        if (rootNode.right != null) {
            startFirstSearch(rootNode.right, startFirst);
        }
        
    }

    
    private static void middleFirstSearch(Node rootNode, StringBuilder middleFirst) {
        if (rootNode.left == null) {
            middleFirst.append(rootNode.name);
            if (rootNode.right != null) {
                middleFirstSearch(rootNode.right, middleFirst);
            }
            return;
        }

        middleFirstSearch(rootNode.left, middleFirst);
        middleFirst.append(rootNode.name);
        if (rootNode.right != null) {
            middleFirstSearch(rootNode.right, middleFirst);
        }
        
    }

    private static void endFirstSearch(Node rootNode, StringBuilder endFirst) {
        if (rootNode.left == null) {
            if (rootNode.right != null) {
                endFirstSearch(rootNode.right, endFirst);
            }
            endFirst.append(rootNode.name);
            return;
        }

        endFirstSearch(rootNode.left, endFirst);
        if (rootNode.right != null) {
            endFirstSearch(rootNode.right, endFirst);
        }
        endFirst.append(rootNode.name);
        
    }

    static class Node{
        String name;
        Node left;
        Node right;

        public Node(String name, Node left, Node right) {
            this.name = name;
            this.left = left;
            this.right = right;
            
        }

    }
}