package twopointers.comparingstringscontainingbackspaces;

public class ComparingStringsContainingBackspaces {

    public static boolean compare(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int ind1 = getNextValidIndex(str1, index1);
            int ind2 = getNextValidIndex(str2, index2);
            if (ind1 < 0 && ind2 < 0) {
                return true;
            }
            if (ind1 < 0 || ind2 < 0) {
                return false;
            }
            if (str1.charAt(ind1) != str2.charAt(ind2))
                return false;
            index1 = ind1 - 1;
            index2 = ind2 - 1;
        }
        return true;
    }

    public static int getNextValidIndex(String str, int index) {
        int backSpaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                backSpaceCount++;
            } else if (backSpaceCount > 0) {
                backSpaceCount--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        String str1 = "xywrrmp";
        String str2 = "xywrrmu#p";
        boolean result = compare(str1, str2);
        System.out.println("Two strings are equal ? " + result);

        String str3 = "xy#z";
        String str4 = "xyz#";
        boolean result1 = compare(str3, str4);
        System.out.println("Two strings are equal ? " + result1);
    }

}