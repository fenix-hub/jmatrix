# JMATRIX | Java Matrix Library

JMatrix is a simple Java library which can be used to make basic linear algebra operations with matrices, or just to instantiate quickly Matrix-like data structures with generic or inferred types.

## Matrices
Matrices are handled using the following `<x>Matrix` class architecture
![jmatrix classes](./jmatrix_classes.svg)

Thus the same `Matrix` can be instantiated in different ways:

### Instantiate an matrix
```java
    // Instantiate a 2x2 Short Matrix (default values = 0)
    GenericMatrix<Short> shortMatrix1 = new GenericMatrix<Short>(2,2);
    System.out.println(shortMatrix1);

    ShortMatrix shortMatrix2 = new GenericMatrix<Short>(2,2);
    System.out.println(shortMatrix2);

    ShortMatrix shortMatrix3 = new ShortMatrix(2,2);
    System.out.println(shortMatrix3);
``` 

### Instantiate a matrix from an array
Since types can be strictly inferred, matrices will always contain only admitted values and be type-safe.
```java
    IntegerMatrix integerMatrix = new IntegerMatrix(
        new Integer[][] {
            {1, 2},
            {3, 4}
        }
    );

    FloatMatrix floatMatrix = new FloatMatrix(
        new Float[][] {
            {1.f, 2.f},
            {3.f, 4.f}
        }
    );

    // Will cause an error!
    DoubleMatrix doubleMatrix = new DoubleMatrix(
        new Short[][] {
            //...
        }
    );
    
    // Will cause an error too!
    DoubleMatrix doubleMatrix2 = new GenericMatrix<Short>();

```

### Instantiate using a builder
Additionally, `JMatrix` offers a `Builder` class for `GenericMatrix`
```java
    // Instantiate a random, 3x3, DoubleMatrix using a Builder with values [-20, +20]
    DoubleMatrix doubleMatrix = new GenericMatrixBuilder<>(Double.class)
    .ofRandom(3, 3, -20, 20)
    .build();
```

## Operations
`JMatrix` supports different basic types of operations between matrices.  
Operations are exposed by the `MatrixOperations` class:
- transpose
- sum (addition by default, subtraction can be obtained through `scalar product` with -1)
- scalar product
- dot product
- hadamard
- min/max finding
- average calculation
- determinant calculation (optimizing for diagonals, triangolars, and using Laplace expansion)
- equality checking