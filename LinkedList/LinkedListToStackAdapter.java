import java.util.LinkedList;

public class LinkedListToStackAdapter{

    static LinkedList<Integer> list;

    public LinkedListToStackAdapter(){
        list = new LinkedList<>();
    }

    void push(int val){
        list.addFirst(val);
    }

    int size(){
        return list.size();
    }

    int pop(){
        return list.removeFirst();
    }

    int top(){
        return list.getFirst();
    }

    public static void main(String[] args) {
        
        LinkedListToStackAdapter l = new LinkedListToStackAdapter();
        l.push(10);
        l.push(20);
        l.push(30);

        System.out.println(l.top());
        //System.out.println("Hiii");
    }
}