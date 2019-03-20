import java.lang.Iterable;
import java.util.*;
 
public class GenericStack <Object> implements Stack <Object>
{
    private Object container[];
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
 
    public Object getTop()
    {
        if (top == -1)
            return null;
        return container[top];
    }
 
    public Object pop()
    {
        if (top == -1)
            return null;
 
        Object obj = container[top];
        container[top--] = null;
 
        if(top > 0 && top == container.length / 4)
           resize (container.length/2);
 
        return obj;
    }
 
    public void push(Object obj)
    {		
        if (top == container.length - 1)
            resize(2 * container.length);
 
        container[++top] = itm;
    }

 
    public boolean isEmpty()
    {
        return (top == -1);
    }
 
    public int size()
    {
        return (top + 1);
    }
 
    private void resize (int newSize)
    {
        Object t[] = (Object[]) new Object[newSize];
        for (int i = 0; i <= top; i++)
            t[i] = container[i];
        container = t;
    }
 
    public Iterator<Object> iterator()
    {
        return new GenericStackIterator();
    }
 
    private class GenericStackIterator implements Iterator <Object>
    {
        private int i = top;
 
        public boolean hasNext()
        {
            return (i > -1);
        }
 
        public Object next()
        {
            return container[i--];
        }
 
    }
}