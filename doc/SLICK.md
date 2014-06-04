Using Slick 2.0.x
=================

Slick 2 has changed the way custom types work. You can no longer keep them in a separate, database-agnostic library like in Slick 1.

Therefore, the recommended way to use Units with Slick 2 is to paste some of the following snippets into the file with model definitions:

    implicit def implicit__intUTypeMapper[U<:MUnit] =
        MappedColumnType.base[IntU[U], Long](_.value, _.of[U])

    implicit def implicit__doubleUTypeMapper[U<:MUnit] =
        MappedColumnType.base[DoubleU[U], Double](_.value, _.of[U])

    implicit def implicit__intATypeMapper[A<:AffineSpace] =
        MappedColumnType.base[IntA[A], Long](_.value, _.at[A])

    implicit def implicit__doubleATypeMapper[A<:AffineSpace] =
        MappedColumnType.base[DoubleA[A], Double](_.value, _.at[A])

All of them require for `import scala.slick.driver._____________.simple._` to be present at the beginning of the file.