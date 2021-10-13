package lab1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Buffer {
    private final BlockingQueue<Message> queue;
    private final AtomicInteger stopCount;

    public Buffer() {
        queue = new ArrayBlockingQueue<>(5);
        stopCount = new AtomicInteger(0);
    }

    public void add(Message message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void incStopCount() {
        stopCount.incrementAndGet();
    }

    public void print() {
        while (stopCount.get() < 3) {
            if (queue.size() == 5) {
                queue.forEach(System.out::println);
                System.out.println("-------------------");
                queue.clear();
            }
        }
        if (!queue.isEmpty())
            queue.forEach(System.out::println);
    }
}
