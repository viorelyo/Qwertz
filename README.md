# Qwertz
Qwertz is an ~~esoteric~~ programming language with multilanguage support.

## Already Implemented
* Integers, Floats 
* Basic operations : `+-*/()`
* Constants 
* Assignment operator, variables
* Print keyword  
    
    ```scala
        integerVar = 4 + 6 + YOLO
        print integerVar
    ```
    > 52.0  
      
* Strings, strings operations : `=*` (concat)  
    
    ```scala
        stringVar = "yo" * 3
        afișează stringVar
    ```
    > yoyoyo  
  
* Conditional operators : `< <= > >= == !=`
* Block statements 
* Boolean operators : `&& ||`
* Branching : `if`, `else`  
    
    ```scala
        qwertz = 42.99
        falls (qwertz > 42) 
        {
            print "yay!"
            print " QWERTZ is amazing\n"
        }
        иначе
            drücke "meh\n" 
    ```
    > yay! QWERTZ is amazing  
  
* Comments : singleline `//` , multiline `/* */` 
* Loop control : `continue` & `break`
* `for` \ `while` \ `do-while` loops  
    
    ```scala
        for (i = 0 : i < 10 : i = i + 2) {
            print "i = " + i
            if i == 4
                стопэ
            print ", "
        }
    ```
    > i = 0.0, i = 2.0, i = 4.0  
  
* System functions : `sin`, `cos`, `fancyPrint` ...  

    ```scala
        fancyPrint(1, 2, 3, 4, 5, YOLO)
    ```
    > 1.0 2.0 3.0 4.0 5.0 42.0  

* User defined functions : `fun`  
     
    ```scala
        fun sum(a, b) {
            a = a + 4
            fancyPrint(a, " ", b, "\n")
            return a + b
        }

        a = 1
        print sum(a, 2)
    ```
    > 5.0 2.0  
    > 7.0  
  
  
## Features
* Multilanguage support for keywords `RO` \ `EN` \ `DE` \ `RU`
> Pardon some of my keywords :)  

* Visual Studio Code Extension for `Qwertz` : `qwertz.vscode-extension`  

## Program Demo
Code Example:
```scala
        /*
        Example
        of
        multiline
        comment
    */

    arr = [1, "text", 1+1, [2 + 3]]
    print arr + "\n"
    arr[0] = arr[0] + 1000 + arr[1]

    fun println(i) {
        print "i = " + i + "\n"
    }

    // So work strings
    word = "yay " + "nice"
    drücke word + "\n"

    // So work numbers
    yo = 5.5 * 2 - 1 + YOLO
    print yo
    print "\n"

    // So work conditionals
    if (40 > 50) || (50 != 60) {
        печать "true\n"
        print "true1\n"
    }
    altfel {
        afișează "false\n"

        i = 0
        while (i < 10) {
            print "i = " + i + "\n"
            i = i + 1
            if i == 4
                oprește
        }
        for (i = 0 : i < 10 : i = i + 2) {
            print "i = " + i + "\n"
            if i == 4
                continue
        }

        do {
            println(i)
            i = i - 1
        } while (i >= 0)
    }
```

## Built with
* Java 8
* Gradle Project
* Intellij Idea

## Visual Studio Code Support
1. Syntax Highlight  
  
To install Qwertz extension for Visual Studio Code, copy the extension folder `qwertz.vscode-extension` to extension directory:  
* on __Windows__: `%USERPROFILE%\.vscode\extensions`
* on __MAC/Linux__: `$HOME/.vscode/extensions`

## Enjoy it ^_^
