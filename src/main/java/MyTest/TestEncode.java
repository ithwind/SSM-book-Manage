package MyTest;


import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestEncode {
    @Test
    public void test1(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newCode = encoder.encode("123456");
        System.out.println(newCode);
        System.out.println(encoder.matches("123456", newCode));
    }
}
