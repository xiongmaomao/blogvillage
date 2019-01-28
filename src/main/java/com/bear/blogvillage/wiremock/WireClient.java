package com.bear.blogvillage.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.http.impl.conn.Wire;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class WireClient {
    public static void main(String[] args) throws IOException {
        WireMock.configureFor(9998);
        WireMock.removeAllMappings();
        ClassPathResource resource = new ClassPathResource("/mock/response/01.txt");
        String content = FileUtils.readFileToString(resource.getFile());
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/order/1")).willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
    }
}
