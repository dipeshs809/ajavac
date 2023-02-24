
/*1*/
import static a5.Memory.*;

class TC21 {
    public static void main(String[] a) {
        Object r0;
        alloca(1);
        store(0, new Fac());
        r0 = 10;
        r0 = ((Fac) load(0)).ComputeFac(((int) r0));
        System.out.println(((int) r0));
    }
}

class Fac {
    public int ComputeFac(int num) {
        Object r0;
        alloca(1);
        r0 = 0;
        r0 = num <= ((int) r0);
        if (((boolean) r0)) {
            r0 = 1;
            r0 = ((int) r0);
        } else {
            store(0, new Fac());
            r0 = 1;
            r0 = num - ((int) r0);
            r0 = ((Fac) load(0)).ComputeFac(((int) r0));
            r0 = num * ((int) r0);
            r0 = ((int) r0);
        }
        return ((int) r0);
    }
}
