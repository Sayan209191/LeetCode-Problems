class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int st=0;int end=0;
        int res = 0;
        for (end = 0; end < fruits.length; end++) {
            basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);
            while(basket.size() > 2) {
                basket.put(fruits[st], basket.get(fruits[st]) - 1);
                basket.remove(fruits[st], 0);
                st++;
            }
            res = Math.max(res, end - st + 1);
        }
        return res;
    }
}