package studydatastruct.test.Collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangkai
 * @create 2020/5/25
 */
public class Person {
    private int age;
    private String name;


    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString()
    {
        return name+":"+age;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj){//引用相等那么两个对象当然相等
            return true;
        }
        if(obj == null || !(obj instanceof  Person)){//对象为空或者不是Person类的实例
            return false;
        }
        Person otherPerson = (Person)obj;
        if(otherPerson.getName().equals(this.getName()) && otherPerson.getAge()==this.getAge()){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Person p1 = new Person("zzh",18);
        Person p2 = new Person("jj",17);
        Person p3 = new Person("zzh",18);
        System.out.println(p1.equals(p2));//false
        System.out.println(p1.equals(p3));//true
        List<Person> list2 = new ArrayList<>();
        list2.add(p1);
        list2.add(p2);
        list2.add(p3);
        list2.sort((o1, o2) -> {
            if (o1 == null || o2 == null)
                return 0;
            return o1.getAge() - o2.getAge();
        });
    }
}
