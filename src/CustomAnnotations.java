import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.stream.Stream;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation{
    int value();
}

//Applying annotation
class Hello{

    @MyAnnotation(value=10)
    public void sayHello(){
        System.out.println("hello annotation");
    }

}

//Accessing annotation
class CustomAnnotations{
    public static void main(String args[])throws Exception{

        Hello h=new Hello();
        Method m=h.getClass().getMethod("sayHello");

        MyAnnotation manno=m.getAnnotation(MyAnnotation.class);
        System.out.println("value is: "+manno.value());

        int[][] nums = { {1,1},
                        {1,1}
        };
        String[][] names = {
                {"h","y"},{"f", "x"}
        };
        System.out.println(Arrays.deepToString(names));
    }}
