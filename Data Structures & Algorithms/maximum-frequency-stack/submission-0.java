class FreqStack {
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> grp;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        grp = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val,0)+1;//count freq
        freq.put(val,f);
        maxFreq = Math.max(maxFreq,f);
        grp.putIfAbsent(f,new Stack<>());// storing freq in stack
        grp.get(f).push(val);

    }
    
    public int pop() {
        Stack<Integer> stack = grp.get(maxFreq);
        int val = stack.pop();
        freq.put(val,freq.get(val)-1);//update the freq stack by removing its past occurence
        if(stack.isEmpty()){
            maxFreq--;
        }
        return val;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */