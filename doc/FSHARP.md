Comparison with F#
==================

This document compares this library with F#'s built-in unit support.

All F# code examples are from [F# Units of Measure guide on MSDN](http://msdn.microsoft.com/en-us/library/dd233243.aspx).

Feature comparison
------------------

What F# has this library doesn't:

* full unit inference: `(x,y,z) -> x*x + y + z*z*z` is correctly inferred to have type `(float<'u^3>, float<'u^6>, float<'u^2>) -> float<'u^6>`

* more robust compile-time unit calculation, especially involving generics

* support for 32-bit floating point values

* cleaner syntax

What this library has F# doesn't:

* automatic unit conversion

* distinction between affine spaces and vector spaces

The main reasons F# unit support is better is that it's first-class language concept, not a library.

Syntax comparison
-----------------

**Defining units**

F#:

``` fsharp
[<Measure>] type cm
[<Measure>] type ml = cm^3
```

Scala:

``` scala
type cm = DefineType[_c~:_m]
type ml = cube[cm]
```

**Values**

F#:

``` fsharp
1.0<cm>
55.0<miles/hour>
55.0f<miles/hour> 
```

Scala:

``` scala
1.0.of[cm]
55.0.of[mile/hour]
// 32-bit floating point numbers with units are not yet supported
```

**Convertion functions**

F#:

``` fsharp
let convertg2kg (x : float<g>) = x / 1000.0<g/kg>

let length = 12.0<cm>
let x = float length
```

Scala:

``` scala
def convertg2kg(x: DoubleU[g]): DoubleU[kg] = x / 1000.of[g/kg]
// explicitly stating the return type is not technically needed, but it makes Eclipse happy

// preferred way:
implicit val g_to_kg = one[kg].contains(1000)[g]

val length = 12.0.of[cm]
val x = length.value
```

**Generics**

F#:

``` fsharp
let genericSumUnits ( x : float<'u>) (y: float<'u>) = x + y

type vector3D<[<Measure>] 'u> = { x : float<'u>; y : float<'u>; z : float<'u>}

let xvec : vector3D<m> = { x = 0.0<m>; y = 0.0<m>; z = 0.0<m> }
```

Scala:

``` scala
def genericSumUnits[U: MUnit](x: DoubleU[U], y: DoubleU[U]) = x + y

case class Vector3D[U: MUnit](x: DoubleU[U], y: DoubleU[U], z: DoubleU[U])

val xvec = Vector3D[m](x=0.0.of, y=0.0.of, z=0.0.of)
```

