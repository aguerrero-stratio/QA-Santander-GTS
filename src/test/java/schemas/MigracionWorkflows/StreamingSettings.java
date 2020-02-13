
package schemas.MigracionWorkflows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StreamingSettings {

    @SerializedName("window")
    @Expose
    private String window;
    @SerializedName("blockInterval")
    @Expose
    private String blockInterval;
    @SerializedName("stopGracefully")
    @Expose
    private Boolean stopGracefully;
    @SerializedName("checkpointSettings")
    @Expose
    private CheckpointSettings checkpointSettings;

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

    public Boolean getStopGracefully() {
        return stopGracefully;
    }

    public void setStopGracefully(Boolean stopGracefully) {
        this.stopGracefully = stopGracefully;
    }

    public CheckpointSettings getCheckpointSettings() {
        return checkpointSettings;
    }

    public void setCheckpointSettings(CheckpointSettings checkpointSettings) {
        this.checkpointSettings = checkpointSettings;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("window", window).append("blockInterval", blockInterval).append("stopGracefully", stopGracefully).append("checkpointSettings", checkpointSettings).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(checkpointSettings).append(stopGracefully).append(window).append(blockInterval).toHashCode();
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
        return new EqualsBuilder().append(checkpointSettings, rhs.checkpointSettings).append(stopGracefully, rhs.stopGracefully).append(window, rhs.window).append(blockInterval, rhs.blockInterval).isEquals();
    }

}
