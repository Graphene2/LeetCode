package 哈希表.time_9_1;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/1 10:30-10:53
 */
class NO_lc299猜数字游戏 {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] arr = new int[10];
        for (int i = 0; i < secret.length(); i++){
            char c = secret.charAt(i);
            char e = guess.charAt(i);
            arr[c - '0']++;
            if (c == e){
                bulls++;
            }
        }
        for (char e: guess.toCharArray()){
            if (arr[e - '0']-- > 0){
                cows++;
            }
        }
        return new String(bulls + "A" + (cows - bulls) + "B");
    }

}
