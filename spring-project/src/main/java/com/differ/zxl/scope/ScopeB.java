package com.differ.zxl.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "scopeBB",proxyMode = ScopedProxyMode.INTERFACES)
public class ScopeB {
}
