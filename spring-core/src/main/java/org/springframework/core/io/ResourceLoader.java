/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.io;

import org.springframework.lang.Nullable;
import org.springframework.util.ResourceUtils;

/**
 * 策略模式的一种实现。
 * 为 Spring 资源加载的统一抽象，具体的资源加载则由相应的实现类来完成，
 * 所以我们可以将 ResourceLoader 称作为统一资源定位器
 */
public interface ResourceLoader {

	//默认为 classpath:
	String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;


	/**
	 * 获取资源
	 * e.g. "file:C:/test.dat".
	 * e.g. "classpath:test.dat".
	 * e.g. "WEB-INF/test.dat".
	 *
	 * 主要实现是在其子类 DefaultResourceLoader 中实现
	 */
	Resource getResource(String location);

	/**
	 * 返回 ClassLoader 实例，对于想要获取 ResourceLoader 使用的 ClassLoader 用户来说，
	 * 可以直接调用该方法来获取。在分析 Resource 时，提到了一个类 ClassPathResource ，这个类是可以根据指定的 ClassLoader 来加载资源的。
	 */
	@Nullable
	ClassLoader getClassLoader();

}
