package singlePattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class SerializedSingleton implements Serializable{
	private static final long serialVersionUID = -7604766932017737115L;
	private SerializedSingleton(){}
	private static class SingletonHelper{
		private static final SerializedSingleton instance = new
		SerializedSingleton();
	}
	public static SerializedSingleton getInstance(){
	return SingletonHelper.instance;

	}
	// Đảm bảo khi deserialize, đối tượng không bị tạo mới
    protected Object readResolve() {
        return getInstance();
    }
    public static void main(String[] args) {
        try {
            SerializedSingleton instance1 = SerializedSingleton.getInstance();

            // Serialize đối tượng
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
            out.writeObject(instance1);
            out.close();

            // Deserialize đối tượng
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.ser"));
            SerializedSingleton instance2 = (SerializedSingleton) in.readObject();
            in.close();

            // Kiểm tra hashcode để xác minh tính toàn vẹn của Singleton
            System.out.println("Instance 1 hashcode: " + instance1.hashCode());
            System.out.println("Instance 2 hashcode: " + instance2.hashCode());

            if (instance1 == instance2) {
                System.out.println("Both instances are the same.");
            } else {
                System.out.println("Instances are different (Singleton is broken).");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
