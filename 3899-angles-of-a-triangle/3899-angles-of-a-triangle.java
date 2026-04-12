class Solution {
    public double[] internalAngles(int[] sides) {
        int a = sides[0], b = sides[1], c = sides[2];


        if((a+b>c)&&(a+c>b)&&(b+c>a)){
            double A = Math.toDegrees(Math.acos((b*b+c*c-a*a)/(2.0*b*c)));
            double B = Math.toDegrees(Math.acos((a*a+c*c-b*b)/(2.0*a*c)));
            double C = Math.toDegrees(Math.acos((a*a+b*b-c*c)/(2.0*a*b)));
            double[] ans = {A,B,C};
            Arrays.sort(ans);
            return ans;
        }

        return new double[0];
    }
}