package pl.krystian.ecommerce.payu;


public class PayUCredentials {
    boolean sandbox;
    static String clientSecret;


    public static PayUCredentials sandbox(String clientId) {
        return new PayUCredentials(clientId, clientSecret);
    }

    public static Object getClientSecret() {
        return null;
    }

    public static Object getClientId() {
        return null;
    }

    public String getBaseUrl() {
        if (sandbox) {
            return "https://secure.snd.payu.com";
        } else {
            return "https://secure.payu.com";
        }
    }
}

//public class PayUCredentials {
//    boolean sandbox;
//    String clientSecret;
//    String sandbox;
//
//    public static PayUCredentials sandbox(String clientId) {
//        return new PayUCredentials(clientId, clientSecret);
//    }
//
//
//}
