package com.kdr.CrediGo.service.impl;

import com.kdr.CrediGo.dto.BankResponse;
import com.kdr.CrediGo.dto.InquiryRequest;
import com.kdr.CrediGo.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
    BankResponse balanceInquiry(InquiryRequest inquiryRequest);
    String nameInquiry(InquiryRequest inquiryRequest);


}




