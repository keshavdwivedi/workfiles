package RestAssuredUtils;

import java.util.HashMap;
import java.util.Map;

public class GetRequestsHeaderUtils {

    static Map<String,String> getRequestHeaders=new HashMap<>();

    public static void setHeaderValues(Map<String,String> headers){
        headers.put("Accept-Encoding","gzip, deflate, br");
        headers.put("Cookie",".AspNetCore.Antiforgery.9bppsQuHM-Y=CfDJ8HlrO4VBw5ZGh72ZUnhKAEGvIZapPZR_EcMUXgfHRuUeYdU5HQ7Ph2xAqyXIHtlUUlhGhuaal8FpkUdS68x3Oi8glGZz-20CmGz5cSEvcOgr-nermlR6BOt4bcmGV3UwgIpQIK-w8lPWMt3lfAIlRpk; ARRAffinity=0befc48d75b6e04c4d602aab20a9e9bfd5e8d39402b43621fe9879088cfb31d7; OpenIdConnect.nonce.o0zoZxJ5gYi7HnuipVZDREKd0tXWNuWGNmjuCp375TE%3D=am5CTmQ2ZkprTDNOczBEaUQtVUc0SHRySl9UeGZEMGtacHB6aVdKeHpVUnlnRmFRTFNmQUFLeVBLTmR5OXZBclBlbnAzU3BwdHFxWnctaGVGNGdKY3M1aEJXaGhZd0RxckNSc2p1S280Q0VVUDZ5SHBnT2YzM3JuZGtfR2lzZy1lV2JHak5ocXdjcmc2RzZDYUhlbkZyRHZpZTUzMDFmaEFYazZYUjFmLTZvX0hLbWFRZnpEQWQ3VE5DTG9XOW1xYU1QeGdqZ09uSU83T1FsVzhOdllpbTJwTEU0; UAT-LCRM-PORTAL=688c13a0fcc79c5b8c62f0333eef841f; UAT-LCRM-PORTALCORS=688c13a0fcc79c5b8c62f0333eef841f");
        getRequestHeaders=headers;
    }

    public static Map<String,String> getHeaderValues(){
        return getRequestHeaders;
    }

}
