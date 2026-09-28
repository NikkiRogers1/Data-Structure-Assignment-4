# Journal
Phase 1- A Queue is better for a message broker because we need the messages to come out in the same order they were added. If we used a Stack instead, it would be first in, last out, so the newest message would come out first. We need the messages to be processed in order, so a Queue makes more sense.

Phase 2 - 
Moving a failed message to the back of the queue is fair because it gives other messages time to run through before giving the failed message another chance that way it doesnt stall the system.

Phase 3-
When a poison message is first added, it goes into the main queue with a retry count of 0. Each time it fails, the retry count goes up by 1 and the message gets moved to the back of the main queue so it can be tried again. Once the retry count reaches 3, it is no longer put back into the main queue. Instead, it gets moved to the Dead-Letter Queue. Then the DLQ can be viewed and cleared by taking the messages out of it.