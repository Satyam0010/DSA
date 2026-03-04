class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int start;
        int end ;
        for(int i =0;i < image.length;i++){
            start = 0;
            end = image.length-1;
            while(start < end){
                int temp = image[i][start];
                image[i][start]=image[i][end];
                image[i][end] = temp;
                start += 1;
                end -= 1;
            }
            for(int j = 0; j < image.length; j++){
                if(image[i][j]==0){
                    image[i][j]=1;
                } else{
                    image[i][j]=0;
                }
            }
        }
        return image;
    }
}