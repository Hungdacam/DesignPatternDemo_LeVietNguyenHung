package singlePattern;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;
	private ThreadSafeSingleton(){}
	public static synchronized ThreadSafeSingleton getInstance(){
	if(instance == null){
		instance = new ThreadSafeSingleton();
	}
		return instance;
	}
	public static void main(String[] args) {
        // Tạo nhiều luồng để kiểm tra tính an toàn của Singleton
        Runnable task = () -> {
            ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " - Instance hashcode: " + instance.hashCode());
        };

        // Tạo nhiều luồng chạy đồng thời
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
