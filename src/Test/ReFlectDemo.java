package Test;

import java.lang.reflect.Field;
import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-04
 * Time: 17:05
 */
public class ReFlectDemo {
    public static void main(String[] args) throws Exception {
        Class aclass = Class.forName("Test.User");
        Field[] fields =  aclass.getFields();
        for (Field field : fields){
            System.out.println("1.public 修饰的成员变量——> " + field);
        }
        Field name = aclass.getField("name");
        System.out.println("2.指定的成员变量：--> " + name);

        Field[] declaredFields = aclass.getDeclaredFields();
        for(Field declaredField : declaredFields){
            System.out.println("3. 不考虑修饰符号，获得全部的成员变量--> " + declaredField);
        }

        Field phone = aclass.getDeclaredField("phone");
        phone.setAccessible(true);
        System.out.println("4.暴力反射--> " + phone);
    }
}
