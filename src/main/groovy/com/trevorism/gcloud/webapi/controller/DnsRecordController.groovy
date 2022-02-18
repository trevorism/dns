package com.trevorism.gcloud.webapi.controller

import com.trevorism.gcloud.model.DnsEntry
import com.trevorism.gcloud.service.DnsService
import com.trevorism.gcloud.service.GodaddyDnsService
import com.trevorism.secure.Roles
import com.trevorism.secure.Secure
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Api("DNS Record Operations")
@Path("dns")
class DnsRecordController {

    private DnsService dnsService = new GodaddyDnsService()

    @ApiOperation(value = "Lists all dns entries for trevorism.com **Secure")
    @GET
    @Secure(Roles.SYSTEM)
    @Produces(MediaType.APPLICATION_JSON)
    List<DnsEntry> list() {
        dnsService.list()
    }

    @ApiOperation(value = "Gets the dns entry specified in the format type:host **Secure")
    @GET
    @Path("{id}")
    @Secure(Roles.SYSTEM)
    @Produces(MediaType.APPLICATION_JSON)
    List<DnsEntry> get(@PathParam("id") String id) {
        dnsService.get(id)
    }

    @ApiOperation(value = "Add a new dns entry **Secure")
    @POST
    @Secure(Roles.SYSTEM)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    DnsEntry createOrUpdate(DnsEntry dnsEntry) {
        dnsService.add(dnsEntry)
    }

    @ApiOperation(value = "Delete a DNS entry specified in the format type:host **Secure")
    @DELETE
    @Path("{id}")
    @Secure(Roles.SYSTEM)
    @Produces(MediaType.APPLICATION_JSON)
    DnsEntry deleteDnsEntry(@PathParam("id") String id) {
        dnsService.delete(id)
    }

}
