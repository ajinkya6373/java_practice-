package tree;


import javax.swing.*;
import java.util.*;

public class BinaryTree {

   public class Node{
        int val;
       Node left;
       Node right;

       Node(int value){
           this.val = value;
           this.left = null;
           this. right = null;
       }
       Node(int value,Node left, Node right){
           this.val = value;
           this.left = left;
           this. right = right;
       }
    }

    public Node CreateTree(Node root){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the data");
        int data= sc.nextInt();
        if(data ==-1){
            return null;
        }
        root = new Node(data);
        System.out.println("Enter data for inserting in left of "+data+"\n");
        root.left = CreateTree(root.left);
        System.out.println("Enter data for inserting in right of "+data+"\n");
        root.right = CreateTree(root.right);
        return root;
    }

    public void inOrder(Node node){
       if(node ==null){
           return;
       }
        inOrder(node.left);
        System.out.println(node.val+" ");
        inOrder(node.right);
    }

    public int NoOfLeafNode(Node root,int count){
       if (root ==null){
           return count;
       }
       if(root.left ==null && root.right ==null){
           count++;
       }
        count =NoOfLeafNode(root.left,count);
        count =NoOfLeafNode(root.right,count);
        return  count;
    }

    public class pair{
       Node key;
       int num;
       pair(Node keyValue,int val){
        this.key = keyValue;
        this.num = val;
       }
    }
    public void perInPostTraversal(Node root){
        Stack<pair> st = new Stack<pair>();
        st.push(new pair(root,1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        List<Integer> In = new ArrayList<>();
        while(!st.isEmpty()){
            pair it = st.pop();
            if (it.num ==1){
                pre.add(it.key.val);
                it.num++;
                st.push(it);
                if (it.key.left!=null){
                    st.push(new pair(it.key.left,1));
                }
            }
            else if(it.num ==2){
                In.add(it.key.val);
                it.num++;
                st.push((it));
                if (it.key.right!=null){
                    st.push(new pair(it.key.right,1));
                }
            }else{
                post.add((it.key.val));
            }
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(post);
        ans.add(In);

        for (int i = 0; i < In.size(); i++) {
            System.out.println(In.get(i));
        }

    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<Node> q = new LinkedList<Node>();
        boolean leftToRight =true;
        if(root ==null) return ans;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sublist = new ArrayList<Integer>(size);
            for (Integer i = 0; i <size; i++) {
                sublist.add(i, null);
            }

            System.out.println("size of sublist"+ sublist.size());
            for(int i=0;i<size;i++){
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);
                int index = (leftToRight) ? i : (size-1-i);
                sublist.add(index,q.poll().val);
            }
            leftToRight = !leftToRight;
            ans.add(sublist);
        }
        for (int i = 0; i <ans.size() ; i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.printf(String.valueOf(ans.get(i).get(j)));
            }
            System.out.println();
        }
        return ans;
    }
    public boolean isLeaf(Node root){
       if(root.left ==null&&root.right==null){
           return true;
       }
       return  false;
    }
    public void addLeftBoundary(Node root,ArrayList <Integer>ans){
       Node cur = root.left;
       while(cur!=null){
           if (!isLeaf(cur)){
               ans.add(root.val);
           }
           if(cur.left !=null){
               cur = cur.left;
           }
           else{
               cur = cur.right;
           }

       }

    }
    public void addLeaf (Node root,ArrayList <Integer>ans){
       if (isLeaf(root)){
           ans.add(root.val);
           return;
       }
      if (root.left!=null)addLeaf(root.left,ans);
      if (root.right!=null)addLeaf(root.right,ans);

    }

    public void addRightBoundary (Node root,ArrayList <Integer>ans){
       Node cur = root.right;
       ArrayList <Integer> temp = new ArrayList<>();
       while (cur!=null){
           if(!isLeaf(cur)){
               temp.add(cur.val);
           }
           if (cur.right!=null){
               cur = cur.right;
           }else {
               cur = cur.left;
           }

           for (int i = temp.size()-1; i >=0 ; --i) {
                ans.add(temp.get(i));
           }

       }

    }
    public ArrayList printArrayBoundary(Node root){
       ArrayList <Integer>ans = new ArrayList<>();
       addLeftBoundary(root,ans);
       addLeaf(root,ans);
       addRightBoundary(root,ans);
       return ans;
    }

    // Top View OF binary tree

    public ArrayList topView(Node root){
       ArrayList<Integer> ans = new ArrayList<Integer>();
       Queue<pair> q = new LinkedList<pair>();
       Map<Integer,Integer> map = new TreeMap<>();
       q.add(new pair(root,0));
       while (!q.isEmpty()){
           pair tp = q.remove();
          if(!map.containsKey(tp.num)) map.put(tp.num,tp.key.val);
          if(tp.key.left!=null) q.add(new pair(tp.key.left,tp.num-1));
          if(tp.key.right!=null) q.add(new pair(tp.key.right,tp.num+1));

       }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }

    return ans;
    }

    // rightSide View Of tree
    public List<Integer> rightSideView(Node root) {
        List<Integer> ans = new ArrayList<>();
        Queue<pair> q = new LinkedList<pair>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.add(new pair(root,0));
        while (!q.isEmpty()){
            pair tp = q.remove();
            int level = tp.num;
            if (!map.containsKey(level)) map.put(level,tp.key.val);
            if(tp.key.right!=null) q.add(new pair(tp.key.right,tp.num+1));
            if(tp.key.left!=null) q.add(new pair(tp.key.left,tp.num+1));

        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;


    }

    // bottom view
    public List<Integer> bottomView(Node root){
        List<Integer> ans = new ArrayList<>();
        Queue<pair> q = new LinkedList<pair>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.add(new pair(root,0));
        while(!q.isEmpty()){
            pair tp = q.remove();
            int level = tp.num;
            map.put(level,tp.key.val);
            if(tp.key.left!=null) q.add(new pair(tp.key.left,tp.num-1));
            if(tp.key.right!=null) q.add(new pair(tp.key.right,tp.num+1));

        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }


    public void MarkParent(Node root,Map<Node,Node> track_parent){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node curNode = q.poll();
            if(curNode.left!=null){
                track_parent.put(curNode.left,curNode);
                q.add(curNode.left);
            }
            if(curNode.right!=null){
                track_parent.put(curNode.right,curNode);
                q.add(curNode.right);
            }

        }
    }
    public List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node,Node> track_parent  = new HashMap<Node,Node>();
        MarkParent(root,track_parent);
        Map<Node,Boolean> visited = new HashMap<Node,Boolean>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(target);
        visited.put(target,true);
        int curDis  =0;
        while(!q.isEmpty()){

            if(k==curDis) break;
            curDis++;
            for(int i=0;i<q.size();i++){
                Node curNode = q.poll();
                if(curNode.left!=null && visited.get(curNode.left) ==null){
                    q.add(curNode.left);
                    visited.put(curNode.left,true);
                }

                if(curNode.right!=null && visited.get(curNode.right) ==null){
                    q.add(curNode.right);
                    visited.put(curNode.right,true);
                }

                if(track_parent.get(curNode)!=null && visited.get(track_parent.get(curNode))==null){
                    q.add(track_parent.get(curNode));
                    visited.put(track_parent.get(curNode),true);
                }

            }

        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            Node curNode = q.poll();
            ans.add(curNode.val);
        }
        return ans;
    }

    // Construct Binary Tree from Preorder and Inorder Traversal
    public Node conTree(int[] preorder, int pStart,int pEnd, int[]inorder,int inStart, int inEnd,Map<Integer,Integer> inMap){
        if(pStart>pEnd || inStart>inEnd) return null;
        Node root = new Node(preorder[pStart]);
        int inRoot = inMap.get(root.val);
        int numLeft = inRoot-inStart;
        root.left = conTree(preorder,pStart+1,pStart+numLeft, inorder,inStart,inRoot-1,inMap);
        root.right = conTree(preorder,pStart+numLeft+1,pEnd,inorder,inRoot+1,inEnd,inMap);
        return root;

    }

    public Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer>inMap = new HashMap<Integer,Integer>();

        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return conTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
    }

    void MorrisTraversal(Node root)
    {
        Node current, pre;
        if (root == null)
            return;
        current = root;
        while (current != null)
        {
            if (current.left == null)
            {
                System.out.print(current.val + " ");
                current = current.right;
            }
            else {
                pre = current.left;
                while (pre.right != null
                        && pre.right != current)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                else
                {
                    pre.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }

            }

        }
    }

    public void FlattenBt(Node root){
       if(root ==null){
           return;
       }
       Node cur = root;
       while(cur!=null){
           if (cur.left!=null){
               Node prev = cur.left;
               while(prev.right!=null){
                   prev=prev.right;
               }
               prev.right = cur.right;
               cur.right=cur.left;
           }
           cur = cur.right;
       }
    }

    public static void main(String[] args) {
        BinaryTree obj = new BinaryTree();
        Node root = obj.CreateTree(null);
//        System.out.println("Last Root value"+root.val);
//        obj.inOrder(root);
//        System.out.println( "no of leaf node are "+obj.NoOfLeafNode(root,0));
//         obj.perInPostTraversal(root);

//       obj.zigzagLevelOrder(root);
//       ArrayList<Integer> ans = obj.printArrayBoundary(root);
//        for (int i = 0; i <ans.size() ; i++) {
//            System.out.printf(String.valueOf(ans.get(i)));
//
//        }
//    ArrayList ans = obj.topView(root);
//    List ans = obj.rightSideView(root);
//        List ans = obj.bottomView(root);
//        List ans = obj.distanceK(root,root.left,2);
//        int [] pre ={3,9,20,15,7};
//        int []in ={9,3,15,20,7};

//        Node root = obj.buildTree(pre,in);
//        obj.MorrisTraversal(root);
            obj.FlattenBt(root);
        System.out.println(root.right.right.right.val);
//    for (int i = 0; i <ans.size() ; i++) {
//            System.out.printf(String.valueOf(ans.get(i)));
//
//        }


    }
}
