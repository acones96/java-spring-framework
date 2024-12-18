/*
 * JAVA DEVELOPMENT KIT (JDK)
        It is a software package you need to develop applications in Java.

 * JAVA COMPILER (JavaC)
        Convert a Java Code into a Byte code.

 * JAVA RUNTIME ENVIRONMENT (JRE)
        Here is where libraries are stored and JVM can use freely }

 * JAVA VIRTUAL MACHINE (JVM)
        Execute a Java Code in any OS, but it needs to be readed in byte code.

        The hierarchy would be JDK -> JRE -> JVM

 * JAVA
        Is a object oriented program which means everything needs to be an object. 
        
        
        So we need a class, which use the following syntax:
        
            class Hello {
                public static void main (String[] args) {
                    System.out.println("Hello World");
                }
            }

        Once it runs,it creates a .class file, which is the byte file.
        
        Is a Strongly Typed Language, where we store a variable with a specific type of data (int, String, etc)
        String variable = "text"

        We can change the type of a variable by using casting, which indicate the data type before: b = (byte) a

        This convertion can be automatically if the data convertion is from a smaller to a larger data type.
*/

import java.util.Arrays;

class Demo {

    /* MAIN METHOD
        The first file needs to have a main method whithc runs all the program.

            (psvm)
            public static void main (String[] args) {
            
            } 
    */
    public static void main (String args[]) {
        new CastingMain();
        new IfElseMain();
        new TernaryMain();
        new SwitchMain();
        new ForLoopMain();
        new WhileLoopMain();
        new OopMain();
        new ArrayMain();
        new StringMain();
        new StaticMain();
        new EncapsulationMain();
        new InheritanceMain();
    }
}

/* CASTING
    Casting, uncasting, and autocasting are concepts used to convert one type of variable to another. These conversions often happen between primitive types or object types to accommodate specific operations.

    1. Casting. Is the process of explicitly converting a value from one data type to another.

        - Upcasting. 
            Converts a smaller data type to a larger one. Happens implicitly (no special syntax required).

            Example:
                int number = 42;
                double result = number; // Automatic conversion from int to double
                System.out.println(result); // Output: 42.0



        - Downcasting. 
            Converts a larger data type to a smaller one. Requires explicit casting as it may result in data loss.

            Example:
                double value = 42.5;
                int result = (int) value; // Explicit conversion from double to int
                System.out.println(result); // Output: 42

    2. Autocasting. Is the automatic conversion of a smaller data type to a larger one (widening). The compiler handles it without any need for explicit syntax.

        * Primitive Type Autocasting Example: 
            int a = 10;
            long b = a; // int to long
            float c = b; // long to float

        Object Type Upcasting Exampple: 
            class Animal {}
            class Dog extends Animal {}

            Animal animal = new Dog(); // Upcasting Dog to Animal

    3. Uncasting. is the process of converting a larger type to a smaller or more specific type (narrowing). It requires explicit syntax and must be done cautiously, as it can lead to ClassCastException or data loss in primitives.

        * Primitive Type Uncasting Example:
            double pi = 3.14;
            int integerPi = (int) pi; // Explicit cast from double to int
            System.out.println(integerPi); // Output: 3

        * Object Type Downcasting Example:
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
*/

    class CastingMain {
        public CastingMain() {
            System.out.println("\n-- Casting --");
            byte b = 12;
            int a = b;

            System.out.println("Conversion byte a int: " + a);

            // Manual casting
            a = 14;
            b = (byte) a;

            System.out.println("Conversion int a byte: " + b);
        }
    }


/* IF-ELSE
    Is a basic control flow structure used to execute a block of code based on a condition. It allows you to decide what action to take depending on whether a condition is true or false.

    It use the following syntax:
        if (condition) {
            // Code to execute if condition is true
        } else {
            // Code to execute if condition is false
        }
*/

    class IfElseMain {
        public IfElseMain() {
            System.out.println("\n-- If-Else Conditions --");
            int x = 5;

            if (x < 5) {
                System.out.println("Print desde if en x");
            } else if (x <= 5) {
                System.out.println("Print desde else if en x");
            } else {
                System.out.println("Print desde else en x");
            }

            int y = 10;

            if (y < 10) {
                System.out.println("Print desde if en y");
            } else if (y != 10) {
                System.out.println("Print desde else if en y");
            } else {
                System.out.println("Print desde else en y");
            }
        }
    }


/* TERNARY
    Is a shortcut for writing a simple if-else statement, which do conditional coding. 
    
    His sintax is:
        condition ? valueIfTrue : valueIfFalse;
*/

    class TernaryMain {
        public TernaryMain() {
            int x = 5;
            int y = 4; 

            System.out.println("\n-- Ternary Condition --");
            boolean result = x > y ? true : false;
            System.out.println(x + " is greater than " + y + "? " + result);
        }
    }

/* SWITCH
    Is a control flow construct that lets you execute different blocks of code based on the value of an expression. It's an alternative to writing multiple if-else statemets and can make the code readable.

    His sintaxis is:

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
*/

    class SwitchMain {
        public SwitchMain() {
            System.out.println("\n-- Switch Condition --");
            int week_day = 3;

            switch (week_day){
                case 1:
                    System.err.println("Monday");
                    break;
                case 2:
                    System.err.println("Thusday");
                    break;
                case 3:
                    System.err.println("Wednesday");
                    break;
                case 4:
                    System.err.println("Thursday");
                    break;
                case 5:
                    System.err.println("Friday");
                    break;
                case 6:
                    System.err.println("Saturday");
                    break;
                case 7:
                    System.err.println("Sunday");
                    break;
                default:
                    System.out.println("Week day doesn't exist");
                    break;
            }
        }
    }


/* FOR LOOP
    It is a control flow statement that repeats ablock of code a specific number of times.

    His syntax is:

        for (initialization; condition; update) {
            // Code block to execute
        }
*/

    class ForLoopMain {
        public ForLoopMain() {
            System.out.println("\n-- For loop --");
            for (int i = 0; i <= 10; i++) {
                if (i != 10) {
                    System.out.print(i + " ");
                } else {
                    System.out.println(i);
                }
            }
        }
    }


/* WHILE LOOP
    Is a control flow statement that allow us to repeatedly execute a block of code as long as a specified condition is true. It's typically used when the number of iterations is not known in advance and depends on some condition being met.

    It use the following syntax:

        while (condition) {
            // Code block to execute
        }
*/

    class WhileLoopMain {
        public WhileLoopMain() {
            System.out.println("\n-- While loop --");

            int i = 0;
            while (true) {
                if (i != 10) {
                    System.out.print(i++ + " ");
                } else {
                    System.out.println(i);
                    break;
                }
                
            }

            // Do While loop
            System.out.println("\n-- Do While --");

            i = 0;
            do {
                System.out.println("Excecute at least one time " + i++);
            } while (false);
        }
    }


/* CLASSES AND OBJECTS (OOP)
    Classes are a blueprint or template for creating objects. It defines a set of attributes and methods that the objects created from the class will have. On the other hand, objects are instances of a class which are created with specific values for their attributes.
*/

    class OopIndependentClasses {
        class Computer {
            public void playMusic() {
                System.out.println("Music Playing...");
            }
        
            public String getMeAPen(int cost) {
                if (cost >= 10) 
                    return "Pen";
        
                return "Nothing";
            }
        }

        class Calculator {
            public int add(int num1, int num2) {
                return num1 + num2;
            }
        
            // METHOD OVERLOADING. Let us create multiple methods with the same name but different numbers or types of parameters

            public int add(int num1, int num2, int num3) {
                return num1 + num2 + num3;
            }

            public int sub(int num1, int num2) {
                return num1 - num2;
            }
            
        }

        class AdvanceCalculator extends Calculator {
            public int multiplication(int n1, int n2) {
                return n1*n2;
            }
        
            public int division(int n1, int n2) {
                return n1 / n2;
            }
        }

        class ScientificCalculator extends AdvanceCalculator {
            public int power (int n1, int n2) {
                return (int) Math.pow(n1, n2);
            }
        }
    }

    class OopMain extends OopIndependentClasses {
        public OopMain() {
            System.out.println("\n-- Class & Objects --");
            int num1 = 5;
            int num2 = 10; 

            Calculator calc = new Calculator(); // Create object
            int resultado = calc.add(num1, num2); // Call method with parameters and assign his result

            System.out.println("El resultado de " + num1 + " + " + num2 + " = " + resultado);

            int num3 = 15;
            resultado = calc.add(num1, num2, num3); // Call method with parameters and assign his result

            System.out.println("El resultado de " + num1 + " + " + num2 +  " + " + num3 + " = " + resultado);

            Computer obj1 = new Computer(); // Create object of Computer class
            obj1.playMusic(); // Execute playMusic method
            System.out.println("You bought: " + obj1.getMeAPen(10));
            System.out.println("You bought: " + obj1.getMeAPen(2));
        }
    }


/* ARRAYS
    Is a data structure that stores a collection of items in a single, contiguous block of memory. 

    They are useful to group related data, efficient access, simplify coding, memory management and enable complex algorithms.
    
    His syntax is:
        int num[] = {1,2,3,4,5} -> Store the elements indicated in the keys

        int num[] = new int[number] -> Can store a number of elements

    Meanwhile a Jagger array is an array where each element itself is an array, and these "inner" arrays can have different sizes or lengths.
*/

    class ArrayIndependentClasses {
        class Student {
            int rollnum;
            String name;
            int marks;
            
        }

    }

    class ArrayMain extends ArrayIndependentClasses {
        public ArrayMain() {
            System.out.println("\n-- Array --");

            int array1[] = {3,7,2,4};
            System.out.println("2nd value in array is " + array1[1]);

            System.out.print("\nEvery element in the array are: ");
            for (int iterate = 0; iterate < array1.length; iterate++) {
                System.out.print(array1[iterate] + " ");
            }

            System.out.print("\nOrder elements in array: ");
            Arrays.sort(array1);
            for (int iterate = 0; iterate < array1.length; iterate++) {
                System.out.print(array1[iterate] + " ");
            }
            
            System.out.println("\nMulti dimensional array:");
            int nums[][] = new int[3][4];

            for (int j1 = 0; j1 < 3 ; j1++) {
                for (int j2 = 0; j2 < 4; j2++) {
                    nums[j1][j2] = (int)(Math.random() * 100); // Assign random values
                    System.out.print(nums[j1][j2] + " "); 
                }
            }


            
            System.out.println("\nJagged Array");
            
            // A Jagger array is an array where each element itself is an array, and these "inner" arrays can have different sizes or lengths.
            
            int jaggedArray[][] = new int[3][]; 
            jaggedArray[0] = new int[3]; // First row of elements will contain 3 elements
            jaggedArray[1] = new int[5]; // Second row of elements will contain 5 elements
            jaggedArray[2] = new int[8]; // Third row of elements will contain 8 elements

            for (int j1 = 0; j1 < jaggedArray.length ; j1++) {
                for (int j2 = 0; j2 < jaggedArray[j1].length; j2++) {
                    jaggedArray[j1][j2] = (int)(Math.random() * 100); // Assign random values
                    System.out.print(jaggedArray[j1][j2] + " "); 
                }
                System.out.println();
            }

            System.out.println("\nArray of objects:");
            Student s1 = new Student();
            s1.rollnum = 1;
            s1.name = "Kevin";
            s1.marks = 67;

            Student s2 = new Student();
            s2.rollnum = 2;
            s2.name = "Kira";
            s2.marks = 68;

            Student s3 = new Student();
            s3.rollnum = 3;
            s3.name = "Marsh";
            s3.marks = 69;

            Student students[] = new Student[3];
            students[0] = s1;
            students[1] = s2;
            students[2] = s3;

            for (Student student : students) {
                System.out.println(student.rollnum + " - " + student.name + " - " + student.marks);
            }
        }
    }

/* STRING
    String Buffer is a mutable String that gives a buffer size (16 bytes) and it is thread safe. Meanwhile, string Buldier it is not thread safe but i is almost the same.
*/

    class StringMain {
        public StringMain() {
            System.out.println("\n--- String ---");

            // String Buffer. A mutable String that gives a buffer size (16 bytes) and it is thread safe.
            StringBuffer sb = new StringBuffer("ACONES");
            sb.append("96");
            System.out.println("StringBuffer capacity: " + sb.capacity());
            System.out.println(sb);

            // String Buldier. It is not thread safe.
            StringBuilder sBuilder = new StringBuilder("ACONES");
            sBuilder.append("96");
            System.out.println("StringBuilder capacity: " + sBuilder.capacity());
            System.out.println(sBuilder);
        }
    }


/* STATIC AND FINAL KEYWORD
    Static is a modifier that can be applied to variables, methods, blocks, and nested classes. His purpose is to define members that belong to the class rather than to any specific instance, meaning that all instances will have the same static value as a share copy.

    
    Final can be used in variables, methods and classes. We are going to explain how it works for each one of them:
        - Variables
            Makes the variable as a constant, so it cannot be change after assign a value. It needs to be assigned during the declaration, inside or the constructor 
        - Methods
            It cannot be overriden by subclasses.
        - Class. 
            It cannot be subclassed 

    
*/

    class StaticIndependentClasses {
        class Mobile {
            String brand;
            int price;
            static String name; // Static let us make the value same for every object. Static is shared by all the objects.
        
            // In static block we can initialice variables where they are going to be called only once.
            static {
                System.out.println("\nIn static block");
                name = "Phone";
            }
        
            public Mobile() {
                System.out.println("\nIn constructor");
                brand = "";
                price = 200;
            }
            
            /* OVERRIDE
                Allow us to modify a method from a parent class in the child class. We can use the @Override anotation as an indicator that the parent method it's been changing.
            */

            @Override
            public String toString() {
                return "Brand: " + brand + ", Price: " + price + ", Name: " + name;
            }
        
            public static void show(Mobile obj) {
                System.out.println("\nIn static method");
                System.out.println("Brand: " + obj.brand + ", Price: " + obj.price + ", Name: " + name);
            }
        }
    }
        
    class StaticMain extends StaticIndependentClasses {
        public StaticMain() {
            System.out.println("\n--- Static ---");
            Mobile aMobile = new Mobile();
            aMobile.brand = "Apple";
            aMobile.price = 1500;
            Mobile.name = "Smart Phone"; // Can call a static variable by the class name.

            System.out.println(aMobile.toString());
            Mobile.show(aMobile); // Using static methods. We send values by the parameters

            Mobile bMobile = new Mobile();
            bMobile.brand = "Samsung";
            bMobile.price = 1700;
            Mobile.name = "Smart Phone"; // Can call a static variable by the class name.

            System.out.println(bMobile.toString());
            Mobile.show(bMobile); // Using static methods. We send values by the parameters
        }
    }


/* ENCAPSULATION
    Control the visibility and accessibility of classes, methods, and variables. They define how and where a member can be accessed from other classes or packages. There are four different levels:
        1. Public. They have access to class, package, subclass, everywhere.
        2. Protected. They have access to class, package and subclass.
        3. Default. They have access to class and package.
        4. Private. They have access only to the class.

    GETTER AND SETTERS
    
        While the variables are encapsulated in a class, we could access to them by getters and setters.

        Syntax:
            Getter:
                public int getVariableName() {
                    return this.variable;
                }
            
            Setter:
                public void setVariableName(int variableName) {
                    this.variableName = variableName;
                }

    PACKAGES
        Packages let us store a number of files in a package, which can be represented as folder.
*/

    class EncapsulationIndependentClasses{
        class Human {
            private int age; 
            private String name;
        
            // Getter and Setter
            public int getAge() {
                return age;
            }
            public void setAge(int age) {
                this.age = age;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
        }
        
    }

    class EncapsulationMain extends EncapsulationIndependentClasses {
        public EncapsulationMain() {
            System.out.println("\n--- Encapsulation ---");
            Human h1 = new Human();
            h1.setAge(12);
            h1.setName("ACONES96");
            
            System.out.println(h1.getName() + " : " + h1.getAge());
        }
    }


/* INHERITANCE
    Inheritance is one of the core concepts of Object-Oriented Programming (OOP), allowing a class (child) to "inherit" properties and behaviors (fields and methods) from another class (parent). It promotes code reuse and helps in building a hierarchy of classes.

    POLIMORPHISM
        The word itself means "many forms", which it allows objects to be treated as instances of their parent class rather than their actual class. There are two types:
            - Compile-Time, which is kind of the use of overloading where is based on the number of parameters.
            - Run-Time, which is kind of the use of overriding wher it needs to use inheritance.

    Method Overloading
        Let us create multiple methods with the same name but different numbers or types of parameters

*/

    class InheritanceIndependentClasses {
        class Calculator {
            public int add(int num1, int num2) {
                return num1 + num2;
            }
        
            // METHOD OVERLOADING. Let us create multiple methods with the same name but different numbers or types of parameters

            public int add(int num1, int num2, int num3) {
                return num1 + num2 + num3;
            }

            public int sub(int num1, int num2) {
                return num1 - num2;
            }
            
        }

        class AdvanceCalculator extends Calculator {
            public int multiplication(int n1, int n2) {
                return n1*n2;
            }
        
            public int division(int n1, int n2) {
                return n1 / n2;
            }
        }

        class ScientificCalculator extends AdvanceCalculator {
            public int power (int n1, int n2) {
                return (int) Math.pow(n1, n2);
            }
        }
        
        /* THIS AND SUPPER
            By default every constructor has a method which is super(), even if it's not there. We can specify the kind of super that is directed to a constructor. If in an inheritance, we want to use the constructor with one parameter instead of none, we use super({value}).

            We can also use this() to represent the constructor in the same class.
        */
        class A {
            public A() {
                System.out.println("Printing in class A");
            }

            public A(int num) {
                System.out.println("Printing in class A with number");
            }

            public void show() {
                System.out.println("Print show in A");
            }

            public void config() {
                System.out.println("Prnit config in A");
            }
        } 

        class B extends A {
            public B() {
                super();
                System.out.println("Printing in class B");
            }

            public B(int n) {
                this();
                System.out.println("Printing in class B with number");
            }

            @Override
            public void show() {
                System.out.println("Print show in B");
            }
        }
    }

    class InheritanceMain extends InheritanceIndependentClasses {
        public InheritanceMain() {
            System.out.println("\n--- Inheritance ---");
            ScientificCalculator adv1 = new ScientificCalculator();
            System.out.println("Sum: " + adv1.add(1, 2));
            System.out.println("Division: " + adv1.division(6, 3));
            System.out.println("Power: " + adv1.power(2, 3));

            // SUPER
            System.out.println("\n--- Super ---");
            B objB = new B(1);
            objB.show();
            objB.config();
        }
    }













