public class LeftLeaningRedBlackTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public Node getRoot() {
        return root;
    }

    class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int subtreeSize;

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.subtreeSize = size;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }


        public Node getKey() {
            return root;
        }

        public Node getValue() {
            return root;
        }
    }


    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, RED, 1);

        int cmp = key.compareTo(h.key);
        if      (cmp < 0) h.left  = put(h.left,  key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else              h.value = val;


        if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);

        h.subtreeSize = size(h.left) + 1 + size(h.right);
        return h;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.subtreeSize = h.subtreeSize;
        h.subtreeSize = size(h.left) + 1 + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.subtreeSize = h.subtreeSize;
        h.subtreeSize = size(h.left) + 1 + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.subtreeSize;
    }


}