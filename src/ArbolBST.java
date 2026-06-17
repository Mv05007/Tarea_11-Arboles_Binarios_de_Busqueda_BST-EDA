public class ArbolBST {
    private Nodo raiz;

    public ArbolBST() {
        this.raiz = null;
    }

    // --- INSERCIÓN ---
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodoActual, int valor) {
        if (nodoActual == null) {
            return new Nodo(valor);
        }

        if (valor < nodoActual.valor) {
            nodoActual.izquierdo = insertarRecursivo(nodoActual.izquierdo, valor);
        } else if (valor > nodoActual.valor) {
            nodoActual.derecho = insertarRecursivo(nodoActual.derecho, valor);
        }

        return nodoActual;
    }

    public void insertarMostrandoRecorrido(int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            System.out.println("Recorrido: Árbol vacío, insertado en la raíz.");
            System.out.println("Comparaciones: 0");
            return;
        }

        Nodo actual = raiz;
        Nodo padre = null;
        int comparaciones = 0;

        System.out.print("Recorrido: ");
        while (actual != null) {
            comparaciones++;
            padre = actual;
            System.out.print(actual.valor + " -> ");

            if (valor < actual.valor) {
                actual = actual.izquierdo;
            } else if (valor > actual.valor) {
                actual = actual.derecho;
            } else {
                System.out.println("Valor ya existe.");
                return;
            }
        }

        System.out.println(valor + " (Insertado)");
        System.out.println("Comparaciones realizadas: " + comparaciones);

        if (valor < padre.valor) {
            padre.izquierdo = new Nodo(valor);
        } else {
            padre.derecho = new Nodo(valor);
        }
    }

    // --- BÚSQUEDA ---
    public boolean buscar(int valor) {
        Nodo actual = raiz;
        int comparaciones = 0;

        System.out.print("Recorrido: ");
        while (actual != null) {
            comparaciones++;
            System.out.print(actual.valor + (actual.valor == valor ? "" : " -> "));

            if (valor == actual.valor) {
                System.out.println("\nComparaciones realizadas: " + comparaciones);
                return true;
            } else if (valor < actual.valor) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }

        comparaciones++; // Comprobación final al topar con el nulo
        System.out.println("puntero nulo");
        System.out.println("Comparaciones realizadas: " + comparaciones);
        return false;
    }

    // --- ELIMINACIÓN ---
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo nodoActual, int valor) {
        if (nodoActual == null) {
            return null;
        }

        if (valor < nodoActual.valor) {
            nodoActual.izquierdo = eliminarRecursivo(nodoActual.izquierdo, valor);
        } else if (valor > nodoActual.valor) {
            nodoActual.derecho = eliminarRecursivo(nodoActual.derecho, valor);
        } else {
            // Nodo encontrado
            // Caso 1: Sin hijos (Hoja) o Caso 2: Un solo hijo
            if (nodoActual.izquierdo == null) {
                return nodoActual.derecho;
            } else if (nodoActual.derecho == null) {
                return nodoActual.izquierdo;
            }

            // Caso 3: Dos hijos. Se busca el sucesor en orden (mínimo del subárbol derecho)
            Nodo sucesor = encontrarMinimo(nodoActual.derecho);
            System.out.println("Nota: Sucesor en orden utilizado para el reemplazo: " + sucesor.valor);

            nodoActual.valor = sucesor.valor;
            nodoActual.derecho = eliminarRecursivo(nodoActual.derecho, sucesor.valor);
        }
        return nodoActual;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual;
    }

    // --- RECORRIDOS ---
    public void imprimirInorden() {
        System.out.print("Inorden: ");
        recorridoInorden(raiz);
        System.out.println();
    }

    private void recorridoInorden(Nodo nodo) {
        if (nodo != null) {
            recorridoInorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            recorridoInorden(nodo.derecho);
        }
    }
}
