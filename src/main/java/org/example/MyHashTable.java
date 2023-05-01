package org.example;
import java.util.ArrayList;
import java.util.Objects;


public class MyHashTable<K, V> {
    private class HashNode <K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] chainArray;
    private int M = 11; //Default number of chain
    private int size;
    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
        for (int i = 0; i < M; i++){
            chainArray[i] = null;
        }
    }

  public MyHashTable(int M){
    size = 0;
    this.M = M;
    this.chainArray = new HashNode[M];
    for (int i = 0; i < M; i++){
        chainArray[i] = null;
    }
}
    private int hash(K key) {
        return Objects.hash(key) % M;
    }
    public void put(K key, V value){
        int Index = hash(key);
        HashNode<K, V> hashnode = chainArray[Index];
        while(hashnode != null){
            if(hashnode.key.equals(key)){
                hashnode.value = value;
                return;
            }
            hashnode = hashnode.next;
        }
        HashNode<K, V> newhashnode = new HashNode<K, V>(key, value);
        newhashnode.next = chainArray[Index];
        chainArray[Index] = newhashnode;
        size++;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public V get(K key){
        int Index = hash(key);
        HashNode<K, V> hashnode = chainArray[Index];
        while(hashnode != null){
            if(hashnode.key.equals(key)){
                return hashnode.value;
            }
            hashnode = hashnode.next;
        }
        return null;
    }
    public V remove(K key){
        int Index = hash(key);
        HashNode<K, V> hashnode = chainArray[Index];
        HashNode<K, V> prevhashnode = null;
        while(hashnode != null){
            if(hashnode.key.equals(key)){
                if( prevhashnode == null){
                    chainArray[Index] = hashnode.next;
                }
                else{
                    prevhashnode.next = hashnode.next;
                }
                size--;
                return prevhashnode.value;
            }
            prevhashnode = hashnode;
            hashnode = hashnode.next;
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (HashNode<K, V> hashnode : chainArray) {
            while (hashnode != null) {
                sb.append(hashnode.key.toString()).append("=").append(hashnode.value.toString()).append(",");
                hashnode = hashnode.next;
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("}");
        return sb.toString();
    }
    public boolean contains(V value){
        return this.getKey(value) != null;
    }
    public K getKey(V value) {
        for (HashNode<K, V> hashnode : chainArray) {
            while (hashnode != null) {
                if (hashnode.value.equals(value)) {
                    return hashnode.key;
                }
                hashnode = hashnode.next;
            }
        }
        return null;
    }
}
