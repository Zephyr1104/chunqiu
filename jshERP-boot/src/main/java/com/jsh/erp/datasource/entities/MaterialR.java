package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.Date;

public class MaterialR {
    private Long id;

    private String type;

    private Long organId;

    private Long creator;

    private Long auditor;

    private String qualityNo;

    private String qualityName;

    private Date qualityTime;

    private Long materialId;

    private String materialName;

    private BigDecimal operNumber;

    private BigDecimal basicNumber;

    private String materialUnit;

    private Long depotId;

    private String linkNumber;

    private String batchNumber;

    private String source;

    private String remark;

    private String fileName;

    private String status;

    private Date createTime;

    private Long tenantId;

    private String deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getOrganId() {
        return organId;
    }

    public void setOrganId(Long organId) {
        this.organId = organId;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public String getQualityNo() {
        return qualityNo;
    }

    public void setQualityNo(String qualityNo) {
        this.qualityNo = qualityNo;
    }

    public String getQualityName() {
        return qualityName;
    }

    public void setQualityName(String qualityName) {
        this.qualityName = qualityName;
    }

    public Date getQualityTime() {
        return qualityTime;
    }

    public void setQualityTime(Date qualityTime) {
        this.qualityTime = qualityTime;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public BigDecimal getOperNumber() {
        return operNumber;
    }

    public void setOperNumber(BigDecimal operNumber) {
        this.operNumber = operNumber;
    }

    public BigDecimal getBasicNumber() {
        return basicNumber;
    }

    public void setBasicNumber(BigDecimal basicNumber) {
        this.basicNumber = basicNumber;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    public String getLinkNumber() {
        return linkNumber;
    }

    public void setLinkNumber(String linkNumber) {
        this.linkNumber = linkNumber;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getAuditor() {
        return auditor;
    }

    public void setAuditor(Long auditor) {
        this.auditor = auditor;
    }
}