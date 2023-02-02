package jenkovtests;

public class TestClass {
    public int a;
    public String j;
    public Object o;
    public Main m = new Main();

    public TestClass(int a) {
        this.a = a;
    }

    public int play(String s, Class<? extends Number> n){
        n = Integer.class;
        return Integer.parseInt(s);
    };

    public void setA(int a) {
        this.a = a;
    }
    public int setloh(int a) {
        this.a = a;
        return 5;
    }

    public void setJ(String j) {
        this.j = j;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public void setM(Main m) {
        this.m = m;
    }

    public int getA() {
        return a;
    }

    public String getJ() {
        return j;
    }

    public Object getO() {
        return o;
    }

    public Main getM() {
        return m;
    }
    public Main getM(int e) {
        return m;
    }
    public void getpis(int e) {
    }
}
