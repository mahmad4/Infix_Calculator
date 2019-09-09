Muhammad Ahmad


OUTPUT file is basically the postfix_eval_short.txt document


I have 3 classes for my project:
1. P_2 : run this class
2. Stack : which has the functions for the stack
3. Queue : which has the functions for the queue

P.S : I did the extra credit for implementing the modulus sign (%) ~ 2 % extra credit

My code will take in the src/infix_expr_short.txt and print out the result in src/postfix_eval_short.txt

I have added a few expressions into the infix_expr_short which also have the result output in postfix_eval_short

For TESTING:
Please note that while giving in expressions to my code have spaces between each token. Thank You!


For my P_2 class I have 6 methods including the main method.
1. infixtopostfix:
method that takes in a line and return a postfix queue

2. op_order:
method used inside the infixtopostfix method...used to determine the precedence of the operators

3. isOperator:
Used inside both the infixtopostfix and eval method...checks if the token is an operator or not

4. eval:
takes in the postfix queue...method that evaluates the postfix expression

5. calc:
Used inside the eval method...to perform the function of each operator

6. main:
main method calls in the file, passes the line to the infixtopostfix method which returns a queue, 
passes the queue to the eval method which returns a value and it saves the value in the output file


For my Stack class:
I have made a push, pop, isEmpty and getTop methods

For my Queue class:
I have made a enqueue, dequeue, and empty method 



