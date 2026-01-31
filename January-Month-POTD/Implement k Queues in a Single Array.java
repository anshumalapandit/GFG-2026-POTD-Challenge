class kQueues {
  
  Map<Integer,Queue<Integer>> map;
  int size;
    kQueues(int n, int k) {
        // Initialize your data members
         map=new HashMap<>();
         // initialise it otheriwse u endup doing null.add 
         for(int i=0;i<k;i++){
             Queue<Integer> q=new LinkedList<>();
             map.put(i,q);
         }
         size=n;
    }

    void enqueue(int x, int i) {
        // enqueue element x into queue number i
        Queue<Integer> q=map.get(i);
        q.add(x);
        // map.put(i,q);
    }

    int dequeue(int i) {
        // dequeue element from queue number i
        Queue<Integer> q=map.get(i);
        if(q.size()!=0)
        return q.poll();
        return -1;
        
    }

    boolean isEmpty(int i) {
        // check if queue i is empty
        Queue<Integer> q=map.get(i);
        return q.size()==0;
    }

    boolean isFull() {
        // check if array is full
        int s=0;
        for(int k: map.keySet()){
            Queue<Integer> q=map.get(k);
            s+=q.size();
        }
        if(s==size) return true;
        return false;
    }
}
