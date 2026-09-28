# Control System for a Boiler in a Chocolate Factory
> Introduction to Singleton Design Pattern
> Creational design pattern

## Description
The context of this project is the *control of a boiler* in a chocolate factory. The boiler is a single physical device, so the system must guarantee that only one instance of it exists and that every part of the program (represented here by different threads) operates on that same instance.

The Singleton pattern solves this: `ChocolateBoiler` has a private constructor and exposes a global access point, `getInstance()`, which is thread-safe (double-checked locking with `volatile`).

The boiler enforces the following business rules:

1. **Initial state:** Empty boiler and heating element turned off.
2. It can only be **filled** if it is empty and the heating element is off.
3. It can only **start mixing** if it is full and the heating element is off.
4. It can only be **drained** if it is not empty and the heating element is on.

> **Note:** Operations that violate these rules are rejected and reported.

# Project Structure
- Package: `singleton`
    * class `Boiler`

- Package: `main`
    * class `Main`

# How to Run

1. Clone or download the repository.
2. Open the project in a Java-compatible IDE such as VS Code, IntelliJ IDEA, or Eclipse.
3. Make sure Java is correctly installed and configured.
4. Compile the sources, e.g. `javac -d bin src/singleton/*.java src/main/*.java`.
5. Run `main.Main` to see the different threads operating on the same boiler instance.
6. Check the console output to verify that every operation respects the boiler rules, that invalid operations are shown as `[RECHAZADO]`, and that the final line prints `true`, confirming that `getInstance()` always returns the same object.

# Console Output
![alt text](/src/Images/image.png)

Last Modification: 28/09/2026