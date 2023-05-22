package org.example.Compulsory;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {

        try {
            String path = "C:\\Users\\andrei14\\Desktop\\Lab12\\src\\main\\java\\org\\example\\Compulsory\\Test\\TestClass.class";
          //System.out.println(getClassName(path));
            Class<?> cls = Class.forName(getClassName(path));

            String packageName = cls.getPackageName();
            System.out.println("Package: " + packageName + " Class: " + cls.getSimpleName());

            Method[] methods = cls.getDeclaredMethods();

            for(Method method : methods){
                if(method.isAnnotationPresent(Test.class) && method.getParameterCount() == 0
                && Modifier.isStatic(method.getModifiers())) {
                    System.out.println("Se executa testul: " + method.getName());
                    method.invoke(null);
                    System.out.println("Test complet");
                }

            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getClassName(String path)
    {
        int start = path.lastIndexOf("org\\");
        int end = path.lastIndexOf(".");
        return path.substring(start, end).replace('\\', '.');
    }
}