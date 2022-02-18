package com.trevorism.gcloud.service

import com.google.gson.Gson
import com.trevorism.gcloud.model.DnsEntry
import com.trevorism.gcloud.model.GodaddyDnsRecord
import com.trevorism.http.headers.HeadersBlankHttpClient
import com.trevorism.http.headers.HeadersHttpClient
import com.trevorism.http.headers.HeadersJsonHttpClient
import com.trevorism.http.util.ResponseUtils

import javax.ws.rs.BadRequestException

/**
For the Go Daddy API spec, see: https://developer.godaddy.com/doc/endpoint/domains
**/

class GodaddyDnsService implements DnsService {

    //public static String BASE_URL = "https://api.godaddy.com" //prod
    public static final String BASE_URL = "https://api.ote-godaddy.com" //dev
    public static final String DOMAIN = "trevorism.com"
    private HeadersHttpClient client = new HeadersJsonHttpClient()
    private Gson gson = new Gson()

    @Override
    DnsEntry add(DnsEntry entry) {
        GodaddyDnsRecord record = GodaddyDnsRecord.fromDnsEntry(entry)
        def recordsJson = gson.toJson([record])
        def response = client.patch("$BASE_URL/v1/domains/$DOMAIN/records", recordsJson, GodaddyHeaders.get())
        ResponseUtils.closeSilently(response)
        if (response.getStatusLine().getStatusCode() == 200) {
            return entry
        }
        throw new BadRequestException("Error creating dns record")
    }

    @Override
    List<DnsEntry> get(String id) {
        String split = id.split(":")
        String type = split[0]
        String name = split[1]

        String jsonArray = ResponseUtils.getEntity(client.get("$BASE_URL/v1/domains/$DOMAIN/records/$type/$name", GodaddyHeaders.get()))
        def list = gson.fromJson(jsonArray, List)
        return list?.collect {
            DnsEntry.fromGodaddyDnsRecord(it)
        }
    }

    @Override
    boolean delete(String id) {
        String split = id.split(":")
        String type = split[0]
        String name = split[1]
        def response = client.delete("$BASE_URL/v1/domains/$DOMAIN/records/${type}/${name}", GodaddyHeaders.get())
        ResponseUtils.closeSilently(response)
        response.getStatusLine().getStatusCode() == 200
    }

    @Override
    List<DnsEntry> list() {
        String jsonArray = ResponseUtils.getEntity(client.get("$BASE_URL/v1/domains/$DOMAIN/records", GodaddyHeaders.get()))
        def list = gson.fromJson(jsonArray, List)
        return list.collect{
            DnsEntry.fromGodaddyDnsRecord(it)
        }
    }

}
