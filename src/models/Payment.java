package models;

public class Payment extends BaseModel {
    private PaymentMode paymentMode;
    private int amount;
    private String provider;
    private String referenceId;
    private PaymentStatus paymentStatus;
    public Payment(int amt,String provider){
        this.amount = amt;
        this.provider = provider;
        this.paymentStatus = PaymentStatus.INITIAL;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getProvider() {
        return provider;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
