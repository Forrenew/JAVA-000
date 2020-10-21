package Jike.week1;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZuoYe1 extends ClassLoader {
	public static void main(String args[]) {
 
		try {
//			Hello hello = new Hello();
//			hello.hello();
			System.out.println("***************************");
 
			Class clazz = new ZuoYe1().findClass("Hello");
			 Object obj = clazz.newInstance();
			 Method method = clazz.getMethod("hello");
			  method.invoke(obj);
			 
			System.out.println("---------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	@Override
	protected Class<?> findClass(String name){
		String spath = "file:///E:/eclipse/workspace/test/src/Jike/week1/" + name + ".class";
		byte[] cLassBytes = null;
        Path path = null;
        try {
            path = Paths.get(new URI(spath));
            cLassBytes = Files.readAllBytes(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Class clazz = defineClass("Jike.week1.Hello", cLassBytes, 0, cLassBytes.length);
        return clazz;
	}
}
