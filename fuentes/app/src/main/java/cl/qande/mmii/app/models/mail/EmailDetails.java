package cl.qande.mmii.app.models.mail;

import java.util.Arrays;

public class EmailDetails {
    private String msgBody;
    private String subject;
    private String attachment;
    private String[] recipientsTo;
    private String[] recipientsCc;
    private String[] recipientsBcc;
    private String senderName;
    private static final String SEPARATOR_LIST_MAIL = ",";

    public EmailDetails() {
        recipientsTo    = new String[]{};
        recipientsCc    = new String[]{};
        recipientsBcc    = new String[]{};
    }

    public String[] getRecipientsTo() {
        return recipientsTo;
    }

    public String[] getRecipientsCc() {
        return recipientsCc;
    }

    public String[] getRecipientsBcc() {
        return recipientsBcc;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }


    public void setRecipientsTo(String recipientToList) {
        this.recipientsTo = recipientToList.isEmpty() ? new String[]{} : recipientToList.split(SEPARATOR_LIST_MAIL);
    }

    public void setRecipientsCc(String recipientCcList) {
        this.recipientsCc = recipientCcList.isEmpty() ? new String[]{} : recipientCcList.split(SEPARATOR_LIST_MAIL);
    }

    public void setRecipientsBcc(String recipientBccList) {
        this.recipientsBcc = recipientBccList.isEmpty() ? new String[]{} : recipientBccList.split(SEPARATOR_LIST_MAIL);
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "EmailDetails{" +
                "msgBody='" + msgBody + '\'' +
                ", subject='" + subject + '\'' +
                ", attachment='" + attachment + '\'' +
                ", recipientsTo=" + Arrays.toString(recipientsTo) +
                ", recipientsCc=" + Arrays.toString(recipientsCc) +
                ", recipientsBcc=" + Arrays.toString(recipientsBcc) +
                ", senderName='" + senderName + '\'' +
                '}';
    }
}
