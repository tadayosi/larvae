package larvae.antlr.hello;

import static larvae.antlr.hello.HelloASTParser.*;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public class HelloASTInterpreter {
  public void run(String program) {
    CommonTree ast = parse(program);
    for (Object child : ast.getChildren()) {
      CommonTree childAst = (CommonTree) child;
      switch (childAst.getToken().getType()) {
      case Hello:
        hello(childAst);
        break;
      default:
        break;
      }
    }
  }

  private void hello(CommonTree hello) {
    System.out.println("Hello, " + hello.getChild(0) + "!");
  }

  private CommonTree parse(String program) {
    HelloASTLexer lexer = new HelloASTLexer(new ANTLRStringStream(program));
    HelloASTParser parser = new HelloASTParser(new CommonTokenStream(lexer));
    try {
      return (CommonTree) parser.program().getTree();
    } catch (RecognitionException e) {
      throw new RuntimeException(e);
    }
  }
}
