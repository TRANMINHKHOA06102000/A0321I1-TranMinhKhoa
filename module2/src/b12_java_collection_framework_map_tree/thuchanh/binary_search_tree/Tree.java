package b12_java_collection_framework_map_tree.thuchanh.binary_search_tree;

public interface Tree<E> {
    public boolean insert(E e);

    public void inorder();

    public int getSize();
}
