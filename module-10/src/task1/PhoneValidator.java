package task1;

import java.util.List;

public class PhoneValidator implements Validatable {

    @Override
    public boolean isValid(String value) {
        return validateLongPhone(value) || validateShortPhone(value);
    }

    private static boolean validateLongPhone(String phone) {
        if (phone.length() != 14) {
            return false;
        }

        char[] chars = phone.toCharArray();
        List<Integer> skipIndex = List.of(0,4,5,9);

        boolean isPhoneCodeStartsWithBracket = Character.toString(chars[0]).equals("(");
        boolean isPhoneCodeEndsWithBracket = Character.toString(chars[4]).equals(")");
        boolean hasSpace = Character.toString(chars[5]).equals(" ");
        boolean hasDash= Character.toString(chars[9]).equals("-");

        if (!isPhoneCodeStartsWithBracket || !isPhoneCodeEndsWithBracket || !hasSpace || !hasDash) {
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            if (skipIndex.contains(i)) {
                continue;
            }

            if (!Character.isDigit(chars[i])) {
                return false;
            }
        }

        return true;
    }

    private static boolean validateShortPhone(String phone) {
        if (phone.length() != 12) {
            return false;
        }

        char[] chars = phone.toCharArray();
        List<Integer> skipIndex = List.of(3,7);

        boolean hasFirstDash= Character.toString(chars[skipIndex.get(0)]).equals("-");
        boolean hasSecondDash= Character.toString(chars[skipIndex.get(1)]).equals("-");

        if (!hasFirstDash || !hasSecondDash) {
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            if (skipIndex.contains(i)) {
                continue;
            }

            if (!Character.isDigit(chars[i])) {
                return false;
            }
        }

        return true;
    }
}
