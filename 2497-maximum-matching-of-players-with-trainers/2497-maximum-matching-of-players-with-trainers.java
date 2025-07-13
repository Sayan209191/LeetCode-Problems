class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = players.length - 1, j = trainers.length - 1;
        int c = 0;
        while(i >= 0 && j >= 0){
            if(players[i] <= trainers[j]){
                j--;
                c++;
            }
            i--;
        }

        return c;
    }
}