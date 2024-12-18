# Advance Java

## Abstract
It is used to define classes and methods that are meant to be either incomplete or generalized, requiring further refinement or implementation in subclasses. It's important to know that we cannot create a variable of an abstract class

In classes: they cannot be instantiated directly, they may contain both abstract methods (methods without implementation) and concrete methods (methods with implementation), and finally they serve as a blueprint for other classes.

On the other hand, in methods: they do not have a body (i.e., no implementation) and they must be implemented by any non-abstract subclass.

His syntax is:
```
abstract class Animal {
    abstract void makeSound(); // Abstract method
    void sleep() { // Concrete method
        System.out.println("Sleeping...");
    }
}
```

## Inner Class
They are classes defined within another class. They are used primarily to improve encapsulation, organization, and logical grouping of code. Here is more description about each reason:

1. **Logical Grouping** <br>
When a class is tightly coupled with another class and doesn't make sense to be used independently, we can group it as an inner class to keep the code organized.

    ```
    class OuterClass {
        class InnerClass {
            void display() {
                System.out.println("Inner class method");
            }
        }
    }
    ```
        
2. **Encapsulation** <br>
Inner classes can access the private members of their outer class, allowing for better encapsulation and modular code.

    ```
    class OuterClass {
        private String message = "Hello, Inner World!";
    
        class InnerClass {
            void displayMessage() {
                System.out.println(message); // Can access private member of OuterClass
            }
        }
    }
    ```
        

3. **Improved Readability** <br>
If a class is used only by a specific outer class, defining it inside the outer class improves readability and reduces clutter in the package namespace.

4. **Helper Classes** <br>
Inner classes can eb used as helper classes to perform specific tasks for the outer class, avoiding pollution of the outer scope.

    ```
    class Calculator {
        private class Adder {
            int add(int a, int b) {
                return a + b;
            }
        }
    
        public int sum(int a, int b) {
            Adder adder = new Adder();
            return adder.add(a, b);
        }
    }
    ```

## Interfaces
Is a blueprint for a class. It's a way to define a contract that any class implementing the interface must follow. Essentially, an interface specifies what a class should do, but not how it should do it.

It uses the keyword implements to be able to inheritance one or multiple interface.

Example of an interface:
```
// Defining an interface
public interface Animal {
    // Method signature (no body)
    void eat();
    void sleep();
}
```

Implementation of the interface:
```
// Implementing the Animal interface
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }
    
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }
}
```

Interfaces can have methods with bodies using the default keyword. We are also able to create variables, but they are final and static, so we need to initialize the variable in the interface.

There are different types of interfaces.
1. **Normal** <br>
Is the most common type of interface with one or more abstract methods. They are used to define a contract that a class must fulfill. Example:
    ```
    interface Shape {
        void draw();
    }
    
    class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            Shape shape = new Circle();
            shape.draw(); // Output: Drawing a Circle
        }
    }
    ```
2. **Functional/ Single Abstract Method (SAM)** <br>
An interface with exactly one abstract method (can have a default and static method). They are used in lambda expressions and functional programming paradigms. They also has an annotation `@FunctionalInterface` which is optional but recommended to enforce functional interface rules. Example:

    ```
    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }
    
    public class Main {
        public static void main(String[] args) {
            Calculator add = (a, b) -> a + b; // Lambda expression
            System.out.println(add.calculate(5, 3)); // Output: 8
        }
    }
    ```

3. **Marker**
An interface with no methods or fields, used to signal or "mark" a class for special behavior. They are used as a "tag" to provide metadata about a class to the JVM or framework. Example:
    ```
    interface MyMarker {}
    
    class MyClass implements MyMarker {
        // This class is marked with MyMarker
    } 
    ```
   
## Lambda Expressions
They are short blocks of code that takes in parameters and returns a value. It provides clear and concise way to represent anonymous functions and is mainly used to implement functional programming concepts.

His syntax is:
```
(parameters) -> expression
    or
(parameters) -> { statements }

- Parameters: inputs to the lambda.
- Arrow (->): separates parameters from the body
- Body: the logic to execute, either a single expression or a block.
```

Here are some example before and after the implementation of lambda.

* Before:
    ```
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("Running without lambda");
        }
    };
    ```
  
* After:
    ```
    Runnable runnable = () -> System.out.println("Running with lambda");
    ```

## Enums
They are a special data type that allow us to define a fixed set of constants. They are commonly used when we know all possible values a variable can take, and  these values are conceptually related.

## Exceptions
There are different types of errors:
* **Logical error (bugs)** <br>
Happen when our program compiles and runs, but it doesn't behave as intended.

* **Runtime errors** <br>
Happen while the program is running. They occur when our code instructs the program to do something invalid, like dividing by zero or accessing an array out of bounds. We use try-catch to handle exceptions allowing our code to deal with these situations gracefully, rather than crashing the program. <br>
His syntax would be:
    ```
    try {
        // Code that might throw an exception
    } catch (ExceptionType e) {
        // Code to handle the exception
    } catch (SecondExceptionType e) {
        // Code to handle another kind of exception
    } finally {
        // Code that runs regardless of whether anexception was thrown or not.
    }
    ```
* **Compile-time error** <br>
They occur during the compilation process, before the code even runs. These errors prevent the program from being compiled into an executable. Some of this category errors are:
  * Stntax errors
  * Type checking errors
  * Missing class/method/variable definitions
  * Access modifier violations
  * Missing return statements
  * Uninitialized variable

### Throw ad Throws Keyword
`Throw` is used to create an exception object and hand it off to the runtime to be handled. Once an exception is thrown, the normal flow of execution stops, and the program looks for an appropriate catch block to handle it. 

Example: 

```
public class Main {
    public static void main(String[] args) {
        try {
            validateAge(15); // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older.");
        }
        System.out.println("Age is valid!");
    }
}    
```

`Throws` is used in a method signature to indicate that the method might throw an exception. It is used when we want to let the exception propagate to the caller instead of handling it inside the method. 

Example: 

```
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    public static void readFile() throws IOException {
        throw new IOException("File not found");
    }
}
```

## BufferReader and Scanner
BufferedReader and Scanner are classes used for input operations. Both are part of the Java I/O package and are used to read input, but they have differences in usage, efficiency, and features.

* `BufferReader` is used to read text from an input stream efficiently. It reads data line by line, which makes it suitable for processing large inputs. It is better to use this type when we need high-speed reading, especially for large files or streams.

  * Key features:
    * Reads data faster due to internal buffering.
    * Can only read strings or characters, not directly parse other data types.
    * Needs to be wrapped around a Reader object like InputStreamReader.
    
* `Scanner` is a utility class for parsing primitive types and strings using regular expressions. It's more flexible and user-friendly for reading input compared to BufferedReader, but is better to use this type when we are working with user input in smaller programs.

  * Key features:
    * Can parse various data types directly.
    *  Easier to use but slightly slower compared to BufferedReader.
    *  Can read input from various sources like files, strings, or System.in

## Threads
They are the smallest unit of execution in a program. Every application has at least one thread, called the main thread, which starts the program. Additional threads can be created an executed to perform tasks simultaneously.

Multithreading is the process of running multiple threads at the same time to achieve concurrent execution. This allows programs to perform multiple tasks simultaneously.

Threads share the same memory space, making communication between threads easier but requiring synchronization to avoid conflicts.

We start a new thread by extending the class by Thread. Then, in the main method we use start for that class which will run the run method inside it.

### Thread Priority
Thread priority determines the relative importance of a thread compared to other threads to decide the order in which threads are schedule for execution. Priorities are integers ranging from 1 (low) to 10 (high) with default priority as 5.

To set the priority we use `setPriority()` method. We can also obtain the priority number of a thread using `getPriority()` method.

### Thread Sleep
Sleep method pause the execution of the current thread for a specified amount of time. Is often used to simulate delays or give other threads a chance to execute. We can also use `wait()` to put it on sleep by undefined time.

`Thread.sleep()` is a static method, that always affect the current executing thread for an amount of time in milliseconds.

## Runnable
Same as thread, is used to create and execute threads in Java, but they are used in different ways and have distinct characteristics.

Runnable is actually a functional interface with a single method: `run()`. It represents a task that can be executed by a thread.

To be able to run the Thread we will need to first create a Runnable object and then a Thread object with his Runnable instance in his constructor:

```
Runnable runnableC = new ThreadC();
Thread threadC = new Thread(runnableC);
```

Using Running instead of Threads allow us to use other abstract classes while giving us the use of threads

### Race Condition
In programming occurs when two or more threads or processes access shared resources simultaneously without proper synchronization, and the program outcome depends on the timing of their execution leading to an unexpected or incorrect behavior.

We use `synchronized` keyword to prevents race conditions by ensuring that only one thread can access a block of code or method a time when working with shared resources. We can also use the `join()` method in the main method to wait other threads to end and continue the main thread.

### Thread States
There are 6 different status in a thread:
1. **New** <br>
The thread is created but not yet started. Example:
    ```
    Thread thread = new Thread(() -> System.out.println("Running"));
    // Thread is in NEW state
    ```
   
2. **Runnable** <br>
The thread is ready to run and is waiting for CPU time to execute. It's in the thread scheduler's queue. After calling `start()`, the thread moves to this state but may not be immediately executing. Example:
    ```
    Thread thread = new Thread(() -> {
        while (true) { 
            // Do something
        }
    });
    
    thread.start(); // Thread is now RUNNABLE
    ```

3. **Blocked** <br>
The thread is waiting to acquire a lock on a synchronized block or method. When one thread tries to enter a synchronized block/method but another thread is already holding the lock. Example:
    ```
    class SharedResource {
        synchronized void criticalSection() {
            while (true) { 
            // Simulating long-running work 
            }
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            SharedResource resource = new SharedResource();
    
            Thread t1 = new Thread(resource::criticalSection);
            Thread t2 = new Thread(resource::criticalSection);
    
            t1.start();
            t2.start(); // t2 will enter BLOCKED state as t1 holds the lock
        }
    }
    ```
   
4. **Waiting** <br>
The thread is waiting indefinitely for another thread to perform a specific action. Thread calls methods like `Object.wait()` without a timeout.
The thread will stay in this state until another thread calls `notify()` or `notifyAll()` on the same object. Example:
    ```
    synchronized void waitForSignal() throws InterruptedException {
        wait(); // Thread enters WAITING state
    }
    ```
   
5. **Timed-Waiting** <br>
The thread is waiting for another thread to perform an action but only for a specified amount of time. A thread calls methods like: `Thread.sleep(milliseconds)`, `Object.wait(milliseconds)`, `Thread.join(milliseconds)`, and `Lock.tryLock(timeout, unit)`. <br>
Example:
```
Thread thread = new Thread(() -> {
    try {
        Thread.sleep(1000); // Thread is in TIMED_WAITING state
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
});

thread.start();
```

6. **Terminated** <br>
The thread has finished execution. After the thread's run() method completes or the thread is explicitly stopped. Example:
    ```
    Thread thread = new Thread(() -> System.out.println("Done"));
    thread.start();
    
    try {
        thread.join(); // Ensures thread has finished
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Thread is TERMINATED");
    ```

Status diagram: 
```
NEW -----------------> RUNNABLE -----------------> TERMINATED
                            |     ^       |     
                            |     |       |     
                            v     |       v     
                        BLOCKED <---> RUNNING ----> WAITING/TIMED_WAITING
```

### Synchronized Keyword
It prevents race conditns by ensuring that only one thread can access a block of code or method a a time when working with shared resources.

## Collection API
Is a unified architecture for managing and manipulating groups of objects. It provides interfaces and classes for storing, retrieving, and processing collections of data efficiently.

The framework is part of the java.util package and includes data structures like lists, sets, queues, and maps.

Some core components of the collection framework are:

1. **Interfaces** <br>
Defines several key interfaces that represent different types of collections:
   * _Collection._ The root interface for most collection classes (except Map).
   * _List._ Ordered collection (allows duplicate elements). Example: ArrayList.
   * _Set._ Unordered collection (no duplicate elements). Example: HashSet.
   * _Queue._ Ordered collection with operations for adding/removing elements in FIFO order.
   * _Deque._ Double-ended queue, supports insertion/removal from both ends.
   * _Map._ Represents key-value pairs (no duplicate keys). Example: HashMap.
   * _SortedSet._ A Set with elements sorted in natural order or by a comparator.
   * _SortedMap._ A Map where keys are sorted.

2. **Classes** <br>
The framework provides concrete implementations of these interfaces, each with unique characteristics:
   * _ArrayList (List Interface)._ Resizable array; fast random access; slow for insert/remove.
   * _LinkedList (List or Deque Interface)._ Doubly linked list; good for frequent insert/remove.
   * _HashSet (Set Interface)._ No duplicates; backed by a HashMap; unordered.
   * _LinkedHashSet (Set Interface)._ No duplicates; maintains insertion order.
   * _TreeSet (SortedSet Interface)._ No duplicates; elements are sorted.
   * _PriorityQueue (Queue Interface)._ Ordered by natural order or a comparator.
   * _HashMap (Map Interface)._ Key-value pairs; no duplicate keys; unordered.
   * _LinkedHashMap (Map Interface)._ Key-value pairs; maintains insertion order.
   * _TreeMap (SortedMap Interface)._ Key-value pairs; keys sorted in natural/comparator order.
   * _Stack (Deque Interface)._ LIFO stack implementation.
   * _Vector (List Interface)._ Synchronized; similar to ArrayList but thread-safe.

3. **Utility Class Collections**
The java.util.Collections class contains utility methods for performing operations on collections, such as:
   * _sort(List<T>)._ Sorts a list in natural order.
   * _reverse(List<T>)._ Reverses the order of elements.
   * _shuffle(List<T>)._ Randomly shuffles elements.
   * _binarySearch(List<T>, key)._ Performs binary search on a sorted list.
   * _max(Collection<T>)._ Returns the maximum element.
   * _min(Collection<T>)._ Returns the minimum element.

Collection Hierarchy Diagram:
```
        Collection
            |
----------------------------------
|           |                   |
List        Set                 Queue
|           |                   |
ArrayList   HashSet           PriorityQueue
LinkedList  LinkedHashSet      Deque
Vector      TreeSet
```

## Comparator
An interface used to define custom ordering for objects in a collection. It allows you to compare two objects and determine their order, independent of their natural ordering.

## Stream API
Introduced in Java 8, it enables functional-style operations on collections and other data sources such as arrays and I/O channels. They make earier to process data with operations such as as filtering, mapping, reducing, and collecting on a sequence of elements with less code.

They make it easier to work with large collections of data and can execute operations in parallel, leveraging multi-core processors for better performance. 

Some common operations are:

1. Intermediate Operations:
   * `filter(Predicate)`. Filters elements based on a condition. Syntax:
       ```
       stream.filter(x -> x > 10)
       ```
   
   * `map(Function)`. Transforms elements to another type or form. Syntax:
       ```
        stream.map(String::lenght)
       ```
   
   * `sorted()`. Sorts elements in natural or custom order. Syntax:
       ```
       stream.sorted(Comparator.reverseOrder())
       ```
   
   * `distinct()`. Removes duplicate elements. Syntax:
       ```
       stram.distinct()
       ```
   
   * `limit(n)`. Limits the number of elements in the stream. Syntax:
       ```
       stream.limit(5)
       ```
   
   * `skip(n)`. Skip the first n elements. Syntax:
       ```
       stream.limit(5)
       ```
     
2. Terminal Operations:
   * `forEach(Consumer)`. Performs an action for each element. Syntax:
      ```
      stream.forEach(System.out::println)
      ```
   
   * `collect(Collector)`. Collects elements into a collection or string. Syntax:
      ```
      stream.collect(Collectors.toList())
      ```
   
   * `toArray()`. Converts elements to an array. Syntax:
      ```
      stream.toArray()
      ```
   
   * `reduce()`. Reduces elements to a single value. Syntax:
      ```
      stream.reduce(0, Integer::sum)
      ```
   
   * `count()`. Counts the number of elements in the stream. Syntax:
      ```
      stream.count()
      ```
   
   * `anyMatch(Predicate)`. Checks if any element matches the condition. Syntax:
      ```
      stream.anyMatch(x -> x > 10)
      ```
     
Once streams are used, we can reuse. But the benefit of it is the amount of methods there are

There are two ways to write a Stream:
* Complete one:
    ```
    import java.util.*;
    import java.util.stream.*;
    
    public class StreamExample {
        public static void main(String[] args) {
            // Step 1: Data Source (Create a List)
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
    
            // Step 2: Create a Stream from the List
            Stream<String> nameStream = names.stream();
    
            // Step 3: Apply Intermediate Operations
            Stream<String> filteredStream = nameStream
                .filter(name -> name.length() > 3); // Keep names longer than 3 characters
    
            Stream<String> mappedStream = filteredStream
                .map(String::toUpperCase); // Convert names to uppercase
    
            Stream<String> sortedStream = mappedStream
                .sorted(); // Sort names alphabetically
    
            // Step 4: Terminal Operation (Collect the Results into a List)
            List<String> result = sortedStream.collect(Collectors.toList());
    
            // Step 5: Output the Result
            System.out.println(result); // Output: [ALICE, CHARLIE, DAVID]
        }
    }
    ```
  
* Reduce one: 
    ```
    import java.util.*;
    import java.util.stream.*;
    
    public class StreamExample {
        public static void main(String[] args) {
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
    
            List<String> result = names.stream()            // Create a Stream
                .filter(name -> name.length() > 3)          // Keep names longer than 3 characters
                .map(String::toUpperCase)                  // Convert to uppercase
                .sorted()                                  // Sort alphabetically
                .collect(Collectors.toList());             // Collect into a List
    
            System.out.println(result); // Output: [ALICE, CHARLIE, DAVID]
        }
    }
    ```
  
### Parallel Stream
Implemented in Java 9, they allow us to perform stream operation in parallel, leveraging multiple CPU cores. It splits the data into chunks and processes these simultaneously in separate threads, which can significantly improve performance for large datasets.

## Optional Class
Introduced in Java 8, is a container object that handle values that can be either present or absent. It helps eliminate the risk of encountering a NullPointerException and encourages writing cleaner and more readable code.

## Method Reference
Implemented in Java 8, is a shorthand syntax for invoking methods by referring to them directly, instead of calling them explicitly. They improve code readability by reducing boilerplate code and allowing developers to reuse existing methods.

There are four types of method reference:
1. Reference to a Static Method
`ClassName::methodName`
2. Reference to an Instance Method of a Particular Object
`instance::methodName`
3. Reference to an Instance Method of an Arbitrary Object of a Particular Type
`ClassName::methodName`
4. Reference to a Constructor
`ClassName::new`