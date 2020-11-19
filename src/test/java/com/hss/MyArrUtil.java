package com.hss;

import org.junit.Test;

public class MyArrUtil {

    @Test
    public void test(){
        //46列
        String[] arr1 = {
                "ID", "BASEINFOID", "ADDRESSINFOID", "ORGID", "ORGINTERNALCODE", "ISINFLOWING",
        "INFLOWINGREASON", "INFLOWINGDATE", "INFLOWINGPROVINCE", "INFLOWINGCITY", "INFLOWINGDISTRICT",
        "REGISTRATIONTYPE", "REGISTERDATE", "EXPECTEDDATEDUE", "LOGOUT", "CREATEUSER", "UPDATEUSER",
        "CREATEDATE", "UPDATEDATE", "CERTIFICATENUMBER", "STAYLOCATIONTYPEID", "ECONOMYSOURCEID",
        "STAYTIMELIMITID", "PREPAREDSTAYTIMELIMITID", "HASMARRIEDPROVE", "LOGOUTREASON", "LOGOUTDATE",
        "SOURCESSTATE", "ISRESIDENT", "MARKBIRTHDAY", "MARKGENDER", "ISEMPHASIS", "CHILDRENNUMBER",
        "HASPOLICYCOMPLIANCE", "CHILDRENEMPLOYMENT", "CHILDRENTOSCHOOL", "SOCIALSECURITY",
        "HEALTHINSURANCE", "RESIDENCEPERMIT", "INTEGRAL", "INFOSOURCE",
        "SOURCEORG", "IS_DEAL_RESIDENCE", "RESIDENCE_REASON", "SERVICE_AREA", "OLDID"
        };
        //41列
        String[] arr2 ={
                "ID",
                "BASEINFOID",
                "ADDRESSINFOID",
                "ORGID",
                "ORGINTERNALCODE",
                "ISINFLOWING",
                "INFLOWINGREASON",
                "INFLOWINGDATE",
                "INFLOWINGPROVINCE",
                "INFLOWINGCITY",
                "INFLOWINGDISTRICT",
                "REGISTRATIONTYPE",
                "REGISTERDATE",
                "EXPECTEDDATEDUE",
                "LOGOUT",
                "CREATEUSER",
                "UPDATEUSER",
                "CREATEDATE",
                "UPDATEDATE",
                "CERTIFICATENUMBER",
                "STAYLOCATIONTYPEID",
                "ECONOMYSOURCEID",
                "STAYTIMELIMITID",
                "PREPAREDSTAYTIMELIMITID",
                "HASMARRIEDPROVE",
                "LOGOUTREASON",
                "LOGOUTDATE",
                "SOURCESSTATE",
                "ISRESIDENT",
                "MARKBIRTHDAY",
                "MARKGENDER",
                "ISEMPHASIS",
                "CHILDRENNUMBER",
                "HASPOLICYCOMPLIANCE",
                "CHILDRENEMPLOYMENT",
                "CHILDRENTOSCHOOL",
                "SOCIALSECURITY",
                "HEALTHINSURANCE",
                "RESIDENCEPERMIT",
                "INTEGRAL",
                "OLDID"
        };
        //求出arr2中少掉的列
        for (int i = 0; i < arr1.length; i++) {
            String s1 = arr1[i];
            for (int j = 0; j < arr2.length; j++) {
                String s2 = arr2[j];
                if(s1.equals(s2)){
                    break;
                }
                if(j == arr2.length-1){
                    System.out.println(s1);
                }
            }
        }

    }
}
