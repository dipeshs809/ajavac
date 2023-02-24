// passing boolean params
/*2*/
class TC23 {
    public static void main(String[] args) {
        J j;

        boolean b3;
        boolean b4;
        boolean b5;
        boolean b6;
        boolean b7;
        boolean b8;
        int x;

        j = new J();
        b3 = true;
        b4 = true;
        b5 = true;
        b6 = false;
        b7 = false;
        b8 = false;
        b7 = true;
        b8 = true;

        x = j.m3(b5, b6, b7, b8, b3, b4);
        System.out.println(x);

    }
}

class J {
    public int m3(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f) {
        K k;
        int x;
        int rt;

        k = new K();
        x = 0;
        rt = 0;

        x = k.m1(a, b);
        rt = rt + x;
        x = k.m2(c, d);
        rt = rt + x;
        x = k.m3(e, f);
        rt = rt + x;
        return rt;
    }

}

class K {

    public int m1(boolean a, boolean b) {
        boolean y;
        int rt;
        y = a && b;
        if (y) {
            rt = 2;
        } else {
            rt = 1;
        }
        System.out.println(rt);
        return rt;
    }

    public int m2(boolean a, boolean b) {
        boolean y;
        boolean zx;
        int x;
        x = 5;
        zx = a != b;
        if (zx) {
            y = true;
            x = 4;
        } else {
            y = false;
            x = 2;
        }
        System.out.println(y);

        return x;
    }

    public int m3(boolean a, boolean b) {
        boolean y;
        int rt;
        y = a && b;
        if (y) {
            rt = 6;
        } else {
            rt = 3;
        }
        System.out.println(rt);
        return rt;
    }
}
