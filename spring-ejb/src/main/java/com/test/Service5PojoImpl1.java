package com.test;

import com.test.ReNameService5.Impl;

@ReNameService5(Impl.Impl1) //因@ReNameServcie5被 @Named重新定義過，因此可以當作是 Service5Pojo 這個 bean 的一個識別
public class Service5PojoImpl1 implements Service5Pojo{

}
