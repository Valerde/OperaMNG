package com.sovava.pojo;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月29日 16:21
 **/
public class Opera {
    //id 主键
    private Integer id;
    //剧目名称
    private String operaName;
    //行当
    private String roles;
    //流派名称
    private String genreName;
    //类型字段
    private Integer type;
    //演员
    private String actor;
    //本地路径
    private String localPath;
    //bilibili路径
    private String biliPath;
    //描述信息
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperaName() {
        return operaName;
    }

    public void setOperaName(String operaName) {
        this.operaName = operaName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeStr() {
        switch (type) {
            case 1: {
                return "全本";
            }
            case 2: {
                return "集锦";
            }
            case 3: {
                return "音频";
            }
            default: {
                return "未知";
            }
        }
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getBiliPath() {
        return biliPath;
    }

    public void setBiliPath(String biliPath) {
        this.biliPath = biliPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Opera{" +
                "id=" + id +
                ", operaName='" + operaName + '\'' +
                ", roles='" + roles + '\'' +
                ", genreName='" + genreName + '\'' +
                ", type=" + type +
                ", actor='" + actor + '\'' +
                ", localPath='" + localPath + '\'' +
                ", biliPath='" + biliPath + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
