# Core Java

## Introduction

Java is an Object-Oriented Program (OOP) which means everything needs to be an object.

There are a few technical concepts that we need to know before start:
* **Java Development Kit (JDK):** is a software package you need to develop applications in Java.
* **Java Compiler (JavaC):** convert a Java Code into a Byte code.
* **Java Runtime Environment (JRE):** is where libraries are stored and JVM can use freely.
* **Java Virtual Machine (JVM):** execute a Java Code in any OS, but it needs to be read in byte code.

The hierarchy between them would be JDK -> JRE -> JVM.

In order to create a class we use the following syntax:

    class Hello {
        public static void main (String[] args) {
            System.out.println("Hello World");
        }
    }

Java is a Strongly Typed Language, where we store a variable with a specific type of data (int, String, etc.)
String variable = "text". Once it runs a Java file, it creates a .class file where the code is represented as a byte file.

We can change the type of variables by using casting, which indicate the data type before: b = (byte) a. This conversion can be automatically if the data conversion is from a smaller to a larger data type.

### Main Method
The first file needs to have a main method where it will run all the program.
    
    class Demo {
        (psvm)
        public static void main (String[] args) {
        
        } 
    }
    
### Casting 

Casting, uncasting, and autocasting are concepts used to convert one type of variable to another. These conversions often happen between primitive types or object types to accommodate specific operations.

1. **Casting** <br>
Is the process of explicitly converting a value from one data type to another. <br>
   * **_Upcasting_** <br>
    Converts a smaller data type to a larger one. Happens implicitly (no special syntax required). Example:
   
    ``` 
    int number = 42;
    double result = number; // Automatic conversion from int to double
    System.out.println(result); // Output: 42.0
    ```
   
   * **_Downcasting_** <br>
   Converts a larger data type to a smaller one. Requires explicit casting as it may result in data loss. Example:

    ```
    double value = 42.5;
    int result = (int) value; // Explicit conversion from double to int
    System.out.println(result); // Output: 42
    ```
   
2. **Autocasting**<br>
Is the automatic conversion of a smaller data type to a larger one (widening). The compiler handles it without any need for explicit syntax. <br>

   * Primitive Type Autocasting 
    ```
   int a = 10;
   long b = a; // int to long
   float c = b; // long to float
   ```
   
   * Object Type Upcasting
   ```
   class Animal {}
   class Dog extends Animal {}

   Animal animal = new Dog(); // Upcasting Dog to Animal
   ```

3. **Uncasting**
Is the process of converting a larger type to a smaller or more specific type (narrowing). It requires explicit syntax and must be done cautiously, as it can lead to ClassCastException or data loss in primitives.

    * Primitive Type Uncasting
   ```
   double pi = 3.14;
   int integerPi = (int) pi; // Explicit cast from double to int
   System.out.println(integerPi); // Output: 3
   ```
    * Object Type Downcasting
   ```
   class Animal {
       void makeSound() {
           System.out.println("Animal sound");
       }
   }

   class Dog extends Animal {
       void bark() {
           System.out.println("Dog barks");
       }
   }

   public class Main {
       public static void main(String[] args) {
           Animal animal = new Dog(); // Upcasting
           Dog dog = (Dog) animal;   // Downcasting (Uncasting)
           dog.bark();              // Access Dog-specific method
       }
   }
   ```

## Conditionals

### If - Else
Is a basic control flow structure used to execute a block of code based on a condition. It allows you to decide what action to take depending on whether a condition is true or false.

It use the following syntax:
```
if (condition) {
     // Code to execute if condition is true
 } else {
     // Code to execute if condition is false
 }
```

### Ternary
Is a shortcut for writing a simple if-else statement, which do conditional coding.

His sintax is:
```
condition ? valueIfTrue : valueIfFalse;
```

### Switch
Is a control flow construct that lets you execute different blocks of code based on the value of an expression. It's an alternative to writing multiple if-else statemets and can make the code readable.

His sintaxis is:
```
switch (expression) {
    case value1:
        // Code block for value1
        break;
    case value2:
        // Code block for value2
        break;
    // You can have as many cases as you want
    default:
        // Code block if no cases match
}
```

## Loops
### For Loop
It is a control flow statement that repeats ablock of code a specific number of times.

His syntax is:
```
for (initialization; condition; update) {
    // Code block to execute
}
```

### While Loop
Is a control flow statement that allow us to repeatedly execute a block of code as long as a specified condition is true. It's typically used when the number of iterations is not known in advance and depends on some condition being met.

His syntax is:
```
while (condition) {
    // Code block to execute
}
```

There is also do-while, where at the start, even if the condition is false, will run at least once the code block.

His syntax is: 
```
do {
    // Code to be executed
} while (condition);
```

## Oriented Object Programming (OOP)
Classes are a blueprint or template for creating objects. It defines a set of attributes and methods that the objects created from the class will have. On the other hand, objects are instances of a class which are created with specific values for their attributes.

### Method Override
Allow us to modify a method from a parent class in the child class. We can use the @Override annotation as an indicator that the parent method it's been changing.

### Encapsulation
Control the visibility and accessibility of classes, methods, and variables. They define how and where a member can be accessed from other classes or packages. There are four different levels:

1. **Public** <br>
They have access to class, package, subclass, everywhere.
2. **Protected** <br>
They have access to class, package and subclass.
3. **Default** <br>
They have access to class and package.
4. **Private** <br>
They have access only to the class.

#### Getter and Setter
While the variables are encapsulated in a class, we could access to them by getters and setters.

The syntax for getters are:
```
public int getVariableName() {
    return this.variable;
}
```

Meanwhile, the syntax for setters are:
```
public void setVariableName(int variableName) {
    this.variableName = variableName;
}
```

#### Packages
let us store a number of files in a package, which can be represented as folder.

### Inheritance
Inheritance is one of the core concepts of Object-Oriented Programming (OOP), allowing a class (child) to "inherit" properties and behaviors (fields and methods) from another class (parent). It promotes code reuse and helps in building a hierarchy of classes.

#### Polymorphism
The word itself means "many forms", which it allows objects to be treated as instances of their parent class rather than their actual class. There are two types:
* **Compile-Time**, which is kind of the use of overloading where is based on the number of parameters.
* **Run-Time**, which is kind of the use of overriding where it needs to use inheritance.

##### Method Overloading
Let us create multiple methods with the same name but different numbers or types of parameters.

## Arrays
Is a data structure that stores a collection of items in a single, contiguous block of memory.

They are useful to group related data, efficient access, simplify coding, memory management and enable complex algorithms.

His syntax is:
```
int num[] = {1,2,3,4,5} -> Store the elements indicated in the keys

int num[] = new int[number] -> Can store a number of elements
```

### Jagger Array
Is an array where each element itself is an array, and these "inner" arrays can have different sizes or lengths.

```
int[][] jaggedArray = new int[3][]; // 3 rows, but columns are not yet defined
```

## String
String Buffer is a mutable String that gives a buffer size (16 bytes) and it is thread safe. Meanwhile, string Buldier it is not thread safe but i is almost the same.

## Keywords

### Static Keyword
Static is a modifier that can be applied to variables, methods, blocks, and nested classes. His purpose is to define members that belong to the class rather than to any specific instance, meaning that all instances will have the same static value as a share copy.

We can also create an static block to initialize variables where they are going to be called only once.
```
static {
    System.out.println("\nIn static block");
    name = "Phone";
}
```

### Final Keyword
Final can be used in variables, methods and classes. We are going to explain how it works for each one of them:
* **Variables** <br>
Makes the variable as a constant, so it cannot be change after assign a value. It needs to be assigned during the declaration, inside or the constructor.
* **Methods** <br>
It cannot be overriden by subclasses.
* **Class** <br>
It cannot be subclassed 

### This Keyword
Is a reference variable that refers to the current object. We can also use this() to represent the constructor in the same class.

### Super Keyword
By default, every constructor has a method which is super(), even if it's not there. We can specify the kind of super that is directed to a constructor. If in an inheritance, we want to use the constructor with one parameter instead of none, we use super({value}).

