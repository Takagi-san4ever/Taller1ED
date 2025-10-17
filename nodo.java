public class nodo {
    protected persona dato;
    protected nodo siguiente;

    public nodo() {
    }

    public nodo(persona dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public nodo(persona dato, nodo liga) {
        this.dato = dato;
        this.siguiente = liga;
    }

    public persona getDato() {
        return dato;
    }

    public void setDato(persona dato) {
        this.dato = dato;
    }

    public nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodo siguiente) {
        this.siguiente = siguiente;
    }

}
