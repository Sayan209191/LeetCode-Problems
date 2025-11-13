class Solution {
    public int maxOperations(String s) {
        int operCnt = 0;
        int onesCnt = 0;
        boolean hasPreviousOne = false;
        List<Integer> list = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                list.add(1);
                hasPreviousOne = true;
            } else if (ch == '0' && hasPreviousOne) {
                list.add(0);
                hasPreviousOne = false;
            }
        }

        for (int ch : list) {
            if (ch == 1) {
                onesCnt++;
            } else {
                operCnt += onesCnt;
            }
        }

        return operCnt;
    }
}