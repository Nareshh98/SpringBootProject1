package com.springBootProject.Common;

import java.time.LocalDateTime;

public class CustomerErrorResponse {

/*    "timestamp": "2022-07-26T11:52:14.866+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "#.........Employee with id=104not found",
      */
   private LocalDateTime loaclDateTime;
   private String error;
   private String message;
   private int status;

   public LocalDateTime getLoaclDateTime() {
        return loaclDateTime;
    }
    public void setLoaclDateTime(LocalDateTime loaclDateTime) {
        this.loaclDateTime = loaclDateTime;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

}
