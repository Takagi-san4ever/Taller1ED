public class listaSimple {

    protected nodo inicio;
    protected nodo fin;

    public listaSimple() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean listaVacia() {
        return inicio == null;
    }

    public void agregarAlInicio(persona p) {
        nodo nuevo = new nodo(p);
        if (listaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    public void agregarAlFinal(persona p) {
        nodo nuevo = new nodo(p);
        if (listaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public void mostrarLista() {
        if (!listaVacia()) {
            nodo actual = inicio;
            while (actual != null) {
                persona p = actual.getDato();
                System.out.println(
                        "Nombre: " + p.getNombre() +
                                ", Apellido: " + p.getApellido() +
                                ", Peso: " + p.getPeso() +
                                ", Altura: " + p.getAltura());
                actual = actual.getSiguiente();
            }
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public void eliminarDelInicio(String nombre) {
        if (!listaVacia()) {
            if (inicio.getDato().getNombre().equalsIgnoreCase(nombre)) {
                inicio = inicio.getSiguiente();
                if (inicio == null) {
                    fin = null;
                }

                persona p = inicio.getDato();
                System.out.println("Persona eliminada: " + "Nombre: " + p.getNombre()
                        + ", Apellido: " + p.getApellido());
            } else {
                System.out.println("La persona no se encuentra al inicio de la lista");
            }
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public void buscarPersona(String nombre) {
        if (!listaVacia()) {
            nodo actual = inicio;
            boolean encontrado = false;
            while (actual != null) {
                if (actual.getDato().getNombre().equalsIgnoreCase(nombre)) {
                    persona p = actual.getDato();
                    System.out.println("Persona encontrada: " + "Nombre: " + p.getNombre() +
                            ", Apellido: " + p.getApellido()
                            + ", Altura: " + p.getAltura() + ", Peso: " + p.getPeso());
                    encontrado = true;
                    break;
                }
                actual = actual.getSiguiente();
            }
            if (!encontrado) {
                System.out.println("Persona no encontrada");
            }
        } else {
            System.out.println("La lista esta vacia");
        }
    }
}