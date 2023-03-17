package models;

public class Gate extends BaseModel {
    private GateType gateType;
    private Operator operator;
    public Gate(GateType gateType){
        this.gateType = gateType;
    }
    public GateType getGateType() {
        return gateType;
    }
    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
