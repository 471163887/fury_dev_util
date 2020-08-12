package com.brilliant.fury.util;

import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author by fury.
 * version 2019/3/1.
 */
public class IpUtil {

    private static final String IP_REGEX = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
        +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
        +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
        +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

    private static Pattern ipPattern = Pattern.compile(IP_REGEX);


    public static boolean isIpAddress(String ipAddress) {
        if (GuavaUtil.isEmpty(ipAddress)) {
            return false;
        }

        Matcher matcher = ipPattern.matcher(ipAddress);
        return matcher.matches();
    }

    public static Long ipStr2Long(String ipStr) {
        String[] split = ipStr.split("\\.");
        Long ips = 0L;
        for (int i = 0; i < 4; ++i) {
            ips = ips << 8 | Integer.parseInt(split[i]);
        }
        return ips;
    }

    public static String long2IpStr(long value) {
        byte[] data = new byte[4];
        data[0] = (byte) value;
        data[1] = (byte) (value >>> 8);
        data[2] = (byte) (value >>> 16);
        data[3] = (byte) (value >>> 24);
        return (data[3] & 0xff) + "." + (data[2] & 0xff) + "." + (data[1] & 0xff) + "." +
            (data[0] & 0xff);
    }

    public static String dnToIp(String domainName) {
        try {
            return InetAddress.getByName(domainName).getHostAddress();
        } catch (Exception e) {
            return null;
        }
    }

}
