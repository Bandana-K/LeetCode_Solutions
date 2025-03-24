class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<List<Integer>> mergedMeetings = mergeMeetings(meetings);
        System.out.println(mergedMeetings);
        int meetingDays = 0;
        for(var meeting : mergedMeetings){
            meetingDays += meeting.get(1)-meeting.get(0)+1;
        }

        return days-meetingDays;
    }

    List<List<Integer>> mergeMeetings(int[][] meetings){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> meeting = new ArrayList<>();
        int start = meetings[0][0], end = meetings[0][1];
        for(int i = 1; i<meetings.length; i++){
            if(meetings[i][0] <= end) {
                end = Math.max(end, meetings[i][1]);
            }
            else{
                meeting.add(start);
                meeting.add(end);
                result.add(meeting);
                meeting = new ArrayList<>();
                start = meetings[i][0];
                end = meetings[i][1];
            }
        }
        
        meeting.add(start);
        meeting.add(end);
        result.add(meeting);

        return result;
    }
}