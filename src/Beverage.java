/*
 * Class: CMSC203 
 * Instructor: Professor Thai
 * Description: THE superclass Beverage is used for essential methods to introduce to it's subclasses.
 * Due: 5/2/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco
*/

public abstract class Beverage 
{
    private String name;
    private Type type;
    private Size size;
    protected final double BASE_PRICE = 2.0;
    protected final double SIZE_UP_PRICE = 1.0;

    /**
     * simple constructor of Beverage instance.
     * @param name
     * @param type
     * @param size
     */
    public Beverage(String name, Type type, Size size) 
    {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    /**
     * an abstract calcPrice() method. For subclasses to utilize, but personalize.
     * @return double (in subclasses)
     */
    public abstract double calcPrice();

    /**
     * basic toString method to print the called beverage object's values.
     * @return formattedString A string showing the values of the called beverage.
     */
    @Override
    public String toString() 
    {
        return String.format("Name: %s,\nType: %s,\nSize: %s,\n", name, type, size);
    }

    /**
     * this equals method is to check the called beverage object and referenced beverage object to see if hold the same values.
     * @param otherBeverage 
     */
    public boolean equals(Beverage otherBeverage)
    {
    	boolean isEqual = false;

        if (otherBeverage == null) 
            return isEqual;
        
        return name.equals(otherBeverage.getName()) && type == otherBeverage.getType() && size == otherBeverage.getSize();
    }

    /**
     * gets BASE_PRICE value
     * @return BASE_PRICE returns the constant BASE_PRICE, which equals 2.0.
     */
    public double getBasePrice() 
    {
        return BASE_PRICE;
    }

    /**
     * gets SIZE_UP_PRICE value
     * @return SIZE_UP_PRICE returns SIZE_UP_PRICE
     */
    public double getSizePrice() 
    {
        return SIZE_UP_PRICE;
    }
    
    /**
     * gets the name of the Beverage instance.
     * @return name 
     */
    public String getName() 
    {
        return name;
    }
    
    /**
     * gets the Type of the Beverage instance.
     * @return type
     */
    public Type getType() 
    {
        return type;
    }
    
    /**
     * gets the Size of the Beverage instance.
     * @return size
     */
    public Size getSize() 
    {
        return size;
    }
    
    /**
     * sets the name of the Beverage instance
     * @param name
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * sets the Type of the Beverage instance
     * @param type
     */
    public void setType(Type type) 
    {
        this.type = type;
    }

    /**
     * sets the Size of the Beverage instance
     * @param size
     */
    public void setSize(Size size) 
    {
        this.size = size;
    }
}
