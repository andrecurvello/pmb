PMB
===

Post Modern BASIC written in Java. The prime motivation is to write a language similar in many ways to a modern BASIC, but missing out on the not so nice features.

  * Use the CLI terminal as the window. Lanterna GLPL licenced.
  * Design for use on my raspberry pi.
  * Graphics via NEWT/JOGL and sound JOAL.
  * A fully extendable syntax.
  * Useful data structures.
  * Extension by Java Class loading.

Current Status
==============

*2013-01-23*

Introduced the expression stack, and PassiveToken for parse() and eval(). There is now a reasonable framework for introducing a procedural expression framework. The general parse process will promote() the program StringToken, and apply a round of parse() to make the stored object. This will be subject to a round of eval() to execute it. The dispatcher is likely to use id() to index a Token[], using a new class ActiveToken. Instances of ActiveToken will deligate to obtain functionality. This makes zero, one and two operand operations easy and fast, and allows a connection with locals to handle multi-parametric functions.

*Oldest*

Writing the type classes, and a simple test of the terminal. The type function dispatch is under consideration. This will perhaps change the type system a little, and the last implemtation details. Some of the implementation has not been done yet, to avoid later changes. I'm at the point of introducing the expression stack.
