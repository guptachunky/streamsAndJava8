import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class EmployeeDetails{

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

    EmployeeDetails(String name, int age){
        this.name=name;
        this.age=age;
    }
}
interface Condition{
    boolean test(EmployeeDetails emp);
}
public class Question6 {
    private static void conditions(List<EmployeeDetails> list,Condition condition){
        for(EmployeeDetails emp:list){
            if(condition.test(emp)){
                System.out.println(emp.getName());
                System.out.println(emp.getAge()+"\n");
            }
        }
    }
    public static void main(String[] args) {

        EmployeeDetails obj1=new EmployeeDetails("chunky",22);
        List<EmployeeDetails> list= Arrays.asList(new EmployeeDetails("chunky",22),
                new EmployeeDetails("neel",25),new EmployeeDetails("nishu",23),
                new EmployeeDetails("prachi",25),new EmployeeDetails("nitin",28));

        System.out.println("All Names Starting With N and Age Greater Than 24");
        conditions(list,p -> p.getName().startsWith("n") && p.getAge() > 24);


    }

}
