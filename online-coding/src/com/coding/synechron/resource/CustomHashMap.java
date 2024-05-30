//package com.coding.synechron;
//
//public class CustomHashMap<K, V> {
//
//    class Entry<k, v> {
//        K key;
//        V value;
//        Entry<K, V> next;
//
//        public Entry ( K key , V value ) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    Entry<K, V>[] buckets;
//    int capacity = 16;
//    int size = 0;
//
//    public CustomHashMap () {
//        buckets = new Entry[capacity];
//    }
//
//    public int getIndex ( K key ) {
//        return key.hashCode() % capacity;
//    }
//
//    public synchronized void put ( K key , V value ) {
//        int index = getIndex(key);
//        Entry<K, V> entry = buckets[index];
//        while (entry != null) {
//            if (entry.key.equals(key)) {
//                entry.value = value;
//            }
//            entry = entry.next;
//        }
//        Entry<K, V> newEntry = new Entry<>(key , value);
//        newEntry.next = buckets[index];
//        buckets[index] = newEntry;
//        size++;
//    }
//
//    public synchronized V get(K key){
//        int index = getIndex(key);
//        Entry<K, V> entry = buckets[index];
//
//    }
//
//}