package com.trevorism.gcloud.service

import com.trevorism.gcloud.model.DnsEntry
import org.junit.Before
import org.junit.Test

class GodaddyDnsServiceTest {

    DnsService dnsService

    @Before
    void setup(){
        dnsService = new GodaddyDnsService()

    }

    @Test
    void testAdd(){
        DnsEntry result = dnsService.add(new DnsEntry(type: "A", host: "@", pointsTo: "234.142.123.21", ttl: 3600))

        assert result
        assert result.id == "A:@"
        assert result.host == "234.142.123.21"
        assert result.ttl == 3600

    }

    @Test
    void testGet(){
        def list = dnsService.get("A", "@")
        assert list
        assert list[0].id == "A:@"
    }
}
