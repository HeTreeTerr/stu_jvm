package com.hss.algorithm.encipher;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * <p>
 *  HmacSHA256 加解密工具类
 * </p>
 *
 * @author Hss
 * @date 2025-03-24
 */
public class HmacSha256Util {

    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

    /**
     * 生成 HMAC-SHA256 签名
     *
     * @param data 待签名的数据
     * @param secret 密钥
     * @return 十六进制格式的签名
     * @throws RuntimeException 当加密过程中出现异常时抛出
     */
    public static String sign(String data, String secret) {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_SHA256_ALGORITHM);
            mac.init(secretKeySpec);
            byte[] rawHmac = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(rawHmac);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Failed to generate HMAC-SHA256 signature", e);
        }
    }

    /**
     * 生成 HMAC-SHA256 签名并返回 Base64 编码结果
     *
     * @param data 待签名的数据
     * @param secret 密钥
     * @return Base64 编码的签名
     * @throws RuntimeException 当加密过程中出现异常时抛出
     */
    public static String signToBase64(String data, String secret) {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_SHA256_ALGORITHM);
            mac.init(secretKeySpec);
            byte[] rawHmac = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(rawHmac);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Failed to generate HMAC-SHA256 signature", e);
        }
    }

    /**
     * 验证 HMAC-SHA256 签名是否有效
     *
     * @param data 原始数据
     * @param secret 密钥
     * @param signature 待验证的签名（十六进制格式）
     * @return 验证结果
     */
    public static boolean verify(String data, String secret, String signature) {
        String expectedSignature = sign(data, secret);
        return expectedSignature.equals(signature);
    }

    /**
     * 验证 Base64 编码的 HMAC-SHA256 签名是否有效
     *
     * @param data 原始数据
     * @param secret 密钥
     * @param base64Signature 待验证的签名（Base64 格式）
     * @return 验证结果
     */
    public static boolean verifyBase64(String data, String secret, String base64Signature) {
        String expectedSignature = signToBase64(data, secret);
        return expectedSignature.equals(base64Signature);
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String secret = "mySecretKey";
        String data = "dataToSign";

        // 生成十六进制格式的签名
        String signature = HmacSha256Util.sign(data, secret);
        System.out.println("HMAC-SHA256 Signature (Hex): " + signature);

        // 生成Base64格式的签名
        String base64Signature = HmacSha256Util.signToBase64(data, secret);
        System.out.println("HMAC-SHA256 Signature (Base64): " + base64Signature);

        // 验证签名
        boolean isValid = HmacSha256Util.verify(data, secret, signature);
        System.out.println("Signature is valid: " + isValid);

        // 验证Base64签名
        boolean isBase64Valid = HmacSha256Util.verifyBase64(data, secret, base64Signature);
        System.out.println("Base64 Signature is valid: " + isBase64Valid);
    }
}