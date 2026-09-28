import java.util.Random;

public class Broker {
   //fields
    private QueueInterface <Message> queue;
    

    //Constructor
    public Broker() {
        queue = new ArrayUnboundedQueue<Message>();
    }

    public void processBatch() throws QueueUnderflowException, QueueOverflowException{
        int batchSize = queue.size();
        Random random = new Random();
        
        for (int i = 0; i < batchSize; i++) {
             Message message = queue.dequeue();
             if (random.nextInt(100) < message.getSuccessChance()) {

                System.out.println("Message processed successfully: " + message);
             }
             else {
            message.incrementRetryCount();
            queue.enqueue(message);
            System.out.println("Message Failed: " + message);

        }
    }
}
    public void enqueueMessage(Message message) throws QueueOverflowException  {
        queue.enqueue(message);
    }  
      
    }


