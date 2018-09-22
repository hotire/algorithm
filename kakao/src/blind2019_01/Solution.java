package blind2019_01;

import java.util.*;

/**
 * @author : hotire
 */
public class Solution {
    public String[] solution(String[] record) {
        OpenChattingManager openChattingManager = new OpenChattingManager();
        String[] answer = openChattingManager.analyzeRecords(record);
        return answer;
    }
}

class OpenChattingManager {
    private Map<String,String> users = new HashMap<String,String>();
    private Map<String,String> operationsOfRegister = new HashMap<>();
    private Set<String> operationsOfUpdate = new HashSet<>();
    private List<Record> records = new ArrayList();

    public OpenChattingManager(){
        operationsOfRegister.put("Enter", "님이 들어왔습니다.");
        operationsOfRegister.put("Leave", "님이 나갔습니다.");
        operationsOfUpdate.add("Change");
    }
    class Record {
        String operation;
        String uid;
        public Record(String operation, String uid) {
            this.operation = operation;
            this.uid = uid;
        }
        @Override
        public String toString() {
            return users.get(uid) + operationsOfRegister.get(operation);
        }
    }
    public String[] analyzeRecords(String[] records) {
        for (String record : records) {
            String[] words =  record.split(" ");
            if (operationsOfRegister.containsKey(words[0])) {
                this.records.add(new Record(words[0],words[1]));
                if ("Leave".equals(words[0])) continue;;
                users.put(words[1],words[2]);
            } else if (operationsOfUpdate.contains(words[0])) {
                users.put(words[1], words[2]);
            } else {
                throw new UnsupportedOperationException("UnsupportedOperation");
            }
        }
        List<String> result = new ArrayList<>();
        this.records.forEach(record -> result.add(record.toString()));
        return result.toArray(new String[0]);
    }
}