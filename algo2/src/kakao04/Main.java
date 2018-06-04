package kakao04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author : hoTire
 * @comment : Kakao, 방금그곡
 */
class MusicInfo implements Comparable<MusicInfo> {
    int time;
    String name;
    String music;
    String[][] filter = new String[][]{{"C#","c"},{"D#","d"}, {"F#","f"},{"G#","g"},{"A#","a"}}; 

    MusicInfo (int time, String name, String music) {
        if (time  < music.length()) {
            this.music = music.substring(0,time);
        } else if (time > music.length()) {
            StringBuilder sb = new StringBuilder(music);
            int length = time - music.length(); 
            for (int i = 0; i < length / music.length(); i++ ) sb.append(music);
            sb.append(music.substring(0,length % music.length()));
            this.music = sb.toString();
        } else {
            this.music = music;
        }
        setMusic(this.music);
        this.name = name;
        this.time = time;
    }

    private void setMusic(String music) {
    	for (String[] f : filter) {
    		this.music.replaceAll(f[0], f[1]);
    	}
    }
    
    public int compareTo(MusicInfo o) {
    	return o.time - time;
    }
    public boolean serachMusic(String m) {
    	return music.indexOf(m) > -1;
    }

}

public class Main {
	
	public static Object[] sort(Object[] file) {
		Queue<Object[]> q = new LinkedList<Object[]>();
		for (int i = 0; i < file.length; i++) q.add(new Object[]{file[i]});
		
		while (q.size() > 1) {
			Object[] left = q.poll();
			Object[] right = q.poll();
			q.add(merge(left,right));
		}
		return q.poll();
	}
	public static Object[] merge(Object[] x, Object[] y) {
		int left,right,count,leftEnd,rightEnd;
		left = right = count = 0;
		leftEnd = x.length;
		rightEnd = y.length;
		Object[] tmp = new Object[leftEnd + rightEnd];
		
		while (left < leftEnd && right < rightEnd) {
			if (((Comparable)x[left]).compareTo(y[right]) <= 0) tmp[count++] = x[left++];
			else tmp[count++] = y[right++];
		}
		while (left < leftEnd) tmp[count++] = x[left++];
		while (right < rightEnd) tmp[count++] = y[right++];
		return tmp;
	}
	
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String m = scanner.next();
		int n = scanner.nextInt();
		
		List<MusicInfo> list = new ArrayList<MusicInfo>();
		for (int i = 0; i < n; i++) {
			String[] musicinfos = scanner.next().split(",");
			String[] startTime = musicinfos[0].split(":");
			String[] endTime = musicinfos[1].split(":");
			
			int hour = Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0]);
			int minute = Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]);
			minute = hour >= 1 ? minute + hour * 60 : minute ;
			
			MusicInfo musicinfo = new MusicInfo(minute,musicinfos[2],musicinfos[3]);
			if (musicinfo.serachMusic(m)) list.add(musicinfo);
		}
		
		if (list.size() == 0) {
			System.out.println("none");
		} else {
			Object[] obj = sort(list.toArray());
			System.out.println(((MusicInfo)obj[0]).name);
		}
		scanner.close();
	}
}
