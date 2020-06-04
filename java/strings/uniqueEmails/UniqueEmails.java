package strings.uniqueEmails;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {
    
    public String[] findUniqueEmails(String[] emails){

        if(emails == null || emails.length == 0) return new String[]{};
        
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            //Apply rules.
            int splitPosition = email.indexOf("@");
            String localName = email.substring(0, splitPosition);
            String domainName = email.substring(splitPosition);
            int indexOfPlus = localName.indexOf("+");
            if(indexOfPlus >= 0){
                localName = localName.substring(0, indexOfPlus);
            }
            localName = localName.replaceAll("\\.", "");
            String uniqueEmail = localName + domainName;
            uniqueEmails.add(uniqueEmail);
        }

        return uniqueEmails.toArray(new String[]{});
    }

    public static void main(String[] args) {
        
        System.out.println("Unique Emails solution.");
        UniqueEmails uniqueEmails = new UniqueEmails();
        String[] emailList = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "test.e.mail+alex@lee.tcode.com"};
        String[] emails =  uniqueEmails.findUniqueEmails(emailList);
        for (String email : emails) {
            System.out.println(email);
        }
    }
}