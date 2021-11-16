package com.cb.edu.letcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSame(left,right);
    }
    boolean isSame(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }else if(root1==null||root2==null) {
            return false;
        }
        return root1.val==root2.val&&isSame(root1.left,root2.right)&&isSame(root1.right,root2.left);

    }
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }
    //将一个有序数组转化为完全平衡搜索二叉树
    public TreeNode sortedArrayToBST(int[] nums) {
        return bbst(nums,0,nums.length-1);
    }
    public TreeNode bbst(int[] nums,int left,int right){
        if(left<right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = bbst(nums,left,mid-1);
        treeNode.right = bbst(nums,mid+1,right);
        return treeNode;
    }
    //杨氏三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <numRows ; i++) {
            List<Integer> slist = new ArrayList<>();
            for (int j = 0; j <=i ; j++) {
                if(j==0||j==i){
                    slist.add(1);
                }else {
                    slist.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
                }
            }
            list.add(slist);
        }
        return list;
    }
    //二分查找
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left + right)/2;
            if (nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right = mid - 1;
            }else {
                left = mid +1;
            }
        }
        return -1;
    }
    //双指针删除元素
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int left = 0;
        for (int right = 0; right < length ; right++) {
            if (nums[right]!=val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;

    }
    //有序数组的平方
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] newnums = new int[n];
        for (int i = 0,nb = n-1,j=n-1; i <=j; ) {
            if (nums[i]*nums[i]<nums[j]*nums[j]){
                newnums[nb] = nums[j]*nums[j];
                j--;
            }else {
                newnums[nb] = nums[i]*nums[i];
                i++;
            }
            nb--;
        }
        return newnums;

    }
    //查找大于目标的最小连续数组
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int h = 0;
        int min = Integer.MAX_VALUE,sum = 0;
        while (h<nums.length){
            sum+=nums[h++];
            while (sum>=target){
                min = Math.min(min,h-l);
                sum-=nums[l++];
            }
        }
        return min == Integer.MAX_VALUE?0:min;
    }



}
