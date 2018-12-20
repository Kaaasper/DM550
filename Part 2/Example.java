public class SimpleCache<K, E> implements Iterable<E>{

    private class Pair<Key, Val> {

        private Key key;
        private Val val;
        
        private Pair(Key key, Val val){
            this.key = key;
            this.val = val;
        }

    }

    private class SomeIterator implements Iterator<E>{

    }

    private ArrayList<Pair<K, E>> cache;
    private int capacity;

    public SimpleCache(int capacity){

        this.capacity = capacity;

    }

    public void add(K key, E e){
        remove(key);

        if (this.cache.size() == this.capacity){
            this.cache.remove(0);
        }

        cache.add(new Pair<K, E>(key, e));
    }


    public void remove(K key){

        for (Pair<K, E> p : this.cache){
            if (p.key.equals(key)){
                this.cache.remove(p);
            }
        }

    }


}