
package schemas.MigracionWorkflows;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SparkConf {

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
    @SerializedName("sparkLocalDir")
    @Expose
    private String sparkLocalDir;
    @SerializedName("sparkSqlCaseSensitive")
    @Expose
    private Boolean sparkSqlCaseSensitive;
    @SerializedName("hdfsTokenCache")
    @Expose
    private Boolean hdfsTokenCache;
    @SerializedName("executorExtraJavaOptions")
    @Expose
    private String executorExtraJavaOptions;

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

    public String getSparkLocalDir() {
        return sparkLocalDir;
    }

    public void setSparkLocalDir(String sparkLocalDir) {
        this.sparkLocalDir = sparkLocalDir;
    }

    public Boolean getSparkSqlCaseSensitive() {
        return sparkSqlCaseSensitive;
    }

    public void setSparkSqlCaseSensitive(Boolean sparkSqlCaseSensitive) {
        this.sparkSqlCaseSensitive = sparkSqlCaseSensitive;
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
        return new ToStringBuilder(this).append("sparkResourcesConf", sparkResourcesConf).append("sparkHistoryServerConf", sparkHistoryServerConf).append("userSparkConf", userSparkConf).append("coarse", coarse).append("sparkLocalDir", sparkLocalDir).append("sparkSqlCaseSensitive", sparkSqlCaseSensitive).append("hdfsTokenCache", hdfsTokenCache).append("executorExtraJavaOptions", executorExtraJavaOptions).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sparkResourcesConf).append(sparkHistoryServerConf).append(hdfsTokenCache).append(coarse).append(executorExtraJavaOptions).append(sparkSqlCaseSensitive).append(userSparkConf).append(sparkLocalDir).toHashCode();
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
        return new EqualsBuilder().append(sparkResourcesConf, rhs.sparkResourcesConf).append(sparkHistoryServerConf, rhs.sparkHistoryServerConf).append(hdfsTokenCache, rhs.hdfsTokenCache).append(coarse, rhs.coarse).append(executorExtraJavaOptions, rhs.executorExtraJavaOptions).append(sparkSqlCaseSensitive, rhs.sparkSqlCaseSensitive).append(userSparkConf, rhs.userSparkConf).append(sparkLocalDir, rhs.sparkLocalDir).isEquals();
    }

}
