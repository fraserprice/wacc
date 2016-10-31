parser grammar WACCParser;

options {
  tokenVocab = WACCLexer;
}

// EOF indicates that the program must consume to the end of the input.
program: BEGIN_STAT func* stat END_STAT EOF;

func: BEGIN_STAT;

stat: END_STAT;