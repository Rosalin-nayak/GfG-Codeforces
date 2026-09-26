/* Structure of binary tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}*/
class Pair{
    Node node;
    int time;
    Pair(Node node,int time){
        this.node=node;
        this.time=time;
    }
}
class Solution {
    static Node start;
    static HashMap<Node,Node> parent;
    public static int minTime(Node root, int target) {
        start=null;
        parent=new HashMap<>();
        dfs(root,target);
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(start,0));
        HashSet<Node> burned=new HashSet<>();
        burned.add(start);
        int totalTime=0;
        while(q.size()>0){
            Pair front=q.remove();
            Node frontNode=front.node;
            int time=front.time;
            totalTime=Math.max(totalTime,time);
            if(frontNode.left!=null && !burned.contains(frontNode.left)){
                q.add(new Pair(frontNode.left,time+1));
                burned.add(frontNode.left);
            }
            if(frontNode.right!=null && !burned.contains(frontNode.right)){
                q.add(new Pair(frontNode.right,time+1));
                burned.add(frontNode.right);
            }
            if(parent.containsKey(frontNode) && !burned.contains(parent.get(frontNode))){
                q.add(new Pair(parent.get(frontNode),time+1));
                burned.add(parent.get(frontNode));
            }
        }
        return totalTime;
    }
    
    public static void dfs(Node root,int target){
        if(root==null) return;
        if(root.data==target) start=root;
        if(root.left!=null) parent.put(root.left,root);
        if(root.right!=null) parent.put(root.right,root);
        dfs(root.left,target);
        dfs(root.right,target);
    }
}