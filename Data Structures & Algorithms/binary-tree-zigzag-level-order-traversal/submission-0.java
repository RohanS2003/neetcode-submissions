/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean leftToRight=true;

        if(root==null){
            return ans;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> curr=new LinkedList<>();

            for(int i=0;i<size;i++){
                TreeNode currNode=q.poll();
                if (leftToRight) {
                    curr.addLast(currNode.val);
                } else {
                    curr.addFirst(currNode.val);
                }

                if (currNode.left != null) {
                    q.offer(currNode.left);
                }

                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
            ans.add(curr);
            leftToRight=!leftToRight;
        }
        return ans;
    }
}