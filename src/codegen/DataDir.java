package codegen;

import java.util.ArrayList;

public class DataDir {
    private int currentMessageNumber = 0;
    private ArrayList<String> messages = new ArrayList<>();

    public void put(String message) {
        if (!messages.contains(message)) {
            messages.add(currentMessageNumber, message);
            currentMessageNumber++;
        }
    }

    public String get(String message) {
        return "msg_" + messages.indexOf(message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(".data\n\n");

        for(int i = 0; i < currentMessageNumber; i++) {
            String message = messages.get(i);
            sb.append("msg_").append(i).append(":\n\t.word ").append(message.length())
                    .append("\n\t.ascii \"").append(message).append("\"\n");
        }

        sb.append("\n");

        return sb.toString();
    }
}
