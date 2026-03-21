class Solution {
    public String toHex(int num) {
        String ans = "";
        if(num==0){
            return "0";
        }
        else if(num > 0){
           ans = convert(num);
        }
        else if(num < 0){
            ans = negative(num);
        }
        return ans;
    }


    String convert(int num){

        String ans = "";

         while(num > 0){
                int rem = num%16;
                if(rem >= 0 && rem < 10){
                    ans = rem+ans;
                }
                else if(rem == 10){
                    ans = "a"+ans;
                }
                else if(rem == 11){
                    ans = "b"+ans;
                }
                else if(rem == 12){
                    ans = "c"+ans;
                }
                else if(rem == 13){
                    ans = "d"+ans;
                }
                else if(rem == 14){
                    ans = "e"+ans;
                }
                else if(rem == 15){
                    ans = "f"+ans;
                }

                num /= 16;
            }

            return ans;
    }


    String negative(int num){
        long uv = (long)num + (1L <<32);

         String ans = "";

         while(uv > 0){
                int rem = (int)(uv%16);
                if(rem >= 0 && rem < 10){
                    ans = rem + ans;
                }
                else if(rem == 10){
                    ans = "a"+ans;
                }
                else if(rem == 11){
                    ans = "b"+ans;
                }
                else if(rem == 12){
                    ans = "c"+ans;
                }
                else if(rem == 13){
                    ans = "d"+ans;
                }
                else if(rem == 14){
                    ans = "e"+ans;
                }
                else if(rem == 15){
                    ans = "f"+ans;
                }

                uv /= 16;
            }

            return ans;
    }
}