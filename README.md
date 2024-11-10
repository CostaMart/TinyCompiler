# Tiny Compiler
In our course of "paradigm e linguaggi di programmazione" at University of Sannio we are developing a compiler for "TinyLanguage".

## Javaccc (java compiler compiler compilator)
a simple script to make the compilation faster (requires Javacc to be in your path).
### input
- path to the .jj file to compile
### output
- creates it/unisannio/paradigmi/generated if not presents and saves java files into it.


## SYNTAX SUMMARY:
- every control instruction (repeat, end, then) must be followed by a newline
- every other instruction must be followed by a semicolon
- comments are in {}
- := is the assignment operator

---

#### Non Terminals ------------------------
* Program.
* Statement
* CallRead
* CallWrite
* Assignment
* IfThen
* RepeatUntil

## RULES

- &lt;Program&gt;::= NEWLINE+ &lt;Statements&gt; EOF
- &lt;Statements&gt;::= &lt;Statement&gt; SEMICOLON &lt;Statements&gt; | &lt;Statement&gt; 
- &lt;Statement&gt;::= &lt;CallRead&gt; | &lt;CallWrite&gt; | &lt;Assigment&gt; | &lt;IfThen&gt; | &lt;RepeatUntil&gt; [NEWLINE]
- &lt;CallWrite&gt;::= WRITE (ID|NUMBER)
- &lt;CalRead&gt;::= READ (ID)
- &lt;Assignment&gt;::= ID ASSIGNMENT &lt;Expression&gt;

 previous  // &lt;Expression&gt; ::= &lt;Expression&gt; SUM_DIV &lt;MulDivExpr&gt; | &lt;MulDivExpr&gt;
- &lt;Expression&gt;::= &lt;MulDivExpr&gt; &lt;ExpressionExt&gt; 
- &lt;ExpressionExt&gt;::= SUM_DIF &lt;MulDivExpr&gt; &lt;ExpressionExt&gt; | epsilon


- &lt;MulDivExpr&gt;::= &lt;Factor&gt; &lt;MulDivExprExt&gt;
- &lt;MulDivExprExt&gt;::= MUL_DIV - &lt;Factor&gt; &lt;MulDivExprExt&gt; | epsilon		


- &lt;Factor&gt;::= ID | NUMBER | (LEF_PAR &lt;Expression&gt; RIGHT_PAR)
- &lt;IfThen&gt;::= IF &lt;Condition&gt; THEN NEWLINE &lt;Statements&gt; [ELSE &lt;Statements&gt;] END NEWLINE
- &lt;Condition&gt;::= &lt;Expression&gt; COMPARISON &lt;Expression&gt;
- &lt;RepeatUntil&gt;::= REPEAT &lt;Statements&gt; UNTIL &lt;Condition&gt; NEWLINE