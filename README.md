# FrontControllerDemo

Coding Standards:

1. Position of Braces: top brace must be one-spaced and next to method or class name, bottom brace must be on its own line.
    ex. public void Example() {
           // pass
        }

2. Single-line Comments must be in the form //
3. Multi-line Comments must be in the form /**/
4. Class Names must start with Capital letter: ex. public class Example 
5. For Class Names longer than 1 word, the next word must be appended to the previous word with the first letter as capitalized: ex. public class ExampleClass 
6. All function names must start with lowercase word: ex. public void example()
7. For Function names longer than 1 word, the next word must be appended to the previous word with the first letter capitalized: ex. public void exampleMethod()
8. All if-statements must be braced
9. In a function, unrelated code must be in its own block
  ex. 
     public void example() {
          Integer a = 1;
          Integer b = 2;
          
          if(a < b) {
            return a + b; 
          }
          else {
            return a - b; 
          }
     }
