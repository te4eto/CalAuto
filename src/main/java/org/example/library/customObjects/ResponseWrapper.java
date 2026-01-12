package org.example.library.customObjects;

import lombok.Getter;

import java.util.List;

public class ResponseWrapper<T> {
    private final Object responseModel; // Can hold T or List<T>

    @Getter
    private final CustomResponse response;

    @Getter
    private final String responseBodyAsString;

    private final String errorMessage;


    public ResponseWrapper(CustomResponse response, String errorMessage) {
        this.response = response;
        this.responseModel = null;
        this.errorMessage = errorMessage;
        this.responseBodyAsString = response.getBodyAsString();
    }

    public ResponseWrapper(CustomResponse response, Object responseModel) {
        this.response = response;
        this.responseModel = responseModel;
        this.errorMessage = null;
        this.responseBodyAsString = response.getBodyAsString();
    }

    public boolean isList() {
        return responseModel instanceof List;
    }

    @SuppressWarnings("unchecked")
    public T getSingleResponseModel() {
        if (isList()) {
            throw new IllegalStateException("Response is a list, use getListResponse() instead");
        }

        return (T) responseModel;
    }

    @SuppressWarnings("unchecked")
    public List<T> getListResponseModel() {
        if (!isList()) {
            throw new IllegalStateException("Response is a single object, use getSingleResponse() instead");
        }

        return (List<T>) responseModel;
    }
}
