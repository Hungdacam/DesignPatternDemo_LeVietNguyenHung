package singlePattern;

public class EagerInitializedSingleton {
	private static final EagerInitializedSingleton instance = new
			EagerInitializedSingleton();
			
			private EagerInitializedSingleton(){}
			public static EagerInitializedSingleton getInstance(){
				return instance;
			}
	public static void main(String[] args) {
		        EagerInitializedSingleton instance1 = EagerInitializedSingleton.getInstance();
		        EagerInitializedSingleton instance2 = EagerInitializedSingleton.getInstance();

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
