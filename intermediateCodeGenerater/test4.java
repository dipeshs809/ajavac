package cs502;

public class test4 {
    public static void main(String[] args) {
        A obj;
        int ans;
        int t1;

        obj = new A();
        t1 = 3;

        ans = obj.foo();
        System.out.println(ans);
        obj.x = t1;
        ans = obj.x;
        System.out.println(ans);
        ans = obj.baz(8);
        System.out.println(ans);

        t1 = 5;
        obj.y = t1;
        ans = obj.priyam(obj);
        System.out.println(ans);
    }
}

class A {
    int x;
    int y;

    public int foo() {
        int x;
        x = 5;
        return x;
    }

    public int bar() {
        return x;
    }

    public int baz(int x) {
        return x;
    }

    public int priyam(A obj) {
        int ans;
        ans = obj.y;
        return ans;
    }
}
