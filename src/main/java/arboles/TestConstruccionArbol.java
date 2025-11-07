package arboles;

public class TestConstruccionArbol {
    public static void main(String[] args) {
        ConstructorArbol constructor = new ConstructorArbol();
        Arbol<StringIdentifiable> arbol = constructor.construirArbol("A");
        System.out.println(arbol);

        arbol = constructor.construirArbol("A(F,T)");
        System.out.println(arbol);

        arbol = constructor.construirArbol("A(F(D,R,E),T,O(B,M))");
        System.out.println(arbol);
    }
}
