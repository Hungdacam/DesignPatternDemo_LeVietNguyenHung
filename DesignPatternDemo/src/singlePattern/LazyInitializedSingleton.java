package singlePattern;

public class LazyInitializedSingleton {
	private static LazyInitializedSingleton instance;
	private LazyInitializedSingleton(){}

	public static LazyInitializedSingleton getInstance(){
		if(instance == null){
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
	
	public static void main(String[] args) {
        LazyInitializedSingleton instance1 = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton instance2 = LazyInitializedSingleton.getInstance();

        // Kiểm tra hai thể hiện có cùng một địa chỉ bộ nhớ hay không
        System.out.println("Instance 1 hashcode: " + instance1.hashCode());
        System.out.println("Instance 2 hashcode: " + instance2.hashCode());

        // Kiểm tra xem chúng có phải cùng một đối tượng hay không
        if (instance1 == instance2) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }
    }
	
}
