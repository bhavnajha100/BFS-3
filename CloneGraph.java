// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
//Using BFS
class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        q.add(node);

        while (!q.isEmpty()) {
            Node currNode = q.poll();
            for (Node ne : currNode.neighbors) {
                if (!map.containsKey(ne)) {
                    Node newNode = new Node(ne.val);
                    map.put(ne, newNode);
                    q.add(ne);
                }
                map.get(currNode).neighbors.add(map.get(ne));
            }
        }
        return copyNode;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
//Using DFS
class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }

    private void dfs(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node))
            return;

        Node copyNode = new Node(node.val);
        map.put(node, copyNode);

        for (Node ne : node.neighbors) {
            dfs(ne, map);
            map.get(node).neighbors.add(map.get(ne));
        }
    }
}