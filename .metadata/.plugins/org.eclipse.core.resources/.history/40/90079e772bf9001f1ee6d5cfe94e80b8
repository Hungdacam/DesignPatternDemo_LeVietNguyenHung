package singlePattern;

public class StaticBlockSingleton {
	private static StaticBlockSingleton instance;
	private StaticBlockSingleton(){}
	static{
		try{
				instance = new StaticBlockSingleton();
			}catch(Exception e){
				throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}
	public static StaticBlockSingleton getInstance(){
		return instance;
	}
	
	public static void main(String[] args) {
        StaticBlockSingleton instance1 = StaticBlockSingleton.getInstance();
        StaticBlockSingleton instance2 = StaticBlockSingleton.getInstance();

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
