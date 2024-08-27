import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
    BOJ 1931
    java 11 / 44912 KB / 504 ms
 */
public class Main {

    static class MeetingRoom {
        int startTime;
        int endTime;

        public MeetingRoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        MeetingRoom[] meetingRooms = new MeetingRoom[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetingRooms[i] = new MeetingRoom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetingRooms, new Comparator<MeetingRoom>() {
            @Override
            public int compare(MeetingRoom o1, MeetingRoom o2) {
                if (o1.endTime == o2.endTime) {
                    return o1.startTime - o2.startTime;
                }

                return o1.endTime - o2.endTime;
            }
        });

        int count = 0, prevMeetingEndTime = 0;
        for (int i = 0; i < N; i++) {
            if (prevMeetingEndTime <= meetingRooms[i].startTime) {
                prevMeetingEndTime = meetingRooms[i].endTime;
                count++;
            }
        }

        System.out.print(count);
    }
}
