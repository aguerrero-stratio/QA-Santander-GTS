
package schemas.Sparta.Workflow;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Predicate implements Serializable
{

    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("operands")
    @Expose
    private List<Object> operands = null;
    @SerializedName("field")
    @Expose
    private String field;
    @SerializedName("operation")
    @Expose
    private String operation;
    private final static long serialVersionUID = 6200831067070577075L;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<Object> getOperands() {
        return operands;
    }

    public void setOperands(List<Object> operands) {
        this.operands = operands;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("order", order).append("operands", operands).append("field", field).append("operation", operation).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(operands).append(field).append(operation).append(order).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Predicate) == false) {
            return false;
        }
        Predicate rhs = ((Predicate) other);
        return new EqualsBuilder().append(operands, rhs.operands).append(field, rhs.field).append(operation, rhs.operation).append(order, rhs.order).isEquals();
    }

}
