package com.differ.zxl.scope;

        import org.springframework.context.annotation.Scope;
        import org.springframework.context.annotation.ScopedProxyMode;
        import org.springframework.stereotype.Component;

@Component
@Scope(value = "scopeAA",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ScopeA {

        public void testM(){
                System.out.println("invoke testM");
        }
}
