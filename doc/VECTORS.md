Using vectors
=============

Since version 0.0.3 Units library supports 2- and 3-dimensional vectors over the field of real numbers.

All components of a vector have to be of the same unit. Here are some examples for 3D vectors:

``` scala
Vector3U(1.of[metre], 2.of[metre], 3.of[metre])

(1, 2, 3).of[metre]  // (Int, Int, Int) and (Double, Double, Double) work here

Vector3U.of[metre](1, 2, 3)
```

You can add and subtract vectors:

``` scala
(1, 2).of[s] + (1, 2).of[s] // == (2, 4).of[s]
```

You can multiply or divide them by a scalar:

``` scala
(1, 2).of[m] * 4          // == (4, 8).of[m]

2.of[m/s] * (5, 5).of[s]  // == (10, 10).of[m]
```

You can calculate their dot products:

``` scala
	(1, 2).of[m] * (1, 2).of[m]    // == 5.of[m]
```

and (in case of 3D vectors) their vector products:

``` scala
(1, 0, 0).of[m] *** (0, 1, 0).of[m]  // == (0, 0, 1).of[m]
```

You can calculate their various properties:

``` scala
(1, 2, 2).of[m].length     // == 3.of[m]
(1, 2, 2).of[m].lengthSq   // == 9.of[square[m]]
(6, 8, 0).of[m].unit       // == (0.6, 0.8, 0).of[_1], unit-less vector of length 1
```

And finally, you can convert them:

``` scala
(1, 0).of[metre].convert[centimetre]   // (100, 0).of[centimetre]
(1, 1).o
```

Vector arrays
-------------

``` scala
import stasiak.karol.units.arrays._

Vector2UArray.of[metre]((1,2), (4,5))

Vector2UArray((1,2).of[metre], (4,5).of[metre])

Vector2UArray.fill (5) ((4,4).of[metre])
```