package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Student {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        try {
            Class<?> clz = Class.forName("reflect.Student");
            Method[] methods = clz.getMethods();
            for (Method method : methods) {
                System.out.println("方法名：" + method.getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Class<?> clz = Class.forName("reflect.Student");
            Student stu = (Student) clz.newInstance();
            System.out.println(stu.getName());
            Method method = clz.getMethod("setName", String.class);
            method.invoke(stu, "kun");
            System.out.println(stu.getName());
            Field[] fields = clz.getFields();
            for (Field field : fields) {
                System.out.println("属性名：" + field.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Class<?> clz = Class.forName("reflect.Student");
            Student stu = (Student) clz.newInstance();
            Field field = clz.getDeclaredField("name");
            field.setAccessible(true);
            System.out.println(field.get(stu));
            field.set(stu, "kun");
            System.out.println(field.get(stu));
        } catch (Exception e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Student stu = new Student();
            stu.setName("kun");
            System.out.println(stu.getName());
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


        System.out.println("手动分割");

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            try {
            Class<?> clz = Class.forName("reflect.Student");
            Student stu = (Student) clz.newInstance();
            Method method = clz.getMethod("setName", String.class);
            method.invoke(stu, "kun");
            System.out.println(stu.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

    }
}
