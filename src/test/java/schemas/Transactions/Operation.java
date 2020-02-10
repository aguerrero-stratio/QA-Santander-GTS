
package schemas.Transactions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Operation {

    @SerializedName("customerOperation")
    @Expose
    private CustomerOperation customerOperation;
    @SerializedName("localOperation")
    @Expose
    private LocalOperation localOperation;
    @SerializedName("swiftCode")
    @Expose
    private String swiftCode;

    public CustomerOperation getCustomerOperation() {
        return customerOperation;
    }

    public void setCustomerOperation(CustomerOperation customerOperation) {
        this.customerOperation = customerOperation;
    }

    public LocalOperation getLocalOperation() {
        return localOperation;
    }

    public void setLocalOperation(LocalOperation localOperation) {
        this.localOperation = localOperation;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("customerOperation", customerOperation).append("localOperation", localOperation).append("swiftCode", swiftCode).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(localOperation).append(swiftCode).append(customerOperation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Operation) == false) {
            return false;
        }
        Operation rhs = ((Operation) other);
        return new EqualsBuilder().append(localOperation, rhs.localOperation).append(swiftCode, rhs.swiftCode).append(customerOperation, rhs.customerOperation).isEquals();
    }

}
