package com.legouu.common.AnnocationFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @target的用法
 * METHOD	可用于方法上
 * TYPE	可用于类或者接口上
 * ANNOTATION_TYPE	可用于注解类型上（被@interface修饰的类型）
 * CONSTRUCTOR	可用于构造方法上
 * FIELD	可用于域上
 * LOCAL_VARIABLE	可用于局部变量上
 * PACKAGE	用于记录java文件的package信息
 * PARAMETER	可用于参数上
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransferType {
    PointGroup value();

}
