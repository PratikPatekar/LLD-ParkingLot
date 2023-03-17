package models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {
    private List<Payment> payments;
    private int amount;
    private Ticket ticket;
    private Operator operator;
    private BillStatus status;
    private Gate gate;
    private Date exitTime;
    public Bill(int amount, Ticket ticket, Operator operator, Gate gate, Date exitTime){
        this.amount = amount;
        this.ticket = ticket;
    }
    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }
}
