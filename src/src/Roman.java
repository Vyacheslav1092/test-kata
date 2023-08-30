import java.util.TreeMap;

public class Roman {
    public static void main(String[] args) {
        Roman roman = new Roman();
    }

    public int getArabInt (char roman) {
        if(roman == 'I') {
            return 1;
        } else if (roman == 'V') {
            return 5;
        } else if (roman == 'X') {
            return 10;
        }
        else if (roman == 'L') {
            return 50;
        } else if (roman == 'C') {
            return 100;
        } else if (roman == 'D') {
            return 500;
        } else if (roman == 'M') {
            return 1000;
        }
        return 0;
    }
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    public Roman() {
        arabianKeyMap.put(1000, "M");
        arabianKeyMap.put(900, "CM");
        arabianKeyMap.put(500, "D");
        arabianKeyMap.put(400, "CD");
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
        arabianKeyMap.put(0, "0");
    }

    public int romanToInt(String string) {
        int end = string.length() - 1;
        char[] arr = string.toCharArray();
        int arab;
        int result = getArabInt(arr[end]);
        for(int i = end - 1; i >= 0; i--) {
            arab = getArabInt(arr[i]);

            if(arab < getArabInt(arr[i + 1])) {
                result -= arab;
            } else {
                result += arab;
            }
        }
        return result;
    }

    public String intToRoman(int number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabianKeyMap.floorKey((number));
            roman += arabianKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return roman;
    }

    public boolean isRoman(String string) {
        if(string.contains("I")) {
            return true;
        } else if (string.contains("V")) {
            return true;
        } else if (string.contains("X")) {
            return true;
        } else if (string.contains("XL")) {
            return true;
        } else if (string.contains("L")) {
            return true;
        } else if (string.contains("XC")) {
            return true;
        } else if (string.contains("C")) {
            return true;
        } else {
            return false;
        }
    }
}
