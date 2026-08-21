
class MyHashSet {
     LinkedList<Integer>[] bucket = new LinkedList[1000];//This creates an empty list that can hold Integer values. bucket is an array of LinkedList<Integer> — and I'm building that array with 1000 raw LinkedList slots.

    public MyHashSet() {
        for (int i = 0; i < 1000; i++) {
            bucket[i] = new LinkedList<Integer>();
        }
    }
    
    public void add(int key) {
        int index = key % 1000;
        if (!bucket[index].contains(key)) {
            bucket[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index = key % 1000;
        if (bucket[index].contains(key)) {
            bucket[index].remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int index = key % 1000;
        return bucket[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);


 list.add(5);          // adds 5 to the list
list.contains(5);     // returns true/false — is 5 in the list?
list.remove(Integer.valueOf(5));  // removes the value 5 (not position 5!)
 */