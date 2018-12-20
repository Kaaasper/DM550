public class BTree<E> implements MyCollection<E>, Iterable<E> {

    /**
     * Inner node class
     */
    private static class Node<T> {

        private T value;
        private Node<T> left, right;

        private Node(T value, Node<T> left, Node<T> right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        private int height(Node<?> n){

            return 0;
        }

        private void add(T t){
            if (this.left == null){
                this.left = new Node<T>(t, null, null);
            } else if (this.right == null){
                this.right = new Node<T>(t, null, null);
            } else if ()
        }

        


    }



    /**
     * Actual BTree class
     */

    //Class Attributes
    private Node<E> root;

    //Constructor
    public BTree(){
        this.root = null;
    }

    public void add(E e){

        if (this.root == null){
            this.root = new Node<E>(e, null, null);
        } else {
            this.root.add(e);

        }


    }



    public E root(){
        return this.root;
    }


}