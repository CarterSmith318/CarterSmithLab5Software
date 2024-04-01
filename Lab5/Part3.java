package Lab5;

import java.util.ArrayList;
import java.util.List;

// Defines the subject interface
interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyUpdate(Message m);
}

// Concrete subject implementation
class MessagePublisher implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyUpdate(Message m) {
        for(Observer o: observers) {
            o.update(m);
        }
    }
}

// Observer interface
interface Observer {
    void update(Message m);
}

// Concrete observer imp
class MessageSubscriberOne implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberOne :: " + m.getMessageContent());
    }
}

class MessageSubscriberTwo implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberTwo :: " + m.getMessageContent());
    }
}

class MessageSubscriberThree implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberThree :: " + m.getMessageContent());
    }
}

// Simple message class used with the updates
class Message {
    final String messageContent;
    
    public Message (String m) {
        this.messageContent = m;
    }

    public String getMessageContent() {
        return messageContent;
    }
}

// Test class / Observer pattern
public class Part3 {
    public static void main(String[] args) {
        // Create subscribers
        MessageSubscriberOne s1 = new MessageSubscriberOne();
        MessageSubscriberTwo s2 = new MessageSubscriberTwo();
        MessageSubscriberThree s3 = new MessageSubscriberThree();

        // Create publisher and attach subscribers
        MessagePublisher p = new MessagePublisher();
        p.attach(s1);
        p.attach(s2);

        // Sending notifications
        p.notifyUpdate(new Message("First Message"));   // s1 and s2 will receive the update

        p.detach(s1);
        p.attach(s3);

        p.notifyUpdate(new Message("Second Message"));  // s2 and s3 will receive the update
    }
}
