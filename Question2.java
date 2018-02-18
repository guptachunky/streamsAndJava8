
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {

    private static final long serialVersionUID = 100L;
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

class SubClass extends Employee {

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        throw new NotSerializableException();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        throw new NotSerializableException();
    }
}

public class Question2 {

    public static void main(String... args) throws Exception {
        Question2 serializationExample = new Question2();
        serializationExample.serializeObject();
        serializationExample.deserializeObject();
    }

    private void serializeObject() throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(new File("/home/chunky/IdeaProjects/AssignmentStreamJava8/src/serialFile.txt")));
        Employee e = new Employee();
        e.setName("chunky");
        e.setAge(22);
        objectOutputStream.writeObject(e);
        objectOutputStream.close();

    }

    private void deserializeObject() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("/home/chunky/IdeaProjects/AssignmentStreamJava8/src/serialFile.txt")));
        Employee e = (Employee) objectInputStream.readObject();
        System.out.println("Employee Name: " + e.name);
        System.out.println("Employee Age: " + e.age);
        objectInputStream.close();
    }
}

