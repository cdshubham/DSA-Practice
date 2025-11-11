package queue;

import java.util.*;

public class QueueUse {
    public static void main(String[] args) {
        Queue<Integer> que=new ArrayDeque<>();
        que.add(12);
        que.add(23);
        que.add(34);
        System.out.println(que);
        System.out.println(que.remove());
        System.out.println(que.peek());
        que.clear();
        System.out.println(que);
    }
}
