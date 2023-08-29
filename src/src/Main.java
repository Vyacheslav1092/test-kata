import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String inData;
        System.out.println("Программа калькулятор включена. Введитите в строчку пример для его решения");
        Scanner scanner = new Scanner(System.in);


        inData = scanner.nextLine();
//        System.out.println(inData);

        new Calculate(inData);
    }
}

class Calculate {
    private String string;

    public Calculate(String string) {
        this.string = string;

        if(this.string.contains("+")) {
            new Summ(this.string);
        } else if (this.string.contains("-")) {
            new Difference(this.string);
        } else if (this.string.contains("*")) {
            new Multiplication(this.string);
        } else if (this.string.contains("/")) {
            new Division(this.string);
        } else {
            System.out.println("Арифметическая операция не была проведена, знак между числами введен не корректно");
        }
    }
}

class Summ {
    private String str;
    private int a;
    private int b;
    private int result;
    public Summ(String str) {
        this.str = str;
        String[] split = this.str.split("\\+");
        if(split.length > 2) {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            NaturalInt naturalInt = new NaturalInt(split[0].trim(), split[1].trim());

            if(naturalInt.isValidRoman()) {
                Roman roman = new Roman();
                this.a = roman.romanToInt(split[0].trim());
                this.b = roman.romanToInt(split[1].trim());
                this.result = this.a + this.b;
                System.out.println("Сумма чисел равна " + roman.intToRoman(this.result));
            }

            if (naturalInt.isValid()) {
                this.a = Integer.parseInt(split[0].trim());
                this.b = Integer.parseInt(split[1].trim());
                this.result = this.a + this.b;
                System.out.println("Сумма чисел равна " + this.result);
            }
        }
    }
}
class Difference {
    private String str;
    private int a;
    private int b;
    private int result;
    public Difference(String str) {
        this.str = str;
        String[] split = this.str.split("-");
        NaturalInt naturalInt = new NaturalInt(split[0].trim(), split[1].trim());
        if(split.length > 2) {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            if (naturalInt.isValidRoman()) {
                Roman roman = new Roman();
                this.a = roman.romanToInt(split[0].trim());
                this.b = roman.romanToInt(split[1].trim());
                this.result = this.a - this.b;
                if (this.result < 0) {
                    System.out.println("В римской системе исчисления нет отрицательных чисел");
                } else {
                    System.out.println("Разность чисел равно " + roman.intToRoman(this.result));
                }
            }

            if (naturalInt.isValid()) {
                this.a = Integer.parseInt(split[0].trim());
                this.b = Integer.parseInt(split[1].trim());
                this.result = this.a - this.b;
                System.out.println("Разность чисел равно " + this.result);
            }
        }
    }
}

class Multiplication {
    private String str;
    private int a;
    private int b;
    private int result;
    public Multiplication(String str) {
        this.str = str;
        String[] split = this.str.split("\\*");
        NaturalInt naturalInt = new NaturalInt(split[0].trim(), split[1].trim());
        if(split.length > 2) {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            if (naturalInt.isValidRoman()) {
                Roman roman = new Roman();
                this.a = roman.romanToInt(split[0].trim());
                this.b = roman.romanToInt(split[1].trim());
                this.result = this.a * this.b;
                System.out.println("Произведение чисел равно " + roman.intToRoman(this.result));
            }

            if (naturalInt.isValid()) {
                this.a = Integer.parseInt(split[0].trim());
                this.b = Integer.parseInt(split[1].trim());
                this.result = this.a * this.b;
                System.out.println("Произведение чисел равно " + this.result);
            }
        }
    }
}

class Division {
    private String str;
    private int a;
    private int b;
    private int result;
    public Division(String str) {
        this.str = str;
        String[] split = this.str.split("/");
        NaturalInt naturalInt = new NaturalInt(split[0].trim(), split[1].trim());
        if(split.length > 2) {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            if (naturalInt.isValidRoman()) {
                Roman roman = new Roman();
                this.a = roman.romanToInt(split[0].trim());
                this.b = roman.romanToInt(split[1].trim());
                this.result = this.a / this.b;
                if (this.result < 0) {
                    System.out.println("В римской системе исчисления нет отрицательных чисел");
                } else {
                    System.out.println("Частное чисел равно " + roman.intToRoman(this.result));
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

            if(this.firstNum > 10) {
                System.out.println("Огогошеньки первое число более 10 =( такого быть не должно");
                this.validRoman = false;
            }
            if(this.secondNum > 10) {
                System.out.println("Огогошеньки второе число более 10 =( такого быть не должно");
                this.validRoman = false;
            }

        } else if (isInteger(firstNum) && isInteger(secondNum)) {
            this.firstNum = Integer.parseInt(firstNum);
            this.secondNum = Integer.parseInt(secondNum);
            this.valid = true;

            if(this.firstNum > 10) {
                System.out.println("Огогошеньки первое число более 10 =( такого быть не должно");
                this.valid = false;
            }
            if(this.secondNum > 10) {
                System.out.println("Огогошеньки второе число более 10 =( такого быть не должно");
                this.valid = false;
            }
        } else {
            System.out.println("Ошибка! Разрешен ввод только целых чисел");
            this.valid = false;
        }
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