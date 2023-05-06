/*
 * Class: CMSC203 
 * Instructor:
 * Description: Customer is to hold the value of a cutomer. Their name and age.
 * Due: 5/2/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco
*/

public class Customer 
{
    private String name;
    private int age;

    /**
     * simple constructor for Customer
     * @param name
     * @param age
     */
    public Customer(String name, int age) 
    {
        this.name = name;
        this.age = age;
    }

    /**
     * copy constructor for Customer instance
     * @param other
     */
    public Customer(Customer other) 
    {
        this.name = other.getName();
        this.age = other.getAge();
    }

    /**
     * gets name value 
     * @return name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * gets age value
     * @return age
     */
    public int getAge() 
    {
        return age;
    }
    
    /**
     * sets name value
     * @param name
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * sets age value
     * @param age
     */
    public void setAge(int age) 
    {
        this.age = age;
    }

    @Override
    public String toString() 
    {
        return String.format("Name: %s,\n Age: %s", name, age);
    }
}
