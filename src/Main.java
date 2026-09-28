public class Main {
    public static void main(String[] args)  throws Exception {
        ArrayUnboundedQueue<Message>  messages = new ArrayUnboundedQueue<>();

        Message message1 = new Message("Tommy", "Message 1");
        Message message2 = new Message("Chucky", "Message 2");
        Message message3 = new Message("Angelica", "Message 3 ");

        messages.enqueue(message1);
        messages.enqueue(message2);
        messages.enqueue(message3);

        Message firstMessage = messages.dequeue();
        System.out.println(firstMessage);

        Message secondMessage = messages.dequeue();
        System.out.println(secondMessage);

        Message thirdMessage = messages.dequeue();
        System.out.println(thirdMessage);
    }
}