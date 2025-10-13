# Codificador Pokéball

## Historia
El Profesor Oak recibió mensajes secretos de diferentes regiones Pokémon. Para asegurarse de que sólo sus asistentes puedan leerlos,
los codifica en una cuadrícula y los guarda dentro de Pokébolas. Ahora te toca ayudar a Misty a decodificar los mensajes leyendo
en el orden correcto.

## Descripción del problema
- **Entrada:**
  1. Una cadena de texto `mensaje` sin saltos de línea.
  2. Un entero `C` que indica la cantidad de columnas de la matriz que se utilizará para reorganizar el mensaje.
- **Proceso:** Coloca los caracteres del mensaje en una matriz de `R` filas y `C` columnas (donde `R` es el número mínimo de filas necesarias), llenándola fila por fila. Si la última fila queda incompleta, rellénala con el carácter `*`. Luego lee la matriz columna por columna de izquierda a derecha y concatena los caracteres diferentes de `*` para formar el mensaje decodificado.
- **Salida:** Una línea con el texto decodificado.

## Casos de ejemplo

### Ejemplo 1
**Entrada**
```
PIKACHU
3
```
**Salida**
```
PAUICKH
```

### Ejemplo 2
**Entrada**
```
ENTRENADORLIGA
4
```
**Salida**
```
EEOGNNRATALRDI
```

### Ejemplo 3
**Entrada**
```
POKEMONMAESTRO
5
```
**Salida**
```
POSONTKMREAOME
```
