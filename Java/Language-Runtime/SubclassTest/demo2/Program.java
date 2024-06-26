class Program {

    public static void main(String[] args) {
        //type inference for local variable (var = Interval)
        var a = new Interval(5, 30);
        var b = new Interval(3, 5);
        var c = new Interval(4, 90);
        var d = b;
        System.out.printf("Interval a = %s%n", a.toString());
        System.out.printf("Interval b = %s%n", b);
        System.out.printf("Interval c = %s%n", c);
        System.out.printf("Interval d = %s%n", d);
        System.out.println("-----------------------------");
        System.out.printf("a is identical to b: %b%n", a == b);
        System.out.printf("a is identical to c: %b%n", a == c);
        System.out.printf("d is identical to b: %b%n", d == b);
        System.out.println("-----------------------------");
        System.out.printf("a is equal to b: %b%n", a.hashCode() == b.hashCode() && a.equals(b));
        System.out.printf("a is equal to c: %b%n", a.hashCode() == c.hashCode() && a.equals(c));
        System.out.printf("d is equal to b: %b%n", d.hashCode() == b.hashCode() && d.equals(b));
    }
}