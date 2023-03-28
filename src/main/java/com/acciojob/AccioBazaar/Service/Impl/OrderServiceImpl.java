package com.acciojob.AccioBazaar.Service.Impl;

import com.acciojob.AccioBazaar.Convertor.OrderConvertor;
import com.acciojob.AccioBazaar.Enum.ProductStatus;
import com.acciojob.AccioBazaar.Exception.CustomerNotFoundException;
import com.acciojob.AccioBazaar.Exception.ProductNotFoundException;
import com.acciojob.AccioBazaar.Model.*;
import com.acciojob.AccioBazaar.Repository.CustomerRepository;
import com.acciojob.AccioBazaar.Repository.ProductRepository;
import com.acciojob.AccioBazaar.RequestDTO.OrderRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.OrderResponseDto;
import com.acciojob.AccioBazaar.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
     public OrderResponseDto placeOrder(@RequestBody OrderRequestDto orderRequestDto) throws Exception {
         Customer customer;
         try{
             customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
         }catch(Exception e){
             throw new CustomerNotFoundException("Invalid Customer Id");
         }

         Product product;
         try{
             product = productRepository.findById(orderRequestDto.getProductId()).get();
         }catch(Exception e){
             throw new ProductNotFoundException("Invalid Product Id");
         }

         if(product.getQuantity()< orderRequestDto.getRequiredQuantity()){
             throw new Exception("Sorry...! Required Quantity not Available");
         }

         //prepare order object
         int totalCost = orderRequestDto.getRequiredQuantity() * product.getPrice();
         int deliveryCharge = 0;

         if(totalCost<500){
             deliveryCharge=50;
             totalCost+=deliveryCharge;
         }
         Ordered order = new Ordered();
         order.setTotalCost(totalCost);
         order.setDeliveryCharges(deliveryCharge);
         order.setOrderDate(new Date());

         //prepare the card string
         Card card = customer.getCardList().get(0);
         String cardNo = "";

         for(int i=0;i<card.getCardNo().length()-4; i++){
             cardNo+="X";
         }
         cardNo+=card.getCardNo().substring(card.getCardNo().length()-4);
         order.setCardUsedForPayment(cardNo);

         //prepare item
         Item item = new Item();
       item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
       item.setProduct(product);
       item.setOrdered(order);
       order.getItemList().add(item);
       order.setCustomer(customer);

         //update the quantity of product left in warehouse
         int leftQuantity = product.getQuantity()-orderRequestDto.getRequiredQuantity();
         if(leftQuantity<=0){
             product.setProductStatus(ProductStatus.OUT_OF_STOCK);
         }
         product.setQuantity(leftQuantity);

         //update item
         customer.getOrderedList().add(order);

         //save product item and customer order
        Customer savedCustomer = customerRepository.save(customer);
        Ordered savedOrder = savedCustomer.getOrderedList().get(savedCustomer.getOrderedList().size()-1);

        //prepare response Dto
         OrderResponseDto orderResponseDto = OrderConvertor.orderToOrderResponseDto(item);

         return orderResponseDto;
     }
}
