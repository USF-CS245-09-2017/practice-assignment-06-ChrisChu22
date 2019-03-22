import java.lang.*;

public class ArrayQueue<Item> implements Queue<Item>
{

    //instance data
    int head;
    int tail;
    Object arr[];

    //constructor
    public ArrayQueue()
    {
        head = 0;
        tail = 0;
        arr = new Object[10];
    }

    //taking item out of queue
    @Override
    public Item dequeue()
    {
        if (empty())
            return null;
        Object temp = arr[head];
        head = (head + 1)%arr.length;
        if (head == arr.length)
            head = 0;
        return (Item) temp;
    }

    //adding item to queue
    @Override
    public void enqueue(Item item)
    {
        if ((head + 1) % arr.length == tail)
            grow_array();
        arr[tail++] = item;
        tail = tail%arr.length;
    }

    //makes a copy of the array and adds all the items of array to temp and makes the array point to temp
    protected void grow_array()
    {
        Object[] temp = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++)
        {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    //checks if array if empty
    public boolean empty()
    {
        if (head == tail)
        {
            return true;
        }
        return false;
    }
}
