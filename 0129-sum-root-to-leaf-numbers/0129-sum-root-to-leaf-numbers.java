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
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        calc(root, root.val);
        int answer = ans;
        ans = 0;
        return answer;
    }

    private void calc(TreeNode n, int sum) {
        if(n.left == null && n.right == null) {
            ans += sum;
        }
        if(n.left != null) {
            calc(n.left, 10*sum + n.left.val);
        }
        if(n.right != null) {
            calc(n.right, 10*sum + n.right.val);
        }
    }
}