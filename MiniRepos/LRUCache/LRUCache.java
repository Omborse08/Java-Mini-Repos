package LRUCache;

import java.util.*;

class LRUCache{
    private int capacity;
    private LinkedHashMap<Integer,String> map;


    public LRUCache(int a) {
        this.capacity = a;
        map = new LinkedHashMap<>(capacity, 0.75f,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }


    public void PUT(int a,String b) {
        map.put(a,b);
    }

    public String GET(int a) {
        return map.get(a);
    }

    public void DELETE(int a) {
        if (!map.containsKey(a)) {
            System.out.println("Does Not Containe Key!");
        }
        else {
            map.remove(a);
        }
    }

    public void printCache() {
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+ " -> "+entry.getValue());
        }
    }
}

class ShowMenu {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.PUT(1,"OM");
        lruCache.PUT(2,"SOHAM");
        lruCache.PUT(3,"DEEPAK");
        lruCache.GET(1);
        lruCache.PUT(4,"ROHAN");
        lruCache.DELETE(3);
        lruCache.PUT(5,"SHUBHAM");
        lruCache.GET(1);
        lruCache.PUT(6,"ASHISH");
        lruCache.GET(5);
        lruCache.GET(1);
        
        lruCache.printCache();
    }
}
