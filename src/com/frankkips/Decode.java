package com.frankkips;
//Diameter command flags
public class Decode {

    public static void main(String[] args) {
        byte bytes[] = new byte[]{  0x45,0x00,0x00, (byte) 0xd2,
                                    0x16,0x61,0x40,0x00,
                                    0x40,0x06,0x30, (byte) 0x92,
                                    (byte) 0xc0, (byte) 0xa8,0x2b, (byte) 0xd3,
                                    0x33,0x0f, (byte) 0xd3, (byte) 0xa8};


//        Version
//        1st 4 bytes 0x45 ---> 0100 0101 we need to mask it & 1111 0000
        int version = (bytes[0] & 0xff) >> 4;
        System.out.println("Version " + version);

//        IHL
        int ihlInBytes = (bytes[0] & 0xff) & 0b00001111;
        System.out.println("IHL in bytes "+ihlInBytes);

        int ihlInWords = ihlInBytes * 4;
        System.out.println("IHL in words "+ihlInWords);

//        Types of service
//        0x00,0x00




//        Total length
//        32 bits --> an int --> is 8 bits Hex 0x00, (byte) 0xd2,
        int totalLength = 0;    // 0x00000000
        totalLength = totalLength | (bytes[2] & 0xff) << 8;   //0x00000000 | 0x00  --> 0x00000000 <-- 0x00000000
        totalLength = totalLength| (bytes[3] & 0xff);    // 0x00000000 | 0xd2 ---> 0x000000d2
        System.out.println("totalLength: "+totalLength);
//        Identification

        //making a change to see on github
        int sourceIp = bytes[0];
























//        byte flag = 0x40;
//
//        byte mask = (byte) 0b10000000;
//        boolean request = (mask & flag) != 0;
//        System.out.println("Request Flag " + request);
//
////        Proxiable
//        byte mask2 = (byte) 0b01000000;
//        boolean request2 = (mask2 & flag) != 0;
//        System.out.println("Proxiable Flag " + request2);
//
////        error
//        byte mask3 = (byte) 0b00100000;
//        boolean request3 = (mask3 & flag) != 0;
//        System.out.println("error Flag " + request3);
//
//

    }
}
