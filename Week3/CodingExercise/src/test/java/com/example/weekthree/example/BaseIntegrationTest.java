package com.example.weekthree.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class BaseIntegrationTest {

    @LocalServerPort
    protected int serverPort;

    @Autowired
    protected TestRestTemplate testRestTemplate;

}
