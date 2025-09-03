import java.util.Scanner;

public class menu {
    private Scanner sc;
    private vectores vec; 

    public menu() {
        this.sc = new Scanner(System.in);
    }

    
    public void inicializarVector() {
        System.out.print("¿Cuántas personas desea registrar? ");
        int cantidad = 0;
        while (true) {
            try {
                cantidad = Integer.parseInt(sc.nextLine());
                if (cantidad > 0) {
                    break;
                } else {
                    System.out.print("Por favor, ingrese un número mayor que 0: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada no válida. Ingrese un número entero: ");
            }
        }
        this.vec = new vectores(cantidad);
        System.out.println("Vector creado para almacenar hasta " + cantidad + " persona(s).\n");
    }

    
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("        MENÚ DE GESTIÓN DE PERSONAS");
            System.out.println("=".repeat(50));
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona por nombre");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    mostrarPersonas();
                    break;
                case 3:
                    eliminarPersona();
                    break;
                case 4:
                    buscarPersona();
                    break;
                case 5:
                    System.out.println("\nGracias por usar el sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija entre 1 y 5.");
            }
        } while (opcion != 5);
    }

    
    private void agregarPersona() {
        if (vec.vectorLleno()) {
            System.out.println("No se pueden agregar más personas: el vector está lleno.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Peso (kg): ");
        float peso = Float.parseFloat(sc.nextLine());

        System.out.print("Altura (m): ");
        float altura = Float.parseFloat(sc.nextLine());

        persona p = new persona(nombre, apellido, peso, altura);
        vec.agregarPersona(p);
        System.out.println("Persona agregada correctamente.\n");
    }

    
    private void mostrarPersonas() {
        if (vec.vectorVacio()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("\n--- LISTA DE PERSONAS REGISTRADAS ---");
            vec.mostrarVector();
        }
    }

    
    private void eliminarPersona() {
        if (vec.vectorVacio()) {
            System.out.println("No hay personas para eliminar.");
            return;
        }

        System.out.print("Ingrese la posición a eliminar (0-" + vec.getIndice() + "): ");
        int posicion = Integer.parseInt(sc.nextLine());

        vec.eliminarPersona(posicion);
    }

    
    private void buscarPersona() {
        if (vec.vectorVacio()) {
            System.out.println("No hay personas registradas.");
            return;
        }

        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = sc.nextLine();

        int pos = vec.buscarPersona(nombre);
        if (pos != -1) {
            persona p = vec.getVectorPersona()[pos];
            System.out.println("\nPersona encontrada en posición " + pos + ":");
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Apellido: " + p.getApellido());
            System.out.println("Peso: " + p.getPeso() + " kg");
            System.out.println("Altura: " + p.getAltura() + " m");
        }
    }

   
    public static void main(String[] args) {
        menu sistema = new menu();
        sistema.inicializarVector(); 
        sistema.mostrarMenu();       
    }
}
// prueba de cambio 