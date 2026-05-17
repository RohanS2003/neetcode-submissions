class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=speed.length;
        int [][] cars=new int[n][2];

        for(int i=0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }

        Arrays.sort(cars, (a,b)->b[0]-a[0]);

        //Stack<Double> stack = new Stack<>();
        /*
        Can we avoid using a stack?
        Yes. Since the stack only stores fleet arrival times 
        and we only ever compare with the top, 
        we can replace it with one variable. */

        double currentFleetTime=0;
        int fleets=0;

        for(int i=0;i<n;i++){
            int pos=cars[i][0];
            int spd=cars[i][1];

            double time=(double)(target-pos)/spd;

            // if(stack.isEmpty() || time>stack.peek()){
            //     stack.push(time);
            // }

            if(time>currentFleetTime){
                fleets++;
                currentFleetTime=time;
            }
        }
        //return stack.size();
        return fleets;
    }
}
