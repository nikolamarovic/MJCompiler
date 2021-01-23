# MJCompiler
The goal of a project was the realization of a compiler for a Java-like programming language called Microjava. Compiler allows translation syntactically and semantically correct Microjava programs into Micro-bytecode which is executed on a virtual machine for Microjava. 
The project consists of four phases: 
1. Lexis Analysis - taking tokens from source code which are used in further steps. Lexer configuration in the file: spec/mjlexer.flex
2. Syntax Analysis - checking if the tokens from previous phase form the correct grammar configured in the file: spec/mjparser.cup
3. Semantical Analysis - using inherited visit methods from the class VisitorAdaptor, class rs/etf/bg/ac/rs/pp1/SemanticAnalyzer.java checks for semantic errors.
4. Bytecode generating - if none of the previous phases reported any errors, class rs/etf/bg/ac/rs/pp1/CodeGenerator.java generates the bytecode for the VM.

