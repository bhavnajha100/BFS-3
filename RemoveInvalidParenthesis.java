// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
//Using BFS
class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false; // to check if we got a balanced string on a particular level
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (isBalanced(curr)) { // check if curr string is balanced;
                    flag = true;
                    result.add(curr);
                }
                if (!flag) {
                    // if the current string is not valid, iterate over the string and its child to
                    // queue
                    for (int k = 0; k < curr.length(); k++) {
                        char ch = curr.charAt(k);
                        if (Character.isAlphabetic(ch))
                            continue;
                        // remove kth character
                        String child = curr.substring(0, k) + curr.substring(k + 1);
                        if (!set.contains(child)) {
                            q.add(child);
                            set.add(child);
                        }
                    }

                }
            }
            if (flag)
                break;
        }
        return result;
    }

    private boolean isBalanced(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch))
                continue;
            if (ch == '(') {
                count++;
            } else {
                if (count == 0)
                    return false;
                count--;
            }
        }
        return count == 0;
    }
}

//Using DFS
class RemoveInvalidParenthesis {
    List<String> result;
    HashSet<String> set;
    int max;

    public List<String> removeInvalidParentheses(String s) {
        this.result = new ArrayList<>();
        this.set = new HashSet<>();
        dfs(s);
        return result;
    }

    private void dfs(String s) {
        // base
        if (s.length() < max)
            return;
        // logic
        if (isBalanced(s)) {
            if (s.length() > max) {
                max = Math.max(max, s.length());
                result = new ArrayList();
            }
            result.add(s);
        }
        set.add(s);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch))
                continue;
            String child = s.substring(0, i) + s.substring(i + 1);
            if (!set.contains(child))
                dfs(child);
        }

    }

    private boolean isBalanced(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch))
                continue;
            if (ch == '(') {
                count++;
            } else {
                if (count == 0)
                    return false;
                count--;
            }
        }
        return count == 0;
    }
}