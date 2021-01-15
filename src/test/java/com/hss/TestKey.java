package com.hss;

public class TestKey {

    public static void main(String[] args) {

        //新生成的公钥私钥
        String mySelfPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDrrDN1tghEMWQfMJTOx35UuP9X7Hgy8q2JJodj84seXlz2GAwc8uF3IQl+j2UmZhu+XsM8hmpPE1sDEK8e07UfRgAsIbdU4Ivi1occ3ikT6WUGRKoWV+1dqEROUesxNDzQvrxfuY1be+ilxK5COLg4Uuf+zzlXGZBSg86ZmVezmQIDAQAB";
        String mySelfPrivateKey= "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOusM3W2CEQxZB8wlM7HflS4/1fseDLyrYkmh2Pzix5eXPYYDBzy4XchCX6PZSZmG75ewzyGak8TWwMQrx7TtR9GACwht1Tgi+LWhxzeKRPpZQZEqhZX7V2oRE5R6zE0PNC+vF+5jVt76KXErkI4uDhS5/7POVcZkFKDzpmZV7OZAgMBAAECgYAhTkeYJz7EKGNubFFeEbUUUxq0Tx/Dj3v1NIPmHRPi7vyzQ2hpf5exMXLj4cRZPg1GBPgRfyuEplxyh/KVEt/3LdXfJATsQdVzBXIdX8h4lZhCk6+6OueisqlwnFg7zy0s41/aqhd0I72YZX1wjugy6jDHAzp9A/oXQFEK7ZmIuwJBAP8QzS2oOGYxLll9iyvSsm0p/lJ3SRoPaaOWSnEYahPfEt8mTX4VwXKBQmAC9j+mxzxFm41hWZm1FB/ybrIy0NcCQQDsiTaEwklb1W1saHC18uJJjm5Sm9GdSPudogHSAy+DN7PE/CQnaAGUyZhZh65OvcxA+7J6kiG90Fjc44ufJGEPAkEA6khffjGG5G8GONL1E2Kr21N4M/03W0WO7eCtLeaUAP6kke3Xvhlzn56U/iWaVGr3lCgHsjwaFfJasuF2xh2g7wJBAJVoBlvNLPEo2rlDLw5+oJi9ssnTSpAC7YwgLO4uvPAxWwfuDBgoBfepbuX+YgeyszXIxm/NpipzU+4SfLrFC9kCQGKHC4pI+kvb9Cu3nwt3xHPObPclEWaqpuAozyef+3QcLp+Z6DpSXIs7GCh/c+21xHr/qdR4z17qAIBmGzdVbmU=";
        //当前线上的公钥私钥
        String proPublicKey = "";
        String proPrivateKey = "";

        System.out.println(mySelfPublicKey.length() == proPublicKey.length());
        System.out.println(mySelfPrivateKey.length() == proPrivateKey.length());
    }
}
