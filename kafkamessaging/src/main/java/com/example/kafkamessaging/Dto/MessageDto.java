package com.example.kafkamessaging.Dto;

public class MessageDto {
    private String id;
    private String payload;

    public MessageDto() {}

    public MessageDto(String id, String payload) {
        this.id = id;
        this.payload = payload;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPayload() { return payload; }
    public void setPayload(String payload) { this.payload = payload; }

    @Override
    public String toString() {
        return "MessageDto{id='" + id + "', payload='" + payload + "'}";
    }}
