public class ArrayUnboundedQueue <T> implements QueueInterface<T> {
   //Fields
   private T[] innerArray;
   private int front;
   private int back;
   private int count;

   //Constructor 
    public ArrayUnboundedQueue() {
        innerArray = (T[]) new Object[5];
         front = 0;
         back = 0;

    }
   //Methods
    @Override 
    public void enqueue(T element) throws QueueOverflowException {
        if (count == innerArray.length){
            expand();

        }

        innerArray[back] = element;
        back++;

        if(back >= innerArray.length) {
            back = 0;
        }
        count++;
   }

   private void expand(){
            T[] newArray = (T[]) new Object[innerArray.length *2];

            for (int i = 0; i < count; i++) {
                newArray[i] = innerArray[(front + i) % innerArray.length];
            }
            innerArray = newArray;
            front = 0; 
            back = count;
        }
    
   @Override 
    public T dequeue() throws QueueUnderflowException {
            if(isEmpty()) {
                throw new QueueUnderflowException();
            }
            else {
                 T result = innerArray[front];
                 innerArray[front] = null;
                 front ++;
                 if(front >= innerArray.length) {
                    front =0;
                 }
                 count--;
                 return result;
                }
    }

    @Override 
    public boolean isFull() {
        return false;
    }

    @Override 
    public boolean isEmpty(){
        return count ==0;
    }

    @Override 
    public int size(){
        return count;
    }
    
}
