import java.util.Scanner;
import java.util.Random;

public class SumaRecursiva {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long startTime, endTime;

        // ----------------------------------------------------------------------------------------------------------

        System.out.println("\n--- Ejercicio 1: Suma de Arreglo ---");
        System.out.println("Ingrese numeros separados por espacio (ej: 1 2 3 4 5):");
        String inputLine = scanner.nextLine();

        if (inputLine.trim().isEmpty()) {
            inputLine = "0";
        }

        String[] parts = inputLine.split("\\s+");
        int[] numeros = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            try {
                numeros[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida (" + parts[i] + "), se usara 0.");
                numeros[i] = 0;
            }
        }


        startTime = System.nanoTime();
        int resIterativo = sumarIterativo(numeros);
        endTime = System.nanoTime();
        System.out.printf("Iterativo: %d \t[Tiempo: %d ns]\n", resIterativo, (endTime - startTime));


        startTime = System.nanoTime();
        int resRecursivo = suma(numeros, 0);
        endTime = System.nanoTime();
        System.out.printf("Recursivo: %d \t[Tiempo: %d ns]\n", resRecursivo, (endTime - startTime));


        // ----------------------------------------------------------------------------------------------------------

        System.out.println("\n--- Ejercicio 2: Maximo (Random) ---");
        System.out.print("Ingrese tamano del arreglo aleatorio: ");
        Random rand = new Random();
        int n = 0;
        try {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) line = "5";
            n = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            n = 5;
            System.out.println("Valor invalido, usando N=5");
        }

        int numeros2[] = new int[n];
        System.out.printf("Generando arreglo aleatorio de tamano %d:\n", n);


        int limiteVisual = 20;
        for (int i = 0; i < n; i++) {
            numeros2[i] = rand.nextInt(100);


            if (i < limiteVisual) {
                System.out.print(numeros2[i] + " ");
            }
        }


        if (n > limiteVisual) {
            System.out.println("\n... (Se ocultaron " + (n - limiteVisual) + " valores para no saturar la pantalla)");
        } else {
            System.out.println();
        }
        // --------------------------------------------------

        if (n > 0) {

            startTime = System.nanoTime();
            int maxRec = maximoRecursivo(numeros2, 0, numeros2.length - 1);
            endTime = System.nanoTime();
            System.out.printf("Recursivo: %d \t[Tiempo: %d ns]\n", maxRec, (endTime - startTime));


            startTime = System.nanoTime();
            int maxIter = maximoIterativo(numeros2);
            endTime = System.nanoTime();
            System.out.printf("Iterativo: %d \t[Tiempo: %d ns]\n", maxIter, (endTime - startTime));
        } else {
            System.out.println("El arreglo esta vacio.");
        }

        // ----------------------------------------------------------------------------------------------------------

        System.out.println("\n--- Ejercicio 3: Invertir Cadena ---");
        System.out.println("Ingrese una cadena de texto:");
        String text = scanner.nextLine();


        startTime = System.nanoTime();
        String invIter = invertirIterativo(text);
        endTime = System.nanoTime();
        System.out.printf("Iterativo: %s \t[Tiempo: %d ns]\n", invIter, (endTime - startTime));


        startTime = System.nanoTime();
        String invRec = invertirRecursivo(text);
        endTime = System.nanoTime();
        System.out.printf("Recursivo: %s \t[Tiempo: %d ns]\n", invRec, (endTime - startTime));

        scanner.close();
    }

    // =============================================================
    // FUNCIONES REALIZADAS

    static int suma(int[] a, int n){
        if (n == a.length) {
            return 0;
        } else {
            return a[n] + suma(a, n + 1);
        }
    }

    static int maximoIterativo(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacio.");
        }

        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    static String invertirRecursivo(String s) {
        if (s.length() <= 1) {
            return s;
        }

        return invertirRecursivo(s.substring(1)) + s.charAt(0);
    }

    // =============================================================
    // FUNCIONES ORIGINALES DEL PDF

    static int sumarIterativo(int[] a) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        return total;
    }

    static int maximoRecursivo(int[] a, int i, int j) {
        if (i == j) {
            return a[i];
        }
        int mid = (i + j) / 2;
        int left = maximoRecursivo(a, i, mid);
        int right = maximoRecursivo(a, mid + 1, j);
        return Math.max(left, right);
    }

    static String invertirIterativo(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}