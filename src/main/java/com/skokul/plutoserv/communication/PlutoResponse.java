package com.skokul.plutoserv.communication;

public class PlutoResponse<T> {

    private T data;
    private String httpResponseExceptionMessage;

    public T getData() {
        return data;
    }

    public String getHttpResponseExceptionMessage() {
        return httpResponseExceptionMessage;
    }
    
    public static class Builder<T> {
        private T data;
        private String httpResponseExceptionMessage;

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> httpResponseExceptionMessage(String httpResponseExceptionMessage) {
            this.httpResponseExceptionMessage = httpResponseExceptionMessage;
            return this;
        }

        public PlutoResponse<T> build() {
            PlutoResponse<T> plutoResponse = new PlutoResponse<T>();
            plutoResponse.data = this.data;
            plutoResponse.httpResponseExceptionMessage = this.httpResponseExceptionMessage;
            return plutoResponse;
        }
    }
}
