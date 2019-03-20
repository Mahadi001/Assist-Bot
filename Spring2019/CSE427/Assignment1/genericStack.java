Import java.util.*;

public class GenericStack <Object> implements Stack <Object>
{
    private Item container[];
    private int top;
    private final static int DEFAULT_SIZE = 10;
 
    public GenericStack ()
    {
        this(DEFAULT_SIZE);
    }
 
    public GenericStack (int initSize)
    {
        container = (Object[]) new Object [initSize];
        top = -1;
    }

    public void push(Object obj)
    {
        container[++top] = obj;
    }

    public Object pop()
    {
        if (top == -1)
            return null;
        return container[top--];
    }	
 
    public boolean isEmpty()
    {
        return (top == -1);
    }
 
}