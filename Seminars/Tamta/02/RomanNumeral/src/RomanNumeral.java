public class RomanNumeral {
    // internal representation of RomanNumeral
    private int arabicNumber;
    
    private final static String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final static int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    
    public RomanNumeral(int arabicNumber) {
        if (arabicNumber < 1 || arabicNumber > 3999) {
            throw new IllegalArgumentException("Number out of range");
        }
        this.arabicNumber = arabicNumber;
    }

    public RomanNumeral(String romanNumber) {
        this.arabicNumber = romanToArabic(romanNumber);
    }

    private int romanToArabic(String romanNumber) {
        String roman = romanNumber.toUpperCase();
        int result = 0;

        for (int i = 0; i < roman.length() - 1; i++) {
            char currentCh = roman.charAt(i);
            char nextCh = roman.charAt(i+1);
            int currentNum = letterToNumber(currentCh);
            int nextNum = letterToNumber(nextCh);

            if (currentNum < nextNum) {
                result -= currentNum;
            } else {
                result += currentNum;
            }
        }
        char lastCh = roman.charAt(roman.length() - 1);
        int lastNum = letterToNumber(lastCh);
        result += lastNum;

        if (result < 1 || result > 3999) {
            throw new IllegalArgumentException("Number out of range");
        }
        return result;
    }

    private int letterToNumber(char letter) {
        return switch (letter) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("Invalid letter");
        };
    }

    public int toInt(){
        return arabicNumber;
    }

    // better algorithm (only iterates over `numbers` array once)
    @Override
    public String toString(){
        int number = arabicNumber;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            while (numbers[i] <= number) {
                number -= numbers[i];
                result.append(letters[i]);
            }
        }
        return result.toString();
    }

//    @Override
//    public String toString(){
//        int number = arabicNumber;
//        StringBuilder result = new StringBuilder();
//        while(number > 0){
//            for (int i = 0; i < letters.length; i++) {
//                if(numbers[i] <= number) {
//                    number -= numbers[i];
//                    result.append(letters[i]);
//                    break;
//                }
//            }
//        }
//        return result.toString();
//    }

}
