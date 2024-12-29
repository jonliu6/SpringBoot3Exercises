Aspect Oriented Programming Terminology

Aspect: module of code for cross-cutting concern (eg logging, security etc)

Advice: what action is taken and when it should be applied
  - Before advice: run before the method
  - After finally advice: run after the method (finally)
  - After returning advice: run after the method (successful execution)
  - After throwing advice: run after the method (if exception thrown)
  - Around advice: run before and after the method

Join Point: when to apply code during program execution

Pointcut: a predicate expression for where advice should be applied

Weaving: connecting aspects to target objects to create an advised object
  Types:
    - compile-time, load time or runtime (slowest performance)
    
Spring AOP or AspectJ