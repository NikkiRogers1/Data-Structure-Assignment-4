import java.util.Random;

public class Broker {
   //fields
    private QueueInterface <Message> queue;
    private static final int MAX_RETRIES = 3;
    private QueueInterface <Message> deadLetterQueue;


    //Constructor
    public Broker() {
        queue = new ArrayUnboundedQueue<Message>();
        deadLetterQueue = new ArrayUnboundedQueue<Message>();
    }

    public void processBatch() throws QueueUnderflowException, QueueOverflowException{
        Random random = new Random();
        
        while (!queue.isEmpty()) {
             Message message = queue.dequeue();
             if (random.nextInt(100) < message.getSuccessChance()) {

                System.out.println("Message processed successfully: " + message);
             }
             else {
            message.incrementRetryCount();

            if (message.getRetryCount() >= MAX_RETRIES) {
                deadLetterQueue.enqueue(message);
            }
            else{
                queue.enqueue(message);
            }
            System.out.println("Message Failed: " + message);

        }
    }
}
    public void enqueueMessage(Message message) throws QueueOverflowException  {
        queue.enqueue(message);
    }  
      
    public void viewAndClearDLQ() throws QueueUnderflowException {
        while(!deadLetterQueue.isEmpty()) {
            Message message = deadLetterQueue.dequeue();
            System.out.println(message);


        }

    }
    }


