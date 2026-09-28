public class Message {
    
    private String messageId;
    private String payload;
    private int retryCount = 0;
 public Message(String messageId, String payload) {
    this.messageId = messageId;
    this.payload = payload;
 }

 @Override 
 public String toString(){
   return "Message{messageId: " + messageId + ", payload: " + payload + ", retryCount: " + retryCount + "}";
 }

}
