# Ejercico con matrices
1.Objetivo: Aplicar la logica de arrglos bidimencionales(matrices) en Java utilizando el paradigma de POO, implementando validaciones de dimmenciones recorridos de indices y encapsulacion.

## Ejercicio 1: Sistema de reserva de asientos.
Diseña un metodo que se llame `reservaAsiento (int fila, int columna)`, debe de resivir la fila y la columna, que controle el mapa de ocupacion de un teatro o sala. La matriz inicicara con cero(eso significa libre).

Si el asiento solicitado contiene cero, cambialo a uno(ocupado), y muestre un mensaje de exito.

Si el aciento ya contiene uno, notifica que esta ocupado.

Validar qu elas coordenadas ingresadas no excedan los limites de la matriz.

## Ejercico 2 : Acumulado de ventas por sucursal en mes(m*n) 
Una empresa registra las ventas enteras de m sucursales, en n mesese.

a) Implementar un metodo, que calcule la suma por cada fila(total por sucursal).

b) Calcular la suma por cada columna( total por mes)

c) Genera un reporte formateado(con formato),en un solo panel de texto 

## Ejercicio 3: Diagnostico de Matriz identidad y diagonal principal (n*n).

Implementa un modulo para analisis algebraico.
**Validadcion orevia**: Comprueba si la matriz es cuadrada. Si no lo es, cancela la operacion y muestra un mensaje de advertencia.

a) Si es cuadrada, evalua si es una **matriz identidad**(unos en la diagonal principal y ceros en el resto).

b) Calcula e imprimi la suma de los elemtos de la diagonal principal.

## Ejercicio 4: Transpocicion dinamica de matriz(M x N->N x N)

a) Creea el metodo `obtenerTrans`, que invierta ,
la funcion debe retornar una nueva instancia de la clase matriz con direcciones invertidas N x N.

b) Copia cada elemento siguiguiendo la regla de trasnpocicion tranpuesta[j][i]=original[i][j]

##  Ejercicio 5: Rotacin de la matriz a 90° en sentido orario, N x N.

A) Simula el giro de una matriz cuadrada o mapa}

b) Verifica que la matriz sea especificamente cuadrada,
rotada 90° a la derecha