
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Threshold implements Serializable
{

    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("actionType")
    @Expose
    private ActionType actionType;
    private final static long serialVersionUID = -1948912055832252950L;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("value", value).append("operation", operation).append("type", type).append("actionType", actionType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(actionType).append(type).append(value).append(operation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Threshold) == false) {
            return false;
        }
        Threshold rhs = ((Threshold) other);
        return new EqualsBuilder().append(actionType, rhs.actionType).append(type, rhs.type).append(value, rhs.value).append(operation, rhs.operation).isEquals();
    }

}
