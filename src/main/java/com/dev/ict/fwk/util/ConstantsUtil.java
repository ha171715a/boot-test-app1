package com.dev.fwk.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConstantsUtil {
    public static final int READ_TIMEOUT = 3000;
    public static final int CONNECT_TIMEOUT = 2000;

    @UtilityClass
    public static class HttpClient {

    	public static final int MAX_CONN_PER_ROUTE = 10;
    	public static final int CONNECT_TIMEOUT = 3;
    	public static final int READ_TIMEOUT = 30;

    }
}
