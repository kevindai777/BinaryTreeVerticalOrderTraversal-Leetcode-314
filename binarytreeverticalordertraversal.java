class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.add(new Pair(root, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> curr = stack.poll();
            TreeNode node = curr.getKey();
            int level = curr.getValue();
            
            if (!map.containsKey(level)) {
                map.put(level, new ArrayList<>());
            }
            map.get(level).add(node.val);
            
            min = Math.min(min, level);
            max = Math.max(max, level);
            
            if (node.left != null) {
                stack.add(new Pair(node.left, level - 1));
            }
            
            if (node.right != null) {
                stack.add(new Pair(node.right, level + 1));
            }
        }
        
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        
        return result;
    }
}