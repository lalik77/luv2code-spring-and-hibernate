package com.mami.luv2codes.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExpressions {

    @Pointcut("execution( * com.mami.luv2codes.aopdemo.dao.*.* (..))")
    public void forDaoPackage() {

    }

    @Pointcut("execution(* com.mami.luv2codes.aopdemo.dao.*.set*(..))")
    public void forSetter() {}

    @Pointcut("execution(* com.mami.luv2codes.aopdemo.dao.*.get*(..))")
    public void forGetter() {}

    // create combine expression

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    public void forDaoPackageNoGetterNoSetter() {}
}
