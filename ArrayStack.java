public class ArrayStack<Item> implements Stack<Item>
{
    //instance data
    Object[] arr;
    int SIZE = 10;
    int top;


    //constructor
    public ArrayStack()
    {
        arr = new Object[SIZE];
        top = -1;
    }

    //put item into stack
    @Override
    public void push(Item item)
    {
        if (top == arr.length - 1)
            grow_array();
        arr[++top] = item;
    }

    //take item out of stack
    @Override
    public Item pop()
    {
        if (empty())
            return null;
        return (Item) arr[top--];

    }

    //check the top item
    @Override
    public Item peek()
    {
        if (empty())
            return null;
        return (Item) arr[top];

    }

    //checks stack if empty
    @Override
    public boolean empty()
    {
        if (top == -1)
            return true;
        return false;
    }

    //makes temp array, adds all item of array into temp, and then make array have same values of temp
    protected void grow_array()
    {
        Object[] temp = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++)
            temp[i] = arr[i];
        arr = temp;
    }
}
