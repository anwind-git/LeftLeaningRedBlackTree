public class MainSem4 {
    public static void main(String[] args) {
        HashTable<Integer,Integer> hashTable=new HashTable<>();
        Basket basket = new Basket();

        Entity entity = new Entity();
        basket.add(entity,hashTable.basketArray);

        LeftLeaningRedBlackTree<Integer, String> tree = new LeftLeaningRedBlackTree<>();
        tree.put(1, "one");
        tree.put(2, "two");
        tree.put(3, "three");

        LeftLeaningRedBlackTree<Integer, String>.Node root = tree.getRoot();
        System.out.println("Root key: " + root.getKey() + ", Root value: " + root.getValue());

    }
}
