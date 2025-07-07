package com.hss.algorithm.encipher;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  HmacSHA256 加解密工具类（时效性）
 * </p>
 *
 * @author Hss
 * @date 2025-07-07
 */
public class TimeLimitedHmacSHA256Util {

    private static final String HMAC_ALGORITHM = "HmacSHA256";

    private final SecretKeySpec secretKey;
    private final long validityPeriodMillis;

    public TimeLimitedHmacSHA256Util(String secretKey, long validityPeriod, TimeUnit unit) {
        this.secretKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_ALGORITHM);
        this.validityPeriodMillis = unit.toMillis(validityPeriod);
    }

    /**
     * 生成带时间戳的HMAC签名
     */
    public String generateTimeLimitedToken(String data) throws Exception {
        long timestamp = System.currentTimeMillis();
        String dataWithTimestamp = timestamp + "|" + data;

        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(secretKey);
        byte[] hmacBytes = mac.doFinal(dataWithTimestamp.getBytes(StandardCharsets.UTF_8));

        // 将时间戳和HMAC一起编码返回
        return timestamp + ":" + Base64.getEncoder().encodeToString(hmacBytes);
    }

    /**
     * 验证带时效的HMAC签名
     */
    public boolean verifyTimeLimitedToken(String data, String token) throws Exception {
        String[] parts = token.split(":", 2);
        if (parts.length != 2) {
            return false;
        }

        long timestamp;
        try {
            timestamp = Long.parseLong(parts[0]);
        } catch (NumberFormatException e) {
            return false;
        }

        // 检查时间是否过期
        long currentTime = System.currentTimeMillis();
        if (currentTime - timestamp > validityPeriodMillis) {
            return false;
        }

        // 重新计算HMAC进行比较
        String dataWithTimestamp = timestamp + "|" + data;
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(secretKey);
        byte[] expectedHmac = mac.doFinal(dataWithTimestamp.getBytes(StandardCharsets.UTF_8));
        byte[] actualHmac = Base64.getDecoder().decode(parts[1]);

        return constantTimeEquals(expectedHmac, actualHmac);
    }

    /**
     * 安全比较两个字节数组，防止时序攻击
     */
    private boolean constantTimeEquals(byte[] a, byte[] b) {
        if (a.length != b.length) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result |= a[i] ^ b[i];
        }
        return result == 0;
    }

    public static void main(String[] args) throws Exception {
        // 示例用法
        String secretKey = "ThisIsASecretKeyForHmacSHA256";
        String originalData = "Important message to protect";

        TimeLimitedHmacSHA256Util hmac = new TimeLimitedHmacSHA256Util(secretKey, 5, TimeUnit.SECONDS);

        // 生成带时效的token
        String token = hmac.generateTimeLimitedToken(originalData);
        System.out.println("Generated token: " + token);

        // 验证token
        boolean isValid = hmac.verifyTimeLimitedToken(originalData, token);
        System.out.println("Token is valid: " + isValid);

        // 篡改数据测试
        boolean isTamperedValid = hmac.verifyTimeLimitedToken("Tampered message", token);
        System.out.println("Tampered token is valid: " + isTamperedValid);

        // 过期测试（取消注释测试）
         Thread.sleep(TimeUnit.SECONDS.toMillis(6));
         boolean isExpiredValid = hmac.verifyTimeLimitedToken(originalData, token);
         System.out.println("Expired token is valid: " + isExpiredValid);
    }
}
