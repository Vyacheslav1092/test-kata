import java.util.Scanner;

public class Main {
    public static String calc(String input) {
        Calculate calc = new Calculate(input);
        return calc.getResult();
    }
    public static void main(String[] args) {
        String inData;
        System.out.println("Программа калькулятор включена. Введитите в строчку пример для его решения");
        Scanner scanner = new Scanner(System.in);

        inData = scanner.nextLine();

        System.out.println(calc(inData));
    }
}

class Calculate {
    private String string;
    private String result;

    public Calculate(String string) {
        this.string = string;

        try {
            if(this.string.contains("+")) {
                Summ summ = new Summ(this.string);
                this.result = summ.getResult();
            } else if (this.string.contains("-")) {
                Difference difference = new Difference(this.string);
                this.result = difference.getResult();
            } else if (this.string.contains("*")) {
                Multiplication multiplication = new Multiplication(this.string);
                this.result = multiplication.getResult();
            } else if (this.string.contains("/")) {
                Division division = new Division(this.string);
                this.result = division.getResult();
            }
        } catch (Exception e) {
            System.out.println("Арифметическая операция не была проведена, знак между числами введен не корректно");
        }
    }
    public String getResult() {
        return result;
    }
}

class Summ {
    private String str;
    private int a;
    private int b;
    private int result;
    private  String resultRoman;
    public Summ(String str) throws Exception {
        this.str = str;
        calculateSum();
    }
    private void calculateSum() throws Exception {
        String[] split = this.str.split("\\+");

        if(split.length > 2) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            NaturalInt naturalInt = new NaturalInt(split[0].trim(), split[1].trim());

            if(naturalInt.isValidRoman()) {
                Roman roman = new Roman();
                this.a = roman.romanToInt(split[0].trim());
                this.b = roman.romanToInt(split[1].trim());
                this.result = this.a + this.b;
                this.resultRoman = roman.intToRoman(this.result);
            }

            if (naturalInt.isValid()) {
                this.a = Integer.parseInt(split[0].trim());
                this.b = Integer.parseInt(split[1].trim());
                this.result = this.a + this.b;
            }
        }
    }
    public String getResult() {
        if(this.result == 0) {
            return "Ошибка! Разрешен ввод только целых чисел";
        }

        NaturalInt naturalInt = new NaturalInt(String.valueOf(this.a), String.valueOf(this.b));
        if(this.resultRoman != null) {
            return "Сумма чисел равна " + this.resultRoman;
        }
        if(naturalInt.isValid()) {
            return "Сумма чисел равна " + this.result;
        }

        return "Ошибка: не смогли определить формат чисел или произошла иная ошибка";
    }
}
class Difference {
    private String str;
    private int a;
    private int b;
    private int result;
    private String resultRoman;
    public Difference(String str) throws Exception {
        this.str = str;
        calculateDifference();
    }
    private void calculateDifference() throws Exception {
        String[] split = this.str.split("-");

        if(split.length > 2) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            NaturalInt naturalInt = new NaturalInt(split[0].trim(), split[1].trim());

            if (naturalInt.isValidRoman()) {
                Roman roman = new Roman();
                this.a = roman.romanToInt(split[0].trim());
                this.b = roman.romanToInt(split[1].trim());
                this.result = this.a - this.b;
                if (this.result < 0) {
                    throw new Exception("В римской системе исчисления нет отрицательных чисел");
                } else {
                    this.resultRoman = roman.intToRoman(this.result);
                }
            }

            if (naturalInt.isValid()) {
                this.a = Integer.parseInt(split[0].trim());
                this.b = Integer.parseInt(split[1].trim());
                this.result = this.a - this.b;
//                System.out.println("Разность чисел равно " + this.result);
            }
        }
    }

    public String getResult() {
        if(this.result == 0) {
            return "Ошибка: результат не был посчитан";
        }

        NaturalInt naturalInt = new NaturalInt(String.valueOf(this.a), String.valueOf(this.b));
        if(this.resultRoman != null) {
            return "Разность чисел равна " + this.resultRoman;
        }
        if(naturalInt.isValid()) {
            return "Разность чисел равна " + this.result;
        }

        return "Ошибка: не смогли определить формат чисел или произошла иная ошибка";
    }
}

class Multiplication {
    private String str;
    private int a;
    private int b;
    private int result;
    private String resultRoman;
    public Multiplication(String str) throws Exception {
        this.str = str;
        calculateMultiplication();
    }

    private void calculateMultiplication() throws Exception {
        String[] split = this.str.split("\\*");

        if(split.length > 2) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            NaturalInt naturalInt = new NaturalInt(split[0].trim(), split[1].trim());
            if (naturalInt.isValidRoman()) {
                Roman roman = new Roman();
                this.a = roman.romanToInt(split[0].trim());
                this.b = roman.romanToInt(split[1].trim());
                this.result = this.a * this.b;
                this.resultRoman = roman.intToRoman(this.result);
//                System.out.println("Произведение чисел равно " + roman.intToRoman(this.result));
            }

            if (naturalInt.isValid()) {
                this.a = Integer.parseInt(split[0].trim());
                this.b = Integer.parseInt(split[1].trim());
                this.result = this.a * this.b;
//                System.out.println("Произведение чисел равно " + this.result);
            }
        }
    }

    public String getResult() {
        if(this.result == 0) {
            return "Ошибка: результат не был посчитан";
        }

        NaturalInt naturalInt = new NaturalInt(String.valueOf(this.a), String.valueOf(this.b));
        if(this.resultRoman != null) {
            return "Произведение чисел равно " + this.resultRoman;
        }
        if(naturalInt.isValid()) {
            return "Произведение чисел равно " + this.result;
        }

        return "Ошибка: не смогли определить формат чисел или произошла иная ошибка";
    }
}

class Division {
    private String str;
    private int a;
    private int b;
    private int result;
    private String resultRoman;
    public Division(String str) throws Exception {
        this.str = str;
        calculateDivision();
    }

    private void calculateDivision() throws Exception {
        String[] split = this.str.split("/");
        if(split.length > 2) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            NaturalInt naturalInt = new NaturalInt(split[0].trim(), split[1].trim());
            if (naturalInt.isValidRoman()) {
                Roman roman = new Roman();
                this.a = roman.romanToInt(split[0].trim());
                this.b = roman.romanToInt(split[1].trim());
                this.result = this.a / this.b;
                if (this.result < 0) {
                    throw new Exception("В римской системе исчисления нет отрицательных чисел");
                } else {
                    this.resultRoman = roman.intToRoman(this.result);
                }
            }

            if (naturalInt.isValid()) {
                this.a = Integer.parseInt(split[0].trim());
                this.b = Integer.parseInt(split[1].trim());
                this.result = this.a / this.b;
                System.out.println("Частное чисел равно " + this.result);
            }
        }
    }
    public String getResult() {
        if(this.result == 0) {
            return "Ошибка: результат не был посчитан";
        }

        NaturalInt naturalInt = new NaturalInt(String.valueOf(this.a), String.valueOf(this.b));
        if(this.resultRoman != null) {
            return "Частное чисел равно " + this.resultRoman;
        }
        if(naturalInt.isValid()) {
            return "Частное чисел равно " + this.result;
        }

        return "Ошибка: не смогли определить формат чисел или произошла иная ошибка";
    }
}

class NaturalInt {
    private int firstNum;
    private int secondNum;
    private boolean valid;
    private boolean validRoman;
    public NaturalInt(String firstNum, String secondNum) {
        Roman roman = new Roman();
        if(roman.isRoman(firstNum) && roman.isRoman(secondNum)) {
            this.firstNum = roman.romanToInt(firstNum);
            this.secondNum = roman.romanToInt(secondNum);
            this.validRoman = true;

            try {
                if(this.firstNum > 10) {
                    this.validRoman = false;
                }
            } catch (Exception e) {
                System.out.println("Огогошеньки первое число более 10 =( такого быть не должно");
            }
            try {
                if(this.secondNum > 10) {
                    this.validRoman = false;
                }
            } catch (Exception e) {
                System.out.println("Огогошеньки второе число более 10 =( такого быть не должно");
            }

        } else if (isInteger(firstNum) && isInteger(secondNum)) {
            this.firstNum = Integer.parseInt(firstNum);
            this.secondNum = Integer.parseInt(secondNum);
            this.valid = true;

            try {
                if(this.firstNum > 10) {
                    this.valid = false;
                }
            } catch (Exception e) {
                System.out.println("Огогошеньки первое число более 10 =( такого быть не должно");
            }
            try {
                if(this.secondNum > 10) {
                    this.valid = false;
                }
            } catch (Exception e) {
                System.out.println("Огогошеньки второе число более 10 =( такого быть не должно");
            }
        }
//        else {
//            System.out.println("Ошибка! Разрешен ввод только целых чисел");
//            this.valid = false;
//        }
    }
    public boolean isValid() {
        return this.valid;
    }
    public boolean isValidRoman() {
        return this.validRoman;
    }
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}