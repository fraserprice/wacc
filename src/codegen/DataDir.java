package codegen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class DataDir {
    /**
     * DataDir defines the messages at the top of the Assembly output.
     * One particular example:
     *      .data
     *
     *      msg_0:
     *          .word 45
     *          .ascii "DivideByZeroError: divide or modulo by zero\n\0"
     *      msg_1:
     *          .word 3
     *          .ascii "%d\0"
     *      msg_2:
     *          .word 5
     *          .ascii "%.*s\"
     *
     *      .text
     */
    private int currentMessageNumber = 0;
    private ArrayList<String> messages = new ArrayList<>();

    /**
     * Adds a new error message to the list
     * @param message to be added (Example: OverflowError message)
     */
    public void put(String message) {
        messages.add(currentMessageNumber, message);
        currentMessageNumber++;
    }

    public String getLastMessage() {
        return "msg_" + (currentMessageNumber - 1);
    }

    /**
     * @return A string representation of the content between .data and .text
     * at the beginning of Assembly output
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(".data\n");

        for(int i = 0; i < currentMessageNumber; i++) {
            String message = messages.get(i);
            int messageLength = message.length();
            messageLength -= message.chars().filter(c -> c == ('\\')).count();
            sb.append("msg_").append(i).append(":\n\t.word ").append(messageLength)
                    .append("\n\t.ascii \"").append(message).append("\"\n");
        }

        sb.append("\n");

        return sb.toString();
    }
}
