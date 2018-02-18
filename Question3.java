import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Test
{
    private String s;
    public Test()  {  s = "constructor"; }
    public void method1()  {
        System.out.println("The string is " + s);
    }

    public void method2(int n)  {
        System.out.println("The number is " + n);
    }

    private void method3() {
        System.out.println("Private method invoked");
    }
}
public class Question3 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Test obj=new Test();
        Class cls = obj.getClass();
        System.out.println("The name of class is " + cls.getName());

        Method[] methods=cls.getMethods();
        for(Method method :methods){
            System.out.println(method.getName());

        }
        Field field = cls.getDeclaredField("s");
        field.setAccessible(true);
        field.set(obj, "JAVA");


        Method methodcall3 = cls.getDeclaredMethod("method3");
        methodcall3.setAccessible(true);
        methodcall3.invoke(obj);

        Method methodcall1=cls.getDeclaredMethod("method1");
        methodcall1.invoke(obj);
    }


}
