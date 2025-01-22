package UdemyJavaFundamentalsTest;

import java.util.ArrayList;
import java.util.List;

public class SingletonOfList {
    private static final SingletonOfList instance = new SingletonOfList();
    private List<String> messages = new ArrayList<>();
    private SingletonOfList(){}

    public static SingletonOfList getInstance(){
        return instance;
    }
    public List<String> getMessages(){
        return messages;        // this is a good design if we have no other way to access the List (like setter)
                                // we already blocked constructor
    }

    // Now if interviewer ask to add modification methods too, you need to modify getter like below

    public List<String> getMessages_withSetters(){
        return new ArrayList<>(messages);       // sending a copy not original object
    }

    public void addMessages(String message) {
        messages.add(message);
    }
    public void clearMessage(){
        messages.clear();
    }

    // if interviewer asks to do thread saftey, use DCL like below

    private static SingletonOfList instance1;
    public static SingletonOfList getInstance_Threadsafe(){
        if(instance1==null) {
            synchronized (SingletonOfList.class){
                if(instance1==null) {
                    instance1 = new SingletonOfList();
                }
            }
        }
        return instance1;
    }

    public List<String> getMessageWithDCL(){
        synchronized (messages) {
            return new ArrayList<>(messages);
        }
    }
}
