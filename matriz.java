public class matriz {
    private int fila;
    private int columna;
    private int c;
    private int f;
    private persona matriz[][];

    public matriz() {
    }

    public matriz(int filas, int columnas) {
        this.fila = filas;
        this.columna = columnas;
        this.f = 0;
        this.c = 0;
        matriz = new persona[filas][columnas];
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public persona[][] getMatriz() {
        return matriz;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void setMatriz(persona[][] matriz) {
        this.matriz = matriz;
    }

    public boolean matrizVacia() {
        if (this.f == this.fila && this.c == this.columna)
            return true;
        else
            return false;
    }

    public boolean matrizLlena() {
        if (this.f == this.fila - 1 && this.c == this.columna)
            return true;
        else
            return false;
    }

    public void agregar(persona p) {
        if (!matrizLlena()) {
            if (this.c < this.columna) {
                matriz[this.f][this.c] = p;
                this.c++;
            } else {
                this.c = 0;
                this.f++;
                matriz[this.f][this.c] = p;
                this.c++;
            }
        }

    }
    
    public void mostrarMatriz() {
        if (!matrizVacia()) {
            for (int i = 0; i < this.fila; i++) {
                for (int j = 0; j < this.columna; j++) {
                    if (matriz[i][j] != null) {
                        System.out.print("[" + matriz[i][j].getNombre() + " " + matriz[i][j].getApellido() + " " 
                        + matriz[i][j].getPeso() + " " + matriz[i][j].getAltura() + "] ");
                    } else {
                        System.out.print("[ ] ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("La matriz esta vacia");
        }
    }

    public void eliminar(int posicion) {
        if (posicion != -1) {
            int fila = posicion / this.columna;
            int columna = posicion % this.columna;
            matriz[fila][columna] = null;
            System.out.println("Persona eliminada de la matriz");
        } else {
            System.out.println("No se puede eliminar, persona no encontrada");
        }
    }

    public int buscarPersona(String nombre) {
        int posicion = -1;
        for (int i = 0; i < this.fila; i++) {
            for (int j = 0; j < this.columna; j++) {
                if (matriz[i][j] != null && matriz[i][j].getNombre().equalsIgnoreCase(nombre)) {
                    posicion = i * this.columna + j;
                }
            }
        }
        return posicion;
    }

    public boolean matrizCuadrada() {
        return this.fila == this.columna;
    }

    public void mostrarDiagonalPrincipal() {
        int peso = 0;
        int promedio = 0;
        if (matrizCuadrada()) {
            promedio = this.fila;
            System.out.println("Elementos en la diagonal principal:");
            for (int i = 0; i < this.fila; i++) {
                if (matriz[i][i] != null) {
                    peso += matriz[i][i].getPeso();
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println("El peso promedio en la diagonal principal: " + (peso / promedio) + " kg");
        } else {
            System.out.println("La matriz no es cuadrada, no tiene diagonal principal.");
        }
    }

    public void mostrarDiagonalSecundaria() {
        double estatura = 0;
        double promedio = 0;
        if (matrizCuadrada()) {
            promedio = this.fila;
            System.out.println("Elementos en la diagonal secundaria:");
            for (int i = 0; i < this.fila; i++) {
                if (matriz[i][this.columna - 1 - i] != null) {
                    estatura += matriz[i][this.columna - 1 - i].getAltura();
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println("La estatura promedio en la diagonal secundaria: " + ((estatura / promedio) / 100) + " metros");
        } else {
            System.out.println("La matriz no es cuadrada, no tiene diagonal secundaria.");
        }
    }

}