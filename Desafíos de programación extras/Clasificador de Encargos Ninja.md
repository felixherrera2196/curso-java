# Clasificador de Encargos Ninja

## Historia
La aldea oculta de Konoha está saturada de encargos. Shikamaru fue asignado a clasificar cientos de misiones que llegan con etiquetas de rango (`D`, `C`, `B`, `A`, `S`). Para no quedarse dormido en el proceso, necesita un programa que cuente cuántas misiones hay de cada tipo y así organizar a los equipos ninja de forma más rápida.

## Descripción del problema
- **Entrada:**
  1. Un número entero `N` que indica la cantidad de encargos recibidos.
  2. Una línea con `N` cadenas separadas por espacio, cada una con el rango del encargo (`D`, `C`, `B`, `A` o `S`).
- **Salida:** Cinco líneas que indiquen la cantidad de misiones de cada rango, en el orden `D`, `C`, `B`, `A`, `S`. Cada línea debe tener el formato `Rango: cantidad`.

## Casos de ejemplo

### Ejemplo 1
**Entrada**
```
10
D C B A S D C B A S
```
**Salida**
```
D: 2
C: 2
B: 2
A: 2
S: 2
```

### Ejemplo 2
**Entrada**
```
7
S S A B C D D
```
**Salida**
```
D: 2
C: 1
B: 1
A: 1
S: 2
```

### Ejemplo 3
**Entrada**
```
5
A A A A A
```
**Salida**
```
D: 0
C: 0
B: 0
A: 5
S: 0
```
