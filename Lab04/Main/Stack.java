package Main;

import java.util.ArrayList;
import java.util.Arrays;

public class Stack {

    ArrayList list;

    Stack(){
        list = new ArrayList();
    }


    public void push(Object obj){
        list.add(0,obj);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public Object pop(){
        Object atTop = list.get(0);
        list.remove(0);
        return atTop;
    }

    public Object peek(){
        return list.get(0);
    }

    public int search(Object o){
        return list.indexOf(o) + 1;
    }
}
