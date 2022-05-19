package com.frankkips;
import java.io.*;
public class finale {


    public static void main(String[] args) {
//                                    0       1   2       3
        byte[] bytes = new byte[]{  0x45,0x00,0x00, (byte) 0xd2,
                                    0x16,0x61,0x40,0x00,
                                    0x40,0x06,0x30, (byte) 0x92,
                                    (byte) 0xc0, (byte) 0xa8,0x2b, (byte) 0xd3,
                                     0x33,0x0f, (byte) 0xd3, (byte) 0xa8};

        //Version
        int version = (bytes[0] & 0b11110000) >> 4;
        System.out.println("Version " + version);

        //IHL
        int ihl = (bytes[0] & 0b00001111);
        System.out.println("IHL " + ihl);

        int ihlAll = ihl * 4;
        System.out.println("IHL Total: " + ihlAll);
        //Type of service
        //Total Length
        int totalLength = 0;
        totalLength |= (bytes[2]& 0xff) << 8;
        totalLength|= (bytes[3] & 0xff);
        System.out.println("Total Length: "+ totalLength);
        //Identification
        //Flags
        boolean doNotFrag = ((bytes[6]& 0xff) & 0b01000000) > 0;
        boolean moreFrag = ((bytes[6]& 0xff) & 0b00100000) > 0;
        System.out.println("Do Not Fragment: " + doNotFrag);
        System.out.println("More Fragments: " + moreFrag);

        //Fragment Offfset
        int fragmentOff = 0;
        fragmentOff |= (bytes[6]& 0xff) & 0b00011111 << 8;
        fragmentOff |= (bytes[7]& 0xff) << 8;
        System.out.println("Fragment Offset " + fragmentOff);

        //TTL
        int ttl = bytes[8]& 0xff;
        System.out.println("Time to leave: " + ttl);
        //Protocol
        int protocol = bytes[9] & 0xff;
        System.out.println("Protocol: " + protocol);
        //Header Checksum
        // 0x30, 0x92
        int headerCheck = 0; //0x00000000
        headerCheck |= bytes[10]&0xff << 8; //0x00003000
        headerCheck |= bytes[11]&0xff;       //0x00003092
        Integer.toHexString(headerCheck);
        System.out.println("Header Checksum: " + headerCheck);
        //Source address
        //0xc0, (byte) 0xa8,0x2b, (byte) 0xd3
        int part1 = (bytes[12]& 0xff);
        int part2 = (bytes[13]& 0xff);
        int part3 = (bytes[14]& 0xff);
        int part4 = (bytes[15]& 0xff);

        String source = (part1+"."+part2+"."+part3+"."+part4+".");
        System.out.println("Source IP: "+ source);

        //Destination Address
        int pat1 = (bytes[16]& 0xff);
        int pat2 = (bytes[17]& 0xff);
        int pat3 = (bytes[18]& 0xff);
        int pat4 = (bytes[19]& 0xff);

        String dest = (pat1+"."+pat2+"."+pat3+"."+pat4+".");
        System.out.println("Destination IP: "+ dest);

    }
}
