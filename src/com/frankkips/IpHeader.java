package com.frankkips;

import org.w3c.dom.ls.LSOutput;

public class IpHeader {

    public static void main(String[] args) {
        byte[] ipHederByte = new byte[]{(byte) 0xae, (byte) 0xd3,  0x47, (byte) 0xcc};


//    we need to find the version
//    so 45 is equivalent to 0100 0101
//    finding version we mask with 11110000 then shift 4 bits forwards
        byte version = (byte) ((ipHederByte[0] & 0xff) >> 4);
        System.out.println(version);


//        Lets find the ihl which are the in the second nibble
//        mask 00001111 we & with 01000101 ---> 00000101

        byte mask = 0b00001111;
        byte ihlBytes = (byte) (mask & ipHederByte[0]);
        System.out.println(ihlBytes);
        byte ihlWords = (byte) (ihlBytes * 4);
        System.out.println(ihlWords);

//        lets do length
        int length = 0;
//        we want to add 1st and 2nd byte to the length
//        we OR length with 0x33 then shift and OR with 0x0f
        length |= (ipHederByte[0] & 0xff) << 8;    // 0x00000000 OR 0x33 --> 0x00000033 <<-- 0x00003300
        length |= (ipHederByte[1] & 0xff);           //0x00003300 OR 0x0f ---> 0x0000330f
        System.out.println("Length: " + length);  //0b0000 0000 0000 0000 0011 0011 0000 1111



//        Alternative
        int length2 = (ipHederByte[0] & 0xff) << 8  | (ipHederByte[1] & 0xff);
        System.out.println("Length2 " + length2);


//        Timestamp
        int timestamp = 0;
        timestamp|= (ipHederByte[0] & 0xff) << 24;
        timestamp|= (ipHederByte[1] & 0xff) << 16;
        timestamp|= (ipHederByte[2] & 0xff) << 8;
        timestamp|= (ipHederByte[3] & 0xff);

        System.out.println("Timestamp "+ timestamp);
        long timestampLong = Integer.toUnsignedLong(timestamp);
        System.out.println("Timestamp Long "+ timestampLong);
//        lets determine the ip address
        int part1 =  (ipHederByte[0] & 0xff);
        int part2 =  (ipHederByte[1] & 0xff);
        int part3 =  (ipHederByte[2] & 0xff);
        int part4 =  (ipHederByte[3] & 0xff);

        String address = (part1 +"."+ part2 +"."+ part3 +"."+ part4);
        System.out.println("Source ip: " + address);

//        Flags


    }



}
