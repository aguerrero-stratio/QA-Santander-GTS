
package schemas.MigracionWorkflows;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TransactionsManagement {

    @SerializedName("sendToOutputs")
    @Expose
    private List<Object> sendToOutputs = null;
    @SerializedName("sendStepData")
    @Expose
    private Boolean sendStepData;
    @SerializedName("sendPredecessorsData")
    @Expose
    private Boolean sendPredecessorsData;
    @SerializedName("sendInputData")
    @Expose
    private Boolean sendInputData;

    public List<Object> getSendToOutputs() {
        return sendToOutputs;
    }

    public void setSendToOutputs(List<Object> sendToOutputs) {
        this.sendToOutputs = sendToOutputs;
    }

    public Boolean getSendStepData() {
        return sendStepData;
    }

    public void setSendStepData(Boolean sendStepData) {
        this.sendStepData = sendStepData;
    }

    public Boolean getSendPredecessorsData() {
        return sendPredecessorsData;
    }

    public void setSendPredecessorsData(Boolean sendPredecessorsData) {
        this.sendPredecessorsData = sendPredecessorsData;
    }

    public Boolean getSendInputData() {
        return sendInputData;
    }

    public void setSendInputData(Boolean sendInputData) {
        this.sendInputData = sendInputData;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sendToOutputs", sendToOutputs).append("sendStepData", sendStepData).append("sendPredecessorsData", sendPredecessorsData).append("sendInputData", sendInputData).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sendPredecessorsData).append(sendStepData).append(sendInputData).append(sendToOutputs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionsManagement) == false) {
            return false;
        }
        TransactionsManagement rhs = ((TransactionsManagement) other);
        return new EqualsBuilder().append(sendPredecessorsData, rhs.sendPredecessorsData).append(sendStepData, rhs.sendStepData).append(sendInputData, rhs.sendInputData).append(sendToOutputs, rhs.sendToOutputs).isEquals();
    }

}
