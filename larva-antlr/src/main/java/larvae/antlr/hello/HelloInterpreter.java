package larvae.antlr.hello;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

public class HelloInterpreter {
  public void run(String program) {
    try {
      HelloLexer lexer = new HelloLexer(new ANTLRStringStream(program));
      HelloParser parser = new HelloParser(new CommonTokenStream(lexer));
      parser.program();
    } catch (RecognitionException e) {
      throw new RuntimeException(e);
    }
  }
}
