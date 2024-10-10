The <b>Strategy Design Pattern</b> is a <u>behavioral design pattern</u> that allows you to define a 
family of algorithms, encapsulate each one, and make them interchangeable. This pattern lets the algorithm 
vary independently from the clients that use it, promoting flexibility and reusability in your code.

<b>Key Concepts</b>:

<b>Strategy Interface</b>: 
Defines a common interface for all supported algorithms.

<b>Concrete Strategies</b>: 
Implement the strategy interface with specific algorithms.
<b>Context</b>: Maintains a reference to a strategy object and delegates the algorithm execution to the strategy.

<u>Features:</u>

<i>Strategy pattern</i> defines a <i>family of behaviours</i>.

<i>Strategy pattern</i> makes it easy to <i>switch between behaviours at runtime</i>.