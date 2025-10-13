# Registro de Amenazas Demoníacas

## Historia
Tras la caída del sol, el Cuerpo de Exterminio de Demonios reúne reportes de los cazadores repartidos por Japón. Shinobu Kocho
quiere saber qué tan peligrosas fueron las misiones de la noche para preparar los medicamentos adecuados. Cada reporte incluye
el nivel de amenaza encontrado, de 1 (baja) a 5 (crítica).

## Descripción del problema
- **Entrada:**
  1. Un entero `N` que indica la cantidad de reportes recibidos.
  2. Una línea con `N` enteros entre `1` y `5` que representan el nivel de amenaza de cada encuentro.
- **Salida:**
  1. Una línea con el formato `Promedio de amenaza: <valor>` donde `<valor>` es el promedio de los niveles con dos decimales.
  2. Una línea con el formato `Nivel más frecuente: <nivel>`, donde `<nivel>` es el nivel que más se repitió (en caso de empate,
     el menor nivel).

## Casos de ejemplo

### Ejemplo 1
**Entrada**
```
6
1 3 4 4 2 5
```
**Salida**
```
Promedio de amenaza: 3.17
Nivel más frecuente: 4
```

### Ejemplo 2
**Entrada**
```
5
2 2 2 5 5
```
**Salida**
```
Promedio de amenaza: 3.20
Nivel más frecuente: 2
```

### Ejemplo 3
**Entrada**
```
3
5 5 5
```
**Salida**
```
Promedio de amenaza: 5.00
Nivel más frecuente: 5
```
