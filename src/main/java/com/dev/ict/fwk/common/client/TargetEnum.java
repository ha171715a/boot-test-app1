package com.dev.ict.fwk.common.client;

public enum TargetEnum {
    SMP0("boot-test-app0"),
    SMP1("boot-test-app1"),
    SMP2("boot-test-app2"),
    SMP3("boot-test-app3"),
    SMP4("boot-test-app4"),
    SMP5("boot-test-app5"),
    SMP6("boot-test-app6"),
    SMP7("boot-test-app7"),
    SMP8("boot-test-app8"),
    SMP9("boot-test-app9"),
    SMP10("boot-test-app10"),
    SMP11("boot-test-app11"),
    SMP12("boot-test-app12"),
    SMP13("boot-test-app13"),
    SMP14("boot-test-app14"),
    SMP15("boot-test-app15"),
    SMP16("boot-test-app16"),
    SMP17("boot-test-app17"),
    SMP18("boot-test-app18"),
    SMP19("boot-test-app19"),
    SMP20("boot-test-app20"),
    SMP21("boot-test-app21"),
    SMP22("boot-test-app22"),
    SMP23("boot-test-app23"),
    SMP24("boot-test-app24"),
    SMP25("boot-test-app25"),
    SMP26("boot-test-app26"),
    SMP27("boot-test-app27"),
    SMP28("boot-test-app28"),
    SMP29("boot-test-app29"),
    SMP30("boot-test-app30");
    
    private final String value;
    
    TargetEnum(String value){
        this.value = value;
    }
    
    public String getValue(){
        return value;
    }
}
