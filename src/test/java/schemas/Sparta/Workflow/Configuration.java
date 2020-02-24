
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Configuration implements Serializable
{

    @SerializedName("inputOptions")
    @Expose
    private String inputOptions;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("debugOptions")
    @Expose
    private String debugOptions;
    @SerializedName("isolationLevel")
    @Expose
    private String isolationLevel;
    @SerializedName("tlsEnabled")
    @Expose
    private Boolean tlsEnabled;
    @SerializedName("driver")
    @Expose
    private String driver;
    @SerializedName("dbtable")
    @Expose
    private String dbtable;
    @SerializedName("errorTableName")
    @Expose
    private String errorTableName;
    @SerializedName("selectType")
    @Expose
    private String selectType;
    @SerializedName("selectExp")
    @Expose
    private String selectExp;
    @SerializedName("inputSchemas")
    @Expose
    private String inputSchemas;
    @SerializedName("sql")
    @Expose
    private String sql;
    @SerializedName("discardConditions")
    @Expose
    private String discardConditions;
    @SerializedName("executeSqlWhenEmpty")
    @Expose
    private Boolean executeSqlWhenEmpty;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("errorSink")
    @Expose
    private Boolean errorSink;
    @SerializedName("saveOptions")
    @Expose
    private String saveOptions;
    @SerializedName("partitions")
    @Expose
    private String partitions;
    @SerializedName("shuffle")
    @Expose
    private Boolean shuffle;
    private final static long serialVersionUID = -4292515426243340013L;

    public String getInputOptions() {
        return inputOptions;
    }

    public void setInputOptions(String inputOptions) {
        this.inputOptions = inputOptions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDebugOptions() {
        return debugOptions;
    }

    public void setDebugOptions(String debugOptions) {
        this.debugOptions = debugOptions;
    }

    public String getIsolationLevel() {
        return isolationLevel;
    }

    public void setIsolationLevel(String isolationLevel) {
        this.isolationLevel = isolationLevel;
    }

    public Boolean getTlsEnabled() {
        return tlsEnabled;
    }

    public void setTlsEnabled(Boolean tlsEnabled) {
        this.tlsEnabled = tlsEnabled;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDbtable() {
        return dbtable;
    }

    public void setDbtable(String dbtable) {
        this.dbtable = dbtable;
    }

    public String getErrorTableName() {
        return errorTableName;
    }

    public void setErrorTableName(String errorTableName) {
        this.errorTableName = errorTableName;
    }

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }

    public String getSelectExp() {
        return selectExp;
    }

    public void setSelectExp(String selectExp) {
        this.selectExp = selectExp;
    }

    public String getInputSchemas() {
        return inputSchemas;
    }

    public void setInputSchemas(String inputSchemas) {
        this.inputSchemas = inputSchemas;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getDiscardConditions() {
        return discardConditions;
    }

    public void setDiscardConditions(String discardConditions) {
        this.discardConditions = discardConditions;
    }

    public Boolean getExecuteSqlWhenEmpty() {
        return executeSqlWhenEmpty;
    }

    public void setExecuteSqlWhenEmpty(Boolean executeSqlWhenEmpty) {
        this.executeSqlWhenEmpty = executeSqlWhenEmpty;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getErrorSink() {
        return errorSink;
    }

    public void setErrorSink(Boolean errorSink) {
        this.errorSink = errorSink;
    }

    public String getSaveOptions() {
        return saveOptions;
    }

    public void setSaveOptions(String saveOptions) {
        this.saveOptions = saveOptions;
    }

    public String getPartitions() {
        return partitions;
    }

    public void setPartitions(String partitions) {
        this.partitions = partitions;
    }

    public Boolean getShuffle() {
        return shuffle;
    }

    public void setShuffle(Boolean shuffle) {
        this.shuffle = shuffle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("inputOptions", inputOptions).append("url", url).append("debugOptions", debugOptions).append("isolationLevel", isolationLevel).append("tlsEnabled", tlsEnabled).append("driver", driver).append("dbtable", dbtable).append("errorTableName", errorTableName).append("selectType", selectType).append("selectExp", selectExp).append("inputSchemas", inputSchemas).append("sql", sql).append("discardConditions", discardConditions).append("executeSqlWhenEmpty", executeSqlWhenEmpty).append("path", path).append("errorSink", errorSink).append("saveOptions", saveOptions).append("partitions", partitions).append("shuffle", shuffle).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(partitions).append(inputOptions).append(discardConditions).append(dbtable).append(errorTableName).append(url).append(sql).append(debugOptions).append(saveOptions).append(path).append(tlsEnabled).append(driver).append(selectExp).append(executeSqlWhenEmpty).append(isolationLevel).append(inputSchemas).append(errorSink).append(selectType).append(shuffle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Configuration) == false) {
            return false;
        }
        Configuration rhs = ((Configuration) other);
        return new EqualsBuilder().append(partitions, rhs.partitions).append(inputOptions, rhs.inputOptions).append(discardConditions, rhs.discardConditions).append(dbtable, rhs.dbtable).append(errorTableName, rhs.errorTableName).append(url, rhs.url).append(sql, rhs.sql).append(debugOptions, rhs.debugOptions).append(saveOptions, rhs.saveOptions).append(path, rhs.path).append(tlsEnabled, rhs.tlsEnabled).append(driver, rhs.driver).append(selectExp, rhs.selectExp).append(executeSqlWhenEmpty, rhs.executeSqlWhenEmpty).append(isolationLevel, rhs.isolationLevel).append(inputSchemas, rhs.inputSchemas).append(errorSink, rhs.errorSink).append(selectType, rhs.selectType).append(shuffle, rhs.shuffle).isEquals();
    }

}
