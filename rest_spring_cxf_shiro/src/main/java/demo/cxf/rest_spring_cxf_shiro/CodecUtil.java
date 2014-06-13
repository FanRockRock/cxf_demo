package demo.cxf.rest_spring_cxf_shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

public class CodecUtil {

    public static String encryptMD5(String source) {
        return new Md5Hash(source).toHex();
    }
}
