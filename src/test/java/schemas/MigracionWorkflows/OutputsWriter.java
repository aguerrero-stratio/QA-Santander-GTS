
package schemas.MigracionWorkflows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OutputsWriter {

    @SerializedName("saveMode")
    @Expose
    private String saveMode;
    @SerializedName("outputStepName")
    @Expose
    private String outputStepName;
    @SerializedName("tableName")
    @Expose
    private String tableName;
    @SerializedName("discardTableName")
    @Expose
    private String discardTableName;
    @SerializedName("extraOptions")
    @Expose
    private ExtraOptions extraOptions;

    public String getSaveMode() {
        return saveMode;
    }

    public void setSaveMode(String saveMode) {
        this.saveMode = saveMode;
    }

    public String getOutputStepName() {
        return outputStepName;
    }

    public void setOutputStepName(String outputStepName) {
        this.outputStepName = outputStepName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDiscardTableName() {
        return discardTableName;
    }

    public void setDiscardTableName(String discardTableName) {
        this.discardTableName = discardTableName;
    }

    public ExtraOptions getExtraOptions() {
        return extraOptions;
    }

    public void setExtraOptions(ExtraOptions extraOptions) {
        this.extraOptions = extraOptions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("saveMode", saveMode).append("outputStepName", outputStepName).append("tableName", tableName).append("discardTableName", discardTableName).append("extraOptions", extraOptions).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(outputStepName).append(saveMode).append(discardTableName).append(extraOptions).append(tableName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OutputsWriter) == false) {
            return false;
        }
        OutputsWriter rhs = ((OutputsWriter) other);
        return new EqualsBuilder().append(outputStepName, rhs.outputStepName).append(saveMode, rhs.saveMode).append(discardTableName, rhs.discardTableName).append(extraOptions, rhs.extraOptions).append(tableName, rhs.tableName).isEquals();
    }

}
