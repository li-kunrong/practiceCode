package MyClass.MyHashMap;

/**
 * @Author: kunrong
 * @Date: 2019/8/19 14:22
 * @Description:
 **/
public class Entry<K, V> implements BaseEntry<K, V> {
    K k;
    V v;
    Entry<K, V> next;

    public Entry(K k, V v, Entry<K, V> next) {
        this.k = k;
        this.v = v;
        this.next = next;
    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }
}