package MyClass.MyHashMap;

public interface BaseMap<K,V> {
    //存
    public V put(K k, V v) ;
    //取
    public V get(K k);
}