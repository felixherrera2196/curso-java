# Brújula del Grand Line

## Historia
Nami ha reunido datos sobre las corrientes marinas alrededor de varias islas del Grand Line. Cada punto de medición forma una matriz cuadrada y le ayuda a determinar la intensidad de las corrientes y qué ruta es más segura para los Sombrero de Paja.

## Descripción del problema
- **Entrada:**
  1. Un entero `N` que indica el tamaño de la matriz (cantidad de filas y columnas).
  2. `N` líneas con `N` enteros cada una que representan la intensidad de la corriente en cada punto.
- **Salida:**
  1. Una línea con el formato `Corriente principal: <valor>` donde `<valor>` es la suma de la diagonal principal.
  2. Una línea con el formato `Corriente inversa: <valor>` donde `<valor>` es la suma de la diagonal secundaria.
  3. Una línea con el formato `Diferencia absoluta: <valor>` que muestre el valor absoluto de la diferencia entre las dos corrientes.
  4. Una línea con el formato `Isla más agitada: fila <f>, columna <c>` indicando la posición (1-indexada) del punto con mayor intensidad. En caso de empate, se prefiere la fila menor y luego la columna menor.

## Sugerencia de desarrollo
Para mantener el enfoque en la lógica estructurada, trabaja con ciclos anidados, condicionales y variables simples:
1. Usa dos acumuladores para las diagonales y una bandera para guardar el primer valor leído.
2. En cada iteración del ciclo doble, actualiza los acumuladores y compara el valor actual con el máximo encontrado.
3. Al terminar, calcula la diferencia absoluta entre las diagonales y muestra los resultados.

## Casos de ejemplo

### Ejemplo 1
**Entrada**
```
3
1 2 3
4 5 6
7 8 9
```
**Salida**
```
Corriente principal: 15
Corriente inversa: 15
Diferencia absoluta: 0
Isla más agitada: fila 3, columna 3
```

### Ejemplo 2
**Entrada**
```
4
5 1 3 2
4 8 0 6
7 2 9 1
3 4 5 2
```
**Salida**
```
Corriente principal: 24
Corriente inversa: 16
Diferencia absoluta: 8
Isla más agitada: fila 3, columna 3
```
