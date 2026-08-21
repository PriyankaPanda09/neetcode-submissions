class MyHashMap {

    LinkedList<int[]>[] bucket = new LinkedList[10000];

    public MyHashMap() {
        for(int i=0; i<1000;i++){
            bucket[i] = new LinkedList<int[]>();
        }
    }
    
    public void put(int key, int value) {
        int index = key % 1000;
        boolean found = false;
        for (int[] arr: bucket[index]){
            if(arr[0]==key){
                arr[1] = value;
                found=true;
            }            
        }
         
            if(!found){
                bucket[index].add(new int[]{key,value});
            }
    }
    
    public int get(int key) {
        int index = key % 1000;
        for (int[] arr: bucket[index]){
            if(arr[0]==key){
                return arr[1];
            }            
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key % 1000;
        // boolean found = false;
        for(int[] arr:bucket[index]){
            if(key == arr[0]){
                bucket[index].remove(arr);
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */