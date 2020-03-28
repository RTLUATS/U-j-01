package Main;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class TestClass {

    @Test
    public void pop(){
        Stack stack = new Stack();
        stack.push(123);
        Object obj = 123;
        Assert.assertEquals(obj,stack.pop());
    }

    @Test
    public void replacement(){
        Object[] arr = new Object[]{1,2,3};
        ClassCollection collection = new ClassCollection(arr);
        collection.replacement(2,0);
        arr = new Object[]{2,2,3};
        Assert.assertArrayEquals(arr,collection.toArray());
    }

    @Test
    public void size(){
        Object[] arr = new Object[]{1,2,3};
        ClassCollection collection = new ClassCollection(arr);
        Assert.assertEquals(3,collection.size());
    }

    @Test
    public void contains(){
        Object[] arr = new Object[]{1,2,3};
        ClassCollection collection = new ClassCollection(arr);
        Assert.assertEquals(true,collection.contains(1));
    }

    @Test
    public void clear(){
        Object[] arr = new Object[]{1,2,3};
        ClassCollection collection = new ClassCollection(arr);
        collection.clear();
        Assert.assertEquals(0,collection.size());
    }

    @Test
    public void retainAll(){
        Object[] arr = new Object[]{1,2,3};
        ClassCollection collection = new ClassCollection(arr);
        ArrayList<Object> list = new ArrayList<Object>() ;
        list.add(1);
        list.add(2);
        collection.retainAll(list);
        Assert.assertEquals(2,collection.size());
    }

    @Test
    public void removeAll(){
        Object[] arr = new Object[]{1,2,3};
        ClassCollection collection = new ClassCollection(arr);
        ArrayList<Object> list = new ArrayList<Object>() ;
        list.add(1);
        list.add(2);
        collection.removeAll(list);
        Assert.assertEquals(1,collection.size());
    }

    @Test
    public void containsAll(){
        Object[] arr = new Object[]{1,2,3};
        ClassCollection collection = new ClassCollection(arr);
        ArrayList<Object> list = new ArrayList<Object>() ;
        list.add(1);
        list.add(2);
        Assert.assertEquals(true,collection.containsAll(list));
    }

    @Test
    public void push(){
        Stack actual = new Stack();
        actual.push(123);
        Stack expected =  new Stack();
        expected.push(123);
        Assert.assertEquals(expected.pop(),actual.pop());
    }

    @Test
    public void search(){
        Stack actual = new Stack();
        actual.push(123);
        Assert.assertEquals(1,actual.search(123));
    }

    @Test
    public void peek(){
        Stack actual = new Stack();
        actual.push(123);
        Assert.assertEquals((Object) 123,actual.peek());
    }

    @Test
    public void isEmpty(){
        Stack actual = new Stack();
        Assert.assertEquals(true,actual.isEmpty());
    }

}
