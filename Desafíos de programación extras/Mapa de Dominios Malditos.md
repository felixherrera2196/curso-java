# Mapa de Dominios Malditos

## Historia
Satoru Gojo quiere asegurarse de que cada dominio en una zona urbana esté libre de energías malditas peligrosas. Para ello envía a sus estudiantes a medir la intensidad maldita en una cuadrícula. Cada fila de la cuadrícula representa una calle y cada columna una sección de esa calle.

## Descripción del problema
- **Entrada:**
  1. Dos enteros `N` y `M` que indican la cantidad de filas y columnas del mapa.
  2. `N` líneas con `M` enteros cada una que representan la intensidad maldita medida en cada sección.
- **Salida:**
  1. Una línea con el formato `Fila más peligrosa: <indice> (energía <valor>)`, donde `<indice>` es el número de fila (1-indexado) con mayor suma de intensidades y `<valor>` es dicha suma.
  2. Una línea con el formato `Columna más estable: <indice> (promedio <valor>)`, donde `<indice>` es el número de columna (1-indexado) con el menor promedio de energía. En caso de empate, se elige la columna con menor índice. El promedio debe mostrarse con dos decimales.

## Sugerencia de desarrollo
Resuelve el reto únicamente con arreglos, ciclos, condicionales y variables auxiliares. Una estrategia sencilla es:
1. Crear un acumulador por columna para guardar las sumas.
2. Usar un ciclo doble para leer cada valor, sumar por fila y por columna y actualizar el registro de la fila más peligrosa.
3. Al finalizar la lectura, recorrer las columnas para calcular el promedio de cada una y encontrar la más estable.

## Casos de ejemplo

### Ejemplo 1
**Entrada**
```
3 4
5 1 0 2
4 3 1 1
2 2 2 2
```
**Salida**
```
Fila más peligrosa: 1 (energía 8)
Columna más estable: 3 (promedio 1.00)
```

### Ejemplo 2
**Entrada**
```
2 3
1 1 1
5 0 4
```
**Salida**
```
Fila más peligrosa: 2 (energía 9)
Columna más estable: 2 (promedio 0.50)
```
