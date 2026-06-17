# Tarea 11: Implementación de un Árbol Binario de Búsqueda (BST) en Java

## 1. Información Académica

* **Institución:** Escuela Politécnica Nacional (EPN)
* **Asignatura:** Estructura de Datos y Algoritmos 1
* **Integrantes:** Adrián Mauricio Trujillo Salazar y Mauro Alexander Valencia Monteros
* **Cédula de prueba utilizada:** 1751416718 (Adrián Trujillo)

---

## 2. Contexto y Relación con el Taller 11

Este proyecto en Java implementa las operaciones fundamentales de un Árbol Binario de Búsqueda (BST). El objetivo principal del programa es reproducir con exactitud algorítmica el árbol construido manualmente en papel durante el "Taller Integrador: Auditoría y Gestión de un Árbol BST".

El sistema utiliza la cédula declarada para generar los valores iniciales V1 a V10 mediante la fórmula Vi = (di * 10) + i. Todas las operaciones ejecutadas por el programa (recorridos, conteo de comparaciones y reestructuración por eliminación) han sido diseñadas para coincidir matemáticamente con el análisis documentado en el taller físico.

---

## 3. Explicación de Operaciones y Casos Cubiertos

El programa cumple con los siguientes requisitos funcionales sin el uso de librerías externas para la estructura de datos:

1. **Validación:** Garantiza el ingreso estricto de una cadena de exactamente 10 dígitos numéricos.
2. **Construcción e Inserción:** Genera y enlaza los nodos secuencialmente, imprimiendo el estado Inorden tras cada inserción para auditar su crecimiento.
3. **Búsquedas Analíticas:** Rastrea valores específicos, documentando la ruta de nodos visitados y el total de comparaciones lógicas realizadas (incluyendo la comprobación final de punteros nulos).
4. **Eliminación por Casos:**
* **Caso 1 (Nodo Hoja):** Eliminación directa desvinculando el puntero del nodo padre.
* **Caso 2 (Un solo hijo):** Eliminación del nodo, ascendiendo a su único hijo para ocupar su posición en la estructura.
* **Caso 3 (Dos hijos):** El algoritmo busca el sucesor en orden (el valor mínimo del subárbol derecho), intercambia los valores con el nodo a eliminar y procede a reestructurar la rama eliminando el nodo original del sucesor.



---

## 4. Pseudocódigo de las Operaciones Centrales

El siguiente pseudocódigo corresponde de manera exacta a la implementación en Java entregada. Se utiliza un enfoque recursivo para las operaciones de inserción y eliminación, y un enfoque iterativo para la búsqueda.

### A. Operación: Insertar (Enfoque Recursivo)

```text
Función insertar(nodoActual, valor):
    Si nodoActual es NULO:
        Retornar nuevo Nodo(valor)
    
    Si valor < nodoActual.valor:
        nodoActual.izquierdo = insertar(nodoActual.izquierdo, valor)
    Sino Si valor > nodoActual.valor:
        nodoActual.derecho = insertar(nodoActual.derecho, valor)
        
    Retornar nodoActual

```

### B. Operación: Buscar (Enfoque Iterativo con conteo)

```text
Función buscar(raiz, valorBuscado):
    actual = raiz
    comparaciones = 0
    Imprimir "Recorrido: "
    
    Mientras actual no sea NULO:
        comparaciones = comparaciones + 1
        Imprimir actual.valor
        
        Si valorBuscado == actual.valor:
            Imprimir "Comparaciones realizadas: ", comparaciones
            Retornar VERDADERO
        Sino Si valorBuscado < actual.valor:
            actual = actual.izquierdo
        Sino:
            actual = actual.derecho
            
    comparaciones = comparaciones + 1
    Imprimir " -> puntero nulo"
    Imprimir "Comparaciones realizadas: ", comparaciones
    Retornar FALSO

```

### C. Operación: Eliminar (Tres casos)

```text
Función eliminar(nodoActual, valor):
    Si nodoActual es NULO:
        Retornar NULO
    
    Si valor < nodoActual.valor:
        nodoActual.izquierdo = eliminar(nodoActual.izquierdo, valor)
    Sino Si valor > nodoActual.valor:
        nodoActual.derecho = eliminar(nodoActual.derecho, valor)
    Sino:
        // Caso 1 (Hoja) y Caso 2 (Un hijo)
        Si nodoActual.izquierdo es NULO:
            Retornar nodoActual.derecho
        Sino Si nodoActual.derecho es NULO:
            Retornar nodoActual.izquierdo
        
        // Caso 3: Dos hijos
        sucesor = encontrarMinimo(nodoActual.derecho)
        nodoActual.valor = sucesor.valor
        nodoActual.derecho = eliminar(nodoActual.derecho, sucesor.valor)
        
    Retornar nodoActual

Función auxiliar encontrarMinimo(nodo):
    actual = nodo
    Mientras actual.izquierdo no sea NULO:
        actual = actual.izquierdo
    Retornar actual

```

---

## 5. Instrucciones de Compilación y Ejecución

El proyecto está diseñado para compilarse sin dependencias de un entorno de desarrollo (IDE). Desde la consola de comandos o terminal, ubíquese en la raíz del proyecto (donde se encuentra la carpeta `src`) y ejecute los siguientes comandos:

**Para compilar los archivos:**

```bash
mkdir bin
javac src/*.java -d bin

```

**Para ejecutar el programa:**

```bash
java -cp bin Main

```

---

## 6. Enlace a Diagramas (Figma)

Para el diseño y la construcción visual de los diagramas de los árboles binarios de búsqueda de este taller, utilizamos la herramienta digital Figma.

En cumplimiento con las instrucciones de la guía de la asignatura, a continuación se adjunta el enlace fuente compartido con los permisos de edición vigentes para su respectiva revisión y verificación técnica:

* **Enlace editable del proyecto:** [https://www.figma.com/board/UjgTSyjlyBP3LSqcJt2eaj/%C3%81RBOLES-DE-LA-TAREA-EN-CLASE-11?node-id=0-1&t=2RfiAj0NpO5uZAux-1](https://www.figma.com/board/UjgTSyjlyBP3LSqcJt2eaj/%C3%81RBOLES-DE-LA-TAREA-EN-CLASE-11?node-id=0-1&t=2RfiAj0NpO5uZAux-1)

---

## 7. Declaración Obligatoria de Integridad Académica y Uso de IA

Nosotros, los integrantes del grupo, declaramos bajo compromiso de integridad académica que el código fuente presentado fue estructurado, analizado y desarrollado algorítmicamente en estricto cumplimiento con la lógica establecida en nuestro taller físico. Se utilizó Inteligencia Artificial (IA) exclusivamente como herramienta de consulta para la validación de la sintaxis iterativa en Java y para estructurar el formato de presentación en Markdown de este documento, respetando integralmente las directrices de la asignatura. Garantizamos que el código, la ejecución y las salidas mostradas corresponden de manera autónoma e íntegra a nuestro análisis basado en la cédula declarada.
