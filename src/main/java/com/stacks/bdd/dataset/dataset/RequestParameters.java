package com.stacks.bdd.dataset.dataset;

import org.apache.http.HttpEntity;

import java.net.URI;
import java.util.Map;

public class RequestParameters {

    private URI uri;
    private Map<String, String> headers;
    private HttpEntity entity;

    public RequestParameters(URI uri) {
        this.uri = uri;
    }

    public RequestParameters(URI uri, Map<String, String> headers, HttpEntity entity) {
        this.uri = uri;
        this.headers = headers;
        this.entity = entity;
    }

    public URI getUri() {
        return uri;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public HttpEntity getEntity() {
        return entity;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
