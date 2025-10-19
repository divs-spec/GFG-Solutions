import java.util.*;

class Solution {
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
        fillMap(root, target, tm);

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : tm.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list); // ensure smaller values first
            for (int val : list) {
                result.add(val);
                if (result.size() == k) return result;
            }
        }
        return result;
    }

    private void fillMap(Node root, int target, TreeMap<Integer, List<Integer>> tm) {
        if (root == null) return;

        int diff = Math.abs(root.data - target);
        tm.putIfAbsent(diff, new ArrayList<>());
        tm.get(diff).add(root.data);

        fillMap(root.left, target, tm);
        fillMap(root.right, target, tm);
    }
}
