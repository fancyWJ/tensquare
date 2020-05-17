import java.util.ArrayList;
import java.util.List;

public class test {
    private  byte[] brArr =  new byte[1000];
    //测试 oom
    public static void main(String[] args) {
        List<test> list = new ArrayList<>();
        while (true)
           list.add(new test());
        }
}
