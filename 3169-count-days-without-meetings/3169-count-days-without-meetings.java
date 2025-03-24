class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> mergedMeetings = mergeMeetings(meetings);
        int meetingDays = 0;
        for(var meeting : mergedMeetings){
            meetingDays += meeting[1]-meeting[0]+1;
        }

        return days-meetingDays;
    }

    List<int[]> mergeMeetings(int[][] meetings){
        List<int[]> result = new ArrayList<>();
        int start = meetings[0][0], end = meetings[0][1];
        for(int i = 1; i<meetings.length; i++){
            if(meetings[i][0] <= end) {
                end = Math.max(end, meetings[i][1]);
            }
            else{
                result.add(new int[]{start, end});
                start = meetings[i][0];
                end = meetings[i][1];
            }
        }
        
        result.add(new int[]{start, end});
        return result;
    }
}