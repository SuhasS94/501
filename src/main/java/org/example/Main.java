package org.example;

import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.example.code.HeaderBlock;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {

        String sortedInput = "0000000000~~10000000308~~GEN~~037~~1~~2006-07-24~~61~~01~~2006-07-14~~N~~1~~037~~037~~4722~~jj~~778~~jj~~jj~~ES~~jj~~103~~jj~~001~~001~~jj~~98~~jj~~jj~~P~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~01~~jj~~jj~~jj~~jj~~N~~9999–12-31T23:59:59.999999Z~~0001-12-30T00:00:00.000000Z~~jj~~jj~~jj~~jj~~jj~~1~~jj~~jj~~jj~~0001-01-01~~jj~~jj~~jj~~jj~~jj~~2~~jj~~jj~~0~~jj~~jj~~jj~~jj~~0~~jj~~O~~jj~~1~~O~~0001-01-01~~jj~~0~~jj~~0~~jj~~0~~0001-01-01~~2015-08-18T08:35:24.454004Z~~BATCH~~2025-06-16T15:30:03.8207242~~Y~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~0001-01-01~~0001-01-01~~jj~~0001-01-01~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~20:00~~1~~2~~3~~4~~5~~6~~7~~8~~9~~0~~11~~12~~13~~14~~15~~[[~~{{~~BLDEN~~N AKXSKYN V CETVLRTY ESL RGEQES JVJXKZ~~2015-08-18T08:35:24. 454004Z~~UNIRECON~~2025-03-25T17:04:16.711853Z~~}}~~{{~~BLDEN~~N AKXSKYN V CETVLRTY ESL RGEQES JVJXKZ~~2015-08-18T08:35:24. 454004Z~~UNIRECON~~2025-03-25T17:04:16.711853Z~~}}~~]]~~[[~~{{~~3~~5~~E}:@^n.ED!kR\\\\pHKC [{u,8(|~~jj~~2015-08-18T08:35:24.454004Z~~UNIRECON~~2025-04-11T06:31:15.116222Z~~}}~~{{~~3~~5~~E}:@^n.ED!kR\\\\pHKC [{u,8(|~~jj~~2015-08-18T08:35:24.454004Z~~UNIRECON~~2025-04-11T06:31:15.116222Z~~}}~~]]~~kk~~kk~~kk~~kk~~kk~~k~~kk~~kk~~kk~~k~~kk~~kk";
        String string = "0000000000~~10000000308~~GEN~~037~~1~~2006-07-24~~61~~01~~2006-07-14~~N~~1~~037~~037~~4722~~jj~~778~~jj~~jj~~ES~~jj~~103~~jj~~001~~001~~jj~~98~~jj~~jj~~P~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~01~~jj~~jj~~jj~~jj~~N~~9999-12-31T23:59:59.999999Z~~0001-12-30T00:00:00.000000Z~~jj~~jj~~jj~~jj~~jj~~1~~jj~~jj~~jj~~0001-01-01~~jj~~jj~~jj~~jj~~jj~~2~~jj~~jj~~0~~jj~~jj~~jj~~jj~~0~~jj~~O~~jj~~1~~O~~0001-01-01~~jj~~0~~jj~~0~~jj~~0~~0001-01-01~~2015-08-18T08:35:24.454004Z~~BATCH~~2025-06-16T15:30:03.8207242~~Y~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~0001-01-01~~0001-01-01~~jj~~0001-01-01~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~jj~~20:00~~1~~2~~3~~4~~5~~6~~7~~8~~9~~0~~11~~12~~13~~14~~15~~A~~BLDEN|N AKXSKYN V CETVLRTY ESL RGEQES JVJXKZ|2015-08-18T08:35:24.454004Z|UNIRECON|2025-03-25T17:04:16.711853Z~~BLDEN|N AKXSKYN V CETVLRTY ESL RGEQES JVJXKZ|2015-08-18T08:35:24.454004Z|UNIRECON|2025-03-25T17:04:16.711853Z~~B~~3|5|E}:@^n.ED!kR\\\\pHKC [{u,8(| |jj|2015-08-18T08:35:24.454004Z|UNIRECON|2025-04-11T06:31:15.116222Z~~3|5|E}:@^n.ED!kR\\\\pHKC [{u,8(| |jj|2015-08-18T08:35:24.454004Z|UNIRECON|2025-04-11T06:31:15.116222Z~~kk~~kk~~kk~~kk~~kk~~k~~kk~~kk~~kk~~k~~kk~~kk";

        StreamFactory factory = StreamFactory.newInstance();
        InputStream mappingXml = Main.class.getClassLoader().getResourceAsStream("mapping.xml");
        if (mappingXml == null) {
            throw new RuntimeException("mapping.xml not found in resources folder");
        }
        factory.load(mappingXml);

        Unmarshaller unmarshaller = factory.createUnmarshaller("headerStream");

        HeaderBlock header = (HeaderBlock) unmarshaller.unmarshal(string);

        System.out.println("arrayBlock1 size = " + header.arrayBlock1.size());
        System.out.println("arrayBlock2 size = " + header.arrayBlock2.size());
    }

}

//String input = "{{~~0000000000~~10000000308~~GEN~~037~~1~~2006-07-24~~61~~01~~2006-07-14~~N~~1~~037~~037~~4722~~~~~~~~~~~~778~~~~~~~~~~~~~~~~~~~~~~ES~~~~~~~~~~~~103~~~~~~~~~~~~001~~001~~~~~~~~~~~~98~~~~~~~~~~~~~~~~~~~~~~P~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~01~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~N~~9999–12-31T23:59:59.999999Z~~0001-12-30T00:00:00.000000Z~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0001-01-01~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~2~~~~~~~~~~~~~~~~~~~~~~0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0~~~~~~~~~~~~O~~~~~~~~~~~~1~~O~~0001-01-01~~~~~~~~~~~~0~~~~~~~~~~~~0~~~~~~~~~~~~0~~0001-01-01~~2015-08-18T08:35:24.454004Z~~BATCH~~2025-06-16T15:30:03.8207242~~Y~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0001-01-01~~0001-01-01~~~~~~~~~~~~0001-01-01~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~20:00~~{{~~1~~2~~3~~4~~5~~6~~7~~8~~9~~0~~11~~12~~13~~14~~15~~}}~~[[~~{{~~BLDEN~~N AKXSKYN V CETVLRTY ESL RGEQES JVJXKZ~~2015-08-18T08:35:24. 454004Z~~UNIRECON~~2025-03-25T17:04:16.711853Z~~}}~~{{~~BLDEN~~N AKXSKYN V CETVLRTY ESL RGEQES JVJXKZ~~2015-08-18T08:35:24. 454004Z~~UNIRECON~~2025-03-25T17:04:16.711853Z~~}}~~]]~~[[~~{{~~3~~5~~E}:@^n.ED!kR\\pHKC [{u,8(|~~~~~~~~~~~~2015-08-18T08:35:24.454004Z~~UNIRECON~~2025-04-11T06:31:15.116222Z~~}}~~{{~~3~~5~~E}:@^n.ED!kR\\pHKC [{u,8(|~~~~~~~~~~~~2015-08-18T08:35:24.454004Z~~UNIRECON~~2025-04-11T06:31:15.116222Z~~}}~~]]~~{{~~kk~~kk~~kk~~kk~~kk~~k~~kk~~kk~~kk~~k~~kk~~kk~~}}~~}}";
