/*class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}
*/

class Solution {
    // Function to merge two sorted bottom-linked lists
    private Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        result.next = null; // important: next should not interfere
        return result;
    }

    // Function to flatten the entire list
    Node flatten(Node root) {
        if (root == null || root.next == null)
            return root;

        // Recur for list on the right
        root.next = flatten(root.next);

        // Merge this list with the right list
        root = merge(root, root.next);

        return root;
    }
}
