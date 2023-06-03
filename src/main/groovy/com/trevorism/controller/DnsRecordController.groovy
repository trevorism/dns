package com.trevorism.controller

import com.google.gson.Gson
import com.trevorism.https.SecureHttpClient
import com.trevorism.model.DnsRecord
import com.trevorism.model.GithubRequest
import com.trevorism.secure.Roles
import com.trevorism.secure.Secure
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag

@Controller("/api/dns")
class DnsRecordController {

    SecureHttpClient secureHttpClient
    Gson gson = new Gson()

    DnsRecordController(SecureHttpClient secureHttpClient) {
        this.secureHttpClient = secureHttpClient
    }

    @Tag(name = "Dns Operations")
    @Operation(summary = "Creates a new dns entry **Secure")
    @Post(value = "/", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    @Secure(Roles.SYSTEM)
    DnsRecord createDnsRecord(@Body DnsRecord record) {
        GithubRequest githubRequest = new GithubRequest(workflowInputs: [
                "SPEC_NAME"    : "dns_create",
                "CYPRESS_TYPE" : record.type,
                "CYPRESS_HOST" : record.host,
                "CYPRESS_VALUE": record.pointsTo])
        String requestJson = gson.toJson(githubRequest)
        secureHttpClient.post("https://github.project.trevorism.com/repo/dns/workflow", requestJson)
        return record
    }
}
