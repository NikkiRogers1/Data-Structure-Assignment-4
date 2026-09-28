public class Message {
    
    private String messageId;
    private String payload;
    private int retryCount = 0;
    private int successChance;

 public Message(String messageId, String payload, int successChance) {
    this.messageId = messageId;
    this.payload = payload;
    this.successChance = successChance;
 }

 @Override 
 public String toString(){
   return "Message{messageId: " + messageId + ", payload: " + payload + ", retryCount: " + retryCount + "}";
 }


 public void incrementRetryCount() {
    retryCount++;
 }

 public int getSuccessChance(){
    return successChance;
 }
public int getRetryCount() {
    return retryCount;
}
}
