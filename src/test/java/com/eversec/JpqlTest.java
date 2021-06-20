package com.eversec;

import com.eversec.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @desc TODO
 *  @author chenming@eversec.cn
 *  @date 2021年06月20日 12:04
 *  
 */
public class JpqlTest {
    /*查询所有*/
    @Test
    public void queryAll() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 查询全部
        String sql = "from com.eversec.Customer ";
        Query query = entityManager.createQuery(sql);
        List resultList = query.getResultList();

        for (Object obj : resultList) {
            System.out.println(obj);
        }
        transaction.commit();

        entityManager.close();

    }

    /*倒叙查询*/
    @Test
    public void queryAllOrder() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 查询全部
        String sql = "from com.eversec.Customer order by  custId desc ";
        Query query = entityManager.createQuery(sql);
        List resultList = query.getResultList();

        for (Object obj : resultList) {
            System.out.println(obj);
        }
        transaction.commit();

        entityManager.close();

    }

    /*统计*/
    @Test
    public void testCount() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 查询全部
        String sql = "select count(custId) from com.eversec.Customer  ";
        Query query = entityManager.createQuery(sql);
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);

        transaction.commit();

        entityManager.close();

    }

    /*分页查询*/
    @Test
    public void testPageQuery() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 查询全部
        String sql = "from Customer ";
        Query query = entityManager.createQuery(sql);
        query.setFirstResult(0);
        query.setMaxResults(3);
        List resultList = query.getResultList();
        for (Object object : resultList) {
            System.out.println(object);

        }
        transaction.commit();

        entityManager.close();

    }
    /*条件查询*/
    @Test
    public void testCondition() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 查询全部
        String sql = "from Customer where custName like ?";
        Query query = entityManager.createQuery(sql);
        query.setParameter(1, "今%");
        List resultList = query.getResultList();
        for (Object object : resultList) {
            System.out.println(object);

        }
        transaction.commit();

        entityManager.close();

    }
}
