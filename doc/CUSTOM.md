Custom types with units
=======================

**TODO**

```scala
import stasiak.karol.units._
import stasiak.karol.units.SI._

val x: WithU[BigInt, metre] = BigInt(100).of[metre]
val y: WithU[BigInt, metre] = BigInt(50).of[metre]

x * y // == BigInt(5000).of[square[metre]]
```

