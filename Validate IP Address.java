class Solution {
    public String validIPAddress(String queryIP) {
        int len = queryIP.length();
        int ind = 0;
        while(ind < len && queryIP.charAt(ind) != '.' && queryIP.charAt(ind) != ':') {
            if(ind+1 > 4) return "Neither";
            ind++;
        }
        if(ind == 0) return "Neither";

        String[] arr;
        if(queryIP.charAt(ind) == '.') {
            if(queryIP.charAt(len-1) == '.') return "Neither";
            
            arr = queryIP.split("\\.");
            if(arr.length != 4) return "Neither";

            if(checkIP4Valid(arr)) return "IPv4";
        }
        else{
            if(queryIP.charAt(len-1) == ':') return "Neither";
            
            arr = queryIP.split(":");
            System.out.println(arr.length+" len ");
            if(arr.length != 8) return "Neither";

            if(checkIP6Valid(arr)) return "IPv6";
        }

        return "Neither";
    }

    public boolean checkIP4Valid(String[] arr){

        for(String ele: arr){
            int len = ele.length();
            if(ele.isEmpty() || len > 3) return false;
            if(len > 1 && ele.charAt(0) == '0') return false;

            int mul = 0;
            for(int i = 0;i < len;i++){
                char ch = ele.charAt(i);
                if(!Character.isDigit(ch)) return false;

                mul *= 10;
                mul += ch - '0';
            }

            if(mul < 0 || mul > 255) return false;
        }

        return true;
    }

    public boolean checkIP6Valid(String[] arr){

        for(String ele: arr){
            int len = ele.length();
            if(ele.isEmpty() || len > 4) return false;

            for(int i = 0;i < len;i++){
                char ch = ele.charAt(i);
                if(!Character.isDigit(ch) && !Character.isAlphabetic(ch)) return false;
                if(Character.isAlphabetic(ch)) {
                    if(Character.isUpperCase(ch) && (ch < 'A' || ch > 'F')) return false;
                    if(Character.isLowerCase(ch) && (ch < 'a' || ch > 'f')) return false;
                }
            }
        }
        return true;
    }
}
