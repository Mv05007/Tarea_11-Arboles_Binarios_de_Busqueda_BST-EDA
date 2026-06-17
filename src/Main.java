import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cedula = "";
        boolean cedulaValida = false;

        System.out.println("--- GESTION DE ARBOL BINARIO DE BUSQUEDA (BST) ---");

        // 1. Lectura y validación estricta de la cédula
        do {
            System.out.print("Ingrese el numero de cedula (exactamente 10 digitos): ");
            cedula = scanner.nextLine().trim();

            if (cedula.length() == 10 && cedula.matches("[0-9]+")) {
                cedulaValida = true;
            } else {
                System.out.println("Error: Formato incorrecto. Asegurese de ingresar 10 numeros sin espacios.");
            }
        } while (!cedulaValida);

        // 2. Generación automática de los 10 valores iniciales de la fase base
        System.out.println("\n--- PARTE 0: Generacion de valores base ---");
        int[] valoresBase = new int[10];
        for (int i = 0; i < 10; i++) {
            int digito = Character.getNumericValue(cedula.charAt(i));
            int posicion = i + 1;
            valoresBase[i] = (digito * 10) + posicion;
            System.out.println("d" + posicion + " = " + digito + " -> V" + posicion + " = " + valoresBase[i]);
        }

        ArbolBST arbol = new ArbolBST();

        // 3. Construcción automática inicial con los valores de la cédula
        System.out.println("\n--- Construccion inicial del arbol ---");
        for (int i = 0; i < 10; i++) {
            arbol.insertar(valoresBase[i]);
        }
        System.out.print("Arbol inicial cargado con exito. ");
        arbol.imprimirInorden();

        // 4. Menú interactivo para inserciones, búsquedas y eliminaciones
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n========================================");
            System.out.println("            MENU DE OPCIONES            ");
            System.out.println("========================================");
            System.out.println("1. Insertar un nuevo valor");
            System.out.println("2. Buscar un valor (Ver recorrido)");
            System.out.println("3. Eliminar un valor");
            System.out.println("4. Mostrar recorrido Inorden actual");
            System.out.println("5. Salir del programa");
            System.out.print("Seleccione una opcion (1-5): ");

            String opcionInput = scanner.nextLine().trim();

            switch (opcionInput) {
                case "1":
                    System.out.print("\nIngrese el valor entero que desea insertar: ");
                    try {
                        int valorInsertar = Integer.parseInt(scanner.nextLine().trim());
                        arbol.insertarMostrandoRecorrido(valorInsertar);
                        System.out.print("Estado actual del ");
                        arbol.imprimirInorden();
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Debe ingresar un numero entero valido.");
                    }
                    break;

                case "2":
                    System.out.print("\nIngrese el valor entero que desea buscar: ");
                    try {
                        int valorBuscar = Integer.parseInt(scanner.nextLine().trim());
                        boolean encontrado = arbol.buscar(valorBuscar);
                        System.out.println("Resultado: El valor " + (encontrado ? "SI" : "NO") + " existe en el arbol.");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Debe ingresar un numero entero valido.");
                    }
                    break;

                case "3":
                    System.out.print("\nIngrese el valor entero que desea eliminar: ");
                    try {
                        int valorEliminar = Integer.parseInt(scanner.nextLine().trim());
                        // Primero verificamos si el valor existe para que la experiencia sea clara
                        System.out.println("Ejecutando algoritmo de eliminacion...");
                        arbol.eliminar(valorEliminar);
                        System.out.print("Estado actual del ");
                        arbol.imprimirInorden();
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Debe ingresar un numero entero valido.");
                    }
                    break;

                case "4":
                    System.out.println();
                    arbol.imprimirInorden();
                    break;

                case "5":
                    System.out.println("\nFinalizando el programa. Sistema cerrado.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcion no valida. Por favor, seleccione un numero entre 1 y 5.");
                    break;
            }
        }

        scanner.close();
    }
}
