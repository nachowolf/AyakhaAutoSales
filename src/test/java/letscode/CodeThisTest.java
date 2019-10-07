package letscode;

import org.junit.jupiter.api.Test;

import static letscode.CodeThis.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CodeThisTest {


    @Test
    public void shouldGreet() {
        assertEquals("Hello, Joe", greet("Joe"));
    }
}
