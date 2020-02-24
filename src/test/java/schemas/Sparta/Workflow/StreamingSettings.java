
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StreamingSettings implements Serializable
{

    @SerializedName("window")
    @Expose
    private String window;
    @SerializedName("blockInterval")
    @Expose
    private String blockInterval;
    @SerializedName("checkpointSettings")
    @Expose
    private CheckpointSettings checkpointSettings;
    private final static long serialVersionUID = 6441712451524750878L;

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public String getBlockInterval() {
        return blockInterval;
    }

    public void setBlockInterval(String blockInterval) {
        this.blockInterval = blockInterval;
    }

    public CheckpointSettings getCheckpointSettings() {
        return checkpointSettings;
    }

    public void setCheckpointSettings(CheckpointSettings checkpointSettings) {
        this.checkpointSettings = checkpointSettings;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("window", window).append("blockInterval", blockInterval).append("checkpointSettings", checkpointSettings).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(checkpointSettings).append(window).append(blockInterval).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StreamingSettings) == false) {
            return false;
        }
        StreamingSettings rhs = ((StreamingSettings) other);
        return new EqualsBuilder().append(checkpointSettings, rhs.checkpointSettings).append(window, rhs.window).append(blockInterval, rhs.blockInterval).isEquals();
    }

}
