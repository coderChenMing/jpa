package com.eversec;

import javax.persistence.*;

/**
 * @desc 客户实体类
 * 配置映射关系
 * 1.实体类和表的映射关系
 * @entity:声明实体类
 * @Table:配置实体类和表的映射关系 name属性：配置数据库表的名称
 * 2.实体类属性和表中字段的映射关系
 * 1.声明主键：@Id
 * 2.声明主键的生成策略: @GeneratedValue
 * strategy:
 *   GenerationType.IDENTITY：支持主键自增的数据库 mysql
 *   SEQUENCE：支持序列的数据库,oracle
 *   AUTO:程序自动根据实际数据库帮我们选择
 *   TABLE:JPA提供的一种机制，以一张表的形式帮我们完成主键自增
 * <p>
 * <p>
 *  @author chenming@eversec.cn
 *  @date 2021年06月20日 0:44
 *  
 */
@Entity
@Table(name = "cst_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_source")
    private String custSource;

    @Column(name = "cust_level")
    private String custLevel;

    @Column(name = "cust_industry")
    private String custIndustry;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_phone")
    private String custPhone;

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }
}
