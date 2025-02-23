// Leetcode : 273 , Integer To English Words

class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        int count = 0;
        String word = "";
        while(num > 0){
            if(num % 1000 != 0){
                word = convert(num % 1000) + thousands[count] + " " + word;   
            }
            num = num / 1000;
            count++;
        }
        return word.trim();
    }
    
    private String convert(int num){
        if(num == 0){
            return "";
        }
        
        if(num < 20){
            return below_20[num] + " ";
        }else if(num < 100){
            return tens[num/10] + " " + convert(num%10);
        }else {
            return below_20[num/100] + " Hundred " + convert(num%100);
        }
    }
}