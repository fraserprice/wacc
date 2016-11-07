/**
 * Created by Mihai on 05/11/2016.
 */
public class B extends A {
    int x;

    public B(int x) {
        super();
        this.x = x;
    }

    @Override
    public void func() {
        System.out.println(x);
    }
}
