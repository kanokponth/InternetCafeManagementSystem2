package System;

import javax.xml.bind.DatatypeConverter;

public class EncodeAndDecode {

    private String encoded = "";
    private String decode = "";


    public String encode(String pass){
        encoded = DatatypeConverter.printBase64Binary(pass.getBytes());
        return encoded;
    }

    public String decode(){
        decode = new String(DatatypeConverter.parseBase64Binary(encoded));
        return decode;
    }
    public String decode2(String pass){
        decode = new String(DatatypeConverter.parseBase64Binary(pass));
        return decode;
    }
}