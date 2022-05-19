package com.frankkips;

import org.w3c.dom.ls.LSOutput;

public class IpHeader {

    public static void main(String[] args) {
        byte[] ipHederByte = new byte[]{0x33, 0x0f, (byte) 0xd3, (byte) 0xa8};


//    we need to find the version
//    so 45 is equivalent to 0100 0101
//    finding version we mask with 11110000 then shift 4 bits forwards
        byte version = (byte) (ipHederByte[0] >> 4);
        System.out.println(version);


//        Lets find the ihl which are the in the second nibble
//        mask 00001111 we & with 01000101 ---> 00000101

        byte mask = 0b00001111;
        byte ihlBytes = (byte) (mask & ipHederByte[0]);
        System.out.println(ihlBytes);
        byte ihlWords = (byte) (ihlBytes * 4);
        System.out.println(ihlWords);


//        lets determine the ip address
        int part1 =  (ipHederByte[0] & 0xff);
        int part2 =  (ipHederByte[1] & 0xff);
        int part3 =  (ipHederByte[2] & 0xff);
        int part4 =  (ipHederByte[3] & 0xff);

        String address = (part1 +"."+ part2 +"."+ part3 +"."+ part4);
        System.out.println("Source ip: " + address);

    }



}
