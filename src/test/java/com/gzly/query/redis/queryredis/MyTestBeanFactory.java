package com.gzly.query.redis.queryredis;

import com.gzly.query.redis.queryredis.bean.MyBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author lzk
 * @date 2018/7/10
 */
@SuppressWarnings("deprecation")
public class MyTestBeanFactory {

    @Test
    public void first() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("mytest.xml"));
        MyBean myBean = (MyBean) bf.getBean("myBean");
        Assert.assertEquals("haha",myBean.str);
    }
}
