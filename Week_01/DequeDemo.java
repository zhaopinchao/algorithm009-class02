
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: zhaopc
 * @date: 2020-05-24 17:22
 * @description
 */
public class DequeDemo {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pollLast());
        }
        System.out.println(deque);
    }
}
