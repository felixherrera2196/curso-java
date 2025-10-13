# Recuento de Pokébolas

## Historia
Misty está reorganizando el almacén del Centro Pokémon de Ciudad Cerulean. Cada hora los asistentes le informan cuántas
pokébolas de cada tipo llegaron: Poké Ball, Super Ball, Ultra Ball o Master Ball. Para saber si necesita hacer un nuevo pedido,
necesita un programa que le muestre el total disponible de cada tipo al final del día.

## Descripción del problema
- **Entrada:**
  1. Un número entero `N` que indica la cantidad de reportes recibidos.
  2. Una línea con `N` palabras separadas por espacio, cada una con el tipo de pokébola (`Poke`, `Super`, `Ultra` o `Master`).
- **Salida:** Cuatro líneas que indiquen cuántas pokébolas hay de cada tipo, en el formato:
  - `Poké Ball: <cantidad>`
  - `Super Ball: <cantidad>`
  - `Ultra Ball: <cantidad>`
  - `Master Ball: <cantidad>`

## Casos de ejemplo

### Ejemplo 1
**Entrada**
```
7
Poke Super Ultra Ultra Poke Master Super
```
**Salida**
```
Poké Ball: 2
Super Ball: 2
Ultra Ball: 2
Master Ball: 1
```

### Ejemplo 2
**Entrada**
```
4
Master Master Master Master
```
**Salida**
```
Poké Ball: 0
Super Ball: 0
Ultra Ball: 0
Master Ball: 4
```

### Ejemplo 3
**Entrada**
```
0
```
**Salida**
```
Poké Ball: 0
Super Ball: 0
Ultra Ball: 0
Master Ball: 0
```
