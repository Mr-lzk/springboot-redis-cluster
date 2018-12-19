package com.gzly.query.redis.queryredis.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @author lzk
 * @date 2018/12/12
 */
public class DiskClassLoader extends ClassLoader {

    private String mLibPath;

    public DiskClassLoader(String path) {
        mLibPath = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String fileName = getFileName(name);
        File file = new File(mLibPath, fileName);
        try {
            FileInputStream is = new FileInputStream(file);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            int len = 0;
            while ((len = is.read()) != -1) {
                os.write(len);
            }
            byte[] data = os.toByteArray();
            is.close();
            os.close();
            return defineClass(name, data, 0, data.length);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        return index == -1 ? name.concat(".class") : name.substring(index + 1).concat(".class");
    }

    public static void main(String[] args) {
        DiskClassLoader diskClassLoader = new DiskClassLoader("D:/");
        try {
            Class clazz = diskClassLoader.loadClass("TestXx");

            if (clazz != null) {
                Object o = clazz.newInstance();
                Method m = clazz.getDeclaredMethod("say", null);
                m.invoke(o, null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
