package aula10.ex2;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Iterator;
import java.lang.Comparable;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {

    private static class BSTNode<T> {
        T element;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T theElement) {
            element = theElement;
            left = right = null;
        }
    }

    private class InternalIterator implements Iterator<T> {
        BSTNode<T> actual;
        Stack<BSTNode<T>> references;

        public InternalIterator() {
            references = new Stack<>();
            setReferencesToStack(root);
        }

        public boolean hasNext() {
            return references.size() != 0;
        }

        public T next() {
            actual = references.peek();
            return valueOf(references.pop());
        }

        public void remove() {
            BinarySearchTree.this.remove(valueOf(actual), root);
            references.remove(actual);
            actual = references.peek();
        }

        private void setReferencesToStack(BSTNode<T> root) {
            if (root != null) {
                references.add(root);
                if (root.left != null)
                    setReferencesToStack(root.left);
                if (root.right != null)
                    setReferencesToStack(root.right);
            }
        }
    }

    private BSTNode<T> root;
    private int numNodes;

    public BinarySearchTree() {
        root = null;
        numNodes = 0;

    }

    public void insert(T value) {
        if (!contains(value) && value != null)
            root = insert(value, root);
    }

    public void remove(T value) {
        if (contains(value) && value != null)
            root = remove(value, root);
    }

    public boolean contains(T value) {
        return valueOf(find(value, root)) != null;
    }

    public Iterator<T> iterator() {
        return this.new InternalIterator();
    }

    private T valueOf(BSTNode<T> node) {
        if (node != null)
            return node.element;
        return null;
    }

    private BSTNode<T> insert(T value, BSTNode<T> root) {
        BSTNode<T> n = new BSTNode<>(value);
        if (root == null) {
            numNodes++;
            return root = n;
        } else if (value.compareTo(root.element) <= 0) {
            if (root.left == null) {
                numNodes++;
                root.left = n;
            } else
                return insert(value, root.left);
        } else if (value.compareTo(root.element) > 0) {
            if (root.right == null) {
                numNodes++;
                root.right = n;
            } else
                return insert(value, root.right);
        }
        return root;
    }

    private BSTNode<T> remove(T value, BSTNode<T> root) {
        if (root == null)
            return null;
        else if (value.compareTo(root.element) < 0)
            root.left = remove(value, root.left);
        else if (value.compareTo(root.element) > 0)
            root.right = remove(value, root.right);
        else if (value.equals(root.element)) {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.right;
            else
                insert(root.left.element, root.right);
        }
        return root;
    }

    private BSTNode<T> find (T value, BSTNode<T> root) {
        if (root != null) {
            if (root.element.equals(value))
                return root;
            else if (root.left != null && root.left.element.compareTo(value) <= 0)
                return find(value, root.left);
            else if (root.right != null && root.right.element.compareTo(value) > 0)
                return find(value, root.right);
        }
        return null;
    }
}