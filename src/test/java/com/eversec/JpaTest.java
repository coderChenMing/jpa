package com.eversec;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @desc 测试类
 *  @author chenming@eversec.cn
 *  @date 2021年06月20日 0:59
 *  
 */
public class JpaTest {
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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        /*通过实体关系工厂获取实体管理器*/
        EntityManager entityManager = factory.createEntityManager();
        /*获取事务对象,开启事务
        *
        *
        * */
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        /*保存一个客户到数据库中*/
        Customer customer = new Customer();
        customer.setCustName("今晚打老虎");
        customer.setCustAddress("中国上海滩");
        customer.setCustIndustry("trembling");
        customer.setCustPhone("99990000");
        customer.setCustLevel("心悦会员");
        /*保存*/
        entityManager.persist(customer);
        /*提交事务*/
        tx.commit();
        /*释放资源*/
        entityManager.close();
        factory.close();
    }
}
