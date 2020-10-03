/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TransferServiceFactory
 * Author:   莉莉
 * Date:     2020/6/13 17:32
 * Description: 建立工厂，用于通过注解来获得相应的实例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.AnnocationFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈建立工厂，用于通过注解来获得相应的实例〉
 *
 * @author 莉莉
 * @create 2020/6/13
 * @since 1.0.0
 */
@Service
@Component
@Configuration
public class TransferServiceFactory implements InitializingBean, ApplicationContextAware {
    private ApplicationContext applicationContext;//这个是spring中联系上下文的重要工具
    private static Map<PointGroup,TransferService> transferServiceMap = new HashMap();

    public TransferService getTransferService(String TP){
        PointGroup[] values = PointGroup.values();
        for (int i = 0; i < values.length; i++) {
            PointGroup value = values[i];
            if (value.getList().contains(TP)){
                System.out.println("map:"+transferServiceMap);
                return transferServiceMap.get(value);
            }
        }
        return null;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        //applicationContext可以通过该方法获取注解类的所有实例并初始化
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(TransferType.class);
        //获取的bean的实例被同一放置在一个set集合
        Set<Map.Entry<String, Object>> entries = beans.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        for(entries.iterator(); iterator.hasNext();){
            Map.Entry<String, Object> next = iterator.next();
            TransferService value = (TransferService) next.getValue();
            TransferType annotation = value.getClass().getAnnotation(TransferType.class);
            transferServiceMap.put(annotation.value(),value);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext arg) throws BeansException {
        this.applicationContext = arg;
    }
}