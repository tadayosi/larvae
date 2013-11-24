package larvae.antlr.hello;

import org.junit.Test;

public class HelloInterpreterTest {
    @Test
    public void run() {
        String program = "hello Test1\nhello Test2\nhello Test3";
        new HelloInterpreter().run(program);
    }
}
