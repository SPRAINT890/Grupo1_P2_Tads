package MyTree;

public interface MyTree <K, V>{
    void insert (K key, V data, K parentKey);
    V find(K key);
    void delete (K key);

    void inOrder();
    void preOrder();
    void postOrder();

}
