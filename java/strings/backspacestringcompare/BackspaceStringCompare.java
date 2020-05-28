package strings.backspacestringcompare;

public class BackspaceStringCompare {
    
    public boolean compareString(String s, String t){

        int sPointer = s.length()-1;
        int tPointer = t.length()-1;
        int sSkips = 0;
        int tSkips = 0;

        while(sPointer >= 0 || tPointer >= 0){

            //skip over characters that are not needed in string s.
            while(sPointer >= 0){
                if(s.charAt(sPointer) == '#'){
                    sSkips++;
                    sPointer--;
                }else if(sSkips > 0){
                    sSkips--;
                    sPointer--;
                }else{
                    break;
                }
            }

            //skip over characters that are not needed in string t.
            while(tPointer >= 0){

                if(t.charAt(tPointer) == '#'){
                    tSkips++;
                    tPointer--;
                }else if(tSkips > 0){
                    tSkips--;
                    tPointer--;
                }else{
                    break;
                }
            }

            if(tPointer >= 0 && sPointer >= 0 && s.charAt(sPointer) != t.charAt(tPointer)){
                return false;
            }

            if((sPointer >= 0) != (tPointer >= 0)){
                return false;
            }

            sPointer--;
            tPointer--;
        }

        return true;
    }

    public static void main(String[] args) {
        
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        System.out.println("String comparision after removal characters of backspace solution.");
        System.out.println("# represents backspace in text editor and the character before # is removed.");
        boolean first  = backspaceStringCompare.compareString("hel#lo", "helo");
        System.out.println("String are equal ? " + first);
        System.out.println("# represents backspace in text editor and the character before # is removed.");
        boolean second  = backspaceStringCompare.compareString("buff##alo", "bu#ffa#lo");
        System.out.println("String are equal ? " + second);
    }
}