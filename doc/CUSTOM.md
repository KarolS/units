Custom types with units
=======================

**Warning: this is an experimental feature and may be subject to removal or severe redesign.**

Since 0.0.8, you can create add units to any type `N` you want. It will support arithmetic operations if there is an implementation of `Numeric[N]` and comparisons if there's `Ordering[N]`.

```scala
import stasiak.karol.units._
import stasiak.karol.units.SI._

val x: WithU[BigInt, metre] = BigInt(100).of[metre]
val y: WithU[BigInt, metre] = BigInt(50).of[metre]

x * y // == BigInt(5000).of[square[metre]]
```
