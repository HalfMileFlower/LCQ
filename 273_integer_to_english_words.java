class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        long target = num;
        String result = "";
        if (num < 0) {
            target = -target;
            result += "Minus ";
        }
        
        int[] sections = new int[4];
        for (int i = 3; i >= 0; i--) {
            sections[i] = (int)(target % 1000);
            target /= 1000;
        }
        
        for (int i = 0; i < 4; i++) {
            String sectionString = transform(sections[i], i);
            if (sectionString.length() == 0) {
                continue;
            }
            result += transform(sections[i], i) + " ";
        }
        
        return result.trim();
    }
    
    private String transform(int num, int section) {
        if (num == 0) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        String[] digits = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] teens = new String[] {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        // start from the hundred digit
        int hundred = num / 100;
        result.append(digits[hundred]);
        if (hundred != 0) {
            result.append(" Hundred");
        }
        
        // handle the left
        int left = num % 100;
        if (left != 0) {
            result.append(" ");
        }
        if (left > 0 && left < 10) {
            // // add "and" ?
            // if (hundred != 0) {
            //     result.append("and ");
            // }
            result.append(digits[left]);
        } else if (left > 10 && left < 20) {
            result.append(teens[left - 10]);
        } else {
            int digit = left % 10;
            int ten = left / 10;
            result.append(tens[ten]);
            if (digit != 0) {
                result.append(" ");
            }
            result.append(digits[digit]);
        }
        
        if (section == 0) {
            result.append(" " + "Billion");
        } else if (section == 1) {
            result.append(" " + "Million");
        } else if (section == 2) {
            result.append(" " + "Thousand");
        }
        
        return result.toString().trim();
    }
}

// Notes: remember the minus condition in follow up
// 4 sections: billion, million, thousand and the left
// trim()
// TC: O(n) - n is the number of digits in num 
// SC: O(1) (not include the dictionaries) - just the section array
