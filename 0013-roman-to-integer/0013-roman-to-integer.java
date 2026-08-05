class Solution {
    public int number(char c){
        if(c == 'I'){
            return 1;
        }else if(c == 'V'){
            return 5;
        }else if(c == 'X'){
            return 10;
        }else if(c == 'L'){
            return 50;
        }else if(c == 'C'){
            return 100;
        }else if(c == 'D'){
            return 500;
        }else if(c == 'M'){
            return 1000;
        }
        return 0;
    }
    public int romanToInt(String s) {
        int index = 0 ;
        int n = s.length() - 1;
        int sum = 0;
        while(index < n){
            if(number(s.charAt(index)) < number(s.charAt(index + 1))){
                sum -= number(s.charAt(index));
            }else{
                sum += number(s.charAt(index));
            }
            index++;
        }
        sum += number(s.charAt(index));
        return sum;
    }
}