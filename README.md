# Qwertz

## Already Implemented
* Integers, Floats 
* Basic operations : `+-*/()`
* Constants 
* Assignment operator, variables
* Print keyword 
* Strings, strings operations : `+*` (concat)
* Conditional operators : `< <= > >= == !=`
* Branching : `if`, `else`
* Comments : singleline `//` , multiline `/* */` 
* Boolean operators : `&& ||`
* Block statements 
* `for` \ `while` \ `do-while` loops
* Loop control : `continue` & `break`

## Features
* Multilanguage support for keywords `RO` \ `EN` \ `DE` \ `RU`

## Demo
Code Example:
```scala
    /*
        Example
        of
        multiline
        comment
    */

    // So work strings
    word = "yay " + "nice"
    drücke word + "\n"

    // So work numbers
    yo = 5.5 * 2 - 1 + YOLO
    print yo
    print "\n"

    // So work conditionals
    if (40 > 50) && (50 != 60) {
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
                continue
        }
        for (i = 0 : i < 10 : i = i + 2) {
            print "i = " + i + "\n"
            if i == 4
                continue
        }

        do {
            print "i = " + i + "\n"
            i = i - 1
        } while (i >= 0)
    }
```