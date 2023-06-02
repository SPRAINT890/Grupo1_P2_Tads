package MyTree;

public class main {
    public static void main(String[] args) {
        MyTreeImpl arbol = new MyTreeImpl();
        arbol.insert(1, 1, 20);
        arbol.insert(2, 2, 1);
        arbol.insert(3, 3, 1);
        arbol.insert(4, 4, 2);
        arbol.insert(5, 5, 3);

        arbol.delete(5);
        System.out.println("hola");
    }
}
