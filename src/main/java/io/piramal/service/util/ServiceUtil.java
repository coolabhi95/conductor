package io.piramal.service.util;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class ServiceUtil {
    public static Map<String, Object> getHeader() {
        return new ImmutableMap.Builder<String, Object>().put("X-Authorization",
                "eyJhbGciOiJIUzUxMiJ9.eyJvcmtlc19rZXkiOiI1ZTcwYmU1NS0xNDhhLTQxMzItYjNlOS1lMjk4OGNkMmRiNjUiLCJvcmtlc19jb25kdWN0b3JfdG9rZW4iOnRydWUsInN1YiI6ImFwcDo4YjVjODYzNy1mYjUyLTQwZjgtOTQyNC0wODcyMmU1OTg3OTYiLCJpYXQiOjE2NzQ1NTMzNjh9.eE_RPo852ChemHUIkPOIwfQfwiWOp1WT05rGdQH6WVj82Cbpc-gBozymvHTUGQ18TnROtMbTfi3OfWcwe_4MxQ").build();
    }
}
