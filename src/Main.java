import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws Exception {

        

        Scanner scanner = new Scanner(System.in);
        Broker broker = new Broker();

        int choice = 0;

        while( choice != 4) {

            System.out.println("1. Enqueue Message");
            System.out.println("2. Process Batch");
            System.out.println("3. View and Clear DLQ");
            System.out.println("4. Exit");

            choice = scanner.nextInt();
        
            if (choice == 1) {
                System.out.println("Enter message ID: ");
                String messageId = scanner.next();

                System.out.println("Enter payload: ");
                String payload= scanner.next();
                
                System.out.println("Enter Success Chance");
                int successChance = scanner.nextInt();

                Message newMessage = new Message(messageId, payload, successChance);
                broker.enqueueMessage(newMessage);

                

            }
            if (choice ==2){
                   broker.processBatch();
                }
        
            if (choice ==3) {
                broker.viewAndClearDLQ();


            } 
        }

        


        
}
}