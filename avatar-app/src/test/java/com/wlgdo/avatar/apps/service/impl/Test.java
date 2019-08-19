package com.wlgdo.avatar.apps.service.impl;

import com.wlgdo.avatar.apps.entity.AppInfo;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) throws IntrospectionException {
		Class clazz = AppInfo.class;
		String field = "appId";
		PropertyDescriptor pd = new PropertyDescriptor(field, clazz);
		Method getMethod = pd.getReadMethod();

		List<AppInfo> list = new ArrayList<>();
		AppInfo app1 = new AppInfo();
		app1.setAppId(1);
		list.add(app1);
		AppInfo app2 = new AppInfo();
		app2.setAppId(2);
		list.add(app2);

		//注意在lambda中key相同时会异常
		Map<Object, AppInfo> collect = list.stream().collect(Collectors.toMap(act -> {
			try {
				return (getMethod.invoke(act));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return null;
		}, act -> act));

		System.out.println(collect);

	}
}
