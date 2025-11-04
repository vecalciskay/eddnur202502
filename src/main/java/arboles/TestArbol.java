package arboles;

public class TestArbol {
    public static void main(String[] args) {
        StringIdentifiable s = new StringIdentifiable("G");
        Arbol<StringIdentifiable> a = new Arbol();

        a.insertar(null, new StringIdentifiable("A"));
        a.insertar("A", new StringIdentifiable("B"));
        a.insertar("A", new StringIdentifiable("C"));
        a.insertar("A", new StringIdentifiable("D"));

        a.insertar("B", new StringIdentifiable("E"));
        a.insertar("C", new StringIdentifiable("F"));
        a.insertar("C", new StringIdentifiable("G"));
        a.insertar("D", new StringIdentifiable("H"));
        a.insertar("D", new StringIdentifiable("I"));
        a.insertar("D", new StringIdentifiable("J"));

        a.insertar("G", new StringIdentifiable("K"));
        a.insertar("G", new StringIdentifiable("L"));

        //Arbol<StringIdentifiable> b = new Arbol("A(D(J,I,H),C(G(L,K),F),B(E))");

        System.out.println(a);

    }
}
