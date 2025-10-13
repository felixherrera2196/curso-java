# Patrullas del Muro

## Historia
Durante una inspección nocturna en el Muro Rose, Hange Zoe necesita organizar a los escuadrones de exploración para cubrir cada
sección sin dejar puntos ciegos. Cada escuadrón reporta la cantidad de titanes avistados en distintas zonas del muro, y Hange
quiere identificar cuál escuadrón tuvo la jornada más intensa y qué zona requiere refuerzos inmediatos.

## Descripción del problema
- **Entrada:**
  1. Dos enteros `R` y `C` separados por espacio que indican el número de escuadrones y de zonas vigiladas.
  2. Una línea con `R` cadenas separadas por espacio que representan el nombre de cada escuadrón.
  3. `R` líneas adicionales; cada línea contiene `C` enteros que indican los avistamientos por zona del escuadrón correspondiente.
- **Salida:**
  1. Una línea con el formato `Escuadrón con más avistamientos: <nombre> (<total>)`.
  2. Una línea con el formato `Zona con más actividad: <indiceZona> (<total>)`, donde `<indiceZona>` es el número de zona iniciando en `1`.

## Casos de ejemplo

### Ejemplo 1
**Entrada**
```
3 4
Levi Hange Erwin
5 3 2 4
6 2 1 3
4 4 4 4
```
**Salida**
```
Escuadrón con más avistamientos: Erwin (16)
Zona con más actividad: 4 (11)
```

### Ejemplo 2
**Entrada**
```
2 3
Mikasa Armin
10 0 5
4 4 4
```
**Salida**
```
Escuadrón con más avistamientos: Mikasa (15)
Zona con más actividad: 1 (14)
```

### Ejemplo 3
**Entrada**
```
4 2
Jean Sasha Connie Historia
3 3
1 5
2 2
3 4
```
**Salida**
```
Escuadrón con más avistamientos: Historia (7)
Zona con más actividad: 2 (14)
```
