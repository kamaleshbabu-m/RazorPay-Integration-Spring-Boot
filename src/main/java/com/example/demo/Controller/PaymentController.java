package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;

import com.example.demo.Bean.payLink;
import com.razorpay.*;

@RestController
public class PaymentController {
    String apikey="rzp_test_k70sS90NcqQOJe";
    String keysecret="g9f6ttM5IebdGwBDn0TBpEhV";

    @GetMapping("/createorder")
    public String createOrder() throws RazorpayException{

      
        try{
        RazorpayClient razorpay = new RazorpayClient(apikey, keysecret); 
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount",50000);
        orderRequest.put("currency","INR");
        orderRequest.put("receipt", "receipt#1");
        JSONObject notes = new JSONObject();
        notes.put("notes_key_1","Tea, Earl Grey, Hot");
        orderRequest.put("notes",notes);
        Order order = razorpay.orders.create(orderRequest);

        return order.toString();

        }
        catch(Exception e){
            return e.toString();
        }
    }

    @PostMapping("/createpaymentlink")
    public String createPaymentLink(@RequestBody payLink pay){

        
        long expire_by = System.currentTimeMillis() / 1000L; // timetamp in unix
          try{

            RazorpayClient razorpay = new RazorpayClient(apikey, keysecret); 
            JSONObject paymentLinkRequest = new JSONObject();

            String name = pay.getName();
            String mail=pay.getEmail();
            String contact=pay.getContact();
            int amount=pay.getAmount();
            String referenceId=pay.getReferenceId();

            paymentLinkRequest.put("amount",amount);
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",true);
            paymentLinkRequest.put("first_min_partial_amount",1000);
          //  paymentLinkRequest.put("expire_by",expire_by);
            paymentLinkRequest.put("reference_id",referenceId);
            paymentLinkRequest.put("description","Payment for policy no #23456");
            JSONObject customer = new JSONObject();
            customer.put("name",name);
            customer.put("contact",contact);
            customer.put("email",mail);
            paymentLinkRequest.put("customer",customer);
            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            // notify.put("whatsapp",true);  not working but showing in response as a parameter
            paymentLinkRequest.put("notify",notify);
            paymentLinkRequest.put("reminder_enable",true);
            JSONObject notes = new JSONObject();
            notes.put("policy_name","Jeevan Bima");
            paymentLinkRequest.put("notes",notes);
            paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
            paymentLinkRequest.put("callback_method","get");
                        
            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
            return payment.toString();
          }
          catch(Exception e){
            return e.toString();
          }
          }
        

}

