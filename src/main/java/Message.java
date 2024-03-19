public class Message {

    //region [ - Fields - ]

    //region [ - String messageText - ]
    private String messageText;

    //region [ - getMessageText() - ]
    public String getMessageText() {
        return messageText;
    }
    //endregion

    //endregion

    //region [ - Person sender - ]
    private Person sender;

    //region [ - getSender() - ]
    public Person getSender() {
        return sender;
    }
    //endregion

    //endregion

    //region [ - Person receiver - ]
    private Person receiver;

    //region [ - Person getReceiver() - ]
    public Person getReceiver() {
        return receiver;
    }
    //endregion

    //endregion

    //endregion

    //region [ - Constructor - ]
    public Message(String messageText, Person sender, Person receiver) {
        this.messageText = messageText;
        this.sender = sender;
        this.receiver = receiver;
    }
    //endregion

}