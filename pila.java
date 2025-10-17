public class pila {

    protected int max = 10;
    protected int tope;
    protected persona[] pilaPrimaria;
    protected persona[] pilaAuxiliar;;

    public pila() {
    }

    public pila(int Max) {
        this.max = Max;
        this.tope = -1;
        this.pilaPrimaria = new persona[this.max];
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public persona[] getpilaPrimaria() {
        return pilaPrimaria;
    }

    public void setpilaPrimaria(persona[] pilaPrimaria) {
        this.pilaPrimaria = pilaPrimaria;
    }

    public boolean pilaVacia() {
        return tope == -1;
    }

    public boolean pilaLlena() {
        return tope == max - 1;
    }

    public void push(persona p) {
        if (!pilaLlena()) {
            tope ++;
            pilaPrimaria[tope] = p;
        } else {
            System.out.println("Pila llena. No se puede agregar el elemento.");
        }
    }

    public persona pop() {
        if (!pilaVacia()) {
            persona elemento = pilaPrimaria[tope];
            tope --;
            pilaAuxiliar[tope] = elemento;
            return elemento;
        } else {
            System.out.println("Pila vacia. No se puede eliminar el elemento.");
            return null;
        }
    }

    public void mostrarPila() {
        if (pilaVacia()) {
            System.out.println("Pila vacia.");
        } else {
            System.out.println("Elementos en la pila:");
            for (int i = tope; i >= 0; i--) {
                System.out.println(pilaPrimaria[i]);
            }
        }
    }

    public void buscarEnPila(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i <= tope; i++) {
            if (pilaPrimaria[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Elemento encontrado: " + pilaPrimaria[i]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Elemento no encontrado en la pila.");
        }
    }
    
}
