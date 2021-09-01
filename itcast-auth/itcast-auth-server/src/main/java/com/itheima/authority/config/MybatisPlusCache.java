package com.itheima.authority.config;

import com.itheima.tools.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class MybatisPlusCache implements Cache {

    // 读写锁
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    private CacheChannel cache;

    private String id;

    //是mybatis必须要求的，必写。此id是xml中的namespace的值
    public MybatisPlusCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("未获取到缓存实例id");
        }
        this.id = id;
        log.info("初始化MyBatisPlus二级缓存成功:{}", id);
    }

    public CacheChannel getCache() {
        if (cache == null) {
            cache = SpringUtils.getBean(CacheChannel.class);
        }
        return cache;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        getCache().set(getId(), o.toString(), o1);
    }

    @Override
    public Object getObject(Object o) {
        CacheObject cacheObject = getCache().get(getId(), o.toString());
        return cacheObject.getValue();
    }

    @Override
    public Object removeObject(Object o) {
        CacheObject cacheObject = getCache().get(getId(), o.toString());
        Object value = cacheObject.getValue();
        cache.evict(getId(), o.toString());
        return value;
    }

    @Override
    public void clear() {
        getCache().clear(getId());
    }

    @Override
    public int getSize() {
        return getCache().keys(getId()).size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
