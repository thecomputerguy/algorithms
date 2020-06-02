package strings.jewelsandstones;

public class JewelsAndStones {
    
    public int countStonesWhichAreAlsoJewels(String jewels, String stones){
        if(stones == null || jewels == null || stones.isEmpty() || jewels.isEmpty()) return 0;
        int counter = 0;
        for (int i = 0; i < stones.length(); i++) {
            if(jewels.indexOf(stones.charAt(i)) >= 0){
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        String jewels = "aA";
        String stones = "aAAbbbb";
        int count = jewelsAndStones.countStonesWhichAreAlsoJewels(jewels, stones);
        System.out.println("stones which are also jewels are " + count);
    }
}