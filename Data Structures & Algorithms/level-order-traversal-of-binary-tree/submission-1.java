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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if(root==null)
        return new ArrayList<>();

        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int size=q.size();

            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                
                if(curr.left!=null)
                q.offer(curr.left);

                if(curr.right!=null)
                q.offer(curr.right);

                temp.add(curr.val);
            }
            res.add(temp);
        }
        return res;
    }
}
