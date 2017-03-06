package cn.simafei.mybatis.bean;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 基类
 */
@MappedSuperclass
public abstract class IdEntity implements Serializable {
    @Id
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == null;
    }

    public boolean isExist() {
        return id != null;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        IdEntity that = (IdEntity) obj;
        return 0 != this.getId() && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += id == null ? 0 : getId() * 31;
        return hashCode;
    }

    @Override
    public String toString() {
        return String.format("%s(id=%s)", this.getClass().getSimpleName(), getId());
    }
}

