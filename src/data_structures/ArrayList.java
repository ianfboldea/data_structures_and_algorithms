package data_structures;

public class ArrayList<E> {
    private E[] backingArray;
    private int size;

    // Constructors
    public ArrayList() {
        this.backingArray = (E[]) new Object[10];
        this.size = 0;
    }
    public ArrayList(int size) {
        // This is safe so long as the client never gets direct access to the backingArray
        this.backingArray = (E[]) new Object[size];
        this.size = 0;
    }
    public ArrayList(E ... items) {
        this.backingArray = items;
        this.size = items.length;
    }

    // Public methods
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size - 1)
            throw new IndexOutOfBoundsException("The provided index is out of bounds.");
        return this.backingArray[index];
    }
    public E first() {
        if (this.isEmpty()) return null;
        return this.backingArray[0];
    }
    public E last() {
        if (this.isEmpty()) return null;
        return this.backingArray[this.size-1];
    }
    public int size() {
        return this.size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public void resize() {
        E[] newBackingArray = (E[]) new Object[this.backingArray.length * 2];
        for (int i = 0; i < this.size; i++)
            newBackingArray[i] = this.backingArray[i];
        this.backingArray = newBackingArray;
    }
    public void append(E item) throws Exception {
        if (item == null)
            throw new Exception("Can't add null elements");
        if (this.size >= this.backingArray.length)
            this.resize();
        this.backingArray[size] = item;
        this.size++;
    }
    public void prepend(E item) throws Exception {
        this.put(item, 0);
    }
    public void put(E item, int index) throws Exception {
        if (item == null)
            throw new Exception("Can't add null elements");
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException("The provided index is out of bounds.");
        if (this.size >= this.backingArray.length)
            this.resize();
        for (int i = this.size; i >= index+1; i--)
            this.backingArray[i] = this.backingArray[i-1];
        this.backingArray[index] = item;
        this.size++;
    }
}

