class MinStack {
    private Stack<Pair> stack;
    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val, val));
        }else{
            int newMin=Math.min(val, stack.peek().min);
            stack.push(new Pair(val, newMin));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }

    private class Pair{
        int val;
        int min;
        Pair(int val, int min){
            this.val=val;
            this.min=min;
        }
    }
}
