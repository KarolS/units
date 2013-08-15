Writing polymorphic functions using units of measure
====================================================

The library supports two kinds of polymorphism: implicit polymorphism, realised using ordinary Scala generics, and explicit polymorphism.

Implicit polymorphism
---------------------

**Note:** This method has severe limitations.

Writing a function that works only on specific units is trivial:

``` scala
def hypotenuse(a: DoubleU[metre], b: DoubleU[metre]) = (a.pow2 + b.pow2).sqrt
```

Writing a function that works on any units requires type constraint:

``` scala
def hypotenuse[U <: MUnit](a: DoubleU[U], b: DoubleU[U]) = (a.pow2 + b.pow2).sqrt
```

If you want to convert units inside your polymorphic function, you need an implicit conversion ratio:

``` scala
def hypotenuse[A <: MUnit, B <: MUnit](a: DoubleU[A], b: DoubleU[B])(implicit ratio: DoubleRatio[A,B]) = 
  (a.convert[B].pow2 + b.pow2).sqrt

```

Similarly with affine spaces:

``` scala
def tempDifference[A <: AffineSpace](a: DoubleA[T], b: DoubleA[T]) = a -- b // return type is DoubleU[T#Unit]

def tempDifference[A1 <: AffineSpace, A2 <: AffineSpace](a: DoubleA[A1], b: DoubleA[A2])(
    implicit converter: DoubleAffineSpaceConverter[A1,A2]
    ) = a.convert[A2] -- b // return type is DoubleU[T2#Unit]
```

Other kinds of implicit parameters are required for automatic unit coercion during addition and for pretty-printing.

**Limitations:**

* Most often than not, the type inferencer will fail. For example: `def function1[U <: MUnit, V<:MUnit](a: DoubleU[U], b: DoubleU[V]) = a*b + b*a` will complain that `DoubleU[U#Mul[V]]` and `DoubleU[V#Mul[U]]` are different types.

* Even dividing/multiplying by dimensionless values won't always work; as a workaround, use methods `times` and `dividedBy`

Explicit polymorphism
---------------------

Suppose we defined universal units of distance and time, plus a function to calculate position of a body under constant acceleration:

``` scala
type L = DefineUnit[_L] // generic length unit
type T = DefineUnit[_T] // generic time unit
type M = DefineUnit[_M] // generic mass unit
def position(x0: DoubleU[L], v0: DoubleU[L/T], a: DoubleU[L/square[T]], t:DoubleU[T]) = 
	x0 + v0*t + a*t*t/2
```

(Note: a similar function using the implicit unit polymorphism will not compile.)

We can define now a unit system, where time is expressed in seconds, mass in kilograms, and distance in metres:

``` scala
val MKS = System3[L, metre, M, kilogram, T, second]

val x0 = 5.of[metre]
val v0 = 1.of[metre/second]
val a = 0.5.of[metre/square[second]]
val t = 30.of[second]

val MKS(result) = position(MKS[L](x0), MKS[L/T](v0), MKS[L/square[T]](a), MKS[T](t))
// or equivalently:
// val result = MKS map position(...)
```

For now, you have to explicitly specify what dimensions your values represent. This nuisance may be removed in the future.

For now, the values have to match the units defined in the system. Automatic implicit conversions are not yet supported here. Therefore:

``` scala
val workday = 8.of[hour]
MKS[T](workday.convert[second])   // explicit conversion required
```

A subset of generic units is defined in `stasiak.karol.units.Mechanical`. By using it, the example above could be rewritten as:

``` scala
import stasiak.karol.units.Mechanical._
import stasiak.karol.units.SI._

def position(x0: DoubleU[length], v0: DoubleU[speed], a: DoubleU[acceleration], t:DoubleU[time]) = 
	x0 + v0*t + a*t*t/2

val x0 = 5.of[metre]
val v0 = 1.of[metre/second]
val a = 0.5.of[metre/square[second]]
val t = 30.of[second]

val MKS(result) = position(MKS[length](x0), MKS[speed](v0), MKS[acceleration](a), MKS[time](t))
```