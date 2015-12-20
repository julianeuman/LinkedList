 /**
 * Your implementation of a SinglyLinkedList
 *
 * @author Julia Neuman
 * @version 1.0
 */
public class SinglyLinkedList<T> implements LinkedListInterface<T> {
    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private int size;

    @Override
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > this.size) {
            throw new java.lang.IndexOutOfBoundsException("Index is not"
                    + " in the range of the list");
        }
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Data cannot be null");
        }
        if (index == 0) {
            addToFront(data);
        } else {
            LinkedListNode<T> current = head.getNext();
            int findIndex = 1;
            LinkedListNode<T> previous = head;
            while (findIndex != index) {
                current = current.getNext();
                previous = previous.getNext();
                findIndex++;
            }
            size++;
            LinkedListNode<T> newNode = new LinkedListNode<T>(data, current);
            previous.setNext(newNode);
        }



    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new java.lang.IndexOutOfBoundsException("Index is not in the"
                    + " range of the list");
        }

        int startingIndex = 0;
        LinkedListNode<T> current = head;
        while (startingIndex != index) {
            current = current.getNext();
            startingIndex++;
        }
        return current.getData();


    }

    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new java.lang.IndexOutOfBoundsException("Index is not in the "
                    + "range of the list");
        }
        LinkedListNode<T> current = head.getNext();
        if (index == 0) {
            return (removeFromFront());

        } else {
            int findIndex = 1;
            LinkedListNode<T> previous = head;
            while (findIndex != index) {
                current = current.getNext();
                previous = previous.getNext();
                findIndex++;
            }
            LinkedListNode<T> nextNode = current.getNext();
            previous.setNext(nextNode);
            size--;
        }
        return current.getData();
    }

    @Override
    public void addToFront(T data) {

        if (data == null) {
            throw new java.lang.IllegalArgumentException("Data cannot be null");
        }
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);

        newNode.setNext(this.head);
        this.head = newNode;

        size++;
    }


    @Override
    public void addToBack(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Data cannot be null");
        }
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            LinkedListNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public T removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        T data = head.getData();
        this.head = head.getNext();
        size = size - 1;
        return data;

    }

    @Override
    public T removeFromBack() {
        if (isEmpty()) {
            return null;
        }

        LinkedListNode<T> current = head;

        if (this.size == 1) {
            return (removeFromFront());
        }
        while (current.getNext().getNext() != null) {
            current = current.getNext();

        }
        T removed = current.getNext().getData();
        current.setNext(null);
        size = size - 1;
        return removed;


    }

    @Override
    public int removeFirstOccurrence(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Data cannot be null");
        }
        int index = 0;
        LinkedListNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                this.removeAtIndex(index);
                return index;
            }
            index++;
            current = current.getNext();
        }
        throw new java.util.NoSuchElementException();
    }

    @Override
    public Object[] toArray() {
        Object[] nodeArray = new Object[size];
        LinkedListNode<T> current = head;
        int index = 0;
        while (current != null) {
            nodeArray[index] = current.getData();
            current = current.getNext();
            index++;
        }
        return nodeArray;

    }


    @Override
    public boolean isEmpty() {
        return (size() == 0);

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;

    }

    @Override
    public LinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }
}
