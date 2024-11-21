package com.hss.versionConvert;

/**
 * <p>
 *
 * </p>
 *
 * @author Hss
 * @date 2024-11-21
 */
public class VersionUtil {

    /**
     * 将数字类型的版本号转换为Vxx.xx.xx格式的版本号
     * @param versionNumber
     * @return
     */
    public static String convertVersionNumber(int versionNumber) {
        // 确保版本号大于等于0
        if (versionNumber < 0) {
            throw new IllegalArgumentException("版本号必须是非负整数");
        }

        // 计算各个部分
        int major = versionNumber / 10000;
        int minor = (versionNumber % 10000) / 100;
        int patch = versionNumber % 100;

        // 格式化输出
        return String.format("V%s.%s.%s", major, minor, patch);
    }

    public static void main(String[] args) {
        // 示例版本号
        //int versionNumber = 1;
        //int versionNumber = 77;
        //int versionNumber = 123;
        //int versionNumber = 4949;
        int versionNumber = 11111;
        //int versionNumber = 103045;
        //int versionNumber = 999999;
        //int versionNumber = 111103045;

        String formattedVersion = convertVersionNumber(versionNumber);
        // 输出: V10.30.45
        System.out.println(formattedVersion);
    }
}
