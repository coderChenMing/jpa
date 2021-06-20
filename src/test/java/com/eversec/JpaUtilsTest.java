package com.eversec;

import com.eversec.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @desc 测试类
 *  @author chenming@eversec.cn
 *  @date 2021年06月20日 0:59
 *  
 */
public class JpaUtilsTest {
    @Test
    public void saveCust() {
        /*加载persistence.xml创建工厂
         * 1.维护了数据库信息
         * 2.维护了缓存信息
         * 3.维护了所有实体管理器对象
         * 4.在创建factory的时候会根据配置创建数据库表
         * 所以factory的创建过程是非常消耗资源的，怎么避免消耗资源？？
         * 创建一个公共的factory,每个线程都用，这样就节省了很多资源
         * 实现方式：静态代码块的方式
         * 创建factory时是线程安全的
         * */
        // EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        /*通过实体关系工厂获取实体管理器*/
        EntityManager entityManager = JpaUtils.getEntityManager();
        /*获取事务对象,开启事务
         *
         *
         * */
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        /*保存一个客户到数据库中*/
        Customer customer = new Customer();
        customer.setCustName("令狐冲");
        customer.setCustAddress("北岳恒山");
        customer.setCustIndustry("武林中人");
        customer.setCustPhone("333333333");
        customer.setCustLevel("顶级杀手");
        /*保存*/
        entityManager.persist(customer);
        /*提交事务*/
        tx.commit();
        /*释放资源*/
        entityManager.close();
        JpaUtils.close();
    }

    @Test
    public void testFind() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.find(Customer.class, 1l);
        System.out.println(customer);
        transaction.commit();
        entityManager.close();
        JpaUtils.close();


    }

    /*
     * getReference：获取的是实体的代理对象
     * sql查询在获取实体的属性信息时才发生，也就是懒加载
     *
     * find:立即加载
     *
     *
     * */
    @Test
    public void testReference() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.getReference(Customer.class, 1l);
        System.out.println(customer);
        transaction.commit();
        entityManager.close();
        JpaUtils.close();


    }

    /*删除*/
    @Test
    public void testRemove() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 1.根据Id查询
        Customer customer = entityManager.find(Customer.class, 1l);
        System.out.println(customer);
        // 2.删除
        entityManager.remove(customer);

        transaction.commit();
        entityManager.close();
        JpaUtils.close();
    }

    /*更新*/
    @Test
    public void testUpdate() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 1.根据Id查询
        Customer customer = entityManager.find(Customer.class, 2l);
        System.out.println(customer);
        customer.setCustIndustry("just do it");
        // 2.更新
        entityManager.merge(customer);

        transaction.commit();
        entityManager.close();
        JpaUtils.close();
    }
}
