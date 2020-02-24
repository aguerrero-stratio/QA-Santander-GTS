
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class LastError implements Serializable
{

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("phase")
    @Expose
    private String phase;
    @SerializedName("exceptionMsg")
    @Expose
    private String exceptionMsg;
    @SerializedName("localizedMsg")
    @Expose
    private String localizedMsg;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("step")
    @Expose
    private String step;
    private final static long serialVersionUID = -5983194267876716486L;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getLocalizedMsg() {
        return localizedMsg;
    }

    public void setLocalizedMsg(String localizedMsg) {
        this.localizedMsg = localizedMsg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("message", message).append("phase", phase).append("exceptionMsg", exceptionMsg).append("localizedMsg", localizedMsg).append("date", date).append("step", step).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(phase).append(date).append(exceptionMsg).append(step).append(message).append(localizedMsg).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LastError) == false) {
            return false;
        }
        LastError rhs = ((LastError) other);
        return new EqualsBuilder().append(phase, rhs.phase).append(date, rhs.date).append(exceptionMsg, rhs.exceptionMsg).append(step, rhs.step).append(message, rhs.message).append(localizedMsg, rhs.localizedMsg).isEquals();
    }

}
