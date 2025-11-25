# Practica-de-recursividad

**Asignatura:** Algoritmos Clásicos y Estructuras de Datos  
**Estudiante:** Jean Carlos Cruz Fernandez

## 📝 Descripción del Proyecto
Este proyecto implementa tres algoritmos clásicos comparando sus versiones **iterativas** y **recursivas**. El objetivo es demostrar la transformación entre ambos enfoques, el manejo de arreglos y cadenas sin usar colecciones de Java, y la diferencia en eficiencia.

## 🛠️ Instrucciones de Ejecución
1. Compilar: `javac SumaRecursiva.java`
2. Ejecutar: `java SumaRecursiva`

---

## 📂 Funciones Implementadas

### Ejercicio 1: Sumar un Arreglo
* **`sumarIterativo(int[] a)`**
  * **Qué hace:** Recorre el arreglo con un bucle `for` acumulando la suma ($O(n)$).
  * **Retorna:** Un entero (`int`) con la suma total.
  
* **`suma(int[] a, int n)`**
  * **Qué hace:** Suma el elemento actual y se llama a sí misma para el siguiente índice hasta llegar al final ($O(n)$).
  * **Retorna:** Un entero (`int`) con la suma total.

### Ejercicio 2: Máximo de un Arreglo
* **`maximoRecursivo(int[] a, int i, int j)`**
  * **Qué hace:** Utiliza "Divide y Vencerás", dividiendo el arreglo en mitades hasta comparar elementos individuales ($O(n)$ tiempo, $O(\log n)$ espacio).
  * **Retorna:** El valor máximo (`int`) encontrado en el rango.

* **`maximoIterativo(int[] a)`**
  * **Qué hace:** Recorre el arreglo linealmente guardando el valor más alto encontrado ($O(n)$ tiempo, $O(1)$ espacio).
  * **Retorna:** El valor máximo (`int`) del arreglo.

### Ejercicio 3: Invertir una Cadena
* **`invertirIterativo(String s)`**
  * **Qué hace:** Crea una nueva cadena recorriendo la original de atrás hacia adelante ($O(n)$).
  * **Retorna:** La cadena invertida (`String`).

* **`invertirRecursivo(String s)`**
  * **Qué hace:** Reduce la cadena quitando el primer carácter, invierte el resto recursivamente y coloca el primer carácter al final ($O(n^2)$).
  * **Retorna:** La cadena invertida (`String`).
