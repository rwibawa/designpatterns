package com.avisow.designpatterns.structuralpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class App2 {

    public static void main(String[] args) {

        Code code = new Code();
        code.setCode("C Code...");
        Platform platform = PlatformFactory.getPlatformInstance("C");
        platform.execute(code);
        System.out.println("-------------------------------------");
        code = new Code();
        code.setCode("C Code2...");
        platform = PlatformFactory.getPlatformInstance("C");
        platform.execute(code);
        System.out.println("-------------------------------------");
        code = new Code();
        code.setCode("JAVA Code...");
        platform = PlatformFactory.getPlatformInstance("JAVA");
        platform.execute(code);
        System.out.println("-------------------------------------");
        code = new Code();
        code.setCode("JAVA Code2...");
        platform = PlatformFactory.getPlatformInstance("JAVA");
        platform.execute(code);
        System.out.println("-------------------------------------");
        code = new Code();
        code.setCode("RUBY Code...");
        platform = PlatformFactory.getPlatformInstance("RUBY");
        platform.execute(code);
        System.out.println("-------------------------------------");
        code = new Code();
        code.setCode("RUBY Code2...");
        platform = PlatformFactory.getPlatformInstance("RUBY");
        platform.execute(code);
    }

}

class Code {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

interface Platform {
    void execute(Code code);
}

class PlatformFactory {

    private static final Map<String, Platform> map = new HashMap<>();
    private PlatformFactory(){
        throw new AssertionError("Cannot instantiate the class");
    }

    public static synchronized Platform getPlatformInstance(String platformType){
        Platform platform = map.get(platformType);
        if(platform==null){
            switch(platformType){
                case "C" : platform = new CPlatform();
                    break;
                case "CPP" : platform = new CPPPlatform();
                    break;
                case "JAVA" : platform = new JavaPlatform();
                    break;
                case "RUBY" : platform = new RubyPlatform();
                    break;
            }

            map.put(platformType, platform);
        }

        return platform;
    }
}

class CPlatform implements Platform {

    public CPlatform(){
        System.out.println("CPlatform object created");
    }

    @Override
    public void execute(Code code) {
        System.out.println("Compiling and executing C code.");
    }

}

class CPPPlatform implements Platform{

    public CPPPlatform(){
        System.out.println("CPPPlatform object created");
    }

    @Override
    public void execute(Code code) {
        System.out.println("Compiling and executing CPP code.");
    }

}

class JavaPlatform implements Platform {

    public JavaPlatform(){
        System.out.println("JavaPlatform object created");
    }

    @Override
    public void execute(Code code) {
        System.out.println("Compiling and executing Java code.");
    }

}

class RubyPlatform implements Platform{

    public RubyPlatform(){
        System.out.println("RubyPlatform object created");
    }

    @Override
    public void execute(Code code) {
        System.out.println("Compiling and executing Ruby code.");
    }

}