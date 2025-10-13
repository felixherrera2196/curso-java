# Evaluación de Aspirantes U.A.

## Historia
Durante los exámenes de ingreso de la Academia U.A., la profesora Midnight anota los puntajes obtenidos por cada aspirante en
las pruebas de combate, rescate y estrategia. Al final del día, necesita saber el promedio de cada estudiante y quién destacó
más en la jornada para asignarle un entrenamiento especial.

## Descripción del problema
- **Entrada:**
  1. Un entero `N` que indica la cantidad de aspirantes evaluados.
  2. `N` líneas; cada línea contiene el nombre del aspirante seguido de tres enteros que representan sus puntajes en combate,
     rescate y estrategia.
- **Salida:**
  1. `N` líneas con el formato `<Nombre>: <promedio>`, donde `<promedio>` es el promedio de los tres puntajes con dos decimales.
  2. Una última línea con el formato `Mejor aspirante: <Nombre>` con la persona que obtuvo el promedio más alto (en caso de
     empate, el primero en aparecer).

## Casos de ejemplo

### Ejemplo 1
**Entrada**
```
3
Deku 90 85 95
Bakugo 100 80 70
Uraraka 88 92 90
```
**Salida**
```
Deku: 90.00
Bakugo: 83.33
Uraraka: 90.00
Mejor aspirante: Deku
```

### Ejemplo 2
**Entrada**
```
2
Todoroki 95 95 95
Iida 80 85 90
```
**Salida**
```
Todoroki: 95.00
Iida: 85.00
Mejor aspirante: Todoroki
```

### Ejemplo 3
**Entrada**
```
1
Jiro 70 75 72
```
**Salida**
```
Jiro: 72.33
Mejor aspirante: Jiro
```
