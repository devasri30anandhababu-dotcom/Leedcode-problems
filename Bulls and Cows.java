class Solution {
    public String getHint(String secret, String guess) {
        int[] secretcount = new int[10];
        int[] guesscount = new int[10];
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < 10; i++) {
            secretcount[i] = 0;
            guesscount[i] = 0;
        }

        for (int j = 0; j < secret.length(); j++) {
            if (secret.charAt(j) == guess.charAt(j)) {
                bulls += 1;
            } else {
                secretcount[secret.charAt(j) - '0'] += 1;
                guesscount[guess.charAt(j) - '0'] += 1;
            }
        }

        for (int p = 0; p < 10; p++) {
            cows += Math.min(secretcount[p], guesscount[p]);
        }

        return bulls + "A" + cows + "B";
    }
}
