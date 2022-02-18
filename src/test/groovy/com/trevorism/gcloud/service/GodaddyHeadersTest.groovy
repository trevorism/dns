package com.trevorism.gcloud.service

import org.junit.Test

class GodaddyHeadersTest {
    @Test
    void testGet() {
        def headers = GodaddyHeaders.get()
        assert headers
        assert headers["Authorization"]
    }
}
