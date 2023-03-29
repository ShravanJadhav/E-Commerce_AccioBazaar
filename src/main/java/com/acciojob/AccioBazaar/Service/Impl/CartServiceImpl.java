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
import com.acciojob.AccioBazaar.Service.CartService;
import com.acciojob.AccioBazaar.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderService orderService;
    @Override
    public String addToCart(OrderRequestDto orderRequestDto) throws Exception {
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

        Cart  cart = customer.getCart();

        int newCost =  cart.getCartTotal()+ orderRequestDto.getRequiredQuantity()* product.getPrice();
         cart.setCartTotal(newCost);

        //add item to cart
         Item item = new Item();
         item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
         item.setProduct(product);
         item.setCart(cart);
         cart.getItemList().add(item);

         customerRepository.save(customer);

         return "Item has been added..!";

    }

    @Override
    public List<OrderResponseDto> checkOutCart(int customerId) throws Exception {
        Customer customer;
        try{
            customer = customerRepository.findById(customerId).get();
        }catch(Exception e){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }

        List<OrderResponseDto>orderResponseDtos = new ArrayList<>();
        int totalCost = customer.getCart().getCartTotal();
        Cart cart = customer.getCart();

        for(Item item : cart.getItemList()){
             Ordered order = new Ordered();
             order.setTotalCost(item.getRequiredQuantity()*item.getProduct().getPrice());
             order.setDeliveryCharges(0);
             order.setCustomer(customer);
             order.getItemList().add(item);

            Card card = customer.getCardList().get(0);
            String cardNo = "";
            for(int i=0;i<card.getCardNo().length()-4;i++)
                cardNo += 'X';
            cardNo += card.getCardNo().substring(card.getCardNo().length()-4);
            order.setCardUsedForPayment(cardNo);

            int leftQuantity = item.getProduct().getQuantity()-item.getRequiredQuantity();
            if(leftQuantity<=0)
                item.getProduct().setProductStatus(ProductStatus.OUT_OF_STOCK);
            item.getProduct().setQuantity(leftQuantity);

            customer.getOrderedList().add(order);

            OrderResponseDto orderResponseDto = OrderConvertor.orderToOrderResponseDto(item);

            orderResponseDtos.add(orderResponseDto);
        }

        cart.setItemList(new ArrayList<>());
        cart.setCartTotal(0);
        customerRepository.save(customer);

        return orderResponseDtos;
    }

}
