package Main;

import java.util.*;

public class ClassCollection <T> implements  Collection, java.io.Serializable {
    private Vector vec;
    private int length;

    ClassCollection(T[] args){

        vec = new Vector(1,1);
        length = args.length;
        vec.addAll(Arrays.asList(args));
    }

    public boolean replacement(Object value, int index){
        try {
            vec.remove(vec.elementAt(index));
            vec.add(index, value);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    ClassCollection(){

        vec = new Vector(10,1);
        length = 0;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(Object o) {

        Iterator<T> iter = vec.iterator();

        while (iter.hasNext()){
            if(iter.next() == o){
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iter = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return  currentIndex < length && vec.elementAt(currentIndex) != null;
            }

            @Override
            public T next() {
                return (T) vec.elementAt(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        return iter;
    }

    @Override
    public Object[] toArray() {

        Object[] arr =  new Object[this.length];
        var num = 0;
        for (var item : vec){
            arr[num] = item;
            num++;
        }
        return arr;
    }

    @Override
    public boolean add(Object o) {

        try {
            vec.add(o);
            length++;
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            vec.remove(o);
            return true;
        }
        catch (Exception ex){
            return  false;
        }
    }

    @Override
    public boolean addAll(Collection c) {
        try {
            vec.addAll(c);
            length += c.size();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public void clear() {
        try {
            vec.clear();
            length = 0;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public boolean retainAll(Collection c) {
        try {
            vec.retainAll(c);
            length = 0;
            for(var b : c){
                length++;
            }
            return true ;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public boolean removeAll(Collection c) {
        try {
            for (var a : c){
                for(var b : vec){
                    if (a == b){
                        length--;
                    }
                }
            }
            vec.removeAll(c);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection c) {
        return vec.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return vec.toArray(a);
    }

    public ArrayList exportToArrayList(){
        ArrayList list = new ArrayList();
        for (var item : vec){
            list.add(item);
        }
        return list;
    }

    @Override
    public String toString() {
        vec.forEach(v->System.out.print(v + ";"));
        return "";
    }
}