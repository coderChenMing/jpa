package com.eversec.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @desc 创建factory
 *  @author chenming@eversec.cn
 *  @date 2021年06月20日 11:02
 *  
 */
public class JpaUtils {
    private static EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("myJpa");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close() {
        entityManagerFactory.close();
    }
}
