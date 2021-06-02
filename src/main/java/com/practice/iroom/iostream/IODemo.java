package com.practice.iroom.iostream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class Person implements Serializable
{
    String name = " ";
    public Person(String name)
    {
        this.name = name;
    }
}
class Employee extends Person
{
    float salary;
    public Employee(String name, float salary)
    {
        super(name);
        this.salary = salary;
    }
//    private void writeObject(ObjectOutputStream out) throws IOException
//    {
//        throw new NotSerializableException();
//    }
//    private void readObject(ObjectInputStream in) throws IOException
//    {
//        throw new NotSerializableException();
//    }

}
public class IODemo
{
    public static void main(String[] args)
            throws Exception
    {
        Employee emp = new Employee("Sharma", 10000);

        System.out.println("name = " + emp.name);
        System.out.println("salary = " + emp.salary);

        FileOutputStream fos = new FileOutputStream("./abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(emp);

        oos.close();
        fos.close();

        System.out.println("Object has been serialized");

        FileInputStream f = new FileInputStream("ab.txt");
        ObjectInputStream o = new ObjectInputStream(f);

        Employee emp1 = (Employee)o.readObject();

        o.close();
        f.close();

        System.out.println("Object has been deserialized");

        System.out.println("name = " + emp1.name);
        System.out.println("salary = " + emp1.salary);
    }
}