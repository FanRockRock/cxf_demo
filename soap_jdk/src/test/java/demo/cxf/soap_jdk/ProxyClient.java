package demo.cxf.soap_jdk;

public class ProxyClient {

    public static void main(String[] args) {
        HelloService_Service service = new HelloService_Service();

        HelloService helloService = service.getHelloServicePort();
        String result = helloService.say("world");
        System.out.println(result);
    }
}
