package Test;

import java.io.Serializable;
import java.nio.IntBuffer;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-05
 * Time: 17:02
 */
public class User implements Serializable {
    public String name;
    protected Integer age;
    Integer sex;
    private String phone;
    public User(){
    }

    public User(String name, Integer age, Integer sex, String phone) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void run(){
        System.out.println("run...");
    }

    public void eat(String username){
        System.out.println(username + " eating...");
    }


}
