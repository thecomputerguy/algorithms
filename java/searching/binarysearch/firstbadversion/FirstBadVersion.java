package searching.binarysearch.firstbadversion;

public class FirstBadVersion {
    
    public int firstBadVersion(int n){
        
        int left = 0;
        int right = n;

        while(left < right){
            int mid = left + (right-left/2);
            //if it's a bad version, then check for the first bad version on the left.
            if(isBadVersion(mid)){
                right = mid;
            }else{ // we have not found a bad version so far, so move to right to find a bad version.

                left = mid + 1;
            }
        }

        if(left == right && isBadVersion(left)) return left;

        return -1;
    }

    public boolean isBadVersion(int n){
        return true;
    }

    public static void main(String[] args) {
        FirstBadVersion version  = new FirstBadVersion();
        int badVersion = version.firstBadVersion(10);
        System.out.println("First bad version.");
    }
}