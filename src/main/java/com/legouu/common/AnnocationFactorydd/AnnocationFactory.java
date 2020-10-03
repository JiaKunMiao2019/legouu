/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AnnocationFactory
 * Author:   莉莉
 * Date:     2020/6/21 21:00
 * Description: 初始化所有的注解
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.AnnocationFactorydd;

import com.legouu.common.AnnocationFactorydd.messege.ProductCodes;
import com.legouu.common.AnnocationFactorydd.messege.ProductType;
import com.legouu.common.AnnocationFactorydd.pojo.TranserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈初始化所有的注解〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
@Component("annocationFactory")
public class AnnocationFactory implements InitializingBean, ApplicationContextAware {
    private ApplicationContext applicationContext;
    private HashMap<ProductCodes,TranserService> transerServices = new HashMap<>();

    public TranserService doFactory(String msg){
        ProductCodes[] values = ProductCodes.values();
        for (int i = 0; i < values.length; i++) {
            ProductCodes value = values[i];
            if (value.getList().contains(msg)){
                TranserService transerService = transerServices.get(value);
                return transerService;
            }
        }
        return null;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(ProductType.class);
        Set<Map.Entry<String, Object>> entries = beans.entrySet();
        for (Iterator<Map.Entry<String, Object>> iterator =entries.iterator();iterator.hasNext();){
            Map.Entry<String, Object> next = iterator.next();
            TranserService value = (TranserService) next.getValue();
            ProductType annotation = value.getClass().getAnnotation(ProductType.class);
            transerServices.put(annotation.value(),value);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}