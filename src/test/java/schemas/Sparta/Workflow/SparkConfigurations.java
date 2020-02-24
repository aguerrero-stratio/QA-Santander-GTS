
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SparkConfigurations implements Serializable
{

    @SerializedName("spark.mesos.driverEnv.VAULT_HOST")
    @Expose
    private String sparkMesosDriverEnvVAULTHOST;
    @SerializedName("spark.mesos.driver.failoverTimeout")
    @Expose
    private String sparkMesosDriverFailoverTimeout;
    @SerializedName("spark.mesos.driverEnv.VAULT_PORT")
    @Expose
    private String sparkMesosDriverEnvVAULTPORT;
    @SerializedName("spark.executorEnv.MESOS_NATIVE_JAVA_LIBRARY")
    @Expose
    private String sparkExecutorEnvMESOSNATIVEJAVALIBRARY;
    @SerializedName("spark.hadoop.fs.s3a.connection.ssl.enabled")
    @Expose
    private String sparkHadoopFsS3aConnectionSslEnabled;
    @SerializedName("spark.executor.extraJavaOptions")
    @Expose
    private String sparkExecutorExtraJavaOptions;
    @SerializedName("spark.hadoop.yarn.resourcemanager.principal")
    @Expose
    private String sparkHadoopYarnResourcemanagerPrincipal;
    @SerializedName("spark.mesos.executor.docker.network.name")
    @Expose
    private String sparkMesosExecutorDockerNetworkName;
    @SerializedName("spark.executorEnv.SPARK_SECURITY_DATASTORE_VAULT_CERT_PATH")
    @Expose
    private String sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH;
    @SerializedName("spark.sql.caseSensitive")
    @Expose
    private String sparkSqlCaseSensitive;
    @SerializedName("spark.hadoop.fs.hdfs.impl.disable.cache")
    @Expose
    private String sparkHadoopFsHdfsImplDisableCache;
    @SerializedName("spark.executorEnv.SPARK_DATASTORE_SSL_ENABLE")
    @Expose
    private String sparkExecutorEnvSPARKDATASTORESSLENABLE;
    @SerializedName("spark.mesos.driverEnv.SPARK_SECURITY_DATASTORE_VAULT_KEY_PASS_PATH")
    @Expose
    private String sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH;
    @SerializedName("spark.jars")
    @Expose
    private String sparkJars;
    @SerializedName("spark.hadoop.fs.s3a.sts.proxy.ssl.enabled")
    @Expose
    private String sparkHadoopFsS3aStsProxySslEnabled;
    @SerializedName("spark.mesos.executor.docker.volumes")
    @Expose
    private String sparkMesosExecutorDockerVolumes;
    @SerializedName("spark.mesos.driver.docker.network.name")
    @Expose
    private String sparkMesosDriverDockerNetworkName;
    @SerializedName("spark.app.name")
    @Expose
    private String sparkAppName;
    @SerializedName("spark.cores.max")
    @Expose
    private String sparkCoresMax;
    @SerializedName("spark.executorEnv.SPARK_LOG_LEVEL")
    @Expose
    private String sparkExecutorEnvSPARKLOGLEVEL;
    @SerializedName("spark.executorEnv.VAULT_PORT")
    @Expose
    private String sparkExecutorEnvVAULTPORT;
    @SerializedName("spark.yarn.principal")
    @Expose
    private String sparkYarnPrincipal;
    @SerializedName("spark.mesos.driverEnv.SPARK_SECURITY_MESOS_ENABLE")
    @Expose
    private String sparkMesosDriverEnvSPARKSECURITYMESOSENABLE;
    @SerializedName("spark.locality.wait")
    @Expose
    private String sparkLocalityWait;
    @SerializedName("spark.driver.memory")
    @Expose
    private String sparkDriverMemory;
    @SerializedName("spark.ui.showConsoleProgress")
    @Expose
    private String sparkUiShowConsoleProgress;
    @SerializedName("spark.executorEnv.SPARK_DRIVER_SECRET_FOLDER")
    @Expose
    private String sparkExecutorEnvSPARKDRIVERSECRETFOLDER;
    @SerializedName("spark.mesos.role")
    @Expose
    private String sparkMesosRole;
    @SerializedName("spark.mesos.constraints")
    @Expose
    private String sparkMesosConstraints;
    @SerializedName("spark.executorEnv.SPARK_SECURITY_DATASTORE_ENABLE")
    @Expose
    private String sparkExecutorEnvSPARKSECURITYDATASTOREENABLE;
    @SerializedName("spark.executorEnv.VAULT_PROTOCOL")
    @Expose
    private String sparkExecutorEnvVAULTPROTOCOL;
    @SerializedName("spark.mesos.executor.docker.image")
    @Expose
    private String sparkMesosExecutorDockerImage;
    @SerializedName("spark.mesos.driverEnv.SPARK_SECURITY_MESOS_VAULT_PATH")
    @Expose
    private String sparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH;
    @SerializedName("spark.driver.cores")
    @Expose
    private String sparkDriverCores;
    @SerializedName("spark.ui.proxyBase")
    @Expose
    private String sparkUiProxyBase;
    @SerializedName("spark.mesos.coarse")
    @Expose
    private String sparkMesosCoarse;
    @SerializedName("spark.mesos.driverEnv.SPARK_DRIVER_SECRET_FOLDER")
    @Expose
    private String sparkMesosDriverEnvSPARKDRIVERSECRETFOLDER;
    @SerializedName("spark.executorEnv.SPARK_SECURITY_DATASTORE_VAULT_KEY_PASS_PATH")
    @Expose
    private String sparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH;
    @SerializedName("spark.streaming.blockInterval")
    @Expose
    private String sparkStreamingBlockInterval;
    @SerializedName("spark.executor.memory")
    @Expose
    private String sparkExecutorMemory;
    @SerializedName("spark.hadoop.fs.sftp.impl")
    @Expose
    private String sparkHadoopFsSftpImpl;
    @SerializedName("spark.driver.extraClassPath")
    @Expose
    private String sparkDriverExtraClassPath;
    @SerializedName("spark.local.dir")
    @Expose
    private String sparkLocalDir;
    @SerializedName("spark.mesos.driverEnv.SPARK_SECURITY_DATASTORE_VAULT_CERT_PASS_PATH")
    @Expose
    private String sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH;
    @SerializedName("spark.executor.extraClassPath")
    @Expose
    private String sparkExecutorExtraClassPath;
    @SerializedName("spark.executor.cores")
    @Expose
    private String sparkExecutorCores;
    @SerializedName("spark.mesos.driverEnv.SPARK_SECURITY_DATASTORE_VAULT_CERT_PATH")
    @Expose
    private String sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH;
    @SerializedName("spark.memory.fraction")
    @Expose
    private String sparkMemoryFraction;
    @SerializedName("spark.executorEnv.VAULT_HOSTS")
    @Expose
    private String sparkExecutorEnvVAULTHOSTS;
    @SerializedName("spark.mesos.driverEnv.SPARK_SECURITY_DATASTORE_ENABLE")
    @Expose
    private String sparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE;
    @SerializedName("spark.mesos.driverEnv.VAULT_PROTOCOL")
    @Expose
    private String sparkMesosDriverEnvVAULTPROTOCOL;
    @SerializedName("spark.mesos.driverEnv.VAULT_HOSTS")
    @Expose
    private String sparkMesosDriverEnvVAULTHOSTS;
    @SerializedName("spark.hadoop.fs.s3a.impl")
    @Expose
    private String sparkHadoopFsS3aImpl;
    @SerializedName("spark.executorEnv.SPARK_SECURITY_DATASTORE_VAULT_CERT_PASS_PATH")
    @Expose
    private String sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH;
    @SerializedName("spark.task.maxFailures")
    @Expose
    private String sparkTaskMaxFailures;
    @SerializedName("spark.mesos.executor.home")
    @Expose
    private String sparkMesosExecutorHome;
    private final static long serialVersionUID = 4912994733268238321L;

    public String getSparkMesosDriverEnvVAULTHOST() {
        return sparkMesosDriverEnvVAULTHOST;
    }

    public void setSparkMesosDriverEnvVAULTHOST(String sparkMesosDriverEnvVAULTHOST) {
        this.sparkMesosDriverEnvVAULTHOST = sparkMesosDriverEnvVAULTHOST;
    }

    public String getSparkMesosDriverFailoverTimeout() {
        return sparkMesosDriverFailoverTimeout;
    }

    public void setSparkMesosDriverFailoverTimeout(String sparkMesosDriverFailoverTimeout) {
        this.sparkMesosDriverFailoverTimeout = sparkMesosDriverFailoverTimeout;
    }

    public String getSparkMesosDriverEnvVAULTPORT() {
        return sparkMesosDriverEnvVAULTPORT;
    }

    public void setSparkMesosDriverEnvVAULTPORT(String sparkMesosDriverEnvVAULTPORT) {
        this.sparkMesosDriverEnvVAULTPORT = sparkMesosDriverEnvVAULTPORT;
    }

    public String getSparkExecutorEnvMESOSNATIVEJAVALIBRARY() {
        return sparkExecutorEnvMESOSNATIVEJAVALIBRARY;
    }

    public void setSparkExecutorEnvMESOSNATIVEJAVALIBRARY(String sparkExecutorEnvMESOSNATIVEJAVALIBRARY) {
        this.sparkExecutorEnvMESOSNATIVEJAVALIBRARY = sparkExecutorEnvMESOSNATIVEJAVALIBRARY;
    }

    public String getSparkHadoopFsS3aConnectionSslEnabled() {
        return sparkHadoopFsS3aConnectionSslEnabled;
    }

    public void setSparkHadoopFsS3aConnectionSslEnabled(String sparkHadoopFsS3aConnectionSslEnabled) {
        this.sparkHadoopFsS3aConnectionSslEnabled = sparkHadoopFsS3aConnectionSslEnabled;
    }

    public String getSparkExecutorExtraJavaOptions() {
        return sparkExecutorExtraJavaOptions;
    }

    public void setSparkExecutorExtraJavaOptions(String sparkExecutorExtraJavaOptions) {
        this.sparkExecutorExtraJavaOptions = sparkExecutorExtraJavaOptions;
    }

    public String getSparkHadoopYarnResourcemanagerPrincipal() {
        return sparkHadoopYarnResourcemanagerPrincipal;
    }

    public void setSparkHadoopYarnResourcemanagerPrincipal(String sparkHadoopYarnResourcemanagerPrincipal) {
        this.sparkHadoopYarnResourcemanagerPrincipal = sparkHadoopYarnResourcemanagerPrincipal;
    }

    public String getSparkMesosExecutorDockerNetworkName() {
        return sparkMesosExecutorDockerNetworkName;
    }

    public void setSparkMesosExecutorDockerNetworkName(String sparkMesosExecutorDockerNetworkName) {
        this.sparkMesosExecutorDockerNetworkName = sparkMesosExecutorDockerNetworkName;
    }

    public String getSparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH() {
        return sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH;
    }

    public void setSparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH(String sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH) {
        this.sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH = sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH;
    }

    public String getSparkSqlCaseSensitive() {
        return sparkSqlCaseSensitive;
    }

    public void setSparkSqlCaseSensitive(String sparkSqlCaseSensitive) {
        this.sparkSqlCaseSensitive = sparkSqlCaseSensitive;
    }

    public String getSparkHadoopFsHdfsImplDisableCache() {
        return sparkHadoopFsHdfsImplDisableCache;
    }

    public void setSparkHadoopFsHdfsImplDisableCache(String sparkHadoopFsHdfsImplDisableCache) {
        this.sparkHadoopFsHdfsImplDisableCache = sparkHadoopFsHdfsImplDisableCache;
    }

    public String getSparkExecutorEnvSPARKDATASTORESSLENABLE() {
        return sparkExecutorEnvSPARKDATASTORESSLENABLE;
    }

    public void setSparkExecutorEnvSPARKDATASTORESSLENABLE(String sparkExecutorEnvSPARKDATASTORESSLENABLE) {
        this.sparkExecutorEnvSPARKDATASTORESSLENABLE = sparkExecutorEnvSPARKDATASTORESSLENABLE;
    }

    public String getSparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH() {
        return sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH;
    }

    public void setSparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH(String sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH) {
        this.sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH = sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH;
    }

    public String getSparkJars() {
        return sparkJars;
    }

    public void setSparkJars(String sparkJars) {
        this.sparkJars = sparkJars;
    }

    public String getSparkHadoopFsS3aStsProxySslEnabled() {
        return sparkHadoopFsS3aStsProxySslEnabled;
    }

    public void setSparkHadoopFsS3aStsProxySslEnabled(String sparkHadoopFsS3aStsProxySslEnabled) {
        this.sparkHadoopFsS3aStsProxySslEnabled = sparkHadoopFsS3aStsProxySslEnabled;
    }

    public String getSparkMesosExecutorDockerVolumes() {
        return sparkMesosExecutorDockerVolumes;
    }

    public void setSparkMesosExecutorDockerVolumes(String sparkMesosExecutorDockerVolumes) {
        this.sparkMesosExecutorDockerVolumes = sparkMesosExecutorDockerVolumes;
    }

    public String getSparkMesosDriverDockerNetworkName() {
        return sparkMesosDriverDockerNetworkName;
    }

    public void setSparkMesosDriverDockerNetworkName(String sparkMesosDriverDockerNetworkName) {
        this.sparkMesosDriverDockerNetworkName = sparkMesosDriverDockerNetworkName;
    }

    public String getSparkAppName() {
        return sparkAppName;
    }

    public void setSparkAppName(String sparkAppName) {
        this.sparkAppName = sparkAppName;
    }

    public String getSparkCoresMax() {
        return sparkCoresMax;
    }

    public void setSparkCoresMax(String sparkCoresMax) {
        this.sparkCoresMax = sparkCoresMax;
    }

    public String getSparkExecutorEnvSPARKLOGLEVEL() {
        return sparkExecutorEnvSPARKLOGLEVEL;
    }

    public void setSparkExecutorEnvSPARKLOGLEVEL(String sparkExecutorEnvSPARKLOGLEVEL) {
        this.sparkExecutorEnvSPARKLOGLEVEL = sparkExecutorEnvSPARKLOGLEVEL;
    }

    public String getSparkExecutorEnvVAULTPORT() {
        return sparkExecutorEnvVAULTPORT;
    }

    public void setSparkExecutorEnvVAULTPORT(String sparkExecutorEnvVAULTPORT) {
        this.sparkExecutorEnvVAULTPORT = sparkExecutorEnvVAULTPORT;
    }

    public String getSparkYarnPrincipal() {
        return sparkYarnPrincipal;
    }

    public void setSparkYarnPrincipal(String sparkYarnPrincipal) {
        this.sparkYarnPrincipal = sparkYarnPrincipal;
    }

    public String getSparkMesosDriverEnvSPARKSECURITYMESOSENABLE() {
        return sparkMesosDriverEnvSPARKSECURITYMESOSENABLE;
    }

    public void setSparkMesosDriverEnvSPARKSECURITYMESOSENABLE(String sparkMesosDriverEnvSPARKSECURITYMESOSENABLE) {
        this.sparkMesosDriverEnvSPARKSECURITYMESOSENABLE = sparkMesosDriverEnvSPARKSECURITYMESOSENABLE;
    }

    public String getSparkLocalityWait() {
        return sparkLocalityWait;
    }

    public void setSparkLocalityWait(String sparkLocalityWait) {
        this.sparkLocalityWait = sparkLocalityWait;
    }

    public String getSparkDriverMemory() {
        return sparkDriverMemory;
    }

    public void setSparkDriverMemory(String sparkDriverMemory) {
        this.sparkDriverMemory = sparkDriverMemory;
    }

    public String getSparkUiShowConsoleProgress() {
        return sparkUiShowConsoleProgress;
    }

    public void setSparkUiShowConsoleProgress(String sparkUiShowConsoleProgress) {
        this.sparkUiShowConsoleProgress = sparkUiShowConsoleProgress;
    }

    public String getSparkExecutorEnvSPARKDRIVERSECRETFOLDER() {
        return sparkExecutorEnvSPARKDRIVERSECRETFOLDER;
    }

    public void setSparkExecutorEnvSPARKDRIVERSECRETFOLDER(String sparkExecutorEnvSPARKDRIVERSECRETFOLDER) {
        this.sparkExecutorEnvSPARKDRIVERSECRETFOLDER = sparkExecutorEnvSPARKDRIVERSECRETFOLDER;
    }

    public String getSparkMesosRole() {
        return sparkMesosRole;
    }

    public void setSparkMesosRole(String sparkMesosRole) {
        this.sparkMesosRole = sparkMesosRole;
    }

    public String getSparkMesosConstraints() {
        return sparkMesosConstraints;
    }

    public void setSparkMesosConstraints(String sparkMesosConstraints) {
        this.sparkMesosConstraints = sparkMesosConstraints;
    }

    public String getSparkExecutorEnvSPARKSECURITYDATASTOREENABLE() {
        return sparkExecutorEnvSPARKSECURITYDATASTOREENABLE;
    }

    public void setSparkExecutorEnvSPARKSECURITYDATASTOREENABLE(String sparkExecutorEnvSPARKSECURITYDATASTOREENABLE) {
        this.sparkExecutorEnvSPARKSECURITYDATASTOREENABLE = sparkExecutorEnvSPARKSECURITYDATASTOREENABLE;
    }

    public String getSparkExecutorEnvVAULTPROTOCOL() {
        return sparkExecutorEnvVAULTPROTOCOL;
    }

    public void setSparkExecutorEnvVAULTPROTOCOL(String sparkExecutorEnvVAULTPROTOCOL) {
        this.sparkExecutorEnvVAULTPROTOCOL = sparkExecutorEnvVAULTPROTOCOL;
    }

    public String getSparkMesosExecutorDockerImage() {
        return sparkMesosExecutorDockerImage;
    }

    public void setSparkMesosExecutorDockerImage(String sparkMesosExecutorDockerImage) {
        this.sparkMesosExecutorDockerImage = sparkMesosExecutorDockerImage;
    }

    public String getSparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH() {
        return sparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH;
    }

    public void setSparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH(String sparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH) {
        this.sparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH = sparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH;
    }

    public String getSparkDriverCores() {
        return sparkDriverCores;
    }

    public void setSparkDriverCores(String sparkDriverCores) {
        this.sparkDriverCores = sparkDriverCores;
    }

    public String getSparkUiProxyBase() {
        return sparkUiProxyBase;
    }

    public void setSparkUiProxyBase(String sparkUiProxyBase) {
        this.sparkUiProxyBase = sparkUiProxyBase;
    }

    public String getSparkMesosCoarse() {
        return sparkMesosCoarse;
    }

    public void setSparkMesosCoarse(String sparkMesosCoarse) {
        this.sparkMesosCoarse = sparkMesosCoarse;
    }

    public String getSparkMesosDriverEnvSPARKDRIVERSECRETFOLDER() {
        return sparkMesosDriverEnvSPARKDRIVERSECRETFOLDER;
    }

    public void setSparkMesosDriverEnvSPARKDRIVERSECRETFOLDER(String sparkMesosDriverEnvSPARKDRIVERSECRETFOLDER) {
        this.sparkMesosDriverEnvSPARKDRIVERSECRETFOLDER = sparkMesosDriverEnvSPARKDRIVERSECRETFOLDER;
    }

    public String getSparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH() {
        return sparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH;
    }

    public void setSparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH(String sparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH) {
        this.sparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH = sparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH;
    }

    public String getSparkStreamingBlockInterval() {
        return sparkStreamingBlockInterval;
    }

    public void setSparkStreamingBlockInterval(String sparkStreamingBlockInterval) {
        this.sparkStreamingBlockInterval = sparkStreamingBlockInterval;
    }

    public String getSparkExecutorMemory() {
        return sparkExecutorMemory;
    }

    public void setSparkExecutorMemory(String sparkExecutorMemory) {
        this.sparkExecutorMemory = sparkExecutorMemory;
    }

    public String getSparkHadoopFsSftpImpl() {
        return sparkHadoopFsSftpImpl;
    }

    public void setSparkHadoopFsSftpImpl(String sparkHadoopFsSftpImpl) {
        this.sparkHadoopFsSftpImpl = sparkHadoopFsSftpImpl;
    }

    public String getSparkDriverExtraClassPath() {
        return sparkDriverExtraClassPath;
    }

    public void setSparkDriverExtraClassPath(String sparkDriverExtraClassPath) {
        this.sparkDriverExtraClassPath = sparkDriverExtraClassPath;
    }

    public String getSparkLocalDir() {
        return sparkLocalDir;
    }

    public void setSparkLocalDir(String sparkLocalDir) {
        this.sparkLocalDir = sparkLocalDir;
    }

    public String getSparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH() {
        return sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH;
    }

    public void setSparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH(String sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH) {
        this.sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH = sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH;
    }

    public String getSparkExecutorExtraClassPath() {
        return sparkExecutorExtraClassPath;
    }

    public void setSparkExecutorExtraClassPath(String sparkExecutorExtraClassPath) {
        this.sparkExecutorExtraClassPath = sparkExecutorExtraClassPath;
    }

    public String getSparkExecutorCores() {
        return sparkExecutorCores;
    }

    public void setSparkExecutorCores(String sparkExecutorCores) {
        this.sparkExecutorCores = sparkExecutorCores;
    }

    public String getSparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH() {
        return sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH;
    }

    public void setSparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH(String sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH) {
        this.sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH = sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH;
    }

    public String getSparkMemoryFraction() {
        return sparkMemoryFraction;
    }

    public void setSparkMemoryFraction(String sparkMemoryFraction) {
        this.sparkMemoryFraction = sparkMemoryFraction;
    }

    public String getSparkExecutorEnvVAULTHOSTS() {
        return sparkExecutorEnvVAULTHOSTS;
    }

    public void setSparkExecutorEnvVAULTHOSTS(String sparkExecutorEnvVAULTHOSTS) {
        this.sparkExecutorEnvVAULTHOSTS = sparkExecutorEnvVAULTHOSTS;
    }

    public String getSparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE() {
        return sparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE;
    }

    public void setSparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE(String sparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE) {
        this.sparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE = sparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE;
    }

    public String getSparkMesosDriverEnvVAULTPROTOCOL() {
        return sparkMesosDriverEnvVAULTPROTOCOL;
    }

    public void setSparkMesosDriverEnvVAULTPROTOCOL(String sparkMesosDriverEnvVAULTPROTOCOL) {
        this.sparkMesosDriverEnvVAULTPROTOCOL = sparkMesosDriverEnvVAULTPROTOCOL;
    }

    public String getSparkMesosDriverEnvVAULTHOSTS() {
        return sparkMesosDriverEnvVAULTHOSTS;
    }

    public void setSparkMesosDriverEnvVAULTHOSTS(String sparkMesosDriverEnvVAULTHOSTS) {
        this.sparkMesosDriverEnvVAULTHOSTS = sparkMesosDriverEnvVAULTHOSTS;
    }

    public String getSparkHadoopFsS3aImpl() {
        return sparkHadoopFsS3aImpl;
    }

    public void setSparkHadoopFsS3aImpl(String sparkHadoopFsS3aImpl) {
        this.sparkHadoopFsS3aImpl = sparkHadoopFsS3aImpl;
    }

    public String getSparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH() {
        return sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH;
    }

    public void setSparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH(String sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH) {
        this.sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH = sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH;
    }

    public String getSparkTaskMaxFailures() {
        return sparkTaskMaxFailures;
    }

    public void setSparkTaskMaxFailures(String sparkTaskMaxFailures) {
        this.sparkTaskMaxFailures = sparkTaskMaxFailures;
    }

    public String getSparkMesosExecutorHome() {
        return sparkMesosExecutorHome;
    }

    public void setSparkMesosExecutorHome(String sparkMesosExecutorHome) {
        this.sparkMesosExecutorHome = sparkMesosExecutorHome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sparkMesosDriverEnvVAULTHOST", sparkMesosDriverEnvVAULTHOST).append("sparkMesosDriverFailoverTimeout", sparkMesosDriverFailoverTimeout).append("sparkMesosDriverEnvVAULTPORT", sparkMesosDriverEnvVAULTPORT).append("sparkExecutorEnvMESOSNATIVEJAVALIBRARY", sparkExecutorEnvMESOSNATIVEJAVALIBRARY).append("sparkHadoopFsS3aConnectionSslEnabled", sparkHadoopFsS3aConnectionSslEnabled).append("sparkExecutorExtraJavaOptions", sparkExecutorExtraJavaOptions).append("sparkHadoopYarnResourcemanagerPrincipal", sparkHadoopYarnResourcemanagerPrincipal).append("sparkMesosExecutorDockerNetworkName", sparkMesosExecutorDockerNetworkName).append("sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH", sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH).append("sparkSqlCaseSensitive", sparkSqlCaseSensitive).append("sparkHadoopFsHdfsImplDisableCache", sparkHadoopFsHdfsImplDisableCache).append("sparkExecutorEnvSPARKDATASTORESSLENABLE", sparkExecutorEnvSPARKDATASTORESSLENABLE).append("sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH", sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH).append("sparkJars", sparkJars).append("sparkHadoopFsS3aStsProxySslEnabled", sparkHadoopFsS3aStsProxySslEnabled).append("sparkMesosExecutorDockerVolumes", sparkMesosExecutorDockerVolumes).append("sparkMesosDriverDockerNetworkName", sparkMesosDriverDockerNetworkName).append("sparkAppName", sparkAppName).append("sparkCoresMax", sparkCoresMax).append("sparkExecutorEnvSPARKLOGLEVEL", sparkExecutorEnvSPARKLOGLEVEL).append("sparkExecutorEnvVAULTPORT", sparkExecutorEnvVAULTPORT).append("sparkYarnPrincipal", sparkYarnPrincipal).append("sparkMesosDriverEnvSPARKSECURITYMESOSENABLE", sparkMesosDriverEnvSPARKSECURITYMESOSENABLE).append("sparkLocalityWait", sparkLocalityWait).append("sparkDriverMemory", sparkDriverMemory).append("sparkUiShowConsoleProgress", sparkUiShowConsoleProgress).append("sparkExecutorEnvSPARKDRIVERSECRETFOLDER", sparkExecutorEnvSPARKDRIVERSECRETFOLDER).append("sparkMesosRole", sparkMesosRole).append("sparkMesosConstraints", sparkMesosConstraints).append("sparkExecutorEnvSPARKSECURITYDATASTOREENABLE", sparkExecutorEnvSPARKSECURITYDATASTOREENABLE).append("sparkExecutorEnvVAULTPROTOCOL", sparkExecutorEnvVAULTPROTOCOL).append("sparkMesosExecutorDockerImage", sparkMesosExecutorDockerImage).append("sparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH", sparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH).append("sparkDriverCores", sparkDriverCores).append("sparkUiProxyBase", sparkUiProxyBase).append("sparkMesosCoarse", sparkMesosCoarse).append("sparkMesosDriverEnvSPARKDRIVERSECRETFOLDER", sparkMesosDriverEnvSPARKDRIVERSECRETFOLDER).append("sparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH", sparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH).append("sparkStreamingBlockInterval", sparkStreamingBlockInterval).append("sparkExecutorMemory", sparkExecutorMemory).append("sparkHadoopFsSftpImpl", sparkHadoopFsSftpImpl).append("sparkDriverExtraClassPath", sparkDriverExtraClassPath).append("sparkLocalDir", sparkLocalDir).append("sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH", sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH).append("sparkExecutorExtraClassPath", sparkExecutorExtraClassPath).append("sparkExecutorCores", sparkExecutorCores).append("sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH", sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH).append("sparkMemoryFraction", sparkMemoryFraction).append("sparkExecutorEnvVAULTHOSTS", sparkExecutorEnvVAULTHOSTS).append("sparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE", sparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE).append("sparkMesosDriverEnvVAULTPROTOCOL", sparkMesosDriverEnvVAULTPROTOCOL).append("sparkMesosDriverEnvVAULTHOSTS", sparkMesosDriverEnvVAULTHOSTS).append("sparkHadoopFsS3aImpl", sparkHadoopFsS3aImpl).append("sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH", sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH).append("sparkTaskMaxFailures", sparkTaskMaxFailures).append("sparkMesosExecutorHome", sparkMesosExecutorHome).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH).append(sparkHadoopFsS3aStsProxySslEnabled).append(sparkMesosDriverFailoverTimeout).append(sparkAppName).append(sparkMesosDriverEnvSPARKDRIVERSECRETFOLDER).append(sparkExecutorCores).append(sparkMemoryFraction).append(sparkMesosExecutorDockerImage).append(sparkHadoopYarnResourcemanagerPrincipal).append(sparkCoresMax).append(sparkMesosDriverDockerNetworkName).append(sparkHadoopFsS3aConnectionSslEnabled).append(sparkMesosCoarse).append(sparkExecutorEnvSPARKDATASTORESSLENABLE).append(sparkSqlCaseSensitive).append(sparkUiShowConsoleProgress).append(sparkLocalDir).append(sparkStreamingBlockInterval).append(sparkExecutorEnvVAULTPROTOCOL).append(sparkMesosRole).append(sparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE).append(sparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH).append(sparkHadoopFsSftpImpl).append(sparkExecutorEnvMESOSNATIVEJAVALIBRARY).append(sparkJars).append(sparkExecutorEnvVAULTPORT).append(sparkLocalityWait).append(sparkMesosDriverEnvSPARKSECURITYMESOSENABLE).append(sparkDriverMemory).append(sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH).append(sparkExecutorEnvVAULTHOSTS).append(sparkMesosDriverEnvVAULTHOST).append(sparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH).append(sparkUiProxyBase).append(sparkTaskMaxFailures).append(sparkExecutorExtraJavaOptions).append(sparkMesosExecutorDockerVolumes).append(sparkYarnPrincipal).append(sparkHadoopFsS3aImpl).append(sparkHadoopFsHdfsImplDisableCache).append(sparkMesosDriverEnvVAULTPROTOCOL).append(sparkExecutorEnvSPARKLOGLEVEL).append(sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH).append(sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH).append(sparkMesosConstraints).append(sparkMesosExecutorHome).append(sparkMesosDriverEnvVAULTPORT).append(sparkExecutorEnvSPARKDRIVERSECRETFOLDER).append(sparkExecutorMemory).append(sparkDriverExtraClassPath).append(sparkMesosDriverEnvVAULTHOSTS).append(sparkDriverCores).append(sparkMesosExecutorDockerNetworkName).append(sparkExecutorExtraClassPath).append(sparkExecutorEnvSPARKSECURITYDATASTOREENABLE).append(sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SparkConfigurations) == false) {
            return false;
        }
        SparkConfigurations rhs = ((SparkConfigurations) other);
        return new EqualsBuilder().append(sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH, rhs.sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH).append(sparkHadoopFsS3aStsProxySslEnabled, rhs.sparkHadoopFsS3aStsProxySslEnabled).append(sparkMesosDriverFailoverTimeout, rhs.sparkMesosDriverFailoverTimeout).append(sparkAppName, rhs.sparkAppName).append(sparkMesosDriverEnvSPARKDRIVERSECRETFOLDER, rhs.sparkMesosDriverEnvSPARKDRIVERSECRETFOLDER).append(sparkExecutorCores, rhs.sparkExecutorCores).append(sparkMemoryFraction, rhs.sparkMemoryFraction).append(sparkMesosExecutorDockerImage, rhs.sparkMesosExecutorDockerImage).append(sparkHadoopYarnResourcemanagerPrincipal, rhs.sparkHadoopYarnResourcemanagerPrincipal).append(sparkCoresMax, rhs.sparkCoresMax).append(sparkMesosDriverDockerNetworkName, rhs.sparkMesosDriverDockerNetworkName).append(sparkHadoopFsS3aConnectionSslEnabled, rhs.sparkHadoopFsS3aConnectionSslEnabled).append(sparkMesosCoarse, rhs.sparkMesosCoarse).append(sparkExecutorEnvSPARKDATASTORESSLENABLE, rhs.sparkExecutorEnvSPARKDATASTORESSLENABLE).append(sparkSqlCaseSensitive, rhs.sparkSqlCaseSensitive).append(sparkUiShowConsoleProgress, rhs.sparkUiShowConsoleProgress).append(sparkLocalDir, rhs.sparkLocalDir).append(sparkStreamingBlockInterval, rhs.sparkStreamingBlockInterval).append(sparkExecutorEnvVAULTPROTOCOL, rhs.sparkExecutorEnvVAULTPROTOCOL).append(sparkMesosRole, rhs.sparkMesosRole).append(sparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE, rhs.sparkMesosDriverEnvSPARKSECURITYDATASTOREENABLE).append(sparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH, rhs.sparkMesosDriverEnvSPARKSECURITYMESOSVAULTPATH).append(sparkHadoopFsSftpImpl, rhs.sparkHadoopFsSftpImpl).append(sparkExecutorEnvMESOSNATIVEJAVALIBRARY, rhs.sparkExecutorEnvMESOSNATIVEJAVALIBRARY).append(sparkJars, rhs.sparkJars).append(sparkExecutorEnvVAULTPORT, rhs.sparkExecutorEnvVAULTPORT).append(sparkLocalityWait, rhs.sparkLocalityWait).append(sparkMesosDriverEnvSPARKSECURITYMESOSENABLE, rhs.sparkMesosDriverEnvSPARKSECURITYMESOSENABLE).append(sparkDriverMemory, rhs.sparkDriverMemory).append(sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH, rhs.sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPATH).append(sparkExecutorEnvVAULTHOSTS, rhs.sparkExecutorEnvVAULTHOSTS).append(sparkMesosDriverEnvVAULTHOST, rhs.sparkMesosDriverEnvVAULTHOST).append(sparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH, rhs.sparkExecutorEnvSPARKSECURITYDATASTOREVAULTKEYPASSPATH).append(sparkUiProxyBase, rhs.sparkUiProxyBase).append(sparkTaskMaxFailures, rhs.sparkTaskMaxFailures).append(sparkExecutorExtraJavaOptions, rhs.sparkExecutorExtraJavaOptions).append(sparkMesosExecutorDockerVolumes, rhs.sparkMesosExecutorDockerVolumes).append(sparkYarnPrincipal, rhs.sparkYarnPrincipal).append(sparkHadoopFsS3aImpl, rhs.sparkHadoopFsS3aImpl).append(sparkHadoopFsHdfsImplDisableCache, rhs.sparkHadoopFsHdfsImplDisableCache).append(sparkMesosDriverEnvVAULTPROTOCOL, rhs.sparkMesosDriverEnvVAULTPROTOCOL).append(sparkExecutorEnvSPARKLOGLEVEL, rhs.sparkExecutorEnvSPARKLOGLEVEL).append(sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH, rhs.sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPATH).append(sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH, rhs.sparkExecutorEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH).append(sparkMesosConstraints, rhs.sparkMesosConstraints).append(sparkMesosExecutorHome, rhs.sparkMesosExecutorHome).append(sparkMesosDriverEnvVAULTPORT, rhs.sparkMesosDriverEnvVAULTPORT).append(sparkExecutorEnvSPARKDRIVERSECRETFOLDER, rhs.sparkExecutorEnvSPARKDRIVERSECRETFOLDER).append(sparkExecutorMemory, rhs.sparkExecutorMemory).append(sparkDriverExtraClassPath, rhs.sparkDriverExtraClassPath).append(sparkMesosDriverEnvVAULTHOSTS, rhs.sparkMesosDriverEnvVAULTHOSTS).append(sparkDriverCores, rhs.sparkDriverCores).append(sparkMesosExecutorDockerNetworkName, rhs.sparkMesosExecutorDockerNetworkName).append(sparkExecutorExtraClassPath, rhs.sparkExecutorExtraClassPath).append(sparkExecutorEnvSPARKSECURITYDATASTOREENABLE, rhs.sparkExecutorEnvSPARKSECURITYDATASTOREENABLE).append(sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH, rhs.sparkMesosDriverEnvSPARKSECURITYDATASTOREVAULTCERTPASSPATH).isEquals();
    }

}
