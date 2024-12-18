/* ANNOTATION
        They are metadata added to the code to provide information to the compiler or runtime environment. They don't change the behavior of the code directly but can influence how the program is processed.

        Some common use annotations are:
        - @Override. 
            Ensures that the method overrides a superclass method.
        - @Deprecated. 
            Marks a method or class as deprecated, meaning it should not be used anymore.
        - @SuppressWarnings. 
            Tells the compiler to suppress specific warnings.
        - @FunctionalInterface.
            Indicates that an interface is intended to be a functional interface (an interface with exactly one abstract method)
 */

package Seccion3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        new AbstractMain(); // Run Abstract Section
        new InnerClassMain(); // Run Inner Classes Section
        new InterfaceMain(); // Run Interfaces Section
        new EnumMain(); // Run Enum Section
        new ExceptionMain(); // Run Exception Section
        new BufferedReaderAndScannerClasses(); // Run Scanner and BufferReader Section
        new ThreadMainClass(); // Run Threads Seccion
        new CollectionMainClass(); // Run Collection Section
        new StreamMainClass(); // Run Stream Section
        new OptionalMainClass(); // Run Optional Class Section
        new ConstructorAndMethodReferenceMainClass(); // Run Constructor and Method Reference Section
        
    }
}

/* ABSTRACT

    It is used to define classes and methods that are meant to be either incomplete or generalized, requiring further refinement or implementation in subclasses. It's important to know that we cannot create a variable of an abstract class

    In classes: they cannot be instantiated directly, they may contain both abstract methods (methods without implementation) and concrete methods (methods with implementation), and finally they serves as a blueprint for other classes.

    On the other hand, in methods: they does not have a body (i.e., no implementation) and they must be implemented by any non-abstract subclass.

    His syntax is:

        abstract class Animal {
            abstract void makeSound(); // Abstract method
            void sleep() { // Concrete method
                System.out.println("Sleeping...");
            }
        }
*/

    class AbstractIndependentClasses {
        abstract class Car {
            public abstract void drive();
            public abstract void fly();
        
            public void playMusic() {
                System.out.println("Play music");
            }
        }
        class WagonR extends Car {
        
            @Override
            public void drive() {
                System.out.println("Driving...");
            }
        
            @Override
            public void fly(){
                System.out.println("Flying...");
            }
        }
    }
        
    class AbstractMain extends AbstractIndependentClasses {
        public AbstractMain() {
            System.out.println("\n--- ABSTRACT ---");
            Car obj = new WagonR(); // Abstract class
            obj.drive(); // Abstract method
            obj.fly();
            obj.playMusic();
        }
    }

/* INNER CLASSES

    They are classes defined within another class. They are used primarily to improve encapsulation, organization, and lofical grouping of code. Here is more description about each reason:

    1. Logical Grouping
        When a class is tightly coupled with another class and doesn't make sanse to be used independently, we can group it as an inner class to keep the code organized.
        
            class OuterClass {
                class InnerClass {
                    void display() {
                        System.out.println("Inner class method");
                    }
                }
            }
    2. Encapsulation
        Inner classes can access the private members of their outer class, allowing for better encapsulation and modular code.

            class OuterClass {
                private String message = "Hello, Inner World!";

                class InnerClass {
                    void displayMessage() {
                        System.out.println(message); // Can access private member of OuterClass
                    }
                }
            }

    3. Improved Readability
        If a class is used only by a specific outer class, defining it inside the outer class improves readability and reduces clutter in the package namespace.

    4. Helper Classes
        Inner classes can eb used as helper classes to perform specific tasjs for the outer class, avoiding pollution of the outer scope.

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
*/

    class InnerIndependentClasses {
        class A {
            int age;
        
            public void show() {
                System.out.println("in show");
            }
        
            class B {
                public void confing() {
                    System.out.println("in config");
                }
            }
        
            static class C {
                public void logs() {
                    System.out.println("in logs");
                }
            }
        }
        
        // Abstract and anoymus inner class
        abstract class AA {
            public abstract void show();
        }
    }
    
    class InnerClassMain extends InnerIndependentClasses {
        public InnerClassMain() {
            System.out.println("\n--- INNER CLASSES ---");
            A objA = new A();
            objA.show();

            // We need object A to access object B
            A.B objB = objA.new B();
            objB.confing();

            // If it's static class, we dont need to declare an A object
            A.C objC = new A.C();
            objC.logs();

            // Anonymus inner class. Inside the brakets is the implementation
            A objA2 = new A() {
                public void show() {
                    System.out.println("in new Show");
                }
            };
            objA2.show();

            AA objAA = new AA() {
                @Override
                public void show() {
                    System.out.println("in abstract anonymus class show");
                }
            };
            objAA.show();
        }
    }

/* INTERFACES
    Is a blueprint for a class. It's a way to define a contract that any class implementing the interface must follow. Essentially, an interface specifies what a class should do, but not how it should do it.

    It use the keyword implements to be able to inheritance one or multiple interface.

    Example of an interface:
        // Defining an interface
        public interface Animal {
            // Method signature (no body)
            void eat();
            void sleep();
        }

    Example of implementing the interface:
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

    Interfaces can have methods with bodies using the default keyword. 

    We are able to create variables but they are final and static, so we need to initialize the variable in the interface.

    There are different types of interfaces.
    1. Normal
        Is the most common type of interface with one or more abstract methods. They are used to define a contract that a class must fulfill.

        Example:
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

    2. Functional/ Single Abstract Method (SAM).
        An interface with exactly one abstract method (can have a default and static method). They are used in lambda expressions and functional programming paradigms.

        It also has an annotacion @FunctionalInterface which is optional but recommended to enforce functional interface rules.

        Example:
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

    3. Marker.
        An interface with no methods or fields, used to signal or "mark" a class for special behavior. They are used as a "tag" to provide metadata about a class to the JVM or framework.

        Example:
            interface MyMarker {}

            class MyClass implements MyMarker {
                // This class is marked with MyMarker
            } 

 * LAMBDA EXPRESSIONS
    They are short blocks of code that takes in parameters and returns a value. It providesa clear and concise way to represent anonymous functions and is mainly used to implement functional programming concepts.

    Syntax:
        (parameters) -> expression
        // or
        (parameters) -> { statements }

    - Parameters: inputs to the lambda.
    - Arrow (->): separates parameters from the body
    - Body: the logic to execute, either a single expression or a block.

    Here are some example before and after the implementation of lambda:

    - Before:
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running without lambda");
            }
        };

    - After:
        Runnable runnable = () -> System.out.println("Running with lambda");
*/

    class InterfacesIndependentClasses {
        interface InterfaceA  {
            int age = 20; // We can create variables but they are final and static, so we need to initialize the variable.
        
            public void show();
            public void config();
        }
        
        class InterfaceB implements InterfaceA {
        
            @Override
            public void show() {
                System.out.println("in interfaceB show");
            }
        
            @Override
            public void config() {
                System.out.println("in interfaceB connfig");
            }
        }
        
        @FunctionalInterface
        interface FunctionalInterfaceShow {
            void show();
        }
        
        // Functional interface with return
        @FunctionalInterface
        interface FunctionalInterfaceReturnInt {
            int add(int num1, int num2);
        }
        
        class FunctionalInterfaceClass implements FunctionalInterfaceShow {
            @Override
            public void show() {
                System.out.println("in Show");
            }
        }
    }
    
    class InterfaceMain extends InterfacesIndependentClasses {
        public InterfaceMain() {
            System.out.println("\n--- INTERFACES ---");
            InterfaceA interfaceB = new InterfaceB();
            interfaceB.show();
            interfaceB.config();

            // Functional Interface without lambda
            FunctionalInterfaceShow functionalInterfaceA = new FunctionalInterfaceClass();
            functionalInterfaceA.show();

            // Funtional Interface with Lambda expression
            FunctionalInterfaceShow functionalInterfaceB = () -> System.out.println("in show lambda functional interface");
            functionalInterfaceB.show();

            // Functional Interface with Lambda return expresion
            FunctionalInterfaceReturnInt functionalInterfaceInt = (i, j) -> i + j;
            System.out.println("Functional Interface with return: "+ functionalInterfaceInt);
        }
    }

/* ENUMS
    They are a special data type that allow us to define a fixed set of constants. They are commonly used when we know all possible values a variable can take, and  these values are conceptually related.
*/

    class EnumIntependentClasses {
        enum Status {
            RUNNING, // index 0
            FAILED, // index 1
            PENDING, // index 2
            SUCCESS; // index 3
        }
        
            // enum class
        enum Laptop {
        
            // Enums should be at the top of the class
            Macbook(2000), 
            XPS(2200), 
            Surface(1500), 
            ThinkPad(1800),
            Huawei; // Run void constructor
        
            // Value indicating the price of the enum
            private int price;
        
            // Constructor to assign which price use the enum
            private Laptop() {
                this.price = 500;
            }
        
            private Laptop(int price) {
                this.price = price;
            }
            
            public int getPrice() {
                return price;
            }
        
            public void setPrice(int price) {
                this.price = price;
            }
        }
    }

    class EnumMain extends EnumIntependentClasses {
        public EnumMain() {
            System.out.println("\n--- ENUMS ---");
            Status enumA = Status.SUCCESS;
            System.out.println("Enum value: " + enumA);
            System.out.println("Index number of " + enumA + " is " + enumA.ordinal()); // print the index of the constant

            System.out.println("\nEnum if-else:");
            if (enumA == Status.RUNNING) {
                System.out.println("\tAll good");
            } else {
                System.out.println("\tIt's not running");
            }
            
            System.out.println("\nEnum switch:");
            Status[] enumArray = Status.values(); // Get all values of the enum in an array
            for (Status status : enumArray) {
                switch (status) {
                    case RUNNING:
                        System.out.println("\tSystem is " + status.toString().toLowerCase() + " : " + status.ordinal());
                        break;

                    case FAILED:
                        System.out.println("\tSystem has " + status.toString().toLowerCase() + " : " + status.ordinal());
                        break;
                
                    case PENDING:
                        System.out.println("\tSystem is " + status.toString().toLowerCase() + " : " + status.ordinal());
                        break;

                    default:
                        System.out.println("\tSystem has " + status.toString().toLowerCase() + " : " + status.ordinal());
                        break;
                }
            }

            // Enum class with parameters
            System.out.println("\nEnum class:");
            for (Laptop lap : Laptop.values()) {
                System.out.println("\t" + lap + " : " + lap.getPrice());
            }
        }
    }

/* EXCEPTIONS
    There are different types of errors:
        - Logical error (bugs)
            Happen when our program compiles and runs, but it doesn't behave as intended.

        - Runtime errors
            Happen while the program is running. They occur when our code instructs the program to do something invalid, like dividing by zero or accessing an array out of bounds.

            We use try-catch to handle exceptions allowing our code to deal with these situations gracefully, rather than crashing the program.

            His sintax would be:
                try {
                    // Code that might throw an exception
                } catch (ExceptionType e) {
                    // Code to handle the exception
                } catch (SecondExceptionType e) {
                    // Code to handle another kind of exception
                } finally {
                    // Code that runs regardless of whether anexception was thrown or not.
                }


        - Compiletime error
            They occur during the compilation process, before the code even runs. These errors prevent the program from being compiled into an executable.

            Some of this category errors are:
            - Stntax errors
            - Type checking errors
            - Missing class/method/variable definitions
            - Access modifier violations
            - Missing return statements
            - Uninitialized variable

    Throw and throws keyword are used to handle exception:
        - Throw
            Is used to create an exception object and hand it off to the runtime to be handled. Once an exception is thrown, the normal flow of excecution stops, and the programlooks for an appropiate catch block to handle it.

            Example:
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
        - Throws
            It is used in a method signature to indicate that the method might throw an exception. It is used when we want to let the exception propagate to the caller instead of handling it inside the method.

            Example:
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
*/

    class ExceptionIndepententClasses {
        class CustomException extends Exception {
            public CustomException(String message) {
                super(message);
            }
        }

        class TestThrowsException {
            public void show() throws ClassNotFoundException {
                Class.forName("Calc");
            }
        }
    }

    class ExceptionMain extends ExceptionIndepententClasses {
        public ExceptionMain() {
            System.out.println("\n--- EXCEPTION ---");

            int i = 0;

            // Throw
            try {
                if(i == 0) {
                    throw new CustomException("try with another value");
                } else {
                    int j = 20 / i;
                    System.out.println("Result is: " + j);
                }
            } catch (CustomException e) {
                System.out.println("There is an error: "+ e);
            } catch(ArithmeticException e) {
                System.out.println("Error! Can't divide by 0.");
            }
            

            // Throws
            System.out.println("\nUsing throws:");
            TestThrowsException testThrowsException = new TestThrowsException();

            try {
                testThrowsException.show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

/* BUFFEREDREADER AND SCANNER
    BufferedReader and Scanner are classes used for input operations. Both are part of the Java I/O package and are used to read input, but they have differences in usage, efficiency, and features.

        - BufferedReader
            Is used to read text from an input stream efficiently. It reads data line by line, which makes it suitable for processing large inputs.

            Some key features are:
                * Reads data faster due to internal buffering.
                * Can only read strings or characters, not directly parse other data types.
                * Needs to be wrapped around a Reader object like InputStreamReader.

            It is better to use this type when we need high-speed reading, especially for large files or streams.

        - Scanner
            Is a utility class for parsing primitive types and strings using regular expressions. It's more flexible and user-friendly for reading input compared to BufferedReader.

            Some key features are:
                * Can parse various data types directly.
                Easier to use but slightly slower compared to BufferedReader.
                Can read input from various sources like files, strings, or System.in

            Is better to use this type when we are working with user input in smaller programs.
*/

    class BufferedReaderAndScannerClasses {
        public BufferedReaderAndScannerClasses() {
            
            // Scanner
            System.out.println("\n--- SCANNER ---");
            Scanner1();

            // BufferedReader
            System.out.println("\n--- BUFFERED READER ---");

            System.out.println("\nBuffered Reader without try-resource:");
            BufferedReader1();
            
            System.out.println("\nBuffered Reader with try-resource:");
            BufferedReader2();

        }

        public void BufferedReader1() {
            BufferedReader bufferedReader = null;

            try {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // InputStreamReader let us input the data whereas BufferedReader reads the data we input

                System.out.println("Enter a number");
                int num1 = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Your number is: " + num1);
                
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }

        public void BufferedReader2() {
            // There's a concept called try with resources implemented since Java 7. It closed automatically the BufferedReader.
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                int num2 = Integer.parseInt(reader.readLine());
                System.out.println(num2);

            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void Scanner1() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input a value: ");
            int num = sc.nextInt();
            System.out.println(num);
        }
    }   

/* THREADS
    They are the smallest unit of execution in a program. Every application has at least one thread, called the main thread, which starts the program. Additional threads can be created an executed to perform tasks simultaneously.

    Multithreading is the process of running multiple threads at the same time to achieve concurrent execution. This allows programs to perform multiple tasks simultaneously.

    Threads share the same memory space, making communication between threads easier but requiring synchronization to avoid conflicts.

    We start a new thread by extending the class by Thread. Then, in the main method we use start for that class which will run the run method inside it.

 * THREAD PRIORITY

    Thread priority determines the relative importance of a thread compared to other threads to decide the order in which threads are schedule for execution. Priorities are integers ranging from 1 (low) to 10 (high) with defautl priority as 5.

    To set the prority we use setPriority() method. We can also obtain the priority number of a thread using getPriority() method.

 * THREAD SLEEP
    Sleep method pause the execution of the current thread for a specified amount of time. Is often used to simulate delays or give other threads a chance to execute. We can also use wait() to put it on sleep by undefinied time.

    Thread.sleep() is a static method, that always affect the current executing thread for an amount of time in miliseconds.

 * RUNNABLE 
    Same as thread, is used to create and execute threads in Java, but they are used in different ways and have distinct characteristics.

    Runnable is actually a functional interface with a single method: run(). It represents a task that can be executed by a thread.

    To be able to run the Thread we will need to first create a Runnable object and then a Thread object with his Runnable instance in his constructor:

        Runnable runnableC = new ThreadC();
        Thread threadC = new Thread(runnableC);

    Using Running instead of Threads allow us to use other abstract classes while giving us the use of threads

 * RACE CONDITION
    In programming occurs when two or more threads or processes access shared resources simultaneously without proper synchronization, and the program outcome depends on the timing of their execution leading to an unexpected or incorrect behavior.

    We use SYNCHRONIZED keyword to prevents race conditns by ensuring that only one thread can access a block of code or method a a time when working with shared resources. We can also use the join() method in the main method to wait other threads to end and continue the main thread.

 * THREAD STATES
    There are 6 different status in a thread:
        1. New
            The thread is created but not yet started. 

            Example: 
                Thread thread = new Thread(() -> System.out.println("Running"));
                // Thread is in NEW state

        2. Runnable
            The thread is ready to run and is waiting for CPU time to execute. It's in the thread scheduler's queue. After calling start(), the thread moves to this state but may not be immediately executing.

            Example: 
                Thread thread = new Thread(() -> {
                    while (true) { 
                        // Do something
                    }
                });

                thread.start(); // Thread is now RUNNABLE
                
        3. Blocked
            The thread is waiting to acquire a lock on a synchronized block or method. When one thread tries to enter a synchronized block/method but another thread is already holding the lock.

            Example:
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
                        
        4. Waiting
            The thread is waiting indefinitely for another thread to perform a specific action. Thread calls methods like Object.wait() without a timeout.

            The thread will stay in this state until another thread calls notify() or notifyAll() on the same object.

            Example:
                synchronized void waitForSignal() throws InterruptedException {
                    wait(); // Thread enters WAITING state
                }
        
        5. Timed-Waiting
            The thread is waiting for another thread to perform an action but only for a specified amount of time. A thread calls methods like:

                * Thread.sleep(milliseconds)
                * Object.wait(milliseconds)
                * Thread.join(milliseconds)
                * Lock.tryLock(timeout, unit)

            Example: 
                Thread thread = new Thread(() -> {
                    try {
                        Thread.sleep(1000); // Thread is in TIMED_WAITING state
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

                thread.start();
                
        6. Terminated
            The thread has finished execution. After the thread's run() method completes or the thread is explicitly stopped.

            Example: 
                Thread thread = new Thread(() -> System.out.println("Done"));
                thread.start();

                try {
                    thread.join(); // Ensures thread has finished
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread is TERMINATED");

    Status diagram:

        NEW -----------------> RUNNABLE -----------------> TERMINATED
                            |     ^       |     
                            |     |       |     
                            v     |       v     
                        BLOCKED <---> RUNNING ----> WAITING/TIMED_WAITING
*/

    class ThreadIndependentClasses {
        class ThreadA extends Thread{
            public void run() { // When we indicate "start", it will run this method while it continues
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i + ". Hi");

                    if (i == 3) {
                        try {
                            setPriority(Thread.MIN_PRIORITY); // Set a low priority over other thrads

                            System.out.println("Start sleep in 'Hi' with priority " + getPriority());

                            Thread.sleep(10); // Pause the execution for a specific amoun of time in ms.
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        class ThreadB extends Thread {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i + ". Hello");
                }
            }
        }

        class ThreadC implements Runnable {

            @Override
            public void run() {
                System.out.println("This is inside ThreadC run method");
            }
        }

        class Counter {
            int count;

            /* SYNCHRONIZED KEYWORD
                It prevents race conditns by ensuring that only one thread can access a block of code or method a a time when working with shared resources.
            */
            public synchronized void increment() {
                count++;
            }
        }
    }

    class ThreadMainClass extends ThreadIndependentClasses {
        public ThreadMainClass() {
            System.out.println("\n--- Thread ---");
            ThreadA threadA = new ThreadA();
            ThreadB threadB = new ThreadB();

            // Seting priority level 1 (low) - 10 (high)
            threadA.setPriority(Thread.MIN_PRIORITY); 
            threadB.setPriority(Thread.NORM_PRIORITY);
            
            
            threadA.start(); // Initialize a new thread and start the "run" method.
            threadB.start();

            try {
                threadA.join();
                threadB.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
            // Using Runnable
            System.out.println("\n--- Runnable ---");
            Runnable runnableC = new ThreadC();
            Thread threadC = new Thread(runnableC);

            threadC.setPriority(Thread.MAX_PRIORITY);
            threadC.start();

            // Using lambda expression
            Runnable runnableD = () -> {
                System.out.println("This is inside lambda expresion");
            };
            Thread threadD = new Thread(runnableD);
            threadD.start();

            try {
                threadD.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Race condition
            System.out.println("\n--- Race Condition ---");

            Counter counter = new Counter();

            Runnable countA = () -> {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            };

            Runnable countB = () -> {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            };

            Thread c1 = new Thread(countA);
            Thread c2 = new Thread(countB);

            c1.start();
            c2.start();

            try {
                c1.join(); // Waits for this thread to die to continue the main thread
                c2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 

            System.out.println(counter.count); // To be consist, we use synchronized keyword in increment method.


            

        }
    }

/* COLLECTION API
    Is a unified architecture for managing and manipulating groups of objects. It provides interfaces and classes for storing, retrieving, and processing collections of data efficiently.

    The framework is part of the java.util package and includes data structures like lists, sets, queues, and maps.

    Some core components of the collection framework are:

    1. Interfaces
        Defines several ke interfaces tat represent different types of collections:
            * Collection
                The root interface for most collection classes (except Map).
            * List
                Ordered collection (allows duplicate elements). Example: ArrayList.
            * Set
                Unordered collection (no duplicate elements). Example: HashSet.
            * Queue
                Ordered collection with operations for adding/removing elements in FIFO order.
            * Deque
                Double-ended queue, supports insertion/removal from both ends.
            * Map
                Represents key-value pairs (no duplicate keys). Example: HashMap.
            * SortedSet
                A Set with elements sorted in natural order or by a comparator.
            * SortedMap
                A Map where keys are sorted.

    2. Classes
        The framework provides concrete implementations of these interfaces, each with unique characteristics.
            * ArrayList (List Interface). Resizable array; fast random access; slow for insert/remove.
            * LinkedList (List or Deque Interface). Doubly linked list; good for frequent insert/remove.
            * HashSet (Set Interface). No duplicates; backed by a HashMap; unordered.
            * LinkedHashSet (Set Interface). No duplicates; maintains insertion order.
            * TreeSet (SortedSet Interface). No duplicates; elements are sorted.
            * PriorityQueue (Queue Interface). Ordered by natural order or a comparator.
            * HashMap (Map Interface). Key-value pairs; no duplicate keys; unordered.
            * LinkedHashMap (Map Interface). Key-value pairs; maintains insertion order.
            * TreeMap (SortedMap Interface). Key-value pairs; keys sorted in natural/comparator order.
            * Stack (Deque Interface). LIFO stack implementation.
            * Vector (List Interface). Synchronized; similar to ArrayList but thread-safe.

    3. Utility Class Collections
        The java.util.Collections class contains utility methods for performing operations on collections, such as: 
            * sort(List<T>). Sorts a list in natural order.
            * reverse(List<T>). Reverses the order of elements.
            * shuffle(List<T>). Randomly shuffles elements.
            * binarySearch(List<T>, key). Performs binary search on a sorted list.
            * max(Collection<T>). Returns the maximum element.
            * min(Collection<T>). Returns the minimum element.

    Collection Hierarchy Diagram:
                Collection
                    |
        ----------------------------------
        |           |                   |
        List        Set                 Queue
        |           |                   |
        ArrayList   HashSet           PriorityQueue
        LinkedList  LinkedHashSet      Deque
        Vector      TreeSet
 
 * COMPARATOR
    An interface used to define custom ordering for obects in a collection. It allows you to compare two objects and determine their order, independent of their natural ordering.
*/

    class CollectionIndependentClass {
        class Student implements Comparable<Student> {
            int age;
            String name;

            public Student(int age, String name) {
                this.age = age;
                this.name = name;
            }
            @Override
            public String toString() {
                return "Student [age=" + age + ", name=" + name + "]";
            }
            @Override
            public int compareTo(Student that) { // Compares this object with the specified object for order.
                return this.age > that.age ? -1 : 1;
            }

            
        }
    }

    class CollectionMainClass extends CollectionIndependentClass {
        public CollectionMainClass() {
            System.out.println("\n--- COLLECTION ---");
            System.out.println("\nArrayList: ");
            List<Integer> listA = new ArrayList<Integer>(); //<DataType> indicate which type of value is storage. We can use Object type but could cause an error if we are working with a specific type.
            
            listA.add(51);
            listA.add(73);
            listA.add(65);
            listA.add(82);

            System.out.println("Value in index 3: " + listA.get(3));
            System.out.println("The whole ArrayList object is: " + listA);

            for (int value : listA) {
                System.out.println(value);
            }

            System.out.println("\nComparator:");

            Comparator<Integer> compA = (i, j) -> (i%10 > j%10 ? 1 : -1);

            System.out.println("Comparator sort second value: ");
            Collections.sort(listA, compA);
            System.out.println("\t" + listA);
            
            Comparator<Student> compB = new Comparator<Student>() {
                @Override
                public int compare(Student i, Student j) {
                    if (i.age > j.age) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            };

            List<Student> students = new ArrayList<Student>();

            students.add(new Student(23, "Acones"));
            students.add(new Student(11, "David"));
            students.add(new Student(28, "Kernel"));

            // Without compareTo() method in Student class from Comparable interface
            System.out.println("\nStudents:");
            System.out.println("\tComparator: ");
            Collections.sort(students, compB); 

            for (Student student : students) {
                System.out.println("\t" + student);
            }

            // With compareTo() method in Student class from Comparable interface
            System.out.println("\nStudents:");
            System.out.println("\tComparable with inverse result:");
            Collections.sort(students);

            for (Student student : students) {
                System.out.println("\t" + student);
            }

            System.out.println("\nHashSet:");
            Set<Integer> setsA = new HashSet<Integer>();

            setsA.add(5);
            setsA.add(6);
            setsA.add(7);
            setsA.add(8);
            setsA.add(4); 
            setsA.add(5); // Will not add a duplicate value

            for (Integer value : setsA) {
                System.out.println("\tValues setsA: " + value);
            }

            System.out.println("\nTreeSet: ");
            Set<Integer> setsB = new TreeSet<Integer>(); // TreeSet is ascendent sorted and has not duplicates

            setsB.add(5);
            setsB.add(6);
            setsB.add(7);
            setsB.add(8);
            setsB.add(4); 
            setsB.add(5);

            Iterator<Integer> values = setsB.iterator();
            
            while (values.hasNext()) {
                System.out.println("\tIterate setsB: " + values.next());
            }

            System.out.println("\nMap:");
            Map<String, Integer> mapA = new HashMap<String, Integer>();

            mapA.put("Acones", 56); // put() add a key and value to the map
            mapA.put("Marsh", 23);
            mapA.put("Marco", 67);
            mapA.put("David", 78);

            mapA.put("David", 59); // Write a new value in the existing key
            

            System.out.println("Values of the map: \n\t" + mapA);
            System.out.println("Value of Acones key: \n\t" + mapA.get("Acones")); // get() retrieve the value from a key

            System.out.println("All keys from the map: \n\t" + mapA.keySet()); // keySet() give us all the keys

            System.out.println("\nKey : Value");
            for (String key : mapA.keySet()) {
                System.out.println("\t" + key + " : " + mapA.get(key));
            }

            System.out.println("mapA values: \n\t" + mapA.values()); // values() return all the values

        }
    }

/* STREAM API
    Introduced in Java 8, it enables functional-style operations on collections and other data sources such as arrays and I/O channels. They make earier to process data with operations such as as filtering, mapping, reducing, and collecting on a sequence of elements with less code. 
    
    They make it easier to work with large collections of data and can execute operations in parallel, leveraging multi-core processors for better performance. 

    Some common operations are:
        Intermediate Operations:
            * filter(Predicate)
                Filters elements based on a condition. Syntax:
                    stream.filter(x -> x > 10)
            * map(Function)
                Transforms elements to another type or form. Syntax: 
                    stream.map(String::lenght)
            * sorted()
                Sorts elements in natural or custom order. Syntax:
                    stream.sorted(Comparator.reverseOrder())
            * distinct()
                Removes duplicate elements. Syntax:
                    stram.distinct()
            * limit(n)
                Limits the number of elements in the stream. Syntax:
                    stream.limit(5)
            * skip(n)
                Skip the first n elements. Syntax:
                    stream.skip(2)

        Terminal Operations:
            * forEach(Consumer)
                Performs an action for each element. Syntax:
                    stream.forEach(System.out::println)
            * collect(Collector)
                Collects elements into a collection or string. Syntax:
                    stream.collect(Collectors.toList())
            * toArray()
                Converts elements to an array. Syntax:
                    stream.toArray()
            * reduce()
                Reduces elements to a single value. Syntax:
                    stream.reduce(0, Integer::sum)
            * count()
                Counts the number of elements in the stream. Syntax:
                    stream.count()
            * anyMatch(Predicate)
                Checks if any element matches the condition. Syntax:
                    stream.anyMatch(x -> x > 10)


    Once streams are used, we can reused. But the benefit of it is the amount of methods there are 

    There are two ways to write a Stream:

        Complete one:
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

        Reduce one: 
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

 * PARALLEL STREAM
    Implemented in Java 9, they allow us to perform stream operation in parallel, leveraging multiple CPU cores. It splits the data into chunks and processes these simultaneously in separate threads, which can significantly improve performance for large datasets.
*/

    class StreamMainClass {
        public StreamMainClass() {
            System.out.println("\n--- STREAM API ---");
            List<Integer> nums = Arrays.asList(4,5,6,7,2);

            Consumer<Integer> consumerA = new Consumer<Integer>() {

                @Override
                public void accept(Integer number) {
                    System.out.println("\t"+ number);
                }
            };

            System.out.println("Extend version of forEach():" );
            nums.forEach(consumerA);

            System.out.println("Shorter version of forEach():");
            nums.forEach(n -> System.out.println("\t" + n)); // A reduce form of a forEach loop

            System.out.println("\nStream:");

            System.out.println("Stream forEach():");
            Stream<Integer> streamA = nums.stream(); // Returns a sequential Stream with this collection as its source without affecting it.
            streamA.forEach(n -> System.out.println("\t" + n));
            
            System.out.println("Stream filter():");
            nums.stream()
            .filter(n -> n%2 == 0) // Filter the collection to only get odd numbers
            .forEach(n -> System.out.println("\t" + n)); // Print each value of the array
            

            System.out.println("Stream map():");
            nums.stream()
            .filter(n -> n%2 == 0) // Filter the collection to only get odd numbers
            .map(n -> n*2) // Transforms elements to another type or form. In this case multiply each element by 2.
            .forEach(n -> System.out.println("\t" + n));

            System.out.println("Stream reduce():");
            int result = nums.stream()
                            .filter(n -> n%2==0) // Filter the collection to only get odd numbers
                            .map(n -> n*2) // Transforms elements to another type or form. In this case multiply each element by 2.
                            .reduce(0, (e, c) -> e + c); // Performs a reduction on the elements, using the provided identity value and an associative accumulation function, and returns the reduced value.

            System.out.println("\t" + result);

            // Parallel stream
            System.out.println("\nParallel Stream:");
            int size = 10_000;

            List<Integer> listA = new ArrayList<>(size); // It has 10k values of 0
            
            Random randomA = new Random();

            for (int i = 0; i < size; i++) {
                listA.add(randomA.nextInt(100)); // Generate a random number with max value 100 and add it to listA
            }

            int sumA = listA.stream()
                        .map(i -> i*2)
                        .reduce(0, (c, e) -> c+e);

            System.out.println("\tUsing reduce(): " + sumA);
            
            long startSumB = System.currentTimeMillis(); // It give us the current time in miliseconds

            int sumB = listA.stream()
                        .map(i -> {
                            try {
                                Thread.sleep(1);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }

                            return i*2;
                        })
                        .mapToInt(i -> i) // Return an int object
                        .sum(); // It only works with int stream (reason why we convert it) and return the sum of elements
            long endSumB = System.currentTimeMillis(); 
                    
            System.out.println("\tUsing sum(): " + sumB);

            long startSumC = System.currentTimeMillis(); 

            int sumC = listA.parallelStream() // Enable parallelStream
                        .map(i -> {
                            try {
                                Thread.sleep(1);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }

                            return i*2;
                        })
                        .mapToInt(i -> i)
                        .sum();

            long endSumC = System.currentTimeMillis(); 

            System.out.println("\tUsing parallelStream(): " + sumC);
            System.out.println("\tTime taked: \n\t\tsumB - " + (endSumB - startSumB) + " : sumC - " + (endSumC - startSumC));

        }
    }

/* OPTIONAL CLASS
    Introduced in Java 8, is a container object that handle values that can be either present or absent. It helps eliminate the risk of encountering a NullPointerException and encourages writing cleaner and more readable code.
*/

    class OptionalMainClass {
        public OptionalMainClass() {
            System.out.println("--- OPTIONAL CLASS ---");

            List<String> listA = Arrays.asList("Acones", "John", "David");

            // Optional avoid NullPointerExceptions
            Optional<String> name = listA.stream()
                            .filter(str -> str.toLowerCase().contains("a"))
                            .findFirst();

            System.out.println(name.orElse("Not found")); // orElse() return a value if is present, otherwise returns "other"
        }
    }

/* METHOD REFERENCE
    Implemented in Java 8, is a shorthand syntax for invoking methods by referring to them directly, instead of calling them explicitly. They improve code readability by reducing boilerplate code and allowing developers to reuse existing methods.

    There are four types of method reference:
        1. Reference to a Static Method
            ClassName::methodName
        2. Reference to an Instance Method of a Particular Object
            instance::methodName
        3. Reference to an Instance Method of an Arbitrary Object of a Particular Type
            ClassName::methodName
        4. Reference to a Constructor
            ClassName::new

 * CONSTRUCTOR REFERENCE
    
*/

    class ConstructorAndMethodReferenceIndependentClasses {
        class Student {
            private String name;
            private int age;

            public Student() {
            }

            public Student(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            @Override
            public String toString() {
                return "Student [name=" + name + ", age=" + age + "]";
            }
        }
    }

    class ConstructorAndMethodReferenceMainClass extends ConstructorAndMethodReferenceIndependentClasses {
        public ConstructorAndMethodReferenceMainClass() {
            System.out.println("--- METHOD REFERENCE ---");
            List<String> listA = Arrays.asList("Acones", "David", "John");

            List<String> lowerListA = listA.stream()
                                    .map(String::toUpperCase) // From the String class :: Use toUpperCase(). It use 1rd type
                                    .toList(); // Transform elements into a list

            lowerListA.forEach(System.out::println); // It use 3nd type

            // Constructor Reference
            System.out.println("--- CONSTRUCTOR REFERENCE ---");

            List<Student> studentsA = new ArrayList<>();
            
            // Without stream
            System.out.println("Without stream:");

            for (String student : listA) {
                studentsA.add(new Student(student));
            }

            System.out.println(studentsA);

            // With stream
            System.out.println("\nWith stream:");

            List<Student> studentsB =  listA.stream()
                                .map(name -> new Student(name))
                                .toList();

            System.out.println(studentsB);

            // With stream and Constructor Reference
            System.out.println("\nWith stream and constructor reference:");

            List<Student> studentsC = listA.stream()
                                .map(Student::new)
                                .toList();

            System.out.println(studentsC);
            

        }
    }

