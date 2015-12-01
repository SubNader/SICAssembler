/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SICAssembler;

/**
 *
 * @author Nader
 */
public class Instruction {

    private String label;
    private String operation;
    private String operand;
    private String objectCode;
    private String address;

    public Instruction(String label, String operation, String operand, String location) {
        this.setLabel(label);
        this.setOperation(operation);
        this.setOperand(operand);
        this.address = location;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * @return the operand
     */
    public String getOperand() {
        return operand;
    }

    /**
     * @param operand the operand to set
     */
    public void setOperand(String operand) {
        this.operand = operand;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the objectCode
     */
    public String getObjectCode() {
        return objectCode;
    }

    /**
     * @param objectCode the objectCode to set
     */
    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

}
