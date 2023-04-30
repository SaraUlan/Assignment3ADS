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
}
