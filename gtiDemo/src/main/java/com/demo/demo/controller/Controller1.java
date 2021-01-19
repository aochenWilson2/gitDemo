package com.demo.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/2/3 17:42
 */
@RestController
@RequestMapping("/controller1")
public class Controller1 {

    @GetMapping("/method1")
    public void method1(HttpServletRequest request) {
        HttpSession session = request.getSession();
        HttpServletRequest requestTemp = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession sessionTemp = requestTemp.getSession();

        Enumeration<String> attrs = session.getAttributeNames();
        String[] valueNames = session.getValueNames();
        for (String valueName : valueNames) {
            System.out.println("valueName...." + valueName);
        }
        while (attrs.hasMoreElements()) {
            String name = attrs.nextElement().toString();
            Object value = session.getAttribute(name);
            System.out.println("name......." + name + "...value......" + value + "\n");
        }

    }

//    public static void main(String[] args) throws JsonProcessingException {
//        RestTemplate restTemplate = new RestTemplate();
//        String loginURL = "https://w3.envision-group.dev.pe2.cc/apis/token";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
////        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
////        map.add("app_id", "612AFBD08E964C86A79A10AA4F0035FA");
////        map.add("app_secret", " RAAyzl0QQDG2298A79Pq");
////        map.add("grant_type", "CREDENTIAL");
////        map.add("tgt_svc", "it-sapdata-calendar");
////        map.add("user_id", "SYS10027");
//        Param param = new Param("612AFBD08E964C86A79A10AA4F0035FA", " RAAyzl0QQDG2298A79Pq", "CREDENTIAL", "it-sapdata-calendar", "SYS10027");
////        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonString = objectMapper.writeValueAsString(param);
//        System.out.println(jsonString);
//        HttpEntity<String> request = new HttpEntity<>(jsonString, headers);
////        ResponseEntity<String> responseEntity = restTemplate.postForEntity(loginURL, request, String.class);
////        ResponseEntity<Map> resp = restTemplate.exchange(loginURL, HttpMethod.POST, request, Map.class);
//        Token s = restTemplate.postForObject(loginURL, request, Token.class);
//
//        System.out.println(s);
//    }

//    public static void main(String[] args) {
//        //获取本周的周天
//        //周天加4周
//        //1-1到周天+4周
//        LocalDate now = LocalDate.now();
//        //今年第一天
//        LocalDate firstDay =  LocalDate.of(now.getYear(), 1, 1);
//        //本星期的周末
//        LocalDate sunDay = now.plusDays(-now.getDayOfWeek().getValue() + 7);
//        System.out.println(sunDay);
//
//        LocalDate nextFourSunDay = sunDay.plusWeeks(4);
//        String format = nextFourSunDay.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//        System.out.println("localDate+...."+format);
//
//        List<String> list = new ArrayList<>();
//        long distance = ChronoUnit.DAYS.between(firstDay, nextFourSunDay);
//        if (distance < 1) {
//            list = new ArrayList<>();
//        }
//        List<String> finalList = list;
//        Stream.iterate(firstDay, d -> d.plusDays(1)).limit(distance + 1).forEach(f -> {
//            finalList.add(f.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
//        });
//        System.out.println(finalList);
//    }


    public static void main(String[] args) throws IOException {
        String json = "{\"a\":\"1\"}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(json);
        System.out.println(jsonNode.get("a").asText());

        Iterator<String> fieldNames = jsonNode.fieldNames();
        System.out.println(fieldNames);
        while (fieldNames.hasNext()) {
            String next = fieldNames.next();
            System.out.println("next:" + next);
        }

        String s = mapper.writeValueAsString(jsonNode);
        System.out.println(s);

        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.set("test", jsonNode);
        objectNode.put("putName", "putValue");
        System.out.println(objectNode);

        Iterator<String> fieldNamesList = objectNode.fieldNames();
        if (fieldNamesList.hasNext()) {
            String next = fieldNamesList.next();
            System.out.println("next:" + next);
        }
    }
}
