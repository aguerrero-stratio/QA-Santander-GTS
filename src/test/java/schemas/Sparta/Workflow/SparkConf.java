
package schemas.Sparta.Workflow;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SparkConf implements Serializable
{

    @SerializedName("sparkResourcesConf")
    @Expose
    private SparkResourcesConf sparkResourcesConf;
    @SerializedName("sparkHistoryServerConf")
    @Expose
    private SparkHistoryServerConf sparkHistoryServerConf;
    @SerializedName("userSparkConf")
    @Expose
    private List<Object> userSparkConf = null;
    @SerializedName("coarse")
    @Expose
    private Boolean coarse;
    @SerializedName("sparkUser")
    @Expose
    private String sparkUser;
    @SerializedName("sparkLocalDir")
    @Expose
    private String sparkLocalDir;
    @SerializedName("sparkKryoSerialization")
    @Expose
    private Boolean sparkKryoSerialization;
    @SerializedName("sparkSqlCaseSensitive")
    @Expose
    private Boolean sparkSqlCaseSensitive;
    @SerializedName("logStagesProgress")
    @Expose
    private Boolean logStagesProgress;
    @SerializedName("hdfsTokenCache")
    @Expose
    private Boolean hdfsTokenCache;
    @SerializedName("executorExtraJavaOptions")
    @Expose
    private String executorExtraJavaOptions;
    private final static long serialVersionUID = 4989148163420283662L;

    public SparkResourcesConf getSparkResourcesConf() {
        return sparkResourcesConf;
    }

    public void setSparkResourcesConf(SparkResourcesConf sparkResourcesConf) {
        this.sparkResourcesConf = sparkResourcesConf;
    }

    public SparkHistoryServerConf getSparkHistoryServerConf() {
        return sparkHistoryServerConf;
    }

    public void setSparkHistoryServerConf(SparkHistoryServerConf sparkHistoryServerConf) {
        this.sparkHistoryServerConf = sparkHistoryServerConf;
    }

    public List<Object> getUserSparkConf() {
        return userSparkConf;
    }

    public void setUserSparkConf(List<Object> userSparkConf) {
        this.userSparkConf = userSparkConf;
    }

    public Boolean getCoarse() {
        return coarse;
    }

    public void setCoarse(Boolean coarse) {
        this.coarse = coarse;
    }

    public String getSparkUser() {
        return sparkUser;
    }

    public void setSparkUser(String sparkUser) {
        this.sparkUser = sparkUser;
    }

    public String getSparkLocalDir() {
        return sparkLocalDir;
    }

    public void setSparkLocalDir(String sparkLocalDir) {
        this.sparkLocalDir = sparkLocalDir;
    }

    public Boolean getSparkKryoSerialization() {
        return sparkKryoSerialization;
    }

    public void setSparkKryoSerialization(Boolean sparkKryoSerialization) {
        this.sparkKryoSerialization = sparkKryoSerialization;
    }

    public Boolean getSparkSqlCaseSensitive() {
        return sparkSqlCaseSensitive;
    }

    public void setSparkSqlCaseSensitive(Boolean sparkSqlCaseSensitive) {
        this.sparkSqlCaseSensitive = sparkSqlCaseSensitive;
    }

    public Boolean getLogStagesProgress() {
        return logStagesProgress;
    }

    public void setLogStagesProgress(Boolean logStagesProgress) {
        this.logStagesProgress = logStagesProgress;
    }

    public Boolean getHdfsTokenCache() {
        return hdfsTokenCache;
    }

    public void setHdfsTokenCache(Boolean hdfsTokenCache) {
        this.hdfsTokenCache = hdfsTokenCache;
    }

    public String getExecutorExtraJavaOptions() {
        return executorExtraJavaOptions;
    }

    public void setExecutorExtraJavaOptions(String executorExtraJavaOptions) {
        this.executorExtraJavaOptions = executorExtraJavaOptions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sparkResourcesConf", sparkResourcesConf).append("sparkHistoryServerConf", sparkHistoryServerConf).append("userSparkConf", userSparkConf).append("coarse", coarse).append("sparkUser", sparkUser).append("sparkLocalDir", sparkLocalDir).append("sparkKryoSerialization", sparkKryoSerialization).append("sparkSqlCaseSensitive", sparkSqlCaseSensitive).append("logStagesProgress", logStagesProgress).append("hdfsTokenCache", hdfsTokenCache).append("executorExtraJavaOptions", executorExtraJavaOptions).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sparkResourcesConf).append(sparkHistoryServerConf).append(sparkKryoSerialization).append(logStagesProgress).append(hdfsTokenCache).append(coarse).append(executorExtraJavaOptions).append(sparkUser).append(sparkSqlCaseSensitive).append(userSparkConf).append(sparkLocalDir).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SparkConf) == false) {
            return false;
        }
        SparkConf rhs = ((SparkConf) other);
        return new EqualsBuilder().append(sparkResourcesConf, rhs.sparkResourcesConf).append(sparkHistoryServerConf, rhs.sparkHistoryServerConf).append(sparkKryoSerialization, rhs.sparkKryoSerialization).append(logStagesProgress, rhs.logStagesProgress).append(hdfsTokenCache, rhs.hdfsTokenCache).append(coarse, rhs.coarse).append(executorExtraJavaOptions, rhs.executorExtraJavaOptions).append(sparkUser, rhs.sparkUser).append(sparkSqlCaseSensitive, rhs.sparkSqlCaseSensitive).append(userSparkConf, rhs.userSparkConf).append(sparkLocalDir, rhs.sparkLocalDir).isEquals();
    }

}
