package larvae.antlr.hello;

import org.junit.Test;

public class HelloASTInterpreterTest {
  @Test
  public void run() {
    String program = "hello Test1\nhello Test2\nhello Test3";
    new HelloASTInterpreter().run(program);
  }
}
