package hanoi.obj;

import java.util.Stack;

public class Torre {
    private Stack<Disco> discos;

    public Torre() {
        discos = new Stack<>();
    }

    public Torre(int n) {
        discos = new Stack<>();

        for (int i = n; i > 0 ; i--) {
            discos.push(new Disco(i));
        }
    }

    public void colocar(Disco d) {
        discos.push(d);
    }

    public Disco sacar() {
        return discos.pop();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("|-");
        for (Disco d:discos) {
            result.append(d).append("-");
        }
        return result.toString();
    }
}
