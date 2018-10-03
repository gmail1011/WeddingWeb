package com.dongnao.weixinapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by 廖师兄
 * 2017-07-30 17:31
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @Pointcut("execution(public * com.dongnao.weixinapp.controller.Seller*.*(..))" +
//    "&& !execution(public * com.dongnao.weixinapp.controller.SellerUserController.*(..))")
//    public void verify() {}
//
//    @Before("verify()")
//    public void doVerify() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        //查询cookie
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if (cookie == null) {
//            log.warn("【登录校验】Cookie中查不到token");
//            throw new SellerAuthorizeException();
//        }
//
//        //去redis里查询
//        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
//        if (StringUtils.isEmpty(tokenValue)) {
//            log.warn("【登录校验】Redis中查不到token");
//            throw new SellerAuthorizeException();
//        }
//    }
}
