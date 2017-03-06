package cn.simafei.mybatis.mapper;

import cn.simafei.mybatis.annotation.AutoResultMap;
import cn.simafei.mybatis.annotation.FillEntityType;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;
import java.util.List;

/**
 * 提供基本的增删改查操作
 */
public interface ICrudMapper<T> {
    /**
     * 查找所有记录
     */
    @SelectProvider(type = CrudProvider.class, method = "findAll")
    @AutoResultMap
    List<T> findAll();

    /**
     * 统计所有记录行数
     */
    @SelectProvider(type = CrudProvider.class, method = "countAll")
    @FillEntityType
    int countAll();

    /**
     * 删除所有记录
     */
    @DeleteProvider(type = CrudProvider.class, method = "deleteAll")
    @FillEntityType
    int deleteAll();

    /**
     * 删除并创建一个同名的新表，可以回收innodb表空间，而且比deleteAll快，多用于测试case清理数据
     */
    @DeleteProvider(type = CrudProvider.class, method = "truncate")
    @AutoResultMap
    int truncate();

    /**
     * 根据主键查找记录
     */
    @SelectProvider(type = CrudProvider.class, method = "findById")
    @AutoResultMap
    T findById(Serializable id);

    /**
     * 插入记录
     */
    @InsertProvider(type = CrudProvider.class, method = "insert")
    int insert(T t);

    /**
     * 插入记录并且取回自动生成的ID
     */
    @InsertProvider(type = CrudProvider.class, method = "insert")
    @Options(useGeneratedKeys = true)
    int insertAndGetId(T t);

    /**
     * 更新记录
     */
    @UpdateProvider(type = CrudProvider.class, method = "update")
    int update(T t);

    /**
     * 更新记录
     */
    @UpdateProvider(type = CrudProvider.class, method = "save")
    int save(T t);

    /**
     * 删除记录
     */
    @DeleteProvider(type = CrudProvider.class, method = "delete")
    int delete(T t);

    /**
     * 根据主键删除记录
     */
    @DeleteProvider(type = CrudProvider.class, method = "deleteById")
    @AutoResultMap
    int deleteById(Serializable id);
}
