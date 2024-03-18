public class RationalNumber {
    private int numerator;
    private int denominator;

    // Abstraction Function: represents the rational number numerator / denominator

    // invariant: gcd(numerator, denominator) = 1
    // invariant: denominator > 0

    /**
     * Make a new RationalNumber == (n / d).
     * @param numerator n
     * @param denominator d
     * @throws IllegalArgumentException if d == 0
     */
    public RationalNumber(int numerator, int denominator){
        if(denominator == 0) {
            throw new IllegalArgumentException("denominator must never be zero");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    /**
     * Make a new RationalNumber == n
     * @param wholeNum n
     */
    public RationalNumber(int wholeNum){
        this(wholeNum, 1);
    }

    /**
     * Make a new RationalNumber == ratNum. copy constructor
     * მომხმარებელი გამოიყენებს როდესაც სჭირდება ორი იდენტური ობიექტი სხვადასხვა მისამართით.
     * @param rat
     */
    public RationalNumber(RationalNumber rat){
        this(rat.numerator, rat.denominator);
    }

    public RationalNumber add(RationalNumber rat) {
        int num = this.numerator * rat.denominator + this.denominator * rat.numerator;
        int denom = this.denominator * rat.denominator;
        return new RationalNumber(num, denom);
    }

    public RationalNumber multiply(RationalNumber rat) {
        int num =  this.numerator * rat.numerator;
        int denom = this.denominator * rat.denominator;
        return new RationalNumber(num, denom);
    }

    /////////////////////////////////////////
    // other methods should go here
    //    producers: add(), subtract(), multiply(), divide(), etc.
    //    observers: isPositive(), intValue(), etc.
    //    mutators: none

    private int gcd(int a, int b){
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        RationalNumber rat = (RationalNumber) obj;
        return this.numerator == rat.numerator && this.denominator == rat.denominator;
    }

}
