package task2;

import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadProcessor extends Thread {
    private int number;
    private final AtomicBoolean isRun = new AtomicBoolean(true);
    private final ThreadCondition condition;

    public ThreadProcessor(ThreadCondition condition) {
        this.condition = condition;
    }

    public void process(int number) {
        this.number = number;
        isRun.set(false);
    }

    @Override
    public void run() {
        while (true) {
            if (isRun.get()) {
                continue;
            }

            condition.checkAndProcess(number);

            isRun.set(true);
        }
    }

    public Boolean getIsRun() {
        return isRun.get();
    }
}
