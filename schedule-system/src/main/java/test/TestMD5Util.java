package test;

import org.testng.annotations.Test;
import util.MD5Util;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
public class TestMD5Util {
    @Test
    public void testEncrypt() {
        System.out.println(MD5Util.encrypt("123456"));
    }
}
