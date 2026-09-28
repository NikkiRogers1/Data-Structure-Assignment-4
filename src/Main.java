public class Main {
    public static void main(String[] args)  throws Exception {


        Message message1 = new Message("Tommy", "Message 1", 75);
        Message message2 = new Message("Chucky", "Message 2", 50);
        Message message3 = new Message("Angelica", "Message 3 ", 15);

        Broker broker = new Broker();


        broker.enqueueMessage(message1);
        broker.enqueueMessage(message2);
        broker.enqueueMessage(message3);

        broker.processBatch();

        
}
}