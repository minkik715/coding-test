public class Temp {

    static Object 자원1 = new Object();
    static Object 자원2 = new Object();

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.run();
        threadB.run();
    }

    public static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (자원1) {
                lock(자원1, "자원1");
                sleep(2000);
                synchronized (자원2) {
                    lock(자원2, "자원2");
                    unlock(자원1, "자원1");
                    unlock(자원2, "자원2");
                }
            }
        }
    }

    public static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (자원2) {
                lock(자원2, "자원2");
                sleep(2000);
                synchronized (자원1) {
                    lock(자원1, "자원1");
                    unlock(자원2, "자원2");
                    unlock(자원1, "자원1");
                }
            }
        }
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void lock(Object obj, String name) {
        try {
            obj.wait(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + "잠금");
    }

    private static void unlock(Object obj, String name) {
        obj.notifyAll();
        System.out.println(name + "잠금해제");
    }
}
