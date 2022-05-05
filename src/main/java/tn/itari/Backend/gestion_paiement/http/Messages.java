package tn.itari.Backend.gestion_paiement.http;

public class Messages {
    private String message;

    public Messages(String message){
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message =  message;
    };

}
