package Collection;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args){
        CollectionTest collection = new CollectionTest();
//        collection.testSet();
//        collection.listTest();
//        collection.queueTest();
        collection.mapTest();
    }
    public void testSet(){
        Set fruits = new HashSet();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.add("apple");
        System.out.println(fruits);
        System.out.println(fruits.size());
        System.out.println(fruits.remove("banana"));
        System.out.println(fruits.size());
        System.out.println(fruits);
        /**
         * 1- never accept duplicated elements
         * 2- never be ordered
         */
    }
    public void listTest(){
        List fruits = new ArrayList();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.add("apple");
        System.out.println(fruits);
        System.out.println(fruits.size());
        System.out.println(fruits.remove("banana"));
        System.out.println(fruits.get(0));
        System.out.println(fruits);
        /**
         * 1- accept duplicated elements
         * 2- elements ordered according to the insertion order
         * 3- can access elements according to their index as they are ordered
         */
    }
    public void queueTest(){
        Queue fruits = new LinkedList();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.add("apple");
        System.out.println(fruits);
        System.out.println(fruits.size());
        System.out.println(fruits.remove());
        System.out.println(fruits);
        /**
         * 1- accept duplicated elements
         * 2- elements ordered according to the insertion order
         * 3- can access elements according to their index as they are ordered
         */
    }
    public void mapTest(){
        Map fruitCalories = new HashMap();
        fruitCalories.put("apple",20);
        fruitCalories.put("orange",30);
        fruitCalories.put("banana",50);
        fruitCalories.put("lemon",10);
        fruitCalories.put("apple",20);
        System.out.println(fruitCalories);
        System.out.println(fruitCalories.size());
        System.out.println(fruitCalories.get("banana"));
        System.out.println(fruitCalories.remove("apple"));
        System.out.println(fruitCalories);
        /**
         * 1- not ordered
         * 2- no duplicated elements
         * 3- doesn't extend collection interface so can't use add method
         * 4- pair of key and vlue key should be unique and values not
         */
    }
}
