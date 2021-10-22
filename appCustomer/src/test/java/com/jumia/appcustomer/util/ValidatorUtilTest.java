package com.jumia.appcustomer.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ValidatorUtilTest {
    @Test
    private void valideCode(){
        assertTrue(ValidatorUtil.validePhone("(251) 9111684500","\\(251\\)\\ ?[1-59]\\d{8}$"));
    }
}