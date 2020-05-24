package lambdas;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Thread(()->{
                System.out.println("Printing from the runnable");
                System.out.println("Line 2");
            }).start();


        Employee John = new Employee("John", 30);
        Employee Jack = new Employee("Jack", 40);
        Employee Snow = new Employee("Snow", 22);
        Employee Tim = new Employee("Tim", 21);

        List<Employee> employees = new ArrayList<>();
        employees.add(John);
        employees.add(Jack);
        employees.add(Snow);
        employees.add(Tim);

        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

        for(Employee employee:employees){
            System.out.println(employee.getName());
        }

//        String sillyString = doStringStuff(new UpperConcat(){
//            @Override
//            public String upperAndConcat(String s1, String s2){
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

//        UpperConcat uc = (s1, s2) -> {
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        } ;
//
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1,s2);
    }


//    class CodeToRun implements Runnable{
//
//        @Override
//        public void run() {
//            System.out.println("Printing from the runnable");
//        }
//    }

}
    class Employee{
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

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

interface UpperConcat{
    public String upperAndConcat(String s1, String s2);

}

class AnotherClass{
    public String doSomething(){
        UpperConcat uc = (s1,s2)->{
            System.out.println("The lamdba expression class is: " + getClass().getSimpleName() );
            String result = s1.toUpperCase() + s2.toUpperCase();
            return  result;
        };

        System.out.println("The AnotherClass class name is: " + getClass().getSimpleName());
//        System.out.println("The AnotherClass class name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");
        return Main.doStringStuff(uc,"String1","String2");
    }
}