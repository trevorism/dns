package com.trevorism.gcloud.service

import com.trevorism.gcloud.model.DnsEntry

interface DnsService {

    DnsEntry add(DnsEntry entry)
    List<DnsEntry> get(String type, String hostName)
    boolean delete(String id)
    List<DnsEntry> listAll()
}
