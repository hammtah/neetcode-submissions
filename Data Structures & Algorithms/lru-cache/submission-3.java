
class LRUCache {
    class Data {
        int value;
        java.time.LocalDateTime lastAccess;
        Data(int value, java.time.LocalDateTime lastAccess) {
            this.value = value;
            this.lastAccess = lastAccess;
        }
        public void access() {
            lastAccess = java.time.LocalDateTime.now();
        }
    }

    HashMap<Integer, Data> cache;
    int capacity;
    int usedMem;

 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            cache.get(key).access();
            return cache.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, new Data(value, java.time.LocalDateTime.now()));
            return;
        }
        // Eviction
        if (usedMem >= capacity) {
            evict();
        }

        // Put
        cache.put(key, new Data(value, java.time.LocalDateTime.now()));
        usedMem++;   
    }

    public void evict() {
        java.time.LocalDateTime min = java.time.LocalDateTime.MAX;
        int minKey = 0;
        for (var key : cache.keySet()) {
            if (cache.get(key).lastAccess.compareTo(min) < 0) {
                min = cache.get(key).lastAccess;
                minKey = key;
            }
        }

        cache.remove(minKey);
        usedMem--;
    }

    public void print() {
        for (var key : cache.keySet()) {
            System.out.println(key + ":" + cache.get(key).value);
        }
    }
}
